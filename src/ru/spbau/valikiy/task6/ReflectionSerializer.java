package ru.spbau.valikiy.task6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReflectionSerializer {

    <T> void serialize(T t, String filename) throws IOException {
        BufferedWriter str = new BufferedWriter(new FileWriter(filename));
        str.write("hello");
        str.newLine();
        str.close();
    }

}
