package ru.spbau.valikiy.task6;

public class Main {

    public static void main(String[] args) {

        try {
            runCheat();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void runCheat() throws Exception {

        ReflectionSerializer s = new ReflectionSerializer();
        StudentBean st = new StudentBean();
        st.setAge(10);
        st.setSurname("Nurk");
        st.setName("Anton");
        st.setAvgGrade(3.8);
        s.serialize(st, "tests/AntonNurk.properties");

        ReflectionDeSerializer d = new ReflectionDeSerializer();

        StudentBean sn = d.deserialize("tests/AntonNurk.properties", StudentBean.class);
        
        System.out.println(sn.age);

    }

}
