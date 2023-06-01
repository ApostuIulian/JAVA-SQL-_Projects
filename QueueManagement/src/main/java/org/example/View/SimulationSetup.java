package org.example.View;

import org.example.Model.Client;

import java.awt.*;

public class SimulationSetup extends javax.swing.JFrame {

    public SimulationSetup() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        simSetLabel = new javax.swing.JLabel();
        nrClientsLabel = new javax.swing.JLabel();
        atiLabel = new javax.swing.JLabel();
        stiLabel = new javax.swing.JLabel();
        simTimeLabel = new javax.swing.JLabel();
        nrQueuesLabel = new javax.swing.JLabel();
        simTimeText = new javax.swing.JTextField();
        nrClientsText = new javax.swing.JTextField();
        nrQueuesText = new javax.swing.JTextField();
        minAtiLabel = new javax.swing.JLabel();
        minAtiText = new javax.swing.JTextField();
        maxAtiText = new javax.swing.JTextField();
        maxAtiLabel = new javax.swing.JLabel();
        maxStiText = new javax.swing.JTextField();
        maxStiLabel = new javax.swing.JLabel();
        minStiText = new javax.swing.JTextField();
        minStiLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));

        simSetLabel.setBackground(new java.awt.Color(255, 255, 255));
        simSetLabel.setFont(new java.awt.Font("Yu Gothic UI Light", Font.PLAIN, 36));
        simSetLabel.setText("Simulation Setup:");

        nrClientsLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
        nrClientsLabel.setText("Number of Clients:");

        atiLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
        atiLabel.setText("Arrival Time Interval:");

        stiLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
        stiLabel.setText("Service Time Interval:");

        simTimeLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
        simTimeLabel.setText("Simulation time:");

        nrQueuesLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
        nrQueuesLabel.setText("Number of Queues:");

        minAtiLabel.setText("min:");

        maxAtiLabel.setText("max:");

        maxStiLabel.setText("max:");

        minStiLabel.setText("min:");

        startButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        startButton.setText("Start Simulation");
        startButton.setFocusable(false);
        //startButton.addActionListener(new java.awt.event.ActionListener() {
/*            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });*/

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(simSetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(stiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                        .addComponent(atiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(nrQueuesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(nrClientsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(simTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(minAtiLabel)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(minAtiText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(maxAtiLabel)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(maxAtiText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(nrQueuesText)
                                                                .addComponent(nrClientsText)
                                                                .addComponent(simTimeText))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(minStiLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(minStiText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(maxStiLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(maxStiText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(simSetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(simTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(simTimeText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(nrClientsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nrClientsText))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nrQueuesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nrQueuesText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(atiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minAtiLabel)
                                                        .addComponent(minAtiText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(maxAtiText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(maxAtiLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(maxStiText, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                        .addComponent(minStiText)
                                                        .addComponent(minStiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(stiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(maxStiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        pack();
    }

    public static int getSimTime()
    {
        return Integer.parseInt(simTimeText.getText());
    }
    public static int getNrClients()
    {
        return Integer.parseInt(nrClientsText.getText());
    }
    public static int getNrQueues()
    {
        return Integer.parseInt(nrQueuesText.getText());
    }
    public static int getMinArrival()
    {
        return Integer.parseInt(minAtiText.getText());
    }
    public static int getMaxArrival()
    {
        return Integer.parseInt(maxAtiText.getText());
    }
    public static int getMinService()
    {
        return Integer.parseInt(minStiText.getText());
    }
    public static int getMaxService()
    {
        return Integer.parseInt(maxStiText.getText());
    }

    public void labelSetText(String text)
    {
        this.simSetLabel.setText(text);
    }

    private javax.swing.JLabel atiLabel;
    private javax.swing.JLabel maxAtiLabel;
    private static javax.swing.JTextField maxAtiText;
    private javax.swing.JLabel maxStiLabel;
    private static javax.swing.JTextField maxStiText;
    private javax.swing.JLabel minAtiLabel;
    private static javax.swing.JTextField minAtiText;
    private javax.swing.JLabel minStiLabel;
    private static javax.swing.JTextField minStiText;
    private javax.swing.JLabel nrClientsLabel;
    private static javax.swing.JTextField nrClientsText;
    private javax.swing.JLabel nrQueuesLabel;
    private static javax.swing.JTextField nrQueuesText;
    private javax.swing.JLabel simSetLabel;
    private javax.swing.JLabel simTimeLabel;
    private static javax.swing.JTextField simTimeText;
    public javax.swing.JButton startButton;
    private javax.swing.JLabel stiLabel;
}
