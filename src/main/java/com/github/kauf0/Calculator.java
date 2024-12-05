package com.github.kauf0;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;

import javax.script.ScriptException;
import java.beans.PropertyEditorSupport;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        // Greet the user and give them instructions on usage
        System.out.println("CalcCli\n" +
                "Input ':q' to exit, or ':c' to copy output.");
        // Create the scanner and read input Expression string
        Scanner scanner = new Scanner(System.in);
        Expression input = new Expression(scanner.nextLine());
        System.out.println(input); // this is for debugging purposes only

        // Check the input for quit command and, if
        // not present, pass the string into parser
        if (input.equals(":q")) {
            System.exit(0);
        } else {
            try {
                EvaluationValue result = input.evaluate();
                System.out.println(result.getNumberValue());
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }
}