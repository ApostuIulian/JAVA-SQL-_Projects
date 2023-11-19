package org.example.Model;

import org.example.Controller.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.Model.Manager.run;

public class Id implements Runnable {
    static Id singleInstance = null;
    private final Object queLock = new Object();
    private static String instruction;
    private static int[] registerFile;
    private int registerAddress1, registerAddress2, immediateValue, registererDestination;
    private static int writeAddress, writeData;
    private String func, aluOp;
    private static boolean[] mainControl;

    public static Id getInstance() {
        if (singleInstance == null)
            singleInstance = new Id();
        return singleInstance;
    }

    private Id() {
        registerFile = new int[32];
        mainControl = new boolean[8];
    }

    void setOpCodes() {
        this.mainControl = new boolean[8];
        //mainControl[0] = mainControl[1] = mainControl[2] = mainControl[3] = mainControl[4] = mainControl[5] = mainControl[6] = mainControl[7] = false;
        aluOp = "-1";
        switch (this.func) {
            case "add":
                this.mainControl[6] = true; //regDst
                this.mainControl[2] = true; //regWr
                aluOp = "000";
                break;
            case "addi":
                this.mainControl[5] = true; //aluSrc
                this.mainControl[2] = true;
                aluOp = "000";
                break;
            case "sub":
                this.mainControl[6] = true;
                this.mainControl[2] = true;
                aluOp = "001";
                break;
            case "and":
                this.mainControl[6] = true;
                this.mainControl[2] = true;
                aluOp = "010";
                break;
            case "or":
                this.mainControl[6] = true;
                this.mainControl[2] = true;
                aluOp = "011";
                break;
            case "xor":
                this.mainControl[6] = true;
                this.mainControl[2] = true;
                aluOp = "111";
                break;
            case "nor":
                this.mainControl[6] = true;
                this.mainControl[2] = true;
                aluOp = "110";
                break;
            case "sll":
                this.mainControl[6] = true;
                this.mainControl[2] = true;
                aluOp = "100";
                break;
            case "srl":
                this.mainControl[6] = true;
                this.mainControl[2] = true;
                aluOp = "101";
                break;
            case "bne":
                this.mainControl[7] = true; //bne
                aluOp = "001";
                break;
            case "beq":
                this.mainControl[4] = true; //branch
                aluOp = "001";
                break;
            case "lw":
                this.mainControl[5] = true;
                this.mainControl[1] = true; //memTOReg
                this.mainControl[2] = true;
                aluOp = "000";
                break;
            case "sw":
                this.mainControl[5] = true;
                this.mainControl[3] = true; //memWr
                aluOp = "000";
                break;
            case "j":
                this.mainControl[0] = true; //jump
                break;
            default:
                this.mainControl = new boolean[8];
                aluOp = "-1";
        }
    }

    public void signal() {
        synchronized (queLock) {
            this.queLock.notifyAll();
        }
    }

    void setInstruction(String newInstruction) {
        instruction = newInstruction;
    }

    void updateRegisterFile() {
        Controller.ui.setRfTextArea(" ");
        for (int i = 0; i < 32; i++) {
            Controller.ui.setRfTextArea(Controller.ui.rfTextArea.getText() + "RF[" + i + "]= " + registerFile[i] + "\n");
        }

    }
    static void setWriteData(int wd) {
        writeData = wd;
    }

    static void setRegWr(boolean regWr)
    {
        mainControl[2] = regWr;
    }

    String decodeInstruction() {
        SyntaxCheck decode = new SyntaxCheck();
        String regex = decode.getInstructionType(this.instruction);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.instruction);
        if (matcher.find()) {
            this.func = matcher.group(1);
            if (regex.equals(decode.getRTypeRegex())) {
                this.registerAddress1 = Integer.parseInt(matcher.group(2).substring(1));
                this.registerAddress2 = Integer.parseInt(matcher.group(3).substring(1));
                this.registererDestination = Integer.parseInt(matcher.group(4).substring(1));
                Controller.ui.setIdTextArea("RF[" + registererDestination + "] = RF[" + registerAddress1 + "] ? RF[" + registerAddress2 + "]");
            } else if (regex.equals(decode.getITypeRegex())) {
                this.registerAddress1 = Integer.parseInt(matcher.group(2).substring(1));
                this.registerAddress2 = Integer.parseInt(matcher.group(3).substring(1));
                this.immediateValue = Integer.parseInt(matcher.group(4));
                Controller.ui.setIdTextArea("RF[" + registerAddress1 + "] = RF[" + registerAddress2 + "] ? " + immediateValue);
            } else if (regex.equals(decode.getIwTypeRegex())) {
                this.registerAddress1 = Integer.parseInt(matcher.group(2).substring(1));
                this.registerAddress2 = Integer.parseInt(matcher.group(4).substring(1));
                this.immediateValue = Integer.parseInt(matcher.group(3));
                if (this.func.equals("lw")) {
                    Controller.ui.setIdTextArea("RF[" + registerAddress1 + "]= DM[" + immediateValue + "RF[" + registerAddress2 + "]");
                } else {
                    Controller.ui.setIdTextArea("DM[" + immediateValue + "RF[" + registerAddress2 + "]= " + "RF[" + registerAddress1 + "]");
                }
            } else {
                this.immediateValue = Integer.parseInt(matcher.group(2));
                Controller.ui.setIdTextArea(instruction);
            }
        }
        return regex;
    }

    static int getRegisterFile(int index) {
        return registerFile[index];
    }

    boolean getMemToReg() {
        return this.mainControl[1];
    }

    boolean getRegWr() {
        return this.mainControl[2];
    }

    boolean getMemWr() {
        return this.mainControl[3];
    }

    boolean getBranch() {
        return this.mainControl[4];
    }

    boolean getAluSrc() {
        return this.mainControl[5];
    }

    boolean getRegDst() {
        return this.mainControl[6];
    }

    boolean getBne() {
        return this.mainControl[7];
    }

    void sendDataToNextStage() {
        Ex ex = Ex.getInstance();
        ex.setAluOp(aluOp);
        ex.setMemSignals(new boolean[]{this.getMemWr(), this.getBranch(), this.getBne()});
        ex.setExSignals(new boolean[]{this.getAluSrc(), this.getRegDst()});
        ex.setWbSignals(new boolean[]{this.getMemToReg(), this.getRegWr()});
        ex.setAluIn1(getRegisterFile(registerAddress1));
        ex.setRegisterDestination(registererDestination);
        ex.setRegisterT(registerAddress2);
        ex.setImmediateValue(immediateValue);
        ex.setInstruction(this.instruction);
        //this.instruction = "";
        if (this.mainControl[2]) {
            registerFile[writeAddress] = writeData;
        }
    }

    public static void setWriteAddress(int wA) {
        writeAddress = wA;
    }

    @Override
    public void run() {
        if (this.instruction == null) {
            Manager.incrementAll();
            return;
        }
        this.decodeInstruction();
        this.setOpCodes();
        synchronized (queLock) {
            try {
                Manager.incrementAll();
                queLock.wait();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (this.func.equals("j")) {
            If.setPc(this.immediateValue);
        } else {
            this.sendDataToNextStage();
        }
        updateRegisterFile();
        instruction = " ";
    }

    public static void reset()
    {
        singleInstance = null;
    }
}
