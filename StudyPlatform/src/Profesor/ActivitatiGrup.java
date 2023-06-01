package Profesor;

import LogIn.GetConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ActivitatiGrup extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect;
    String numeA="";
    String idProf="";
    public ActivitatiGrup(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        try {
            connection = GetConnection.getConnection(this.email, this.parola);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from calendargrup join materie on (calendargrup.idG=materie.id) join curs on (curs.idM=materie.id) where " +
                    "idProf = (Select id from Profesor where email = '"+this.email+"') and expirata = 0");
            while (resultSet.next()) {
                numeA=numeA+resultSet.getString("nume")+"\n";
            }
            activitArea.insert(numeA, 0);
        }catch(Exception A)
        {
            System.out.println(A);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        activitLabel = new javax.swing.JLabel();
        activitField = new javax.swing.JTextField();
        participaButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        activitArea = new javax.swing.JTextArea();
        inapoiButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        activitLabel.setText("Activitati active ale grupului:");

        participaButton.setText("Participa");
        participaButton.setFocusable(false);
        participaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participaButtonActionPerformed(evt);
            }
        });

        activitArea.setColumns(20);
        activitArea.setRows(5);
        jScrollPane2.setViewportView(activitArea);

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(activitLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(participaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                                        .addComponent(activitField, javax.swing.GroupLayout.Alignment.LEADING))))
                                                .addGap(88, 88, 88)
                                                .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(activitField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(participaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(activitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void participaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            connection = GetConnection.getConnection(this.email, this.parola);
            String asigneazaGrupActivitate = "{ call asigneazaGrupActivitateProf(?, ?) }";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Profesor where Profesor.email = '"+this.email+"'");
            while (resultSet.next()) {
                idProf=resultSet.getString("id");
            }
            CallableStatement cs = connection.prepareCall(asigneazaGrupActivitate);
            cs.setString(1, activitField.getText());
            cs.setString(2, idProf);
            cs.execute();
            activitField.setText("");
        }catch(Exception A)
        {
            System.out.println(A);
        }
    }

    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuProfesor back = new MenuProfesor(this.email, this.parola);
    }

    private javax.swing.JTextArea activitArea;
    private javax.swing.JTextField activitField;
    private javax.swing.JLabel activitLabel;
    private javax.swing.JButton inapoiButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton participaButton;
}
