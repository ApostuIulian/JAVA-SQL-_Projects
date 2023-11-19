package org.example.Model;

import org.example.Controller.Controller;

public class If implements Runnable {
    static If singleInstance = null;
    private final Object queLock = new Object();
    private static String[] instructions;
    private static int pc;

    private If() {
        pc = 0;
    }

    static void setPc(int newPc) {
        pc = newPc;
    }

    static void setInstructions(String[] instr)
    {
        instructions = instr;
    }

    public static If getInstance() {
        if (singleInstance == null)
            singleInstance = new If();
        return singleInstance;
    }

    public void signal() {
        synchronized (queLock) {
            queLock.notifyAll();
        }
    }

    private void sendDataToNextStage(String nextInstruction) {
        Id id = Id.getInstance();
        id.setInstruction(nextInstruction);
    }

    @Override
    public void run() {
        String nextInstruction = " ";
        try {
            nextInstruction = instructions[pc];
        } catch (IndexOutOfBoundsException e) {
            Manager.incrementAll();
            Manager.run--;
            return;
        }
        Controller.ui.setIfTextArea(nextInstruction);
        pc++;
        synchronized (queLock) {
            try {
                Manager.incrementAll();
                queLock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.sendDataToNextStage(nextInstruction);
    }

    public static void reset()
    {
        singleInstance = null;
    }
}
