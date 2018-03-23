package ru.sbt.jschool.session1;

import java.io.*;
import java.util.*;

/**
 * Created by Df-170815-F1 on 20.03.2018.
 */
public class Problem4 {
    static int count = -1;

    public static void main(String[] args) {
        nextMethod(args);
        print();
    }

    private static void nextMethod(String[] args) {
        String text = "JSCHOOl1_COUNT";
        String textForFile = "JSCHOOL1_PROPERTIES_FILE";
        if (args.length > 0) {
            String arg = args[0];
            if (Objects.equals(arg.substring(0, text.length()), text)) {
                count = Integer.parseInt(arg.substring(text.length() + 1));
            }
            return;
        }

        String prop = System.getProperty(text);
        if (prop != null) {
            count = Integer.parseInt(prop);
            return;
        }

        Map<String, String> env = System.getenv();
        if (env.get(text) != null) {
            count = Integer.parseInt(env.get(text));
            return;
        }

        if (env.get(textForFile) != null) {
            String path = env.get(textForFile);
            if (new File(path).exists()) {
                count = getCountFromFile(path);
            }
        }
    }

    private static void print() {
        if (count == -1) {
            System.out.println("Требуется передать одно из четырёх:\n" +
                    "параметр вида `JSCHOOl1_COUNT=XXX`, где `XXX` число раз.\n" +
                    "системная настройка вида `JSCHOOl1_COUNT=XXX`, где `XXX` число раз.\n" +
                    "переменная окружения вида `JSCHOOl1_COUNT=XXX`, где `XXX` число раз.\n" +
                    "переменная окружения вида `JSCHOOL1_PROPERTIES_FILE=XXX`, где `XXX` это путь к существующему файлу.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Hello, World!");
        }
    }

    private static int getCountFromFile(String path) {
        Scanner in = null;
        try {
            in = new Scanner(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(in.next());
        in.close();
        return Integer.parseInt(sb.toString());
    }
}
