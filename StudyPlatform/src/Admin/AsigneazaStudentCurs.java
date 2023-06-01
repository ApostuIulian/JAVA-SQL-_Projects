package Admin;

import LogIn.GetConnection;

import java.sql.CallableStatement;
import java.sql.Connection;

public class AsigneazaStudentCurs extends javax.swing.JFrame {

    String email;
    String parola;
    Connection connection;
    public AsigneazaStudentCurs(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        asigneazaButton = new javax.swing.JButton();
        inapoiButton = new javax.swing.JButton();
        numeField = new javax.swing.JTextField();
        numeLabel = new javax.swing.JLabel();
        materieLabel = new javax.swing.JLabel();
        materieField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asigneaza Student la Curs");

        asigneazaButton.setText("Asigneaza");
        asigneazaButton.setFocusable(false);
        asigneazaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asigneazaButtonActionPerformed(evt);
            }
        });

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        numeLabel.setText("Nume/Prenume:");

        materieLabel.setText("Materie:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(asigneazaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(materieLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(numeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(materieField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(99, 99, 99))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(numeField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(4, 4, 4))))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(numeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(materieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(materieField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(asigneazaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101))
        );

        pack();
    }// </editor-fold>

    private void asigneazaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String text = numeField.getText();
        int i = text.indexOf(" ");
        String nume = text.substring(0, i);
        String prenume = text.substring(i + 1);
        try {
            connection = GetConnection.getConnection(this.email, this.parola);
            String asigneazaStudentC = "{ call asigneazaStudentC(?, ?, ?) }";
            CallableStatement cs = connection.prepareCall(asigneazaStudentC);
            cs.setString(1, nume);
            cs.setString(2, prenume);
            cs.setString(3, materieField.getText());
            cs.execute();
            numeField.setText("");
            materieField.setText("");
        }catch(Exception A)
        {
            System.out.println(A);
        }
    }

    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        AsigneazaStudent back = new AsigneazaStudent(this.email, this.parola);
    }
    private javax.swing.JButton asigneazaButton;
    private javax.swing.JButton inapoiButton;
    private javax.swing.JTextField materieField;
    private javax.swing.JLabel materieLabel;
    private javax.swing.JTextField numeField;
    private javax.swing.JLabel numeLabel;
}
