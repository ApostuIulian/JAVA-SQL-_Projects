package org.example;

import org.example.Controller.Controller;
import org.example.View.SimulationSetup;

public class Main {

    public static void main(String[] args) {
        new Controller(new SimulationSetup());
    }
}