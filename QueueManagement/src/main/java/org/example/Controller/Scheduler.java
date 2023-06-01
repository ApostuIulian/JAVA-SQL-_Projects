package org.example.Controller;

import org.example.Model.Client;
import org.example.Model.Queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Scheduler {
    private Queue[] queue;
    private final int maxNrQues;

    public Scheduler(int maxNrQues) {
        this.maxNrQues = maxNrQues;
        queue = new Queue[maxNrQues];
        for (int i = 0; i < maxNrQues; i++) {
            queue[i] = new Queue();
        }
    }

    Queue[] getQueues() {
        return queue;
    }

    public int getMaxNrQues()
    {
        return maxNrQues;
    }

    public void addClientToLowestWaitingTimeQue(CopyOnWriteArrayList<Client> clients, int currentTime)
    {
        if (!clients.isEmpty()) {
            Iterator<Client> iter = clients.iterator();
            while (iter.hasNext()) {
                Client client = iter.next();
                if (client.getTArrival() == currentTime) {
                    queue[0].addClient(client);
                    Arrays.sort(queue);
                    clients.remove(client);
                }
            }
        }
    }

    void startQueues() {
        for (int i = 0; i < maxNrQues; i++) {
            Thread startQueue = new Thread(queue[i]);
            startQueue.start();
        }
    }
}