package org.example.DataAccess;

import org.example.Model.Bill;
import org.example.Model.Clients;
import org.example.Model.Orders;
import org.example.Model.Products;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

/**
 * @param <T> generic
 *            clasa abstracta ce realizeaza interactiune cu baza de date
 */
public class DAO<T> {
    private final Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * @param object primeste orice obiect: Client, Produs, Order, Bill
     *               insert into tableName
     */
    public int insert(T object) {
        String className = object.getClass().getSimpleName();
        if (object instanceof Orders) {
            if (!this.checkOrderAndCreateBill((Orders) object)) {
                return -1;
            }
        }
        String insertStatementString = "INSERT INTO " + className + " VALUES (";
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (field.getName().equals("id")) {
                    insertStatementString += "DEFAULT, ";
                } else {
                    insertStatementString += "'" + value + "', ";
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        insertStatementString = insertStatementString.substring(0, insertStatementString.length() - 2) + ");";
        System.out.println(insertStatementString);
        Statement insertStatement = null;
        ResultSet rs = null;
        int lastId = -1;
        try {
            insertStatement = connection.createStatement();
            insertStatement.executeUpdate(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                lastId = rs.getInt(1);
            }
            insertStatement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (object instanceof Orders) {
            Bill bill = new Bill(-1, lastId, ((Orders) object).getIdClient(), ((Orders) object).getIdProdus(), ((Orders) object).getQuantity());
            this.insert((T) bill);
        }
        return lastId;
    }

    /**
     * @param order primeste ca parametru o posibila comanda
     *              verifica daca aceasta comanda se poate plasa (cantitatea ceruta > cantitatea totala)
     *              si creaza un Bill (o clasa imutabila)
     * @return
     */
    private boolean checkOrderAndCreateBill(Orders order) {
        Products product = (Products) findById((T) new Products(), order.getIdProdus());
        int totalQuantity = product.getQuantity();
        int desiredQuantity = order.getQuantity();
        System.out.println(totalQuantity + " " + desiredQuantity);
        if (totalQuantity >= desiredQuantity) {
            product.setQuantity(totalQuantity - desiredQuantity);
            this.edit((T) product);
            return true;
        }
        return false;
    }

    /**
     * @param object cauta orice obiect: Client, Produs, Order...
     * @param byId   in  functie de id
     * @return returneaza un obiect ce contine informatii despre instanta cautata daca a fost gasita
     */
    private Object findById(T object, int byId) {
        Object found = null;
        String findStatementString = "SELECT ";
        findStatementString += "* FROM " + object.getClass().getSimpleName();
        findStatementString += " WHERE id = " + byId + ";";
        //System.out.println(findStatementString);
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = connection.prepareStatement(findStatementString);
            rs = findStatement.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            int id, quantity;
            String name, address, email;
            while (rs.next()) {
                if (object instanceof Clients) {
                    id = rs.getInt("id");
                    name = rs.getString("name");
                    address = rs.getString("address");
                    email = rs.getString("email");
                    found = new Clients(id, name, address, email);
                }

                if (object instanceof Products) {
                    id = rs.getInt("id");
                    name = rs.getString("name");
                    quantity = Integer.parseInt(rs.getString("quantity"));
                    found = new Products(id, name, quantity);
                }

            }

            findStatement.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return found;
    }

    /**
     * @param object primeste orice obiect(Exclus Order si Bill ce nu pot fi editate)
     *               si editeaza cu informatiile dorite
     */
    public void edit(T object) {
        String className = object.getClass().getSimpleName();
        if (object instanceof Bill || object instanceof Orders) {
            System.out.println("Placed Orders/Bills cannot be edited!");
            return;
        }
        String updateStatementString = "UPDATE " + className + " SET ";
        Field[] fields = object.getClass().getDeclaredFields();
        int id = -1;
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals("id")) {
                try {
                    id = field.getInt(object);
                    //System.out.println(id);
                } catch (IllegalAccessException e) {
                    System.out.println(e);
                }
            } else {
                try {
                    Object value = field.get(object);
                    updateStatementString += field.getName() + " =  '" + value + "', ";
                } catch (IllegalAccessException e) {
                    System.out.println(e);
                }
            }
        }
        updateStatementString = updateStatementString.substring(0, updateStatementString.length() - 2) + " WHERE id = " + id + ";";
        System.out.println(updateStatementString);
        Statement updateStatement = null;
        try {
            updateStatement = connection.createStatement();
            updateStatement.executeUpdate(updateStatementString);
            updateStatement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @param object primeste orice obiect (Exclus Bill)
     *               sterge elementul dorit
     */
    public void delete(T object) {
        if (object instanceof Bill) {
            System.out.println("Bills cannot be deleted!");
            return;
        }
        String className = object.getClass().getSimpleName();
        String deleteStatementString = "DELETE FROM " + className + " WHERE id =  ";
        int id = -1;
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals("id")) {
                try {
                    id = field.getInt(object);
                    //System.out.println(id);
                } catch (IllegalAccessException e) {
                    System.out.println(e);
                }
                break;
            }
        }
        deleteStatementString += id + ";";
        //System.out.println(deleteStatementString);
        Statement deleteStatement = null;
        try {
            deleteStatement = connection.createStatement();
            deleteStatement.executeUpdate(deleteStatementString);
            deleteStatement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (object instanceof Orders) {
            Products product = (Products) findById((T) new Products(), ((Orders) object).getIdProdus());
            int quantityLeft = product.getQuantity();
            product.setQuantity(quantityLeft + ((Orders) object).getQuantity());
            this.edit((T) product);
        }
    }

    /**
     * @param object primeste un ArrayList ce poate contine mai multe obiecte diferite precum clienti, produse, orders
     *               si le insereaza in tabelele corespunzatoare
     */
    public void multipleInsert(T object) {
        ArrayList<Object> multipleObjects = (ArrayList<Object>) object;
        for (Object tables : multipleObjects) {
            if (!(tables instanceof Bill)) {
                this.insert((T) tables);
            }
        }
    }
}
