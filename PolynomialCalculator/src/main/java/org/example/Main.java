package org.example;

import org.example.Controller.Controller;
import org.example.Model.Polynomial;
import org.example.View.Ui;

public class Main {
    public static void main(String[] args) {
        Ui view = new Ui();
        Polynomial model = new Polynomial();
        new Controller(view, model);
    }
}