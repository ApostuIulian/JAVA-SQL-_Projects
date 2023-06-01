package org.example.Controller;

import org.example.Model.Client;
import org.example.Model.Queue;
import org.example.View.QueueEvolution;
import org.example.View.SimulationSetup;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class SimulationManager implements Runnable {

    private FileWriter write;
    private Scheduler scheduler;
    public SimulationSetup simulationSetupGUI;
    private QueueEvolution queueEvolutionGUI;
    private CopyOnWriteArrayList<Client> clients = new CopyOnWriteArrayList<Client>();
    private String log;

    public SimulationManager(SimulationSetup simulationSetupGUI, Scheduler scheduler) {
        try {
            this.write = new FileWriter("LogOfEvents.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.scheduler = scheduler;
        this.simulationSetupGUI = simulationSetupGUI;
        for (int i = 0; i < simulationSetupGUI.getNrClients(); i++) {
            clients.add(new Client());
        }
        this.queueEvolutionGUI = new QueueEvolution();
        log = "";
    }

    @Override
    public void run() {
        scheduler.startQueues();
        int currentTime = 0, finish = 0, maxClientsInQueue = 0, peakHour = 0;
        while (currentTime <= simulationSetupGUI.getSimTime()) {
            int currentTotalSize = 0, openedQueues = 0;

            scheduler.addClientToLowestWaitingTimeQue(clients, currentTime);
            String logTemp = "";
            log += "Time " + currentTime + "\n" + "Waiting clients: ";
            try {
                write.write("Time " + currentTime + "\n");
                write.write("Waiting clients: ");
                for (Client c : clients) {
                    log += c + ";";
                    logTemp += c+";";
                    write.write(c + ";");
                }
                write.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            log += "\n";
            logTemp +="\n";
            queueEvolutionGUI.setClientsText(clients.size() + "/" + SimulationSetup.getNrClients());

            for (Queue queue : scheduler.getQueues()) {
                try {
                    write.write(queue.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                currentTotalSize += queue.getSize();
                if (queue.getStatus() == 0) {
                    openedQueues++;
                }
                log += queue.toString();
                logTemp += queue.toString();
                queue.signal();
            }

            queueEvolutionGUI.setQueueText(openedQueues + "/" + scheduler.getMaxNrQues());

            int emptyQueues = 0;
            for (Queue queue : scheduler.getQueues()) {
                if (queue.getWaitPeriod() != 0) {
                    emptyQueues = 0;
                    break;
                }
                emptyQueues = 1;
            }

            if (maxClientsInQueue < currentTotalSize) {
                maxClientsInQueue = currentTotalSize;
                peakHour = currentTime;
            }

            if (finish == 1) {
                break;
            }

            if (emptyQueues == 1) {
                if (clients.isEmpty()) {
                    finish = 1;
                }
            }

            try {
                write.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            log += "\n";
            logTemp +="\n";
            queueEvolutionGUI.setAreaText(logTemp);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentTime++;
        }
        double avgWaitingTime = ((double) scheduler.getQueues()[0].getTotalWaitingTime() / (double) scheduler.getQueues()[0].getClientsServed());
        double avgServiceTime = ((double) scheduler.getQueues()[0].getTotalServiceTime() / (double) scheduler.getQueues()[0].getClientsServed());
        queueEvolutionGUI.setWaitText(String.valueOf(avgWaitingTime));
        queueEvolutionGUI.setServiceText(String.valueOf(avgServiceTime));
        queueEvolutionGUI.setPeakText(String.valueOf(peakHour));

        try {
            write.write("\nAverage waiting time: " + avgWaitingTime + "\n");
            write.write("Average service time: " + avgServiceTime + "\n");
            write.write("Peak Hour: " + peakHour + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            write.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}