package ru.sbt.jschool.session1;

import java.util.Map;

/**
 * Created by Df-170815-F1 on 20.03.2018.
 */
public class Problem3 {
    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }
    }
}
