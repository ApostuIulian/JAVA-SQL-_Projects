package org.example.Model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Queue implements Runnable, Comparable<Queue> {

    private int id;
    static private int counter = 1;
    private BlockingQueue<Client> queue;
    private int waitPeriod;
    private final Object queLock = new Object();
    private int closed = 1;
    private static int totalWaitingTime = 0;
    private static int clientsServed = 0;
    private static int totalServiceTime = 0;

    public Queue() {
        queue = new ArrayBlockingQueue<>(100);
        this.id = counter;
        counter++;
        waitPeriod = 0;
    }

    public void addClient(Client client) {
        try {
            queue.put(client);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        totalWaitingTime += waitPeriod;
        waitPeriod += client.getTService();
        totalWaitingTime += waitPeriod;
        totalServiceTime+=client.getTService();
        closed = 0;
    }

    public void signal() {
        synchronized (queLock) {
            queLock.notifyAll();
        }
    }

    @Override
    public void run() {
      while(true) {
            synchronized (queLock) {
                try {
                    queLock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            Client first = null;
            try {
                first = queue.peek();
            } catch (Exception e) {
            }
            if (first != null) {
                first.tService--;
                this.waitPeriod--;
                if (first.tService == 0) {
                    queue.poll();
                    clientsServed++;
                }
            }
            if (this.waitPeriod == 0) {
                closed = 1;
            }
        }
    }

    public int getWaitPeriod() {
        return this.waitPeriod;
    }

    public int getStatus() {
        return this.closed;
    }

    public String toString() {
        if (closed == 1) {
            return "Queue " + this.id + ": " + "closed\n";
        } else {
            String queNotEmpty = "Queue " + this.id + ": ";
            for (Client c : queue) {
                queNotEmpty += c + ";";
            }
            return queNotEmpty + "\n";
        }
    }

    public int getTotalWaitingTime()
    {
        return totalWaitingTime;
    }

    public int getClientsServed()
    {
        return clientsServed;
    }

    public int getTotalServiceTime()
    {
        return totalServiceTime;
    }

    public int getSize() {
        return this.queue.size();
    }

    @Override
    public int compareTo(Queue o) {
        int wait = this.waitPeriod - o.waitPeriod;
        if (wait == 0) {
            return this.id - o.id;
        }
        return wait;
    }
}
