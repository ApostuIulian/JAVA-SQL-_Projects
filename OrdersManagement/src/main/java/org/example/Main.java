package org.example;

import org.example.Connection.ConnectionFactory;
import org.example.Controller.Controller;
import org.example.View.SelectData;

public class Main {
    public static void main(String[] args) {
        new Controller(new SelectData(), ConnectionFactory.getConnection());
    }
}