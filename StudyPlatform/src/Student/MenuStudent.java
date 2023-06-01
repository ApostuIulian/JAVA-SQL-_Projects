package Student;

import LogIn.LogInPage;

public class MenuStudent extends javax.swing.JFrame {
    String email;
    String parola;
    public MenuStudent(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        deautentificareButton = new javax.swing.JButton();
        datePersButton = new javax.swing.JButton();
        inscriereCursButton = new javax.swing.JButton();
        inscriereActivButton = new javax.swing.JButton();
        veziActivButton = new javax.swing.JButton();
        veziNoteButton = new javax.swing.JButton();
        veziGrupuriButton = new javax.swing.JButton();
        inscriereGrupButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meniu Student");

        deautentificareButton.setText("Deautentificare");
        deautentificareButton.setFocusable(false);
        deautentificareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deautentificareButtonActionPerformed(evt);
            }
        });

        datePersButton.setText("Date Personale");
        datePersButton.setFocusable(false);
        datePersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePersButtonActionPerformed(evt);
            }
        });

        inscriereCursButton.setText("Inscriere la curs");
        inscriereCursButton.setFocusable(false);
        inscriereCursButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscriereCursButtonActionPerformed(evt);
            }
        });

        inscriereActivButton.setText("Inscriere la activitate");
        inscriereActivButton.setFocusable(false);
        inscriereActivButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscriereActivButtonActionPerformed(evt);
            }
        });

        veziActivButton.setText("Vezi activitati");
        veziActivButton.setFocusable(false);
        veziActivButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veziActivButtonActionPerformed(evt);
            }
        });

        veziNoteButton.setText("Vezi note");
        veziNoteButton.setFocusable(false);
        veziNoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veziNoteButtonActionPerformed(evt);
            }
        });

        veziGrupuriButton.setText("Grupuri de studiu");
        veziGrupuriButton.setFocusable(false);
        veziGrupuriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veziGrupuriButtonActionPerformed(evt);
            }
        });

        inscriereGrupButton.setText("Inscriere grup studiu");
        inscriereGrupButton.setFocusable(false);
        inscriereGrupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscriereGrupButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(datePersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                                .addComponent(veziActivButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(inscriereCursButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                        .addComponent(veziNoteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                        .addComponent(inscriereGrupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(inscriereActivButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                        .addComponent(veziGrupuriButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                        .addComponent(deautentificareButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(datePersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(veziActivButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(inscriereCursButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inscriereActivButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(veziNoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(veziGrupuriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deautentificareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inscriereGrupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }

    private void datePersButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        DatePersonaleS dpS= new DatePersonaleS(this.email, this.parola);
    }

    private void veziActivButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        VeziActivitati vezi = new VeziActivitati(this.email, this.parola);
    }

    private void inscriereCursButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        InscriereCurs ic = new InscriereCurs(this.email, this.parola);
    }

    private void inscriereActivButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        InscriereActivitate ac = new InscriereActivitate(this.email, this.parola);
    }

    private void veziNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        VeziNote vezi = new VeziNote(this.email, this.parola);
    }

    private void veziGrupuriButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        GrupuriStudiu gs = new GrupuriStudiu(this.email, this.parola);
    }

    private void inscriereGrupButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        InscriereGrup iG = new InscriereGrup(this.email, this.parola);
    }

    private void deautentificareButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        LogInPage.disconnect();
        LogInPage deautentific = new LogInPage();
    }

    private javax.swing.JButton datePersButton;
    private javax.swing.JButton deautentificareButton;
    private javax.swing.JButton inscriereActivButton;
    private javax.swing.JButton inscriereCursButton;
    private javax.swing.JButton inscriereGrupButton;
    private javax.swing.JButton veziActivButton;
    private javax.swing.JButton veziGrupuriButton;
    private javax.swing.JButton veziNoteButton;
}
