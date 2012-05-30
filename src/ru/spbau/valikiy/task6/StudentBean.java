package ru.spbau.valikiy.task6;

/**
 * Test class for serialisation
 */
public class StudentBean {

    String name;
    String surname;
    int age;
    double avgGrade;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public double getAvgGrade() {
        return avgGrade;
    }
    
    public String getName(){
        return name;
    }
    
}
