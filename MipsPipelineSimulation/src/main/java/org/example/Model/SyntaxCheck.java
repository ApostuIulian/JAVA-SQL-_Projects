package org.example.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.example.Controller.Controller;
public class SyntaxCheck {

    private static String rTypeRegex = null;
    private static String[] iTypeRegex = new String[0];
    private static String jTypeRegex = null;

    public SyntaxCheck()
    {
        rTypeRegex = "(add|sub|and|or|xor|nor|sll|srl) (\\$\\d+), (\\$\\d+), (\\$\\d+)";
        iTypeRegex = new String[2];
        iTypeRegex[0] = "(addi|bne|beq|bgtz) (\\$\\d+), (\\$\\d+), (\\d+)";
        iTypeRegex[1] = "(lw|sw) (\\$\\d+), (\\d+)\\((\\$\\d+)\\)";
        jTypeRegex = "(j) (\\d+)";
    }

    public String[] checkSyntax() {
        String[] instructions = Controller.ui.getInstructions().split("\\r?\\n");
        String[] instructionTypes = new String[4];
        instructionTypes[0] = rTypeRegex;
        instructionTypes[1] = iTypeRegex[0];
        instructionTypes[2] = iTypeRegex[1];
        instructionTypes[3] = jTypeRegex;
        for (String instruction : instructions) {
            int match = 0;
            for (String i : instructionTypes) {
                Pattern pattern = Pattern.compile(i);
                Matcher matcher = pattern.matcher(instruction);
                if (!matcher.matches()) {
                    match++;
                } else {
                    break;
                }
                if (match > 3) {
                    throw new RuntimeException("Error! The following Instruction does not match any type: " + instruction);
                }
            }
        }
        return instructions;
    }

    String getInstructionType(String regexInstruction) {
        Pattern pattern = Pattern.compile(rTypeRegex);
        Matcher matcher = pattern.matcher(regexInstruction);
        if (matcher.matches()) {
            return rTypeRegex;
        }
        pattern = Pattern.compile(iTypeRegex[0]);
        matcher = pattern.matcher(regexInstruction);
        if (matcher.matches()) {
            return iTypeRegex[0];
        }
        pattern = Pattern.compile(iTypeRegex[1]);
        matcher = pattern.matcher(regexInstruction);
        if (matcher.matches()) {
            return iTypeRegex[1];
        }
        pattern = Pattern.compile(jTypeRegex);
        matcher = pattern.matcher(regexInstruction);
        if (matcher.matches()) {
            return jTypeRegex;
        }
        return "Err";
    }

    public String getRTypeRegex() {
        return rTypeRegex;
    }

    public String getITypeRegex() {
        return iTypeRegex[0];
    }

    public String getIwTypeRegex() {
        return iTypeRegex[1];
    }

    public String getJTypeRegex() {
        return jTypeRegex;
    }

}
