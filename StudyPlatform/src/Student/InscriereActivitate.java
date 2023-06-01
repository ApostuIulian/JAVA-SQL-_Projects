package Student;

import LogIn.GetConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InscriereActivitate extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect = new GetConnection();
    String[] Activitati = new String[5];
    String nume;
    String prenume;
    public InscriereActivitate(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        Activitati[0]=Activitati[1]=Activitati[2]=Activitati[3]=Activitati[4]="null";
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        inapoiButton = new javax.swing.JButton();
        materieLabel = new javax.swing.JLabel();
        materieField = new javax.swing.JTextField();
        inscriereButton = new javax.swing.JButton();
        colocCheck = new javax.swing.JCheckBox();
        examenCheck = new javax.swing.JCheckBox();
        seminarCheck = new javax.swing.JCheckBox();
        labCheck = new javax.swing.JCheckBox();
        cursCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        materieLabel.setText("Materie:");

        inscriereButton.setText("Inscriere");
        inscriereButton.setFocusable(false);
        inscriereButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscriereButtonActionPerformed(evt);
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

        cursCheck.setText("Curs");
        cursCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursCheckActionPerformed(evt);
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
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labCheck)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(cursCheck)
                                                                        .addComponent(seminarCheck))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(examenCheck)
                                                                        .addComponent(colocCheck))))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(inscriereButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(materieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(materieField, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cursCheck)
                                        .addComponent(colocCheck))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(seminarCheck)
                                        .addComponent(examenCheck))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inscriereButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

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

    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuStudent back = new MenuStudent(this.email, this.parola);
    }

    private void inscriereButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            connection = connect.getConnection(this.email, this.parola);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student where student.email = '"+this.email+"'");
            while (resultSet.next()) {
                this.nume=resultSet.getString("nume");
                this.prenume=resultSet.getString("prenume");
            }
            String asigneazaStudentA = "{ call asigneazaStudentA(?, ?, ?, ?) }";
            CallableStatement cs = connection.prepareCall(asigneazaStudentA);
            for(String ac : Activitati)
            {
                if(!ac.equals("null")) {
                    cs.setString(1, this.nume);
                    cs.setString(2, this.prenume);
                    cs.setString(3, materieField.getText());
                    cs.setString(4, ac);
                }
            }
            cs.execute();
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
    private javax.swing.JCheckBox colocCheck;
    private javax.swing.JCheckBox cursCheck;
    private javax.swing.JCheckBox examenCheck;
    private javax.swing.JButton inapoiButton;
    private javax.swing.JButton inscriereButton;
    private javax.swing.JCheckBox labCheck;
    private javax.swing.JTextField materieField;
    private javax.swing.JLabel materieLabel;
    private javax.swing.JCheckBox seminarCheck;
    // End of variables declaration
}
