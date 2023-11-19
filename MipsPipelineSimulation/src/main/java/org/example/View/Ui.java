package org.example.View;

import org.example.Controller.Controller;

public class Ui extends javax.swing.JFrame {

    public Ui() {
        this.setVisible(true);
        initComponents();
    }

    public static void setDmTextArea(String text) {
        dmTextArea.setText(text);
    }

    public String getInstructions() {
        return this.instructionsTextArea.getText();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        instructionsTextArea = new javax.swing.JTextArea();
        writeLabel = new javax.swing.JLabel();
        runButton = new javax.swing.JButton();
        ifLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ifTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        idTextArea = new javax.swing.JTextArea();
        idLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        exTextArea = new javax.swing.JTextArea();
        exLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        memTextArea = new javax.swing.JTextArea();
        memLabel = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        wbTextArea = new javax.swing.JTextArea();
        wbLabel = new javax.swing.JLabel();
        rfLabel = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        rfTextArea = new javax.swing.JTextArea();
        dmLabel = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        dmTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        instructionsTextArea.setColumns(20);
        instructionsTextArea.setRows(5);
        jScrollPane1.setViewportView(instructionsTextArea);

        writeLabel.setText("Write your instructions (Every instruction on a new line):");

        runButton.setText("RUN");
        runButton.setFocusable(false);

        ifLabel.setText("                                  Instruction Fetch ");

        ifTextArea.setColumns(20);
        ifTextArea.setRows(5);
        jScrollPane2.setViewportView(ifTextArea);

        idTextArea.setColumns(20);
        idTextArea.setRows(5);
        jScrollPane3.setViewportView(idTextArea);

        idLabel.setText("                               Instruction Decode");

        exTextArea.setColumns(20);
        exTextArea.setRows(5);
        jScrollPane4.setViewportView(exTextArea);

        exLabel.setText("                                        Execute");

        memTextArea.setColumns(20);
        memTextArea.setRows(5);
        jScrollPane5.setViewportView(memTextArea);

        memLabel.setText("                                         Memory");

        wbTextArea.setColumns(20);
        wbTextArea.setRows(5);
        jScrollPane6.setViewportView(wbTextArea);

        wbLabel.setText("                                         Write Back");

        rfLabel.setText("Register File");

        rfTextArea.setColumns(20);
        rfTextArea.setRows(5);
        jScrollPane7.setViewportView(rfTextArea);

        dmLabel.setText("Data Memory");

        dmTextArea.setColumns(20);
        dmTextArea.setRows(5);
        jScrollPane8.setViewportView(dmTextArea);

        ifTextArea.setEditable(false);
        idTextArea.setEditable(false);
        exTextArea.setEditable(false);
        memTextArea.setEditable(false);
        wbTextArea.setEditable(false);
        rfTextArea.setEditable(false);
        dmTextArea.setEditable(false);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(writeLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(runButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ifLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                                        .addComponent(exLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(rfLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(memLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                                        .addComponent(wbLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(dmLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(writeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(runButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(ifLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(wbLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(memLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(exLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(idLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(rfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(dmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap())
        );

        pack();
    }

    public void setRunError(String error) {
        ifTextArea.setText(error);
    }

    public void setWriteLabel() {
        writeLabel.setText("Write your instructions (Every instruction on a new line):");
    }

    public static void setIfTextArea(String text) {
        ifTextArea.setText(text);
    }

    public static void setIdTextArea(String text) {
        idTextArea.setText(text);
    }

    public static void setExTextArea(String text) {
        exTextArea.setText(text);
    }

    public static void setMemTextArea(String text) {
        memTextArea.setText(text);
    }

    public static void setWbTextArea(String text) {
        wbTextArea.setText(text);
    }

    public static void setRfTextArea(String text)
    {
        rfTextArea.setText(text);
    }

    public String getIdTextArea() {
        return idTextArea.getText();
    }

    public String getIfTextArea() {
        return ifTextArea.getText();
    }


    private javax.swing.JLabel dmLabel;
    public static javax.swing.JTextArea dmTextArea;
    private javax.swing.JLabel exLabel;
    private static javax.swing.JTextArea exTextArea;
    private javax.swing.JLabel idLabel;
    private static javax.swing.JTextArea idTextArea;
    private javax.swing.JLabel ifLabel;
    private static javax.swing.JTextArea ifTextArea;
    private javax.swing.JTextArea instructionsTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel memLabel;
    private static javax.swing.JTextArea memTextArea;
    private javax.swing.JLabel rfLabel;
    public static javax.swing.JTextArea rfTextArea;
    public javax.swing.JButton runButton;
    private javax.swing.JLabel wbLabel;
    private static javax.swing.JTextArea wbTextArea;
    private javax.swing.JLabel writeLabel;
}
