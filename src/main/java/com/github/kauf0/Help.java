package com.github.kauf0;

public class Help {
    public static void help(){
        System.out.println("""
                            List of commands:
                            | **These commands should be used at the end of expression**
                            | :q   - Quit
                            | :h   - Prints this message
                            |----------------------------------------------------------------
                            | :c   - Copies both the expression and the result
                            | :cr  - Copies only the result
                            | :ce  - Copies only the expression
                            |----------------------------------------------------------------
                            | :b   - Prints the result in true Big Decimal (without rounding)
                            | :bc  - Copies both the expression and the result in Big Decimal
                            | :bcr - Copies only the result in Big Decimal
                            | :bce - Copies only the expression""");
    }
}
