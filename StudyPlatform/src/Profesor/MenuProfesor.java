package Profesor;

import LogIn.LogInPage;
import LogIn.GetConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class MenuProfesor extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect;
    public MenuProfesor(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    private void initComponents() {

        datePersButton = new javax.swing.JButton();
        deautentificareButton = new javax.swing.JButton();
        veziActivButton = new javax.swing.JButton();
        catalogButton = new javax.swing.JButton();
        programActivitati = new javax.swing.JButton();
        activitGrButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        datePersButton.setText("Date Personale");
        datePersButton.setFocusable(false);
        datePersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePersButtonActionPerformed(evt);
            }
        });

        deautentificareButton.setText("Deautentificare");
        deautentificareButton.setFocusable(false);
        deautentificareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deautentificareButtonActionPerformed(evt);
            }
        });

        veziActivButton.setText("Vezi activitati");
        veziActivButton.setFocusable(false);
        veziActivButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veziActivButtonActionPerformed(evt);
            }
        });

        catalogButton.setText("Catalog");
        catalogButton.setFocusable(false);
        catalogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogButtonActionPerformed(evt);
            }
        });

        programActivitati.setText("Programeaza Activitati");
        programActivitati.setFocusable(false);
        programActivitati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programActivitatiActionPerformed(evt);
            }
        });

        activitGrButton.setText("Activitati grup studiu");
        activitGrButton.setFocusable(false);
        activitGrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activitGrButtonActionPerformed(evt);
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
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(deautentificareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(activitGrButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(catalogButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(datePersButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(programActivitati, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(veziActivButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(datePersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(veziActivButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(catalogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(programActivitati, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(activitGrButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(deautentificareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void datePersButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        DatePersonaleP dP = new DatePersonaleP(this.email, this.parola);
    }

    private void deautentificareButtonActionPerformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:
        this.dispose();
        LogInPage.disconnect();
        LogInPage deautentific = new LogInPage();
    }

    private void veziActivButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        VeziActivitati vezi = new VeziActivitati(this.email, this.parola);
    }

    private void catalogButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        Catalog c = new Catalog(this.email, this.parola);
    }

    private void programActivitatiActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        ProgrameazaActivitati program = new ProgrameazaActivitati(this.email, this.parola);
    }

    private void activitGrButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        ActivitatiGrup activit = new ActivitatiGrup(this.email, this.parola);
    }

    private javax.swing.JButton datePersButton;
    private javax.swing.JButton deautentificareButton;
    private javax.swing.JButton programActivitati;
    private javax.swing.JButton veziActivButton;
    private javax.swing.JButton catalogButton;
    private javax.swing.JButton activitGrButton;
}
