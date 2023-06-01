package Student;
import Student.Grupuri.*;
import LogIn.GetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GrupuriStudiu extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect = new GetConnection();
    String materie;
    int rows=0;
    public GrupuriStudiu(String email, String parol) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        inapoiButton = new javax.swing.JButton();
        materieLabel = new javax.swing.JLabel();
        materieField = new javax.swing.JTextField();
        acceseazaButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        statusLabel.setText("Nu faci parte din acest grup!");
        statusLabel.setVisible(false);

        materieLabel.setText("Materie:");

        acceseazaButton.setText("Acceseaza Grup");
        acceseazaButton.setFocusable(false);
        acceseazaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceseazaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(acceseazaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(materieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(materieField, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(materieLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(materieField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(acceseazaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }
    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuStudent back = new MenuStudent(this.email, this.parola);
    }

    private void acceseazaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here
        try {
            connection = connect.getConnection(this.email, this.parola);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from grup where grup.idM = (Select id from materie where materie.descriere = '" +
                    materieField.getText() + "') and grup.idS = (Select id from student where student.email = '"+this.email+"')");
            while(resultSet.next())
            {
                rows++;
            }
            System.out.println(rows);
            ResultSet resultSet1 = statement.executeQuery("select * from materie where materie.descriere = '"+materieField.getText()+"'");
            while(resultSet1.next()) {
                this.materie = resultSet1.getString("descriere");
            }
            if(rows==0)
            {
                statusLabel.setVisible(true);
            }else
            {
                if(materie.equals("CAN")) {
                    this.dispose();
                    CAN mat = new CAN(this.email, this.parola);
                }else if(materie.equals("POO")) {
                    this.dispose();
                    POO mat = new POO(this.email, this.parola);
                }else if(materie.equals("MES")) {
                    this.dispose();
                    MES mat = new MES(this.email, this.parola);
                }else if(materie.equals("MSI")) {
                    this.dispose();
                    MSI mat = new MSI(this.email, this.parola);
                }else if(materie.equals("AF")) {
                    this.dispose();
                    AF mat = new AF(this.email, this.parola);
                }else if(materie.equals("BD")) {
                    this.dispose();
                    BD mat = new BD(this.email, this.parola);
                }else
                {
                    statusLabel.setVisible(true);
                }
                System.out.println(rows+" "+materie);
            }
        }catch (Exception A)
        {
            System.out.println(A);
        }
    }
    private javax.swing.JButton acceseazaButton;
    private javax.swing.JButton inapoiButton;
    private javax.swing.JTextField materieField;
    private javax.swing.JLabel materieLabel;
    private javax.swing.JLabel statusLabel;
}
