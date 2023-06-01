package Admin;
import LogIn.GetConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cauta_Modifica extends javax.swing.JFrame {
    String email;
    String parola;
    String role = "null";
    Connection connection;
    GetConnection connect = new GetConnection();
    String emailUser = "null";

    public Cauta_Modifica(String email, String parola) {
        initComponents();
        this.email = email;
        this.parola = parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        oredepLabel.setVisible(false);
        oredepField.setVisible(false);
        orePLabel.setVisible(false);
        orePField.setVisible(false);
        oreOreLabel.setVisible(false);
        oreOreField.setVisible(false);
        oreMaxField.setVisible(false);
        numeField.setEditable(false);
        prenumeField.setEditable(false);
        cnpField.setEditable(false);
        adresaField.setEditable(false);
        telefonField.setEditable(false);
        emailField.setEditable(false);
        ibanField.setEditable(false);
        contractField.setEditable(false);
        oredepField.setEditable(false);
        orePField.setEditable(false);
        oreOreField.setEditable(false);
        oreMaxField.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        cautaLabel = new javax.swing.JLabel();
        numeLabel = new javax.swing.JLabel();
        prenumeLabel = new javax.swing.JLabel();
        adresaLabel = new javax.swing.JLabel();
        cnpLabel = new javax.swing.JLabel();
        telefonLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        ibanLabel = new javax.swing.JLabel();
        contractLabel = new javax.swing.JLabel();
        oredepLabel = new javax.swing.JLabel();
        oreOreLabel = new javax.swing.JLabel();
        cautaField = new javax.swing.JTextField();
        numeField = new javax.swing.JTextField();
        cnpField = new javax.swing.JTextField();
        prenumeField = new javax.swing.JTextField();
        adresaField = new javax.swing.JTextField();
        telefonField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        ibanField = new javax.swing.JTextField();
        contractField = new javax.swing.JTextField();
        oredepField = new javax.swing.JTextField();
        oreOreField = new javax.swing.JTextField();
        cautaButton = new javax.swing.JButton();
        modificaButton = new javax.swing.JButton();
        inapoiButton = new javax.swing.JButton();
        studentRadio = new javax.swing.JRadioButton();
        profesorRadio = new javax.swing.JRadioButton();
        aplicaButton = new javax.swing.JButton();
        orePLabel = new javax.swing.JLabel();
        orePField = new javax.swing.JTextField();
        oreMaxField = new javax.swing.JTextField();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cauta si Modifica");

        cautaLabel.setText("Nume/Prenume:");

        numeLabel.setText("Nume:");

        prenumeLabel.setText("Prenume:");

        adresaLabel.setText("Adresa:");

        cnpLabel.setText("CNP:");

        telefonLabel.setText("Telefon:");

        emailLabel.setText("Email:");

        ibanLabel.setText("IBAN:");

        contractLabel.setText("Contract:");

        oredepLabel.setText("Departament/ore");

        oreOreLabel.setText("Ore");

        cautaButton.setText("Cauta");
        cautaButton.setFocusable(false);
        cautaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cautaButtonActionPerformed(evt);
            }
        });

        modificaButton.setText("Modifica");
        modificaButton.setFocusable(false);
        modificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaButtonActionPerformed(evt);
            }
        });

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
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

        aplicaButton.setText("Aplica");
        aplicaButton.setFocusable(false);
        aplicaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicaButtonActionPerformed(evt);
            }
        });

        orePLabel.setText("Ore:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(cautaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cautaField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cautaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(profesorRadio)
                                                        .addComponent(modificaButton)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(numeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numeField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(studentRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(adresaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(adresaField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(telefonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(telefonField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(ibanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ibanField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(contractLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(contractField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(oreOreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(oreOreField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(oreMaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(prenumeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(cnpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(prenumeField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(cnpField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(oredepLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(oredepField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(orePLabel)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(orePField))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(aplicaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cautaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cautaField, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(modificaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(cautaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(profesorRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(studentRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(aplicaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(numeField)
                                        .addComponent(numeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(prenumeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(prenumeField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cnpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(cnpField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(adresaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adresaField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(telefonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(telefonField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ibanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ibanField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(contractLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(contractField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(oredepLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(oredepField, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(orePLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(orePField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(oreOreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(oreMaxField)
                                        .addComponent(oreOreField))
                                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>

    private void studentRadioActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        role = "Student";
        oredepLabel.setVisible(false);
        oredepField.setVisible(false);
        orePLabel.setVisible(false);
        orePField.setVisible(false);
        oreOreLabel.setVisible(false);
        oreOreField.setVisible(false);
        oreMaxField.setVisible(false);
        oredepLabel.setVisible(true);
        oredepLabel.setText("An:");
        oredepField.setVisible(true);
        orePLabel.setVisible(true);
        orePField.setVisible(true);
        orePLabel.setText("Ore:");

    }

    private void profesorRadioActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        role = "Profesor";
        oredepLabel.setVisible(false);
        oredepField.setVisible(false);
        orePLabel.setVisible(false);
        orePField.setVisible(false);
        oreOreLabel.setVisible(false);
        oreOreField.setVisible(false);
        oreMaxField.setVisible(false);
        oredepLabel.setVisible(true);
        oredepLabel.setText("Departament:");
        oredepField.setVisible(true);
        orePLabel.setVisible(true);
        orePField.setVisible(true);
        oreOreLabel.setVisible(true);
        oreOreLabel.setText("Ore Min/Max:");
        oreOreField.setVisible(true);
        oreMaxField.setVisible(true);
    }

    private void cautaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String text = cautaField.getText();
        int i = text.indexOf(" ");
        String numeOld = text.substring(0, i); // from 0 to 3
        String prenumeOld = text.substring(i + 1); // after the space to the rest of the line
        try {
            connection = connect.getConnection(this.email, this.parola);
            Statement statement = connection.createStatement();
            ResultSet resultSet = null;
            if (role.equals("Profesor")) {
                resultSet = statement.executeQuery("Select * from Profesor where nume = '" + numeOld + "' and prenume = '" + prenumeOld + "'");
            } else if (role.equals("Student")) {
                resultSet = statement.executeQuery("Select * from Student where nume = '" + numeOld + "' and prenume = '" + prenumeOld + "'");
            }
            while (resultSet.next()) {
                numeField.setText(resultSet.getString("nume"));
                prenumeField.setText(resultSet.getString("prenume"));
                cnpField.setText(resultSet.getString("cnp"));
                adresaField.setText(resultSet.getString("adresa"));
                telefonField.setText(resultSet.getString("telefon"));
                emailField.setText(resultSet.getString("email"));
                ibanField.setText(resultSet.getString("iban"));
                contractField.setText(resultSet.getString("nrContract"));
                this.emailUser = resultSet.getString("email");
                if (role.equals("Student")) {
                    oredepField.setText(resultSet.getString("an"));
                    orePField.setText(resultSet.getString("nrOre"));
                } else if (role.equals("Profesor")) {
                    oredepField.setText(resultSet.getString("departament"));
                    orePField.setText(resultSet.getString("nrOrePred"));
                    oreOreField.setText(resultSet.getString("oreMin"));
                    oreMaxField.setText(resultSet.getString("oreMax"));
                }
            }
        } catch (Exception A) {
            System.out.println(A);
        }
    }

    private void modificaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        numeField.setEditable(true);
        prenumeField.setEditable(true);
        cnpField.setEditable(true);
        adresaField.setEditable(true);
        telefonField.setEditable(true);
        emailField.setEditable(true);
        ibanField.setEditable(true);
        contractField.setEditable(true);
        if (role.equals("Profesor")) {
            oredepField.setEditable(true);
            orePField.setEditable(true);
            oreOreField.setEditable(true);
            oreMaxField.setEditable(true);
        } else if (role.equals("Student")) {
            oredepField.setEditable(true);
            orePField.setEditable(true);
        }
    }

    private void aplicaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        numeField.setEditable(false);
        prenumeField.setEditable(false);
        cnpField.setEditable(false);
        adresaField.setEditable(false);
        telefonField.setEditable(false);
        emailField.setEditable(false);
        ibanField.setEditable(false);
        contractField.setEditable(false);
        oredepField.setEditable(false);
        orePField.setEditable(false);
        oreOreField.setEditable(false);
        oreMaxField.setEditable(false);
        if (role.equals("Profesor")) {
            try {
                connection = connect.getConnection(this.email, this.parola);
                String updateProfesor = "{ call updateProfesor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?) }";
                CallableStatement cs = connection.prepareCall(updateProfesor);
                cs.setString(1, emailUser);
                cs.setString(2, numeField.getText());
                cs.setString(3, prenumeField.getText());
                cs.setString(4, cnpField.getText());
                cs.setString(5, adresaField.getText());
                cs.setString(6, telefonField.getText());
                cs.setString(7, emailField.getText());
                this.emailUser = emailField.getText();
                cs.setString(8, ibanField.getText());
                cs.setString(9, String.valueOf((Integer.parseInt(contractField.getText()))));
                cs.setString(10, oredepField.getText());
                cs.setString(11, String.valueOf((Integer.parseInt(orePField.getText()))));
                cs.setString(12, String.valueOf((Integer.parseInt(oreOreField.getText()))));
                cs.setString(13, String.valueOf((Integer.parseInt(oreMaxField.getText()))));
                cs.execute();
            }catch(Exception A)
            {
                System.out.println(A);
            }
        }else
        if (role.equals("Student")) {
            try {
                connection = connect.getConnection(this.email, this.parola);
                String updateStudent = "{ call updateStudent(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
                CallableStatement cs = connection.prepareCall(updateStudent);
                cs.setString(1, emailUser);
                cs.setString(2, numeField.getText());
                cs.setString(3, prenumeField.getText());
                cs.setString(4, cnpField.getText());
                cs.setString(5, adresaField.getText());
                cs.setString(6, telefonField.getText());
                cs.setString(7, emailField.getText());
                this.emailUser = emailField.getText();
                cs.setString(8, ibanField.getText());
                cs.setString(9, String.valueOf((Integer.parseInt(contractField.getText()))));
                cs.setString(10, oredepField.getText());
                cs.setString(11, String.valueOf((Integer.parseInt(orePField.getText()))));
                cs.execute();
            }catch(Exception A)
            {
                System.out.println(A);
            }
        }
    }
    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuAdmin back = new MenuAdmin(this.email, this.parola);
    }

    private javax.swing.JTextField adresaField;
    private javax.swing.JLabel adresaLabel;
    private javax.swing.JButton aplicaButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cautaButton;
    private javax.swing.JTextField cautaField;
    private javax.swing.JLabel cautaLabel;
    private javax.swing.JTextField cnpField;
    private javax.swing.JLabel cnpLabel;
    private javax.swing.JTextField contractField;
    private javax.swing.JLabel contractLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField ibanField;
    private javax.swing.JLabel ibanLabel;
    private javax.swing.JButton inapoiButton;
    private javax.swing.JButton modificaButton;
    private javax.swing.JTextField numeField;
    private javax.swing.JLabel numeLabel;
    private javax.swing.JTextField oreMaxField;
    private javax.swing.JTextField oreOreField;
    private javax.swing.JLabel oreOreLabel;
    private javax.swing.JTextField orePField;
    private javax.swing.JLabel orePLabel;
    private javax.swing.JTextField oredepField;
    private javax.swing.JLabel oredepLabel;
    private javax.swing.JTextField prenumeField;
    private javax.swing.JLabel prenumeLabel;
    private javax.swing.JRadioButton profesorRadio;
    private javax.swing.JRadioButton studentRadio;
    private javax.swing.JTextField telefonField;
    private javax.swing.JLabel telefonLabel;
    // End of variables declaration
}
