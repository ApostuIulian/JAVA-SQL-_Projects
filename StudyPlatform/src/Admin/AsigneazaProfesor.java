
package Admin;

import LogIn.GetConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class AsigneazaProfesor extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect = new GetConnection();
    String[] Activitati = new String[5];
    public AsigneazaProfesor(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        statusLabel.setVisible(false);
        Activitati[0]=Activitati[1]=Activitati[2]=Activitati[3]=Activitati[4]="null";
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        inapoiButton = new javax.swing.JButton();
        numeLabel = new javax.swing.JLabel();
        numeField = new javax.swing.JTextField();
        materieLabel = new javax.swing.JLabel();
        materieField = new javax.swing.JTextField();
        depLabel = new javax.swing.JLabel();
        depField = new javax.swing.JTextField();
        asigneazaButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        cursCheck = new javax.swing.JCheckBox();
        seminarCheck = new javax.swing.JCheckBox();
        labCheck = new javax.swing.JCheckBox();
        colocCheck = new javax.swing.JCheckBox();
        examenCheck = new javax.swing.JCheckBox();
        capacitateLabel = new javax.swing.JLabel();
        capacitateField = new javax.swing.JTextField();

        numeLabel.setText("Nume/Prenume:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asigneaza Profesor");

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        numeLabel.setText("Nume/Prenume:");

        materieLabel.setText("Materie:");

        depLabel.setText("Departament:");

        asigneazaButton.setText("Asigneaza");
        asigneazaButton.setFocusable(false);
        asigneazaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asigneazaButtonActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(255, 0, 0));
        statusLabel.setText("Acest profesor nu face parte din acest departament!");

        cursCheck.setText("Curs");
        cursCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursCheckActionPerformed(evt);
            }
        });

        seminarCheck.setText("Seminar");
        seminarCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seminarCheckActionPerformed(evt);
            }
        });

        labCheck.setText("Laborator");
        labCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labCheckActionPerformed(evt);
            }
        });

        colocCheck.setText("Colocviu");
        colocCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colocCheckActionPerformed(evt);
            }
        });

        examenCheck.setText("Examen");
        examenCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examenCheckActionPerformed(evt);
            }
        });

        capacitateLabel.setText("Capacitate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cursCheck)
                                                        .addComponent(seminarCheck)
                                                        .addComponent(labCheck)
                                                        .addComponent(colocCheck)
                                                        .addComponent(examenCheck))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(capacitateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(depLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(materieLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(numeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(numeField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(asigneazaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(depField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(materieField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(capacitateField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(numeField)
                                        .addComponent(numeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(asigneazaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(depLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(depField, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(materieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(materieField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(capacitateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(capacitateField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cursCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seminarCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(colocCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(examenCheck)
                                .addGap(306, 306, 306))
        );

        pack();
    }// </editor-fold>

    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuAdmin back = new MenuAdmin(this.email, this.parola);
    }
    private void asigneazaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String text = numeField.getText();
        int i = text.indexOf(" ");
        String nume = text.substring(0, i);
        String prenume = text.substring(i + 1);
        cursCheck.setSelected(false);
        seminarCheck.setSelected(false);
        labCheck.setSelected(false);
        colocCheck.setSelected(false);
        examenCheck.setSelected(false);
        try {
            statusLabel.setVisible(false);
            connection = connect.getConnection(this.email, this.parola);
            String asigneazaProfesor = "{ call asigneazaProfesor(?, ?, ?, ?, ?, ?) }";
            CallableStatement cs = connection.prepareCall(asigneazaProfesor);
            for(String ac : Activitati)
            {
                if(!ac.equals("null")) {
                    cs.setString(1, nume);
                    cs.setString(2, prenume);
                    cs.setString(3, depField.getText());
                    cs.setString(4, materieField.getText());
                    cs.setString(5, ac);
                    cs.setString(6, capacitateField.getText());
                    int rows = cs.executeUpdate();
                    System.out.println(rows);
                    if (rows == 0) {
                        statusLabel.setVisible(true);
                    }
                }
            }
            numeField.setText("");
            depField.setText("");
            materieField.setText("");
            capacitateField.setText("");
        }catch(Exception A)
        {
            System.out.println(A);
        }
        Activitati[0]=Activitati[1]=Activitati[2]=Activitati[3]=Activitati[4]="null";
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


    // Variables declaration - do not modify
    private javax.swing.JButton asigneazaButton;
    private javax.swing.JTextField capacitateField;
    private javax.swing.JLabel capacitateLabel;
    private javax.swing.JCheckBox colocCheck;
    private javax.swing.JCheckBox cursCheck;
    private javax.swing.JTextField depField;
    private javax.swing.JLabel depLabel;
    private javax.swing.JCheckBox examenCheck;
    private javax.swing.JButton inapoiButton;
    private javax.swing.JCheckBox labCheck;
    private javax.swing.JTextField materieField;
    private javax.swing.JLabel materieLabel;
    private javax.swing.JTextField numeField;
    private javax.swing.JLabel numeLabel;
    private javax.swing.JCheckBox seminarCheck;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration
}
