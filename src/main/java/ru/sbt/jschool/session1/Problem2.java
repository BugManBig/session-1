package ru.sbt.jschool.session1;

import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by Df-170815-F1 on 20.03.2018.
 */
public class Problem2 {
    public static void main(String[] args) {
        Properties p = System.getProperties();
        Enumeration keys = p.keys();
        while (keys.hasMoreElements()) {
            String key = (String) (keys.nextElement());
            String value = (String) (p.get(key));
            System.out.println(key + ": " + value);
        }
    }
}
