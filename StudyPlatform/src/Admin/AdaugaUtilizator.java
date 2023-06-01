package Admin;

import LogIn.GetConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdaugaUtilizator extends javax.swing.JFrame {
    String email;
    String parola;
    String role = "null";
    Connection connection;
    GetConnection connect = new GetConnection();
    public AdaugaUtilizator(String email, String parola) {
        initComponents();
        this.email = email;
        this.parola = parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        numeLabel = new javax.swing.JLabel();
        numeField = new javax.swing.JTextField();
        prenumeLabel = new javax.swing.JLabel();
        prenumeField = new javax.swing.JTextField();
        cnpField = new javax.swing.JTextField();
        cnpLabel = new javax.swing.JLabel();
        adresField = new javax.swing.JTextField();
        adresaLabel = new javax.swing.JLabel();
        telefonField = new javax.swing.JTextField();
        telefonLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        ibanLabel = new javax.swing.JLabel();
        ibanField = new javax.swing.JTextField();
        contractField = new javax.swing.JTextField();
        contractLabel = new javax.swing.JLabel();
        deporeField = new javax.swing.JTextField();
        deporeLabel = new javax.swing.JLabel();
        oreLabel = new javax.swing.JLabel();
        oreField = new javax.swing.JTextField();
        oreMMLabel = new javax.swing.JLabel();
        oreMinField = new javax.swing.JTextField();
        oreMaxField = new javax.swing.JTextField();
        inapoiButton = new javax.swing.JButton();
        adaugaButton = new javax.swing.JButton();
        studentRadio = new javax.swing.JRadioButton();
        profesorRadio = new javax.swing.JRadioButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        numeLabel.setText("Nume:");

        prenumeLabel.setText("Prenume:");

        cnpLabel.setText("CNP:");

        adresaLabel.setText("Adresa:");

        telefonLabel.setText("Telefon:");

        emailLabel.setText("Email:");

        ibanLabel.setText("IBAN:");

        contractLabel.setText("Contract:");

        deporeLabel.setText("Departament/Ore");

        oreLabel.setText("Ore:");

        oreMMLabel.setText("Ore:");

        inapoiButton.setText("Inapoi");
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        adaugaButton.setText("Adauga");
        adaugaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(studentRadio);
        studentRadio.setText("Student");
        studentRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(profesorRadio);
        profesorRadio.setText("Profesor");
        profesorRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profesorRadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(numeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(numeField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(prenumeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(prenumeField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(cnpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cnpField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(adresaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(adresField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(telefonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(telefonField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(ibanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(ibanField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(contractLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(contractField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(deporeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(deporeField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(oreLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(oreField)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(adaugaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                                        .addComponent(studentRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(oreMMLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(oreMinField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(oreMaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(profesorRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(numeField, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                                        .addComponent(adaugaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(numeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(prenumeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(prenumeField, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                                .addComponent(studentRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(profesorRadio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cnpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cnpField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(adresaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(adresField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(telefonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(telefonField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ibanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ibanField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(contractLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(contractField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(deporeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(deporeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(oreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(oreField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(oreMMLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(oreMinField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(oreMaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>

    private void studentRadioActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        role = "Student";
        deporeLabel.setVisible(false);
        deporeField.setVisible(false);
        oreLabel.setVisible(false);
        oreField.setVisible(false);
        oreMMLabel.setVisible(false);
        oreMinField.setVisible(false);
        oreMaxField.setVisible(false);
        deporeLabel.setVisible(true);
        deporeLabel.setText("An:");
        deporeField.setVisible(true);
        oreLabel.setVisible(true);
        oreField.setVisible(true);
        oreLabel.setText("Ore:");
    }

    private void profesorRadioActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        role = "Profesor";
        deporeLabel.setVisible(false);
        deporeField.setVisible(false);
        oreLabel.setVisible(false);
        oreField.setVisible(false);
        oreLabel.setVisible(false);
        oreMinField.setVisible(false);
        oreMaxField.setVisible(false);
        deporeLabel.setVisible(true);
        deporeLabel.setText("Departament:");
        deporeField.setVisible(true);
        oreLabel.setVisible(true);
        oreField.setVisible(true);
        oreMMLabel.setVisible(true);
        oreMMLabel.setText("Ore Min/Max:");
        oreMinField.setVisible(true);
        oreMaxField.setVisible(true);
    }

    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuAdmin back = new MenuAdmin(this.email, this.parola);
    }

    private void adaugaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (role.equals("Profesor")) {
            try {
                connection = connect.getConnection(this.email, this.parola);
                String updateProfesor = "{ call insertProfesor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?) }";
                CallableStatement cs = connection.prepareCall(updateProfesor);
                cs.setString(1, numeField.getText());
                cs.setString(2, prenumeField.getText());
                cs.setString(3, cnpField.getText());
                cs.setString(4, adresField.getText());
                cs.setString(5, telefonField.getText());
                cs.setString(6, emailField.getText());
                cs.setString(7, ibanField.getText());
                cs.setString(8, String.valueOf((Integer.parseInt(contractField.getText()))));
                cs.setString(9, deporeField.getText());
                cs.setString(10, String.valueOf((Integer.parseInt(oreField.getText()))));
                cs.setString(11, String.valueOf((Integer.parseInt(oreMinField.getText()))));
                cs.setString(12, String.valueOf((Integer.parseInt(oreMaxField.getText()))));
                cs.execute();
            }catch(Exception A)
            {
                System.out.println(A);
            }
        }else
        if (role.equals("Student")) {
            try {
                connection = connect.getConnection(this.email, this.parola);
                String updateStudent = "{ call insertStudent(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
                CallableStatement cs = connection.prepareCall(updateStudent);
                cs.setString(1, numeField.getText());
                cs.setString(2, prenumeField.getText());
                cs.setString(3, cnpField.getText());
                cs.setString(4, adresField.getText());
                cs.setString(5, telefonField.getText());
                cs.setString(6, emailField.getText());
                cs.setString(7, ibanField.getText());
                cs.setString(8, String.valueOf((Integer.parseInt(contractField.getText()))));
                cs.setString(9, deporeField.getText());
                cs.setString(10, String.valueOf((Integer.parseInt(oreField.getText()))));
                cs.execute();
            }catch(Exception A)
            {
                System.out.println(A);
            }
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton adaugaButton;
    private javax.swing.JTextField adresField;
    private javax.swing.JLabel adresaLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cnpField;
    private javax.swing.JLabel cnpLabel;
    private javax.swing.JTextField contractField;
    private javax.swing.JLabel contractLabel;
    private javax.swing.JLabel deporeLabel;
    private javax.swing.JTextField deporeField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField ibanField;
    private javax.swing.JLabel ibanLabel;
    private javax.swing.JButton inapoiButton;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JTextField numeField;
    private javax.swing.JLabel numeLabel;
    private javax.swing.JTextField oreField;
    private javax.swing.JLabel oreLabel;
    private javax.swing.JLabel oreMMLabel;
    private javax.swing.JTextField oreMaxField;
    private javax.swing.JTextField oreMinField;
    private javax.swing.JTextField prenumeField;
    private javax.swing.JLabel prenumeLabel;
    private javax.swing.JRadioButton profesorRadio;
    private javax.swing.JRadioButton studentRadio;
    private javax.swing.JTextField telefonField;
    private javax.swing.JLabel telefonLabel;
    // End of variables declaration
}
