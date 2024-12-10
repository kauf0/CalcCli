package com.github.kauf0;

import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;

import java.math.BigDecimal;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        // Greet the user and give them instructions on usage
        System.out.println("CalcCli\n" +
                "Input ':q' to exit, or ':c' to copy output.");
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
                case String sInp when sInp.equals(":q") -> {
                    System.exit(0);
                }
                case String sInp when sInp.contains(":c") -> {
                    System.out.println("this should later be used to copy string");
                }
                case String sInp when sInp.matches("[a-zA-Z;:\"'`~!@#$%{}\\[\\]]+") || sInp.isBlank() -> {
                    System.out.println("Please, provide proper input.");
                }
                default -> {
                    try {
                        Expression inputExp = new Expression(input);
                        EvaluationValue result = inputExp.evaluate();
                        System.out.println(result.getNumberValue().toPlainString());
                    } catch (Exception e) {
                        e.printStackTrace(System.out);
                    }
                }
            }
        } while (!input.equals(":q"));
    }
}