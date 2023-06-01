package org.example.Controller;

import org.example.DataAccess.DAO;
import org.example.Model.Orders;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * asemanatoare clasei ClientsBLL
 */
public class OrdersBLL {
    Connection connection;
    DAO<Orders> dao;
    public OrdersBLL(Connection connection) {
        this.connection = connection;
        dao = new DAO<>(connection);
    }

    public void addOrder(Orders newOrder) {
        dao.insert(newOrder);
    }

    public void viewOrders(DefaultTableModel model) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Orders");
            while (rs.next()) {
                int id = rs.getInt("id");
                int idClient = rs.getInt("idClient");
                int idProduct = rs.getInt("idProduct");
                int quantity = rs.getInt("quantity");
                Object[] row = {id, idClient, idProduct, quantity};
                model.addRow(row);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteOrder(JTable table) {
        if (table.getSelectedRowCount() == 1) {
            int selectedRow = table.getSelectedRow();
            int id = (int) table.getValueAt(selectedRow, 0);
            int idClient = (int) table.getValueAt(selectedRow, 1);
            int idProduct = (int) table.getValueAt(selectedRow, 2);
            int quantity= (int) table.getValueAt(selectedRow, 3);
            Orders order = new Orders(id, idClient, idProduct, quantity);
            dao.delete(order);
        } else if (table.getSelectedRowCount() > 1) {
            int[] selectedRows = table.getSelectedRows();
            for (int i : selectedRows) {
                int id = (int) table.getValueAt(i, 0);
                int idClient = (int) table.getValueAt(i, 1);
                int idProduct = (int) table.getValueAt(i, 2);
                int quantity= (int) table.getValueAt(i, 3);
                Orders order = new Orders(id, idClient, idProduct, quantity);
                dao.delete(order);
            }
        }
    }
}
