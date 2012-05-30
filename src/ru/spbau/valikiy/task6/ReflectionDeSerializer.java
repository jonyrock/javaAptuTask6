package ru.spbau.valikiy.task6;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;
import java.util.Set;

public class ReflectionDeSerializer {

    <T> T deserialize(String filename, Class<T> cls) throws Exception {

        Object o = cls.getConstructors()[0].newInstance();

        Properties properties = new Properties();
        properties.load(new FileReader(filename));

        Method methods[] = cls.getDeclaredMethods();
        Arrays.sort(methods, new Comparator<Method>() {
            public int compare(Method methodA, Method methodB) {
                return methodA.getName().compareTo(methodB.getName());
            }
        });

        Set<String> names = properties.stringPropertyNames();
        for (String name : names) {

            String setterName = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);

            int res = Arrays.binarySearch(methods, setterName, new Comparator<Object>() {
                public int compare(Object method, Object name) {

                    String n = name.toString();
                    String mn = ((Method) method).getName();
                    return mn.compareTo(n);

                }
            });

            if (res == -1) {
                continue;
            }

            String value = properties.getProperty(name);
            Method m = methods[res];
            
            Class<?> cl = m.getParameterTypes()[0];
            m.invoke(o, parseStringValue(value, cl));

        }

        return cls.cast(o);

    }

    static <T> Object parseStringValue(String str, Class<T> cls) {
        if(cls.getName().toLowerCase().equals("double")){
            return Double.parseDouble(str);
        }
        if(cls.getName().toLowerCase().equals("integer")){
            return Integer.parseInt(str);
        }
        if(cls.getName().toLowerCase().equals("int")){
            return Integer.parseInt(str);
        }
        if(cls.getName().toLowerCase().equals("float")){
            return Integer.parseInt(str);
        }
        return str;
    }

}
