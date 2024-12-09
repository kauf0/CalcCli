package com.github.kauf0;

import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.math.MathContext;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        // Greet the user and give them instructions on usage
        System.out.println("CalcCli\n" +
                "Input ':q' to exit.\n" +
                ":h for list of commands.");
        // Create blank variables to use later
        String input = "";

        // Math goes here
        do {
            // Create the scanner and read input Expression string
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();

            // Check for presence of commands and if expression doesn't contain
            // any letters and special symbols
            switch (input) {
                // QUIT command
                case String sInp when sInp.equals(":q") -> {
                    System.exit(0);
                }
                // HELP command
                case String sInp when sInp.equals(":h") -> {
                    System.out.println("List of commands:\n" +
                            "| **These commands should be used at the end of expression**\n" +
                            "| :q  - Quit\n" +
                            "| :h  - Prints this message\n" +
                            "|---------------------------------------------------------------\n" +
                            "| :c  - Copies both the expression and the result\n" +
                            "| :cr - Copies only the result\n" +
                            "| :ce - Copies only the expression\n" +
                            "|---------------------------------------------------------------\n" +
                            "| :b  - Prints the result in true Big Decimal (without rounding)");
                }
                // COPY command
                case String sInp when sInp.endsWith(":c") -> {
                    try {
                        MathContext m = new MathContext(3);
                        // Cutting off the end of the sentence that contains ":c"
                        Expression inputExp = new Expression(input.substring(0, input.length() - 2));

                        EvaluationValue result = inputExp.evaluate();
                        System.out.println(result.getNumberValue().round(m).toPlainString());

                        // Copies both expression and result
                        StringSelection stringSelection = new StringSelection(input.substring(0, input.length() -2) + "\n" + result.getNumberValue().round(m).toPlainString());
                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clipboard.setContents(stringSelection, null);
                    } catch (Exception e) {
                        e.printStackTrace(System.out);
                    }
                }
                // COPY-RESULT command
                case String sInp when sInp.endsWith(":cr") -> {
                    try {
                        MathContext m = new MathContext(3);
                        // Cutting off the end of the sentence that contains ":cr"
                        Expression inputExp = new Expression(input.substring(0, input.length() - 3));

                        EvaluationValue result = inputExp.evaluate();
                        System.out.println(result.getNumberValue().round(m).toPlainString());

                        // Copies both expression and result
                        StringSelection stringSelection = new StringSelection(result.getNumberValue().round(m).toPlainString());
                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clipboard.setContents(stringSelection, null);
                    } catch (Exception e) {
                        e.printStackTrace(System.out);
                    }
                }
                // COPY-EXPRESSION command
                case String sInp when sInp.endsWith(":ce") -> {
                    try {
                        MathContext m = new MathContext(3);
                        // Cutting off the end of the sentence that contains ":c"
                        Expression inputExp = new Expression(input.substring(0, input.length() - 3));

                        EvaluationValue result = inputExp.evaluate();
                        System.out.println(result.getNumberValue().round(m).toPlainString());

                        // Copies both expression and result
                        StringSelection stringSelection = new StringSelection(input.substring(0, input.length() -3));
                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clipboard.setContents(stringSelection, null);
                    } catch (Exception e) {
                        e.printStackTrace(System.out);
                    }
                }
                // BIG command -- prints true Big Decimal
                case String sInp when sInp.endsWith(":b") -> {
                    try {
                        // Cutting off the end of the sentence that contains ":b"
                        Expression inputExp = new Expression(input.substring(0, input.length() - 2));

                        EvaluationValue result = inputExp.evaluate();
                        System.out.println(result.getNumberValue().toPlainString());
                    } catch (Exception e) {
                        e.printStackTrace(System.out);
                    }
                }
                // Check for irrelevant input (letters and special characters)
                case String sInp when sInp.matches("[a-zA-Z;:\"'`~!@#$%{}\\[\\]]+") || sInp.isBlank() -> {
                    System.out.println("Please, provide proper input.");
                }
                // Default expression evaluation (with rounding to 3 numbers after point)
                default -> {
                    try {
                        MathContext m = new MathContext(3);
                        Expression inputExp = new Expression(input);
                        EvaluationValue result = inputExp.evaluate();
                        System.out.println(result.getNumberValue().round(m).toPlainString());
                    } catch (Exception e) {
                        e.printStackTrace(System.out);
                    }
                }
            }
        } while (!input.equals(":q"));
    }
}