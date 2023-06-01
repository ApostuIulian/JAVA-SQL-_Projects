package Admin;

import LogIn.GetConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatePersonaleA extends javax.swing.JFrame
{
    String email;
    String parola;
    Connection connection;
    GetConnection connect = new GetConnection();
    public DatePersonaleA(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        try {
            connection = connect.getConnection(email, parola);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from admin where email = '"+this.email+"'");
            while (resultSet.next()) {
                numeField.setText(resultSet.getString("nume"));
                numeField.setEditable(false);
                prenumeField.setText(resultSet.getString("prenume"));
                prenumeField.setEditable(false);
                cnpField.setText(resultSet.getString("cnp"));
                cnpField.setEditable(false);
                adresaField.setText(resultSet.getString("adresa"));
                adresaField.setEditable(false);
                telefonField.setText(resultSet.getString("telefon"));
                telefonField.setEditable(false);
                emailField.setText(resultSet.getString("email"));
                emailField.setEditable(false);
                ibanField.setText(resultSet.getString("iban"));
                ibanField.setEditable(false);
                contractField.setText(resultSet.getString("nrContract"));
                contractField.setEditable(false);
            }
            connection.close();
        } catch (Exception A) {
            System.out.println(A);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        inapoiButton = new javax.swing.JButton();
        numeLabel = new javax.swing.JLabel();
        prenumeLabel = new javax.swing.JLabel();
        adresaLabel = new javax.swing.JLabel();
        cnpLabel = new javax.swing.JLabel();
        telefonLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        contractLabel = new javax.swing.JLabel();
        ibanLabel = new javax.swing.JLabel();
        numeField = new javax.swing.JTextField();
        prenumeField = new javax.swing.JTextField();
        adresaField = new javax.swing.JTextField();
        cnpField = new javax.swing.JTextField();
        telefonField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        ibanField = new javax.swing.JTextField();
        contractField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Date Personale");

        inapoiButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inapoiButton.setText("Inapoi");
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        numeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numeLabel.setText("Nume:");

        prenumeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        prenumeLabel.setText("Prenume");

        adresaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adresaLabel.setText("Adresa:");

        cnpLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cnpLabel.setText("CNP:");

        telefonLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        telefonLabel.setText("Telefon:");

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailLabel.setText("Email:");

        contractLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        contractLabel.setText("Contract:");

        ibanLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ibanLabel.setText("IBAN:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(contractLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(ibanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(telefonLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(adresaLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cnpLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(prenumeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(numeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(numeField, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                                        .addComponent(prenumeField)
                                        .addComponent(adresaField)
                                        .addComponent(cnpField)
                                        .addComponent(telefonField)
                                        .addComponent(emailField)
                                        .addComponent(ibanField)
                                        .addComponent(contractField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(numeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(numeField, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(prenumeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(prenumeField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cnpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cnpField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(adresaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adresaField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(telefonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(telefonField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ibanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ibanField, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(contractLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(contractField))
                                .addGap(11, 11, 11))
        );

        pack();
    }

    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuAdmin back = new MenuAdmin(this.email, this.parola);
    }
    private javax.swing.JTextField adresaField;
    private javax.swing.JLabel adresaLabel;
    private javax.swing.JTextField cnpField;
    private javax.swing.JLabel cnpLabel;
    private javax.swing.JTextField contractField;
    private javax.swing.JLabel contractLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField ibanField;
    private javax.swing.JLabel ibanLabel;
    private javax.swing.JButton inapoiButton;
    private javax.swing.JTextField numeField;
    private javax.swing.JLabel numeLabel;
    private javax.swing.JTextField prenumeField;
    private javax.swing.JLabel prenumeLabel;
    private javax.swing.JTextField telefonField;
    private javax.swing.JLabel telefonLabel;
}
