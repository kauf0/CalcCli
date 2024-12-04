package com.github.kauf0;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class Calculator {

    public static final String CMD_EXIT = "cmd_exit";
    public static final String CMD_COPY = "cmd_copy";

    public static void main(String[] args) {
        // Greet the user and give them instructions on usage
        System.out.println("CalcCli\n" +
                "Input ':q' to exit, or ':c' to copy output.");
        // Create blank output string and print it out
        String output = "";
        System.out.println(output);
        // Create the scanner and read input string
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input); // this is for debugging purposes only

        // Check the input for quit and copy commands and, if
        // not present, pass the string into parser
        if (input.equals(":q")) {
            System.exit(0);
        } else {
            
        }


    }
}