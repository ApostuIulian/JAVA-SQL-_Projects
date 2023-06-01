package org.example.Model;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;

import static org.example.Model.Operations.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpTest {
    static double[] a;
    static double[] b;
    static double[] aAddB;
    static double[] c;
    static double[] d;
    static double[] cAddD;
    static double[] aSubC;
    static double[] bSubC;
    static double[] aMulC;
    static double[] bMulD;
    @BeforeAll
    static public void init() {
        //1x^3-2x^2+6x^1-5x^0
        a = new double[]{3, 1, 2, -2, 1, 6, 0, -5};
        //1x^2-1x^0
        b = new double[]{2, 1, 0, -1};
        //1x^3-x^2+6x^1-6x^0
        aAddB = new double[]{3, 1, 2, -1, 1, 6, 0, -6};

        //2x^3-1x^2+6x^1-9x^0
        c = new double[]{3, 2, 2, -1, 1, 6, 0, -9};
        //2x^2-2x^0
        d = new double[]{2, 2, 0, -2};

        //2x^3+1x^2+6x^1-11x^0
        cAddD = new double[]{3, 2, 2, 1, 1, 6, 0, -11};

        //-1x^3-1x^2-0x^1+4x^0
        aSubC = new double[]{3, -1, 2, -1, 1, 0, 0, 4};

        //-2.0x^3 + 2.0x^2 + -6.0x^1 + 8.0x^0
        bSubC = new double[]{3, -2, 2, 2, 1, -6, 0, 8};

        //2x^6−5x^5+20x^4−37x^3+59x^2−84x^1+45x^0
        aMulC = new double[]{6, 2, 5, -5, 4, 20, 3, -37, 2, 59, 1, -84, 0, 45};

        //2x^4−4x^2+2x^0
        bMulD = new double[]{4, 2, 2, -4, 0, 2};

    }

    @ParameterizedTest
    @MethodSource("addInput")
    public void addTest(String p3T, String resT) {
        assertEquals(p3T, resT);
    }
    private static List<Arguments> addInput(){
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of(new Polynomial(aAddB).toString(), add(new Polynomial(a), new Polynomial(b)).toString()));
        arguments.add(Arguments.of(new Polynomial(cAddD).toString(), add(new Polynomial(c), new Polynomial(d)).toString()));
        arguments.add(Arguments.of(new Polynomial(cAddD).toString(), add(new Polynomial(a), new Polynomial(c)).toString()));
        return arguments;
    }

    @ParameterizedTest
    @MethodSource("subtractInput")
    public void subTest(String p3T, String resT) {
        assertEquals(p3T, resT);
    }
    private static List<Arguments> subtractInput(){
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of(new Polynomial(aSubC).toString(), subtract(new Polynomial(a), new Polynomial(c)).toString()));
        arguments.add(Arguments.of(new Polynomial(bSubC).toString(), subtract(new Polynomial(b), new Polynomial(c)).toString()));
        arguments.add(Arguments.of(new Polynomial(bSubC).toString(), subtract(new Polynomial(a), new Polynomial(c)).toString()));
        return arguments;
    }

    @ParameterizedTest
    @MethodSource("multiplicationInput")
    public void multiplicationTest(String p3T, String resT) {
        assertEquals(p3T, resT);
    }
    private static List<Arguments> multiplicationInput(){
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of(new Polynomial(aMulC).toString(), multiplication(new Polynomial(a), new Polynomial(c)).toString()));
        arguments.add(Arguments.of(new Polynomial(bMulD).toString(), multiplication(new Polynomial(b), new Polynomial(d)).toString()));
        arguments.add(Arguments.of(new Polynomial(bMulD).toString(), multiplication(new Polynomial(a), new Polynomial(d)).toString()));
        return arguments;
    }

    @ParameterizedTest
    @MethodSource("divisionInput")
    public void divisionTest(String p3T, String resT) {
        assertEquals(p3T, resT);
    }
    private static List<Arguments> divisionInput(){
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of("Q= 1.0x^1-2.0x^0 | R= 7.0x^1-7.0x^0", division(new Polynomial(a), new Polynomial(b), new Polynomial(), new Polynomial()).toString()));
        arguments.add(Arguments.of("Q= 0.5x^0 | R= ", division(new Polynomial(b), new Polynomial(d), new Polynomial(), new Polynomial()).toString()));
        arguments.add(Arguments.of("Q= 0.5x^0 | R= ", division(new Polynomial(a), new Polynomial(d), new Polynomial(), new Polynomial()).toString()));
        return arguments;
    }

    @ParameterizedTest
    @MethodSource("differentiationInput")
    public void differentiationTest(String p3T, String resT) {
        assertEquals(p3T, resT);
    }
    private static List<Arguments> differentiationInput(){
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of("3.0x^2-4.0x^1+6.0x^0", differentiation(new Polynomial(a)).toString()));
        arguments.add(Arguments.of("2.0x^1", differentiation(new Polynomial(b)).toString()));
        arguments.add(Arguments.of("3.0x^2-4.0x^1+6.0x^0", differentiation(new Polynomial(d)).toString()));
        return arguments;
    }

    @ParameterizedTest
    @MethodSource("integralInput")
    public void integralTest(String p3T, String resT) {
        assertEquals(p3T, resT);
    }
    private static List<Arguments> integralInput(){
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of("0.25x^4-0.6666666666666666x^3+3.0x^2-5.0x^1", integral(new Polynomial(a)).toString()));
        arguments.add(Arguments.of("0.3333333333333333x^3-1.0x^1", integral(new Polynomial(b)).toString()));
        arguments.add(Arguments.of("3.0x^2-4.0x^1+6.0x^0-0.0x^-1", integral(new Polynomial(d)).toString()));
        return arguments;
    }
}
