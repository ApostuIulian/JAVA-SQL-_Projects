package org.example.Controller;

import org.example.View.Ui;

import java.awt.event.ActionEvent;

public class Controller {
    Ui ui;
    static Controller singleInstance = null;
    private Controller() {
        ui = new Ui();
        ui.runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });
    }

    private void runButtonActionPerformed(ActionEvent evt) {

    }

    public static Controller getInstance() {
        if (singleInstance == null)
            singleInstance = new Controller();
        return singleInstance;
    }

}
