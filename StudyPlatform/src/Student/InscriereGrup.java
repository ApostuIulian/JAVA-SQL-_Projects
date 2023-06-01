package Student;

import LogIn.GetConnection;

import java.sql.*;

public class InscriereGrup extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect = new GetConnection();
    String idS;
    public InscriereGrup(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        inapoiButton = new javax.swing.JButton();
        materieLabel = new javax.swing.JLabel();
        materieField = new javax.swing.JTextField();
        inscriereButton = new javax.swing.JButton();
        parasireButton = new javax.swing.JButton();

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

        parasireButton.setText("Paraseste");
        parasireButton.setFocusable(false);
        parasireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parasireButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(materieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(materieField))
                                        .addComponent(inscriereButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(parasireButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inscriereButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(parasireButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
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
                this.idS=resultSet.getString("id");
            }
            String inscriereGrup = "{ call inscriereGrup(?, ?) }";
            CallableStatement cs = connection.prepareCall(inscriereGrup);
            cs.setString(1, materieField.getText());
            cs.setString(2, idS);
            int rows = cs.executeUpdate();
            if(rows == 0)
            {
                materieField.setText("Nu apartii cursului!");
            }else {
                materieField.setText("");
            }
        }catch(Exception A)
        {
            System.out.println(A);
        }
    }

    private void parasireButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            connection = connect.getConnection(this.email, this.parola);
            String query = "delete from Grup where idS = (Select id from student where student.email = '"+this.email+"') and idM = (Select id from Materie where Materie.descriere = '"+materieField.getText()+"');";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.execute();
            materieField.setText("");
        }catch(Exception A)
        {
            System.out.println(A);
        }
    }

    private javax.swing.JButton inapoiButton;
    private javax.swing.JButton inscriereButton;
    private javax.swing.JTextField materieField;
    private javax.swing.JLabel materieLabel;
    private javax.swing.JButton parasireButton;
}
