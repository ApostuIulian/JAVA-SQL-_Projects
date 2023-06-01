package Student;

import LogIn.GetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatePersonaleS extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect;
    public DatePersonaleS(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        try {
            connection = connect.getConnection(email, parola);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from Student where email = '"+this.email+"'");
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
                anField.setText(resultSet.getString("an"));
                anField.setEditable(false);
                oreField.setText(resultSet.getString("nrOre"));
                oreField.setEditable(false);
            }
            connection.close();
        } catch (Exception A) {
            System.out.println(A);
        }
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        inapoiButton = new javax.swing.JButton();
        numeLabel = new javax.swing.JLabel();
        prenumeLabel = new javax.swing.JLabel();
        cnpLabel = new javax.swing.JLabel();
        adresaLabel = new javax.swing.JLabel();
        telefonLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        ibanLabel = new javax.swing.JLabel();
        contractLabel = new javax.swing.JLabel();
        anLabel = new javax.swing.JLabel();
        oreLabel = new javax.swing.JLabel();
        numeField = new javax.swing.JTextField();
        prenumeField = new javax.swing.JTextField();
        cnpField = new javax.swing.JTextField();
        adresaField = new javax.swing.JTextField();
        telefonField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        ibanField = new javax.swing.JTextField();
        contractField = new javax.swing.JTextField();
        anField = new javax.swing.JTextField();
        oreField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        numeLabel.setText("Nume:");

        prenumeLabel.setText("Prenume:");

        cnpLabel.setText("CNP:");

        adresaLabel.setText("Adresa:");

        telefonLabel.setText("Telefon:");

        emailLabel.setText("Email:");

        ibanLabel.setText("IBAN:");

        contractLabel.setText("Contract:");

        anLabel.setText("An:");

        oreLabel.setText("Numar de ore:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(numeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numeField)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(oreLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(prenumeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addComponent(cnpLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addComponent(adresaLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addComponent(telefonLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addComponent(ibanLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addComponent(contractLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addComponent(anLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(prenumeField, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                                                        .addComponent(cnpField)
                                                        .addComponent(adresaField)
                                                        .addComponent(telefonField)
                                                        .addComponent(emailField)
                                                        .addComponent(ibanField)
                                                        .addComponent(contractField)
                                                        .addComponent(anField)
                                                        .addComponent(oreField))
                                                .addGap(156, 156, 156)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(numeField)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(numeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(prenumeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(prenumeField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cnpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cnpField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(adresaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adresaField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(telefonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(telefonField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ibanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ibanField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(contractLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(contractField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(anLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(anField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(oreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(oreField))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }
    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuStudent back = new MenuStudent(this.email, this.parola);
    }
    private javax.swing.JTextField adresaField;
    private javax.swing.JLabel adresaLabel;
    private javax.swing.JTextField anField;
    private javax.swing.JLabel anLabel;
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
    private javax.swing.JTextField oreField;
    private javax.swing.JLabel oreLabel;
    private javax.swing.JTextField prenumeField;
    private javax.swing.JLabel prenumeLabel;
    private javax.swing.JTextField telefonField;
    private javax.swing.JLabel telefonLabel;
}
