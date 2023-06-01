package org.example.Model;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer, Double> poly = new TreeMap<>(Collections.reverseOrder());

    public Polynomial() {

    }

    public Polynomial(double[] x) {
        for (int i = 0; i < x.length; i += 2) {
            this.putM((int) x[i], x[i + 1]);
        }
    }

    public void putM(int exponent, double coefficient) {
/*        if(this.poly.containsKey(exponent))
        {
            coefficient=coefficient+this.poly.get(exponent);
        }*/
        this.poly.put(exponent, coefficient);
    }

    public TreeMap<Integer, Double> getPoly() {
        return this.poly;
    }

    public void setPoly(Polynomial p) {
        this.poly = p.poly;
    }

    public String toString() {
        String s = "";
        int first=1;
        for (Map.Entry<Integer, Double> i : this.poly.entrySet()) {
            if(i.getValue()>0) {
                if(first==1)
                {
                    s = s + i.getValue() + "x^" + i.getKey();
                    first=0;
                }else
                s = s + "+" + i.getValue() + "x^" + i.getKey();
            }
            if(i.getValue()<0)
                s = s + i.getValue() + "x^" + i.getKey();
        }
        return s;
    }//1x^5-3x^3+2x^1-3x^0
    //1x^2+1x^1+3x^0
}
