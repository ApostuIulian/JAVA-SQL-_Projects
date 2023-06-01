package Profesor;

import LogIn.GetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VeziStudenti extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect = new GetConnection();
    String all="";
    public VeziStudenti(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        try {
            connection = connect.getConnection(email, parola);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student join contractari on (contractari.idS=Student.id) join curs on (curs.id=contractari.idC) where idProf = (Select id from profesor where Profesor.email= '"+this.email+"')");
            while (resultSet.next()) {
                all=all+resultSet.getString("Student.nume")+" "+resultSet.getString("Student.prenume")+"\n";
            }
            studArea.insert(all, 0);
            studArea.setEditable(false);
        } catch (Exception A) {
            System.out.println(A);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        inapoiButton = new javax.swing.JButton();
        studentiLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        studentiLabel.setText("Studenti:");

        studArea.setColumns(20);
        studArea.setRows(5);
        jScrollPane1.setViewportView(studArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(studentiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                                .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(studentiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }
    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        Catalog back = new Catalog(this.email, this.parola);
    }
    private javax.swing.JButton inapoiButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea studArea;
    private javax.swing.JLabel studentiLabel;
    // End of variables declaration
}
