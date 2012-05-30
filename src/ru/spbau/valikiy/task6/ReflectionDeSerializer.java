package ru.spbau.valikiy.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Comparator;

public class ReflectionDeSerializer {

    <T> void deserialize(String filename, Class<T> cls) throws Exception {

        BufferedReader ostr = new BufferedReader(new FileReader(filename));


        try {

            Method methods[] = cls.getDeclaredMethods();
            Arrays.sort(methods, new Comparator<Method>() {
                public int compare(Method methodA, Method methodB) {
                    return methodA.getName().compareTo(methodB.getName());
                }
            });

            String line;
            while ((line = ostr.readLine()) != null) {

                String[] ln = line.split("=");
                String name = ln[0];
                String value = ln[1];
                String setterName = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);

                int res = Arrays.binarySearch(methods, setterName, new Comparator<Object>() {
                    public int compare(Object method, Object name) {
                        return name.toString().compareTo(((Method) method).getName());
                    }
                });

                if (res == -1) {
                    continue;
                }

                Method m = methods[res];
                Type t = m.getGenericParameterTypes()[0];
                //t.getClass().c
                //m.invoke()

                //String propertyName = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                //Object value = m.invoke(t);
                //ostr.write(propertyName + "=" + value);
                //ostr.newLine();

            }

        } catch (Exception e) {
            ostr.close();
            throw e;
        }

    }

}
