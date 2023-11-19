package org.example.Model;

import org.example.Controller.Controller;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Manager implements Runnable {
    static Manager singleInstance = null;
    private String[] instructions;
    private static AtomicInteger allThreadsFinished;
    static int run;

    private Manager() {
        allThreadsFinished = new AtomicInteger(0);
        run = 4;
    }

    public static Manager getInstance() {
        if (singleInstance == null)
            singleInstance = new Manager();
        return singleInstance;
    }

    public void setInstructions(String[] instructions) {
        this.instructions = instructions;
    }

    static int getAllThreadsFinished() {
        return allThreadsFinished.get();
    }

    static int incrementAll() {
        return allThreadsFinished.incrementAndGet();
    }

    @Override
    public void run() {
        while (run > 0) {
            If ifStage = If.getInstance();
            ifStage.setInstructions(instructions);
            Thread ifThread = new Thread(ifStage);

            Id idStage = Id.getInstance();
            idStage.updateRegisterFile();
            Thread idThread = new Thread(idStage);

            Ex exStage = Ex.getInstance();
            Thread exThread = new Thread(exStage);

            Mem memStage = Mem.getInstance();
            memStage.updateDataMemory();
            Thread memThread = new Thread(memStage);

            Wb wbStage = Wb.getInstance();
            Thread wbThread = new Thread(wbStage);

            ifThread.start();
            idThread.start();
            exThread.start();
            memThread.start();
            wbThread.start();

            boolean ok = false;
            while (!ok) {
                if ((allThreadsFinished.get() % 5) == 0) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Controller.ui.setIfTextArea(" ");
                    Controller.ui.setIdTextArea(" ");
                    Controller.ui.setExTextArea(" ");
                    Controller.ui.setMemTextArea(" ");
                    Controller.ui.setWbTextArea(" ");
                    wbStage.signal();
                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    memStage.signal();
                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    exStage.signal();
                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    idStage.signal();
                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ifStage.signal();
                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ok = true;
                }
            }

            try {
                ifThread.join();
                idThread.join();
                exThread.join();
                memThread.join();
                wbThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("gata");
    }
}
