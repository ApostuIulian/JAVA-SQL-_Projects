package org.example.Model;

import java.util.Random;
import static org.example.View.SimulationSetup.*;
import static org.example.View.SimulationSetup.getMaxArrival;

public class Client {
    private int id;
    static private int counter = 1;
    private int tArrival;
    public int tService;

    public Client() {
        Random random = new Random();
        this.id = counter;
        counter++;
        this.tArrival = random.nextInt(getMaxArrival() + 1 - getMinArrival()) + getMinArrival();
        this.tService = random.nextInt(getMaxService() + 1 - getMinService()) + getMinService();
    }

    public int getTArrival() {
        return this.tArrival;
    }

    public int getTService() {
        return this.tService;
    }

    public String toString() {
        return "(" + this.id + "," + this.tArrival + "," + this.tService + ")";
    }
}
