package Admin;

import LogIn.GetConnection;

import java.sql.CallableStatement;
import java.sql.Connection;

public class AsignareStudentActivitate extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect = new GetConnection();
    String[] Activitati = new String[5];
    public AsignareStudentActivitate(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        Activitati[0]=Activitati[1]=Activitati[2]=Activitati[3]=Activitati[4]="null";
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        numeLabel = new javax.swing.JLabel();
        prenumeLabel = new javax.swing.JLabel();
        materieLabel = new javax.swing.JLabel();
        numeField = new javax.swing.JTextField();
        prenumeField = new javax.swing.JTextField();
        materieField = new javax.swing.JTextField();
        inapoiButton = new javax.swing.JButton();
        examenCheck = new javax.swing.JCheckBox();
        colocCheck = new javax.swing.JCheckBox();
        labCheck = new javax.swing.JCheckBox();
        seminarCheck = new javax.swing.JCheckBox();
        cursCheck = new javax.swing.JCheckBox();
        asigneazaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        numeLabel.setText("Nume:");

        prenumeLabel.setText("Prenume:");

        materieLabel.setText("Materie:");

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        examenCheck.setText("Examen");
        examenCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examenCheckActionPerformed(evt);
            }
        });

        colocCheck.setText("Colocviu");
        colocCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colocCheckActionPerformed(evt);
            }
        });

        labCheck.setText("Laborator");
        labCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labCheckActionPerformed(evt);
            }
        });

        seminarCheck.setText("Seminar");
        seminarCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seminarCheckActionPerformed(evt);
            }
        });

        cursCheck.setText("Curs");
        cursCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursCheckActionPerformed(evt);
            }
        });

        asigneazaButton.setText("Asigneaza");
        asigneazaButton.setFocusable(false);
        asigneazaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asigneazaButtonActionPerformed(evt);
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
                                                .addComponent(numeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numeField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labCheck)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(materieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cursCheck)
                                                                        .addComponent(seminarCheck))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(examenCheck)
                                                                        .addComponent(colocCheck)
                                                                        .addComponent(materieField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(prenumeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prenumeField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(asigneazaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(prenumeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(asigneazaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(prenumeField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(materieLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(materieField, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cursCheck)
                                        .addComponent(colocCheck))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(seminarCheck)
                                        .addComponent(examenCheck))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labCheck)
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuAdmin back = new MenuAdmin(this.email, this.parola);
    }

    private void examenCheckActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(examenCheck.isSelected())
        {
            Activitati[4]="Examen";
        }else
        {
            Activitati[4]="null";
        }
        System.out.println(Activitati[4]);
    }

    private void colocCheckActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(colocCheck.isSelected())
        {
            Activitati[3]="Colocviu";
        }else
        {
            Activitati[3]="null";
        }
        System.out.println(Activitati[3]);
    }

    private void labCheckActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(labCheck.isSelected())
        {
            Activitati[2]="Laborator";
        }else
        {
            Activitati[2]="null";
        }
        System.out.println(Activitati[2]);
    }

    private void seminarCheckActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(seminarCheck.isSelected())
        {
            Activitati[1]="Seminar";
        }else
        {
            Activitati[1]="null";
        }
        System.out.println(Activitati[1]);
    }

    private void cursCheckActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(cursCheck.isSelected())
        {
            Activitati[0]="Curs";
        }else
        {
            Activitati[0]="null";
        }
        System.out.println(Activitati[0]);
    }

    private void asigneazaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            connection = connect.getConnection(this.email, this.parola);
            String asigneazaStudentA = "{ call asigneazaStudentA(?, ?, ?, ?) }";
            CallableStatement cs = connection.prepareCall(asigneazaStudentA);
            for(String ac : Activitati)
            {
                if(!ac.equals("null")) {
                    cs.setString(1, numeField.getText());
                    cs.setString(2, prenumeField.getText());
                    cs.setString(3, materieField.getText());
                    cs.setString(4, ac);
                }
            }
            cs.execute();
            numeField.setText("");
            prenumeField.setText("");
            materieField.setText("");
        }catch(Exception A)
        {
            System.out.println(A);
        }
        Activitati[0]=Activitati[1]=Activitati[2]=Activitati[3]=Activitati[4]="null";
        cursCheck.setSelected(false);
        seminarCheck.setSelected(false);
        labCheck.setSelected(false);
        colocCheck.setSelected(false);
        examenCheck.setSelected(false);
    }
    // Variables declaration - do not modify
    private javax.swing.JButton asigneazaButton;
    private javax.swing.JCheckBox colocCheck;
    private javax.swing.JCheckBox cursCheck;
    private javax.swing.JCheckBox examenCheck;
    private javax.swing.JButton inapoiButton;
    private javax.swing.JCheckBox labCheck;
    private javax.swing.JTextField materieField;
    private javax.swing.JLabel materieLabel;
    private javax.swing.JTextField numeField;
    private javax.swing.JLabel numeLabel;
    private javax.swing.JTextField prenumeField;
    private javax.swing.JLabel prenumeLabel;
    private javax.swing.JCheckBox seminarCheck;
    // End of variables declaration
}
