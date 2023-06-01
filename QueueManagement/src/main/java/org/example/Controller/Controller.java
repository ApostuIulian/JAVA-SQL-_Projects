package org.example.Controller;

import org.example.View.QueueEvolution;
import org.example.View.SimulationSetup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class Controller implements ActionListener {

    SimulationSetup simulationSetupGUI;
    Scheduler scheduler;

    public Controller(SimulationSetup simulationSetupGUI) {
        this.simulationSetupGUI = simulationSetupGUI;
        simulationSetupGUI.startButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int[] simulationSettings = new int[7];
        for (int i = 0; i < 7; i++) {
            simulationSettings[i] = -1;
        }
        try {
            simulationSettings[0] = SimulationSetup.getNrClients();
            simulationSettings[1] = SimulationSetup.getNrQueues();
            simulationSettings[2] = SimulationSetup.getSimTime();
            simulationSettings[3] = SimulationSetup.getMinArrival();
            simulationSettings[4] = SimulationSetup.getMaxArrival();
            simulationSettings[5] = SimulationSetup.getMinService();
            simulationSettings[6] = SimulationSetup.getMaxService();
        } catch (Exception wrongInput) {
            this.simulationSetupGUI.labelSetText("Empty/Wrong Fields!");
        }

        boolean okFields = false;

        for (int i = 0; i < 7; i++) {
            if (simulationSettings[i] >= 0 && simulationSettings[4] >= simulationSettings[3] && simulationSettings[6] >= simulationSettings[5]) {
                okFields = true;
            }
        }

        System.out.println(okFields);

        if (okFields) {
            scheduler = new Scheduler(simulationSettings[1]);
            this.simulationSetupGUI.dispose();

            SimulationManager simulationManager = new SimulationManager(simulationSetupGUI, scheduler);
            Thread startSimulation = new Thread(simulationManager);
            startSimulation.start();
        }
    }
}