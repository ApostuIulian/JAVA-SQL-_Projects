package org.example.View;

public class QueueEvolution extends javax.swing.JFrame {

    public QueueEvolution() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaText = new javax.swing.JTextArea();
        clientsLabel = new javax.swing.JLabel();
        clientsText = new javax.swing.JTextField();
        queueText = new javax.swing.JTextField();
        queueLabel = new javax.swing.JLabel();
        peakText = new javax.swing.JTextField();
        peakLabel = new javax.swing.JLabel();
        serviceText = new javax.swing.JTextField();
        serviceLabel = new javax.swing.JLabel();
        waitLabel = new javax.swing.JLabel();
        waitText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaText.setColumns(20);
        areaText.setRows(5);
        jScrollPane1.setViewportView(areaText);

        clientsLabel.setText("Clients left:");

        queueLabel.setText("Opened Queues:");

        peakLabel.setText("Peak hour:");

        serviceLabel.setText("Avg service time:");

        waitLabel.setText("Avg waiting time:");

        areaText.setEditable(false);
        clientsText.setEditable(false);
        queueText.setEditable(false);
        waitText.setEditable(false);
        serviceText.setEditable(false);
        peakText.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(waitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(serviceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(peakLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(queueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(clientsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(clientsText, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(queueText)
                                        .addComponent(peakText)
                                        .addComponent(serviceText)
                                        .addComponent(waitText))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(clientsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(clientsText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(queueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(queueText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(waitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(waitText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(serviceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(serviceText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(peakLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(peakText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        pack();
    }

    public void setAreaText(String text) {
        areaText.setText(text);
    }

    public void setClientsText(String text) {
        clientsText.setText(text);
    }

    public void setQueueText(String text) {
        queueText.setText(text);
    }

    public void setWaitText(String text) {
        waitText.setText(text);
    }

    public void setServiceText(String text) {
        serviceText.setText(text);
    }

    public void setPeakText(String text) {
        peakText.setText(text);
    }

    public String getAreaText() {
        return areaText.getText();
    }

    private javax.swing.JTextArea areaText;
    private javax.swing.JLabel clientsLabel;
    private javax.swing.JTextField clientsText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel peakLabel;
    private javax.swing.JTextField peakText;
    private javax.swing.JLabel queueLabel;
    private javax.swing.JTextField queueText;
    private javax.swing.JLabel serviceLabel;
    private javax.swing.JTextField serviceText;
    private javax.swing.JLabel waitLabel;
    private javax.swing.JTextField waitText;
}
