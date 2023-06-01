package Profesor;

import Admin.MenuAdmin;
import LogIn.GetConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProgrameazaActivitati extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect = new GetConnection();
    String activitate;
    int idProf;

    public ProgrameazaActivitati(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {


        buttonGroup1 = new javax.swing.ButtonGroup();
        cursCheck = new javax.swing.JCheckBox();
        seminarCheck = new javax.swing.JCheckBox();
        labCheck = new javax.swing.JCheckBox();
        colocCheck = new javax.swing.JCheckBox();
        examenCheck = new javax.swing.JCheckBox();
        startLabel = new javax.swing.JLabel();
        endLabel = new javax.swing.JLabel();
        startField = new javax.swing.JTextField();
        endField = new javax.swing.JTextField();
        inapoiButton = new javax.swing.JButton();
        programeazaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(cursCheck);
        cursCheck.setText("Curs");
        cursCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursCheckActionPerformed(evt);
            }
        });

        buttonGroup1.add(seminarCheck);
        seminarCheck.setText("Seminar");
        seminarCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seminarCheckActionPerformed(evt);
            }
        });

        buttonGroup1.add(labCheck);
        labCheck.setText("Laborator");
        labCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labCheckActionPerformed(evt);
            }
        });

        buttonGroup1.add(colocCheck);
        colocCheck.setText("Colocviu");
        colocCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colocCheckActionPerformed(evt);
            }
        });

        buttonGroup1.add(examenCheck);
        examenCheck.setText("Examen");
        examenCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examenCheckActionPerformed(evt);
            }
        });

        startLabel.setText("Start (AN-LUNA-ZI ORA:MINUT:SECUNDA):");

        endLabel.setText("End (AN-LUNA-ZI ORA:MINUT:SECUNDA):");

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });


        programeazaButton.setText("Programeaza");
        programeazaButton.setFocusable(false);
        programeazaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programeazaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(endLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(startLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(colocCheck, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(examenCheck, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cursCheck, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(seminarCheck, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(endField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                        .addComponent(startField)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(programeazaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(cursCheck)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(seminarCheck)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labCheck)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(colocCheck)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(examenCheck))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(programeazaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(startLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(endField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void cursCheckActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(cursCheck.isSelected())
        {
            activitate="Curs";
        }else
        {
            activitate="null";
        }
    }

    private void seminarCheckActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(seminarCheck.isSelected())
        {
            activitate="Seminar";
        }else
        {
            activitate="null";
        }
    }

    private void labCheckActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(labCheck.isSelected())
        {
            activitate="Laborator";
        }else
        {
            activitate="null";
        }
    }

    private void colocCheckActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(colocCheck.isSelected())
        {
            activitate="Colocviu";
        }else
        {
            activitate="null";
        }
    }

    private void examenCheckActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(examenCheck.isSelected())
        {
            activitate="Examen";
        }else
        {
            activitate="null";
        }
    }

    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuProfesor back = new MenuProfesor(this.email, this.parola);
    }
    private void programeazaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cursCheck.setSelected(false);
        seminarCheck.setSelected(false);
        labCheck.setSelected(false);
        colocCheck.setSelected(false);
        examenCheck.setSelected(false);
        String text = startField.getText();
        int i = text.indexOf(" ");
        String startD = text.substring(0, i);
        String startT = text.substring(i + 1);
        text = endField.getText();
        i = text.indexOf(" ");
        String endD = text.substring(0, i);
        String endT = text.substring(i + 1);
        try {
            connection = connect.getConnection(this.email, this.parola);
            String programeazaActivitate = "{ call programeazaActivitate(?, ?, ?, ?, ?, ?) }";
            CallableStatement cs = connection.prepareCall(programeazaActivitate);
            Statement statement = connection.createStatement();
            ResultSet resultSet = null;
            resultSet = statement.executeQuery("Select id from Profesor where email = '"+this.email+"'");
            while(resultSet.next())
            idProf = Integer.parseInt(resultSet.getString("id"));
            System.out.println(idProf);
            if(!activitate.equals("null"))
            {
                cs.setString(1, activitate);
                cs.setString(2, String.valueOf(idProf));
                cs.setString(3, startD);
                cs.setString(4, startT);
                cs.setString(5, endD);
                cs.setString(6, endT);
            }
            cs.execute();
            startField.setText("");
            endField.setText("");
            examenCheck.setSelected(false);
            cursCheck.setSelected(false);
            colocCheck.setSelected(false);
            labCheck.setSelected(false);
            seminarCheck.setSelected(false);
        }catch(Exception A)
        {
            System.out.println(A);
        }
        activitate="null";
    }

    private javax.swing.JCheckBox colocCheck;
    private javax.swing.JCheckBox cursCheck;
    private javax.swing.JTextField endField;
    private javax.swing.JLabel endLabel;
    private javax.swing.JCheckBox examenCheck;
    private javax.swing.JButton inapoiButton;
    private javax.swing.JCheckBox labCheck;
    private javax.swing.JButton programeazaButton;
    private javax.swing.JCheckBox seminarCheck;
    private javax.swing.JTextField startField;
    private javax.swing.JLabel startLabel;
    private javax.swing.ButtonGroup buttonGroup1;
}
