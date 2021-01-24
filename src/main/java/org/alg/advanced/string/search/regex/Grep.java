package org.alg.advanced.string.search.regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grep {
    public static void main(String[] args) throws FileNotFoundException {
        String regexp = "(.*" + args[1] + ".*)";
        NFA nfa = new NFA(regexp);
        Scanner scanner = new Scanner(new File(args[0]));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (nfa.recognize(line))
                System.out.println(line);
        }
    }
}