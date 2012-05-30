package ru.spbau.valikiy.task6;

import java.io.*;
import java.lang.reflect.Method;

public class ReflectionSerializer {

    <T> void serialize(T t, String filename) throws Exception {

        BufferedWriter ostr = new BufferedWriter(new FileWriter(filename));
        
        try {
            
            Class<?> cls = t.getClass();

            Method methods[] = cls.getDeclaredMethods();
            for (Method m : methods) {

                String name = m.getName();
                if (!name.startsWith("get") || name.length() == 3) {
                    continue;
                }

                String propertyName = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                Object value = m.invoke(t);
                ostr.write(propertyName + "=" + value);
                ostr.newLine();

            }

        } catch (Exception e) {
            ostr.close();
            throw e;
        }
        
        ostr.close();

    }

}
