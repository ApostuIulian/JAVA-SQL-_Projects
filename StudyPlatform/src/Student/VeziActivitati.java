package Student;

import LogIn.GetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VeziActivitati extends javax.swing.JFrame {
    String email;
    String parola;
    Connection connection;
    GetConnection connect;
    String all="";

    public VeziActivitati(String email, String parola) {
        initComponents();
        this.email=email;
        this.parola=parola;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        try {
            connection = connect.getConnection(email, parola);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from Calendar join asignaristudenti on (calendar.id=asignaristudenti.idS) join Activitate on(activitate.id=Calendar.idA) " +
                    " join Curs on (activitate.idC=curs.id) join Materie on(curs.idM=Materie.id) where asignaristudenti.idS=" +
                    "(Select id from student where student.email = '"+this.email+"') and startDateA=CURRENT_DATE();");
            while (resultSet.next()) {
                all=all+resultSet.getString("Materie.descriere")+" "+resultSet.getString("Activitate.nume")+": Data "+resultSet.getString("Calendar.startDate")+" Ora "+resultSet.getString("calendar.startTime")+"\n";
            }
            activitatiZiArea.insert(all, 0);
            all="";
            ResultSet resultSet1 = statement.executeQuery("select * from calendar join asignaristudenti on (asignaristudenti.idCa=calendar.id) join activitate on (calendar.idA=activitate.id) join curs on(curs.id=activitate.idC) join \n" +
                    "materie on (materie.id=curs.idM) join contractari on (curs.id=contractari.idC) where contractari.idS=(Select id from student where student.email='"+this.email+"');");
            while (resultSet1.next()) {
                all=all+resultSet1.getString("Materie.descriere")+" "+resultSet1.getString("Activitate.nume")+": Data "+resultSet1.getString("Calendar.startDate")
                        +" Ora "+resultSet1.getString("calendar.startTime")+"\n";
            }
            toateAArea.insert(all, 0);
            activitatiZiArea.setEditable(false);
            toateAArea.setEditable(false);
        } catch (Exception A) {
            System.out.println(A);
        }
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        activitatiZiLabel = new javax.swing.JLabel();
        inapoiButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        activitatiZiArea = new javax.swing.JTextArea();
        toateALabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        toateAArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        activitatiZiLabel.setText("Activitati Ziua Curenta:");

        inapoiButton.setText("Inapoi");
        inapoiButton.setFocusable(false);
        inapoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiButtonActionPerformed(evt);
            }
        });

        activitatiZiArea.setColumns(20);
        activitatiZiArea.setRows(5);
        jScrollPane1.setViewportView(activitatiZiArea);

        toateALabel.setText("Toate Activitatile:");

        toateAArea.setColumns(20);
        toateAArea.setRows(5);
        jScrollPane2.setViewportView(toateAArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(toateALabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 232, Short.MAX_VALUE))
                                        .addComponent(activitatiZiLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inapoiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(activitatiZiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inapoiButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toateALabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
        );

        pack();
    }
    private void inapoiButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        MenuStudent back = new MenuStudent(this.email, this.parola);
    }
    private javax.swing.JTextArea activitatiZiArea;
    private javax.swing.JLabel activitatiZiLabel;
    private javax.swing.JButton inapoiButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea toateAArea;
    private javax.swing.JLabel toateALabel;
    // End of variables declaration
}
