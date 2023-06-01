package org.example.Model;

import java.util.Iterator;
import java.util.Map;

public class Operations {
    public Operations() {

    }

    public static void delZeros(Polynomial Poly) {
        Iterator<Map.Entry<Integer, Double>> iter = Poly.getPoly().entrySet().iterator();
        while (iter.hasNext()) {
            if (iter.next().getValue() == 0) {
                iter.remove();
            }
        }
    }

    public static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> i : p1.getPoly().entrySet()) {
            int exponent = i.getKey();
            double coefficient = i.getValue();
            result.putM(exponent, coefficient);
        }
        for (Map.Entry<Integer, Double> i : p2.getPoly().entrySet()) {
            int exponent = i.getKey();
            double coefficient = i.getValue();
            if (result.getPoly().containsKey(exponent)) {
                coefficient = coefficient + result.getPoly().get(exponent);
            }
            result.putM(exponent, coefficient);
        }
        return result;
    }

    public static Polynomial subtract(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> i : p1.getPoly().entrySet()) {
            int exponent = i.getKey();
            double coefficient = i.getValue();
            result.putM(exponent, coefficient);
        }
        for (Map.Entry<Integer, Double> i : p2.getPoly().entrySet()) {
            int exponent = i.getKey();
            double coefficient = -i.getValue();
            if (result.getPoly().containsKey(exponent)) {
                coefficient = coefficient + result.getPoly().get(exponent);
            }
            result.putM(exponent, coefficient);
        }
        return result;
    }

    public static Polynomial multiplication(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        double coefficient;
        for (Map.Entry<Integer, Double> i : p1.getPoly().entrySet()) {
            for (Map.Entry<Integer, Double> j : p2.getPoly().entrySet()) {
                coefficient = 0;
                if (result.getPoly().containsKey(i.getKey() + j.getKey())) {
                    coefficient = result.getPoly().get(i.getKey() + j.getKey());
                }
                result.putM(i.getKey() + j.getKey(), coefficient + (i.getValue() * j.getValue()));
            }
        }
        return result;
    }

    public static String division(Polynomial p1, Polynomial p2, Polynomial q, Polynomial q1) {
        if (p1.getPoly().firstKey() >= p2.getPoly().firstKey()) {
            q.putM(p1.getPoly().firstKey() - p2.getPoly().firstKey(), p1.getPoly().firstEntry().getValue() / p2.getPoly().firstEntry().getValue());
            q1.putM(p1.getPoly().firstKey() - p2.getPoly().firstKey(), p1.getPoly().firstEntry().getValue() / p2.getPoly().firstEntry().getValue());
            p1.setPoly(subtract(p1, multiplication(q, p2)));
            delZeros(p1);
            q.getPoly().clear();
            if (!p1.getPoly().isEmpty())
                division(p1, p2, q, q1);
        }
        return "Q= " + q1.toString() + " | R= " + p1.toString();
    }

    public static Polynomial differentiation(Polynomial p) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> i : p.getPoly().entrySet()) {
            if (!(i.getValue() == 0)) {
                result.putM(i.getKey() - 1, i.getKey() * i.getValue());
            }
        }
        return result;
    }

    public static Polynomial integral(Polynomial p) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> i : p.getPoly().entrySet()) {
            result.putM(i.getKey() + 1, i.getValue() / (i.getKey() + 1));
        }
        return result;
    }
}
