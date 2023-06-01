package org.example.Controller;

import org.example.Connection.ConnectionFactory;
import org.example.DataAccess.DAO;
import org.example.Model.Clients;
import org.example.Model.Products;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * asemanatoare clasei ClientsBLL
 */
public class ProductsBLL {
    Connection connection;
    DAO<Products> dao;

    public ProductsBLL(Connection connection) {
        this.connection = connection;
        dao = new DAO<>(connection);
    }

    public void addProduct(Products newProduct) {
        dao.insert(newProduct);
    }

    public void viewProducts(DefaultTableModel model) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Products");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                Object[] row = {id, name, quantity};
                model.addRow(row);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editProduct(JTable table) {
        if (table.getSelectedRowCount() == 1) {
            int selectedRow = table.getSelectedRow();
            int id = (int) table.getValueAt(selectedRow, 0);
            String newName = (String) table.getValueAt(selectedRow, 1);
            int quantity = (int) table.getValueAt(selectedRow, 2);
            Products product = new Products(id, newName, quantity);
            dao.edit(product);
        }
    }

    public void deleteProduct(JTable table) {
        if (table.getSelectedRowCount() == 1) {
            int selectedRow = table.getSelectedRow();
            int id = (int) table.getValueAt(selectedRow, 0);
            String name = (String) table.getValueAt(selectedRow, 1);
            int quantity = (int) table.getValueAt(selectedRow, 2);
            Products product = new Products(id, name, quantity);
            dao.delete(product);
        } else if (table.getSelectedRowCount() > 1) {
            int[] selectedRows = table.getSelectedRows();
            for (int i : selectedRows) {
                int id = (int) table.getValueAt(i, 0);
                String name = (String) table.getValueAt(i, 1);
                int quantity = (int) table.getValueAt(i, 2);
                Products product = new Products(id, name, quantity);
                dao.delete(product);
            }
        }
    }
}