/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0065;

import Country.Country;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class ManagerStudent {
 Country country= new Country();
    public double getInputdouble(String s) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(s + ":");
            try {
                double n = Double.parseDouble(sc.nextLine());
                if (n > 10) {
                    System.out.println(s + " is less than equal ten");
                } else {
                    if (n < 0) {
                        System.out.println(s + " is greater than zero");
                    } else {
                        return n;
                    }
                }
            } catch (Exception e) {
                System.out.println(s + " is digit");
            }
        }
    }

    public void display(ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("----Student" + (i + 1) + "Info----");
            list.get(i).display();
        }
    }

    public void createStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {      
            System.out.print("Name:");
            String name = sc.nextLine();
            System.out.print("Classes:");
            String className = sc.nextLine();
            double maths = getInputdouble("Maths");
            double physics = getInputdouble("Physics");
            double chemistry = getInputdouble("Chemistry");
            list.add(new Student(name, className, maths, physics, chemistry));
            System.out.println("Do you want to enter more student information?(Y/N)");
            String choice = sc.nextLine();
            if (choice.equals("N")) {
                ArrayList<Student> result= averageStudent(list);
                display(result);
                HashMap<String, Double> map = getPercentTypeStudent(result);
                System.out.println("----Classìication Info----");
                map.forEach((t, u) -> {
                    System.out.println(t + ":" + u+"%");
                });
                return;
            }
        }
    }
  public ArrayList<Student> averageStudent(ArrayList<Student> list){
      ArrayList<Student> result=new ArrayList<>();
        for (Student o:list)
        result.add(new Student(o.getName(),o.getClassName(),o.getMath(),o.getPhysical(),o.getChemistry(),o.getAverage(),o.getTypeOfStudent(0,0,0,0)));
        return result;
  }
    public HashMap<String, Double> getPercentTypeStudent(ArrayList<Student> list) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        for (int i = 0; i < list.size(); i++) {
           list.get(i).getTypeOfStudent(countA, countB, countC, countD);
        }
        
        HashMap<String, Double> map = new HashMap<>();
        map.put("A", (countA * 100.0) / list.size());
        map.put("B", (countB * 100.0) / list.size());
        map.put("C", (countC * 100.0) / list.size());
        map.put("D", (countD * 100.0) / list.size());
        return map;
    }
}
