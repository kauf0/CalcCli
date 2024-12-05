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
        String input = "";

        do {
            // Create the scanner and read input Expression string
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            //System.out.println(input); // this was for debugging purposes only

            if (input.equals(":q")){
                System.exit(0);
            } else if (input.contains(":c")){
                System.out.println("this should later be used to copy string");
            } else if (input.matches("[a-zA-Z_;:\"'`~!@#$%{}\\[\\]]+") || input.isBlank()){
                System.out.println("Please, provide proper input.");
            } else {
                try {
                    Expression inputExp = new Expression(input);
                    EvaluationValue result = inputExp.evaluate();
                    System.out.println(result.getNumberValue());
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }
        } while (!input.equals(":q"));
    }
}