package org.example.Model;

import org.example.Controller.Controller;

import java.util.Arrays;

import static org.example.Model.Manager.run;

public class Wb implements Runnable {
    static Wb singleInstance = null;
    private final Object queLock = new Object();
    private boolean[] wbSignals = new boolean[2];
    private int readData, address, destination;
    private String instruction;


    private Wb() {

    }

    public static Wb getInstance() {
        if (singleInstance == null)
            singleInstance = new Wb();
        return singleInstance;
    }

    public void setWbSignals(boolean[] wb) {
        this.wbSignals = Arrays.copyOf(wb, 2);
    }


    public void setReadData(int readData) {
        this.readData = readData;
    }

    public void setDestination(int dst) {
        this.destination = dst;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void signal() {
        synchronized (queLock) {
            queLock.notifyAll();
        }
    }

    @Override
    public void run() {
        if (this.instruction == null) {
            Manager.incrementAll();
            return;
        }
        Id.setWriteAddress(this.destination);
        if (wbSignals[0]) {
            Id.setWriteData(this.readData);
            Controller.ui.setWbTextArea("RF[" + this.destination + "]= " + this.readData + "\nRegister Write signal = " + this.wbSignals[1]);
        } else {
            Id.setWriteData(this.address);
            Controller.ui.setWbTextArea("RF[" + this.destination + "]= " + this.address + "\nRegister Write signal = " + this.wbSignals[1]);
        }
        Id.setRegWr(this.wbSignals[1]);
        Manager.incrementAll();
        synchronized (queLock) {
            try {
                queLock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void reset()
    {
        singleInstance = null;
    }
}
