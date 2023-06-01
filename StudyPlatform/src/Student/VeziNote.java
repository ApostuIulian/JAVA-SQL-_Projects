package Student;

import LogIn.GetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VeziNote extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect = new GetConnection();
    String all="";
    public VeziNote(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        try {
            connection = connect.getConnection(email, parola);
            Statement statement = connection.createStatement();
            noteArea.setText("");
            ResultSet resultSet = statement.executeQuery("select * from catalog join activitate on (catalog.idA=activitate.id) join curs on (curs.id=activitate.idC) " +
                    "join Materie on (curs.idM = materie.id) join contractari on (curs.id=contractari.idC) and contractari.idS = " +
                    "(select id from student where student.email = '"+this.email+"')");
            while (resultSet.next()) {
                all=all+resultSet.getString("Materie.descriere")+" "+resultSet.getString("Activitate.nume")+": Nota "+resultSet.getString("catalog.nota")+"\n";
            }
            noteArea.insert(all, 0);
            noteArea.setEditable(false);
        } catch (Exception A) {
            System.out.println(A);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        inapoiButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        noteArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        noteArea.setColumns(20);
        noteArea.setRows(5);
        jScrollPane1.setViewportView(noteArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuStudent back= new MenuStudent(this.email, this.parola);
    }
    // Variables declaration - do not modify
    private javax.swing.JButton inapoiButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea noteArea;
    // End of variables declaration
}
