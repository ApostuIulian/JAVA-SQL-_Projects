package org.example.Controller;

import org.example.DataAccess.DAO;
import org.example.Model.Clients;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clasa ClientsBLL face parte din pachetul Controller si face legatura dintre interfata si baza de date
 */
public class ClientsBLL {
    Connection connection;
    DAO<Clients> dao;

    public ClientsBLL(Connection connection) {
        this.connection = connection;
        dao = new DAO<>(connection);
    }

    public void addClient(Clients newClient) {
        dao.insert(newClient);
    }

    /**
     * @param model modelul tabelului (JTable) de clienti
     *              cu un select vom lua toti clientii pentru a-i adauga in tabel
     */
    public void viewClients(DefaultTableModel model) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Clients");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                Object[] row = {id, name, address, email};
                model.addRow(row);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param table trimitem tabelul de clienti ca parametru
     *             luam informatiile de la randul selectat(putem edita doar informatiile de pe un singur rand)
     *              pentru a realiza schimbarile
     */
    public void editClient(JTable table) {
        if (table.getSelectedRowCount() == 1) {
            int selectedRow = table.getSelectedRow();
            int id = (int) table.getValueAt(selectedRow, 0);
            String newName = (String) table.getValueAt(selectedRow, 1);
            String newAddress = (String) table.getValueAt(selectedRow, 2);
            String newEmail = (String) table.getValueAt(selectedRow, 3);
            Clients client = new Clients(id, newName, newAddress, newEmail);
            dao.edit(client);
        }
    }

    /**
     * @param table trimitem tabelul de clienti ca parametru
     *              putem sterge unul sau mai multe randuri(clienti) in acelasi timp
     *              pentru selectare multipla tasta CTRL + click pe fiecare client
     */
    public void deleteClient(JTable table) {
        if (table.getSelectedRowCount() == 1) {
            int selectedRow = table.getSelectedRow();
            int id = (int) table.getValueAt(selectedRow, 0);
            String Name = (String) table.getValueAt(selectedRow, 1);
            String Address = (String) table.getValueAt(selectedRow, 2);
            String Email = (String) table.getValueAt(selectedRow, 3);
            Clients client = new Clients(id, Name, Address, Email);
            dao.delete(client);
        } else if (table.getSelectedRowCount() > 1) {
            int[] selectedRows = table.getSelectedRows();
            for (int i : selectedRows) {
                int id = (int) table.getValueAt(i, 0);
                String Name = (String) table.getValueAt(i, 1);
                String Address = (String) table.getValueAt(i, 2);
                String Email = (String) table.getValueAt(i, 3);
                Clients client = new Clients(id, Name, Address, Email);
                dao.delete(client);
            }
        }
    }
}
