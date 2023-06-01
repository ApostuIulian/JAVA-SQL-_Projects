package org.example.View;


import javax.swing.*;

public class Ui extends JFrame {
    private JTextField resultField = new JTextField();
    private JLabel insertLabel = new JLabel("Insert polinomes:");
    private JTextField firstPoly = new JTextField();
    private JTextField secondPoly = new JTextField();
    public JButton addB = new JButton("+");
    public JButton subtractB = new JButton("-");
    public JButton multiplicationB = new JButton("*");
    public JButton divisionB = new JButton("/");
    public JButton differentiationB = new JButton("d/dx");
    public JButton integralB = new JButton("∫");
    private JLabel invisible = new JLabel("");

    public Ui() {
        this.setSize(600, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Polynome Calculator");
        resultField.setBounds(0, 0, 600, 70);
        insertLabel.setBounds(0, 100, 100, 100);
        firstPoly.setBounds(0, 200, 600, 70);
        secondPoly.setBounds(0, 300, 600, 70);
        addB.setBounds(0, 500, 300, 70);
        subtractB.setBounds(300, 500, 300, 70);
        multiplicationB.setBounds(0, 600, 300, 70);
        divisionB.setBounds(300, 600, 300, 70);
        differentiationB.setBounds(0, 700, 300, 70);
        integralB.setBounds(300, 700, 300, 70);
        resultField.setEditable(false);

        this.add(resultField);
        this.add(insertLabel);
        this.add(firstPoly);
        this.add(secondPoly);
        this.add(addB);
        this.add(subtractB);
        this.add(multiplicationB);
        this.add(divisionB);
        this.add(differentiationB);
        this.add(integralB);
        this.add(invisible);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        invisible.setVisible(false);
    }

    public String getFirstPoly() {
        return firstPoly.getText();
    }

    public String getSecondPoly() {
        return secondPoly.getText();
    }

    public void setResultField(String result) {
        resultField.setText(result);
    }
}
