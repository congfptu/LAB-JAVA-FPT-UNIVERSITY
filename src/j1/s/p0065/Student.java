/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0065;

/**
 *
 * @author asus
 */
public class Student {

    private String name;
    private String className;
    private double math;
    private double physical;
    private double chemistry;
    private double average;
    private String type;

    public Student() {
    }

    public Student(String name, String className, double math, double physical, double chemistry, double average, String type) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
        this.average = average;
        this.type = type;
    }

    public Student(String name, String className, double math, double physical, double chemistry) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getAverage() {
        return (chemistry + math + physical) / 3;
    }

    public String getTypeOfStudent(int countA, int countB, int countC, int countD) {
        double avg = (chemistry + math + physical) / 3;
        if (avg > 7.5) {
           countA++;
            return "A";
        }
        if (avg >= 6) {
            countB++;
            return "B";
        }
        if (avg >= 4) {
            countC++;
            return "C";
        }
        countD++;
        return "D";

    }

    public void display() {

        System.out.println("Name:" + name);
        System.out.println("Classes:" + className);

        System.out.println("AVG:" + (chemistry + math + physical) / 3);
        System.out.println("Type:" + getTypeOfStudent(0, 0, 0, 0));

    }

}
