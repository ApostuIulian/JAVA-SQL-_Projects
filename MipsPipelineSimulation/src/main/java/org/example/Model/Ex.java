package org.example.Model;

import org.example.Controller.Controller;

import java.util.Arrays;

import static org.example.Model.Manager.run;

public class Ex implements Runnable {
    static Ex singleInstance = null;
    private final Object queLock = new Object();
    private static String instruction, aluOp;
    private static boolean[] wbSignals, memSignals, exSignals;
    private int aluIn1, aluIn2, immediateValue, registerDestination, registerT, destination, result;
    private boolean zero;
    private String operation;

    private Ex() {
        wbSignals = new boolean[2];
        memSignals = new boolean[3];
        exSignals = new boolean[2];
    }

    public static Ex getInstance() {
        if (singleInstance == null)
            singleInstance = new Ex();
        return singleInstance;
    }

    void alu() {
        switch (aluOp) {
            case "000":
                this.result = this.aluIn1 + this.aluIn2;
                operation = "+";
                break;
            case "001":
                this.result = this.aluIn1 - this.aluIn2;
                operation = "-";
                break;
            case "010":
                this.result = this.aluIn1 & this.aluIn2;
                operation = "&";
                break;
            case "011":
                this.result = this.aluIn1 | this.aluIn2;
                operation = "|";
                break;
            case "100":
                this.result = this.aluIn1 << this.aluIn2;
                operation = "<<";
                break;
            case "101":
                this.result = this.aluIn1 >> this.aluIn2;
                operation = ">>";
                break;
            case "110":
                this.result = ~this.aluIn1;
                operation = "~";
                break;
            case "111":
                this.result = this.aluIn1 ^ this.aluIn2;
                operation = "^";
                break;
            default:
                break;
        }
        if (this.result == 0) {
            this.zero = true;
        } else {
            this.zero = false;
        }
    }

    void setAluIn1(int newAluIn1) {
        aluIn1 = newAluIn1;
    }

    void setRegisterT(int newRt) {
        registerT = newRt;
    }

    void setAluOp(String newAluOp) {
        aluOp = newAluOp;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setWbSignals(boolean[] wb) {
        this.wbSignals = Arrays.copyOf(wb, 2);
    }


    public void setMemSignals(boolean[] mem) {
        this.memSignals = Arrays.copyOf(mem, 3);
    }

    public void setExSignals(boolean[] ex) {
        exSignals = Arrays.copyOf(ex, 2);
    }

    public void setImmediateValue(int imm) {
        this.immediateValue = imm;
    }

    void setRegisterDestination(int rd) {
        registerDestination = rd;
    }

    void sendDataToNextStage()
    {
        Mem mem = Mem.getInstance();
        mem.setInstruction(this.instruction);
        mem.setWbSignals(wbSignals);
        mem.setMemSignals(memSignals);
        mem.setBranch(this.immediateValue);
        mem.setAddress(this.result);
        mem.setWriteData(Id.getRegisterFile(registerT));
        mem.setDestination(this.destination);
        mem.setZero(this.zero);
    }

    public void signal() {
        synchronized (queLock) {
            queLock.notifyAll();
        }
    }
    @Override
    public void run() {
        if (this.instruction == null || run < 2) {
            Manager.incrementAll();
            return;
        }
        if (exSignals[0]) //AluSrc
        {
            this.aluIn2 = this.immediateValue;
        } else {
            this.aluIn2 = Id.getRegisterFile(registerT);
        }
        if (exSignals[1]) {
            this.destination = registerDestination;
        } else {
            this.destination = registerT;
        }
        this.alu();
        Controller.ui.setExTextArea(aluIn1 + " " + operation + " " + aluIn2);
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

    public static void reset()
    {
        singleInstance = null;
    }
}
