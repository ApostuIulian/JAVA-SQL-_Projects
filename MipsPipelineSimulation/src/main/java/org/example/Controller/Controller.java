package org.example.Controller;

import org.example.Model.Ex;
import org.example.Model.Manager;
import org.example.Model.SyntaxCheck;
import org.example.View.Ui;

import java.awt.event.ActionEvent;

public class Controller {
    static public Ui ui;
    static Controller singleInstance = null;
    SyntaxCheck checkInstructions;
    private Controller() {
        checkInstructions = new SyntaxCheck();
        ui = new Ui();
        ui.runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    runButtonActionPerformed(evt);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void runButtonActionPerformed(ActionEvent evt) throws InterruptedException {
        ui.setWriteLabel();
        Manager manager;
        try {
            String[] instructions = checkInstructions.checkSyntax();
            manager = Manager.getInstance();
            manager.setInstructions(instructions);
        }catch(RuntimeException exception){
            ui.setRunError(String.valueOf(exception).substring(28));
            return;
        }
        Thread startThread = new Thread(manager);
        startThread.start();
        //System.out.println("gata");
    }

    public static void getInstance() {
        if (singleInstance == null)
            singleInstance = new Controller();
    }

}
