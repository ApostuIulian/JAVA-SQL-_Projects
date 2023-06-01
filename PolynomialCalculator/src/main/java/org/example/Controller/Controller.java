package org.example.Controller;

import org.example.Model.Operations;
import org.example.Model.Polynomial;
import org.example.View.Ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements ActionListener {
    private Ui view;
    private Polynomial result;
    String regex = "([+-])?([0-9]*\\.?[0-9]*)?(x\\^)(\\d*)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher;
    int wrongInput = 0;

    public Controller(Ui view, Polynomial result) {
        this.view = view;
        this.result = result;
        this.view.addB.addActionListener(this);
        this.view.subtractB.addActionListener(this);
        this.view.multiplicationB.addActionListener(this);
        this.view.divisionB.addActionListener(this);
        this.view.differentiationB.addActionListener(this);
        this.view.integralB.addActionListener(this);
    }

    public Polynomial getFirstPolynomial() {
        Polynomial p = new Polynomial();
        String input = view.getFirstPoly();
        matcher = pattern.matcher(input);
        StringTokenizer st = new StringTokenizer(input, "+-", true);
        String sign1 = "";
        String monom = "";
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("+") || token.equals("-")) {
                sign1 = token;
            } else {
                monom=sign1+token;
                if(!monom.matches(regex)){
                    wrongInput=1;
                }
                sign1 = "";
            }
        }
        while (matcher.find()) {
            String sign = matcher.group(1);
            double coefficient = Double.parseDouble(matcher.group(2));
            int exponent = Integer.parseInt(matcher.group(4));
            if (sign == null || sign.equals("+")) {
                p.putM(exponent, coefficient);
            } else if (sign.equals("-")) {
                p.putM(exponent, -coefficient);
            }
        }
        return p;
    }

    public Polynomial getSecondPolynomial() {
        Polynomial p = new Polynomial();
        String input = view.getSecondPoly();
        matcher = pattern.matcher(input);
        StringTokenizer st = new StringTokenizer(input, "+-", true);
        String sign1 = "";
        String monomial = "";
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("+") || token.equals("-")) {
                sign1 = token;
            } else {
                monomial=sign1+token;
                if(!monomial.matches(regex)){
                    wrongInput=1;
                }
                sign1 = "";
            }
        }
        while (matcher.find()) {
            String sign = matcher.group(1);
            double coefficient = Double.parseDouble(matcher.group(2));
            int exponent = Integer.parseInt(matcher.group(4));
            if (sign == null || sign.equals("+")) {
                p.putM(exponent, coefficient);
            } else if (sign.equals("-")) {
                p.putM(exponent, -coefficient);
            }
        }
        return p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Polynomial p1 = getFirstPolynomial();
        Polynomial p2 = getSecondPolynomial();
        Operations o = new Operations();
        view.setResultField("");
        int div = 0;
        if (e.getSource() == view.addB) {
            this.result = o.add(p1, p2);
        }
        if (e.getSource() == view.subtractB) {
            this.result = o.subtract(p1, p2);
        }
        if (e.getSource() == view.multiplicationB) {
            this.result = o.multiplication(p1, p2);
        }
        if (e.getSource() == view.divisionB) {
            view.setResultField(o.division(p1, p2, new Polynomial(), new Polynomial()));
            div=1;
        }
        if (e.getSource() == view.differentiationB) {
            this.result = o.differentiation(p1);
        }
        if (e.getSource() == view.integralB) {
            this.result = o.integral(p1);
        }
        if (div == 0 && wrongInput == 0) {
            o.delZeros(result);
            view.setResultField(result.toString());
        } else if (wrongInput == 1) {
            view.setResultField("Wrong Input");
            wrongInput = 0;
        }
    }
}
