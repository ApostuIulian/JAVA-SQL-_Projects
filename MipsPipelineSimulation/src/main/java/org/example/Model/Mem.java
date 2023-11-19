package org.example.Model;

import org.example.Controller.Controller;

import java.util.Arrays;

import static org.example.Model.Manager.run;

public class Mem implements Runnable {

    static Mem singleInstance = null;

    private final Object queLock = new Object();
    private boolean[] wbSignals;
    private boolean[] memSignals;
    private boolean zero;
    private int address, writeData, destination, branch, readData;
    private static int[] dataMemory;
    private String instruction;

    private Mem() {
        wbSignals = new boolean[2];
        memSignals = new boolean[3];
        dataMemory = new int[100];
    }

    public static Mem getInstance() {
        if (singleInstance == null)
            singleInstance = new Mem();
        return singleInstance;
    }

    void setAddress(int address) {
        this.address = address;
    }

    void setMemSignals(boolean[] mem) {
        this.memSignals = Arrays.copyOf(mem, 3);
    }

    public void setWbSignals(boolean[] wb) {
        this.wbSignals = Arrays.copyOf(wb, 2);
    }

    public void setWriteData(int writeData) {
        this.writeData = writeData;
    }


    void setDestination(int dst) {
        this.destination = dst;
    }


    void setZero(Boolean zero) {
        this.zero = zero;
    }

    void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    void setBranch(int branch) {
        this.branch = branch;
    }

    static void updateDataMemory() {
        Controller.ui.setDmTextArea(" ");
        for (int i = 0; i < 32; i++) {
            Controller.ui.setDmTextArea(Controller.ui.dmTextArea.getText() + "DM[" + i + "]= " + dataMemory[i] + "\n");
        }
    }

    public void signal() {
        synchronized (queLock) {
            queLock.notifyAll();
        }
    }



    @Override
    public void run() {
        if (this.instruction == null || run < 1) {
            Manager.incrementAll();
            return;
        }
        if (this.memSignals[1]) {
            Controller.ui.setMemTextArea(this.instruction);
            if (this.zero) {
                If.setPc(this.branch);
            }
        } else if (this.memSignals[2]) {
            Controller.ui.setMemTextArea(this.instruction);
            if (!zero) {
                If.setPc(this.branch);
            }
        } else {
            if (this.memSignals[0]) {
                this.dataMemory[address] = writeData;
                Controller.ui.setMemTextArea("dataMemory["+address+"]" + "= " + writeData);
            } else {
                this.readData = dataMemory[address];
                Controller.ui.setMemTextArea("Read data" + "= " + dataMemory[address] + "\n Register Targer(rt)= " + this.address);
            }
            synchronized (queLock) {
                try {
                    Manager.incrementAll();
                    queLock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.sendDataToNextStage();
        }
        updateDataMemory();
    }

    private void sendDataToNextStage() {
        Wb wb = Wb.getInstance();
        wb.setInstruction(this.instruction);
        wb.setWbSignals(this.wbSignals);
        wb.setReadData(this.readData);
        wb.setAddress(this.address);
        wb.setDestination(this.destination);
    }
    public static void reset()
    {
        singleInstance = null;
    }
}
