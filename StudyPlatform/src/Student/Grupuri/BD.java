package Student.Grupuri;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import LogIn.GetConnection;
import Student.GrupuriStudiu;

import java.io.*;
import java.sql.*;

public class BD extends javax.swing.JFrame {
    String email;
    String parola;
    String nume;
    String prenume;
    Connection connection;
    GetConnection connect = new GetConnection();
    String mesaj="";
    String idGr="";
    String idStud="";
    String numeA="";
    public BD(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        loadMes();
        //JOptionPane.showMessageDialog(null, "Test", "Text", JOptionPane.WARNING_MESSAGE);
        try{
            connection = connect.getConnection(this.email, this.parola);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from calendargrup join grup on (grup.id=calendargrup.idG) where idM = (select id from materie where descriere = 'BD') and expirata = 1;");
            while (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Activitatea "+resultSet.getString("nume")+" a expirat!", "Atentie!", JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception A)
        {
            System.out.println(A);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        inapoiButton = new javax.swing.JButton();
        trimiteButton = new javax.swing.JButton();
        mesajField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        mesajeArea = new javax.swing.JTextArea();
        programeazaButton = new javax.swing.JButton();
        activitatiLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        activitatiArea = new javax.swing.JTextArea();
        participaButton = new javax.swing.JButton();
        activitateLabel = new javax.swing.JLabel();
        activitateField = new javax.swing.JTextField();
        activitatePLabel = new javax.swing.JLabel();
        activitatePField = new javax.swing.JTextField();
        nrMinLabel = new javax.swing.JLabel();
        nrMinField = new javax.swing.JTextField();
        expiraLabel = new javax.swing.JLabel();
        expiraField = new javax.swing.JTextField();
        incepeLabel = new javax.swing.JLabel();
        startDField = new javax.swing.JTextField();
        startTField = new javax.swing.JTextField();
        veziButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        trimiteButton.setText("Trimite Mesaj");
        trimiteButton.setFocusable(false);
        trimiteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trimiteButtonActionPerformed(evt);
            }
        });

        mesajeArea.setColumns(20);
        mesajeArea.setRows(5);
        jScrollPane1.setViewportView(mesajeArea);

        programeazaButton.setText("Programeaza Activitate");
        programeazaButton.setFocusable(false);
        programeazaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programeazaButtonActionPerformed(evt);
            }
        });

        activitatiLabel.setText("Activitati:");

        activitatiArea.setColumns(20);
        activitatiArea.setRows(5);
        jScrollPane2.setViewportView(activitatiArea);

        participaButton.setText("Participa");
        participaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participaButtonActionPerformed(evt);
            }
        });

        activitateLabel.setText("Numele Activitatii:");

        activitatePLabel.setText("Numele Activitatii:");

        nrMinLabel.setText("Minim Studenti:");

        expiraLabel.setText("Expira in:");

        incepeLabel.setText("Incepe (Data, Ora):");

        veziButton.setText("Vezi Activitati:");
        veziButton.setFocusable(false);
        veziButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veziButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                        .addComponent(mesajField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(programeazaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2)
                                        .addComponent(participaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(activitateLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(activitateField))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(incepeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(activitatePLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(activitatePField)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(startDField)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(startTField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(trimiteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(nrMinLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(nrMinField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(expiraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(expiraField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(activitatiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(veziButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(trimiteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(mesajField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(programeazaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(activitatePLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(activitatePField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(incepeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(startDField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(startTField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(expiraField)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(expiraLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(nrMinField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(nrMinLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(activitatiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                                        .addComponent(veziButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(activitateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(activitateField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(participaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        GrupuriStudiu back = new GrupuriStudiu(this.email, this.parola);
    }

    private void trimiteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try{
            connection = connect.getConnection(this.email, this.parola);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student where student.email = '"+this.email+"'");
            while (resultSet.next()) {
                this.nume=resultSet.getString("nume");
                this.prenume=resultSet.getString("prenume");
            }
        }catch(Exception A)
        {
            System.out.println(A);
        }
        mesaj=nume+" "+prenume+": "+mesajField.getText()+"\n";
        mesajeArea.append(mesaj);
        mesajField.setText("");
        saveMes(mesaj);
        mesaj="";
    }

    private void programeazaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            connection = GetConnection.getConnection(this.email, this.parola);
            String programeazaActivitateGrup = "{ call programeazaActivitateGrup(?, ?, ?, ?, ?, ?) }";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from materie where materie.descriere = 'BD'");
            while (resultSet.next()) {
                idGr=resultSet.getString("id");
            }
            PreparedStatement stm = connection.prepareStatement("CREATE EVENT "+activitatePField.getText()+" " +
                    "ON SCHEDULE AT CURRENT_TIMESTAMP() + interval "+expiraField.getText()+" minute " +
                    "ON COMPLETION PRESERVE " +
                    "DO BEGIN " +
                    "delete from asignarigrup where asignarigrup.idCG = (Select id from calendargrup where calendargrup.nume = '"+activitatePField.getText()+"'); "+
                    "update calendargrup set expirata = 1;" +
                    " END;");
            stm.execute();
            ResultSet resultSet1 = statement.executeQuery("select * from calendargrup where calendargrup.nume = '"+activitatePField.getText()+"'");
            CallableStatement cs = connection.prepareCall(programeazaActivitateGrup);
            cs.setString(1, activitatePField.getText());
            cs.setString(2, startDField.getText());
            cs.setString(3, startTField.getText());
            cs.setString(4, idGr);
            cs.setString(5, nrMinField.getText());
            cs.setString(6, expiraField.getText());
            cs.execute();
            activitatePField.setText("");
            startDField.setText("");
            startTField.setText("");
            nrMinField.setText("");
            expiraField.setText("");
        }catch(Exception A)
        {
            System.out.println(A);
        }
    }
    private void participaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            connection = GetConnection.getConnection(this.email, this.parola);
            String asigneazaGrupActivitate = "{ call asigneazaGrupActivitate(?, ?) }";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Student where Student.email = '"+this.email+"'");
            while (resultSet.next()) {
                idStud=resultSet.getString("id");
            }
            CallableStatement cs = connection.prepareCall(asigneazaGrupActivitate);
            cs.setString(1, activitateField.getText());
            cs.setString(2, idStud);
            cs.execute();
        }catch(Exception A)
        {
            System.out.println(A);
        }
    }

    private void veziButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            connection = GetConnection.getConnection(this.email, this.parola);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from calendargrup where idG = (Select id from materie where materie.descriere='BD') and expirata=0");
            while (resultSet.next()) {
                numeA=numeA+resultSet.getString("nume")+"\n";
            }
            activitatiArea.insert(numeA, 0);
        }catch(Exception A)
        {
            System.out.println(A);
        }
    }

    private javax.swing.JTextField activitateField;
    private javax.swing.JLabel activitateLabel;
    private javax.swing.JTextField activitatePField;
    private javax.swing.JLabel activitatePLabel;
    private javax.swing.JTextArea activitatiArea;
    private javax.swing.JLabel activitatiLabel;
    private javax.swing.JTextField expiraField;
    private javax.swing.JLabel expiraLabel;
    private javax.swing.JButton inapoiButton;
    private javax.swing.JLabel incepeLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mesajField;
    private javax.swing.JTextArea mesajeArea;
    private javax.swing.JTextField nrMinField;
    private javax.swing.JLabel nrMinLabel;
    private javax.swing.JButton participaButton;
    private javax.swing.JButton programeazaButton;
    private javax.swing.JTextField startDField;
    private javax.swing.JTextField startTField;
    private javax.swing.JButton trimiteButton;
    private javax.swing.JButton veziButton;
    private void loadMes() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("BD.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                mesajeArea.append(line + "\n");
            }
            reader.close();
        } catch (IOException e) {
        }
    }
    private void saveMes(String message) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("BD.txt", true));
            writer.write(message);
            writer.close();
        } catch (IOException e) {
        }
    }
}
