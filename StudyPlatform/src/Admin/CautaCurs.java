/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import LogIn.GetConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CautaCurs extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect;
    String np="";
    public CautaCurs(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        materieLabel = new javax.swing.JLabel();
        materieField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        profesoriArea = new javax.swing.JTextArea();
        inapoiButton = new javax.swing.JButton();
        veziStudButton = new javax.swing.JButton();
        profesoriLabel = new javax.swing.JLabel();
        studentLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        materieLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        materieLabel.setText("Materie:");

        profesoriArea.setColumns(20);
        profesoriArea.setRows(5);
        jScrollPane1.setViewportView(profesoriArea);

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        veziStudButton.setText("Vezi");
        veziStudButton.setFocusable(false);
        veziStudButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veziStudButtonActionPerformed(evt);
            }
        });

        profesoriLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profesoriLabel.setText("Profesori:");

        studentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentLabel.setText("Studenti:");

        studentArea.setColumns(20);
        studentArea.setRows(5);
        jScrollPane2.setViewportView(studentArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(materieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(profesoriLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(materieField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(veziStudButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(studentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(materieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(materieField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(veziStudButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(profesoriLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(studentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuAdmin back = new MenuAdmin(this.email, this.parola);
    }

    private void veziStudButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            connection = connect.getConnection(email, parola);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from Profesor join Curs on (Curs.idProf=Profesor.id) Join Materie on (Curs.idM = Materie.id) where Materie.descriere = '"
                    +materieField.getText()+"'");
            while (resultSet.next()) {
                String numeP=resultSet.getString("nume");
                String prenumeP=resultSet.getString("prenume");
                np=np+numeP+" "+prenumeP+"\n";
            }
            profesoriArea.insert(np, 0);
            np="";
            ResultSet resultSet1 = statement.executeQuery("Select * from Student join Contractari on (Student.id=Contractari.idS) Join Curs on (Curs.id = Contractari.idC) " +
                    "join Materie on (Curs.idM = Materie.id) where Materie.descriere ='"
                    +materieField.getText()+"'");
            while (resultSet1.next()) {
                String numeP=resultSet1.getString("nume");
                String prenumeP=resultSet1.getString("prenume");
                np=np+numeP+" "+prenumeP+"\n";
            }
            studentArea.insert(np, 0);
            profesoriArea.setEditable(false);
            studentArea.setEditable(false);
        } catch (Exception A) {
            System.out.println(A);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton inapoiButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField materieField;
    private javax.swing.JLabel materieLabel;
    private javax.swing.JTextArea profesoriArea;
    private javax.swing.JTextArea studentArea;
    private javax.swing.JLabel profesoriLabel;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JButton veziStudButton;
    // End of variables declaration
}
