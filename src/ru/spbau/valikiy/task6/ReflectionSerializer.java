package ru.spbau.valikiy.task6;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionSerializer {

    <T> void serialize(T t, String filename) throws Exception {

        Properties properties = new Properties();

        Class<?> cls = t.getClass();

        Method methods[] = cls.getDeclaredMethods();
        for (Method m : methods) {

            String name = m.getName();
            if (!name.startsWith("get") || name.length() == 3) {
                continue;
            }

            String propertyName = Character.toLowerCase(name.charAt(3)) + name.substring(4);
            Object value = m.invoke(t);
            properties.setProperty(propertyName, value.toString());

        }

        properties.store(new FileWriter(filename), "");

    }

}
