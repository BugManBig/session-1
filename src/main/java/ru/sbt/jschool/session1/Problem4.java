package ru.sbt.jschool.session1;

import java.util.*;

/**
 * Created by Df-170815-F1 on 20.03.2018.
 */
public class Problem4 {
    static int count = 0;

    public static void main(String[] args) {
        nextMethod(args);
        print();
    }

    private static void nextMethod(String[] args) {
        String text = "JSCHOOl1_COUNT=";
        if (args.length > 0) {
            String arg = args[0];
            if (Objects.equals(arg.substring(0, text.length()), text)) {
                count = Integer.parseInt(arg.substring(text.length()));
            }
            return;
        }

        Properties p = System.getProperties();
        Enumeration keys = p.keys();
        String key;
        while (keys.hasMoreElements()) {
            key = (String) (keys.nextElement());
            if (Objects.equals(key, text.substring(0, text.length() - 1))) {
                count = Integer.parseInt((String) (p.get(key)));
                return;
            }
        }

        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            if (Objects.equals(envName, text.substring(0, text.length() - 1))) {
                System.out.println("YY");
            }
        }

        //Output
        for (int i = 0; i < count; i++) {
            System.out.println("Hello, World!");
        }

        //new line for test
    }

    private static void print() {
        for (int i = 0; i < count; i++) {
            System.out.println("Hello, World!");
        }
    }
}
