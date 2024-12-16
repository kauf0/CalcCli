package com.github.kauf0;

import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.math.MathContext;

public class Copying {
    // Copy with rounding
    //
    //
    public static void copyExpressionAndResult(String input) {
        try {
            MathContext m = new MathContext(3);
            // Cutting off the end of the sentence that contains ":c"
            String inputCommandCutoff = input.substring(0, input.length() - 2);

            Expression inputExp = new Expression(inputCommandCutoff);

            EvaluationValue result = inputExp.evaluate();
            System.out.println(result.getNumberValue().round(m).toPlainString());

            // Copies both expression and result
            StringSelection stringSelection = new StringSelection(inputCommandCutoff + "\n" + result.getNumberValue().round(m).toPlainString());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    public static void copyResultOnly(String input) {
        try {
            MathContext m = new MathContext(3);
            // Cutting off the end of the sentence that contains ":cr"
            String inputCommandCutoff = input.substring(0, input.length() - 3);

            Expression inputExp = new Expression(inputCommandCutoff);

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
    public static void copyExpressionOnly(String input) {
        try {
            MathContext m = new MathContext(3);
            // Cutting off the end of the sentence that contains ":ce"
            String inputCommandCutoff = input.substring(0, input.length() - 3);

            Expression inputExp = new Expression(inputCommandCutoff);

            EvaluationValue result = inputExp.evaluate();
            System.out.println(result.getNumberValue().round(m).toPlainString());

            // Copies both expression and result
            StringSelection stringSelection = new StringSelection(inputCommandCutoff);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    // BIG-related copy commands
    //
    //
    public static void copyBigExpressionAndResult(String input) {
        try {
            // Cutting off the end of the sentence that contains ":bc"
            String inputCommandCutoff = input.substring(0, input.length() - 3);

            Expression inputExp = new Expression(inputCommandCutoff);

            EvaluationValue result = inputExp.evaluate();
            System.out.println(result.getNumberValue().toPlainString());

            // Copies both expression and result
            StringSelection stringSelection = new StringSelection(inputCommandCutoff + "\n" + result.getNumberValue().toPlainString());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    public static void copyBigResultOnly(String input) {
        try {
            // Cutting off the end of the sentence that contains ":bcr"
            String inputCommandCutoff = input.substring(0, input.length() - 4);

            Expression inputExp = new Expression(inputCommandCutoff);

            EvaluationValue result = inputExp.evaluate();
            System.out.println(result.getNumberValue().toPlainString());

            // Copies both expression and result
            StringSelection stringSelection = new StringSelection(result.getNumberValue().toPlainString());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    public static void copyBigExpressionOnly(String input) {
        try {
            // Cutting off the end of the sentence that contains ":bcr"
            String inputCommandCutoff = input.substring(0, input.length() - 4);

            Expression inputExp = new Expression(inputCommandCutoff);

            EvaluationValue result = inputExp.evaluate();
            System.out.println(result.getNumberValue().toPlainString());

            // Copies both expression and result
            StringSelection stringSelection = new StringSelection(inputCommandCutoff);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
