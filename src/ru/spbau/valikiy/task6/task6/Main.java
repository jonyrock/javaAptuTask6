package ru.spbau.valikiy.task6.task6;

/**
 * Start class
 */
public class Main {

    /**
     * Start point
     * @param args filename to update avgGrade or nothing to create example 
     */
    public static void main(String[] args) {

        try {
            if (args.length == 0) {
                runNewExample();
            } else {
                runCheat(args[0]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Generate example
     * @throws Exception if something wrong
     */
    public static void runNewExample() throws Exception {
        ReflectionSerializer s = new ReflectionSerializer();
        StudentBean st = new StudentBean();
        st.setAge(21);
        st.setSurname("Velikiy");
        st.setName("Alexey");
        st.setAvgGrade(2.1);
        st.setClassName('A');
        s.serialize(st, "AlexeyVelikiy.properties");
    }

    /**
     * Update avgGrade in file
     * @param filename to read
     * @throws Exception if something wrong
     */
    public static void runCheat(String filename) throws Exception {

        ReflectionDeSerializer d = new ReflectionDeSerializer();
        StudentBean sn = d.deserialize(filename, StudentBean.class);
        sn.avgGrade = Math.min(5.0, sn.avgGrade + 1.0);

        ReflectionSerializer s = new ReflectionSerializer();
        s.serialize(sn, filename);

    }

}
