package com.example.ProiectPS.Model;

import java.io.*;
import java.util.Map;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class CompileCode {
    public static String compileJava(String code, String input) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        PrintStream originalOut = System.out;
        System.setOut(printStream);

        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            File tempDir = new File(System.getProperty("java.io.tmpdir"));
            String fileName = "Main.java";
            File sourceFile = new File(tempDir, fileName);

            try (FileWriter writer = new FileWriter(sourceFile)) {
                writer.write(code);
            }

            int compilationResult = compiler.run(null, null, null, sourceFile.getPath());

            if (compilationResult != 0) {
                return "Compilation failed.";
            }

            Process process = Runtime.getRuntime().exec("java -cp " + tempDir.getPath() + " Main " + input);

            String output = readProcessOutput(process);

            process.waitFor();

            return output;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Execution interrupted.";
        } finally {
            System.setOut(originalOut);
        }
    }

    public static String compileCpp(String code, String input) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        PrintStream originalOut = System.out;
        System.setOut(printStream);

        try {
            // Create temporary files
            File tempDir = new File(System.getProperty("java.io.tmpdir"));
            String fileName = "Main.cpp";
            File sourceFile = new File(tempDir, fileName);

            // Write C++ code to the temporary file
            try (FileWriter writer = new FileWriter(sourceFile)) {
                writer.write(code);
            }

            // Compile using g++ (assuming it's installed)
            Process compileProcess = Runtime.getRuntime().exec(
                    new String[]{"g++", "-o", "Main", sourceFile.getPath()}
            );

            String compileOutput = readProcessOutput(compileProcess);
            compileProcess.waitFor();

            if (compileProcess.exitValue() != 0) {
                return "Compilation failed:\n" + compileOutput;
            }

            // Run the compiled program
            Process runProcess = Runtime.getRuntime().exec(
                    new String[]{"./Main", input}
            );

            String runOutput = readProcessOutput(runProcess);
            runProcess.waitFor();

            return runOutput;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        } finally {
            System.setOut(originalOut);
        }    }

    private static String readProcessOutput(Process process) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = process.getInputStream().read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        return outputStream.toString().trim();
    }
}
