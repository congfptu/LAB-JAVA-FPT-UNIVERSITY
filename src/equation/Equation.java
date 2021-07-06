/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class Equation {

    /**
     * @param args the command line arguments
     */
    public static int checkInputIntLimit(int min, int max) {
        Scanner sc = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public float checkIn(String floatString){           
               float number=Float.parseFloat(floatString);
               return number;   
    }
    public float getFloat(){
          Scanner sc = new Scanner(System.in);
        while(true){
            try{
             String floatString=sc.nextLine();
             return checkIn(floatString);
        } 
            catch(Exception e){
                System.out.println("Enter number");
            }
        }
    }
    public static float getInput(int i) {
        Scanner sc = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            if (i == 1) {
                System.out.println("Enter A");
            }
            if (i == 2) {
                System.out.println("Enter B");
            }
            if (i == 3) {
                System.out.println("Enter C");
            }
            try {
                float result = Float.parseFloat(sc.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Please Input number");
            }

        }
    }

    public boolean checkOdd(double n) {
        if (checkEven(n) == false) {
            return true;
        } else {
            return false;
        }
    }

    //check number is even or not
    public boolean checkEven(double n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkSquareNumber(double n) {
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return true;
        } else {
            return false;
        }
    }

    public static int menu() {
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 3);
        return choice;
    }

    public List<Float> calculateEquation(float a, float b) {
        List<Float> list = new ArrayList();
        if (a == 0 && b != 0) {
            return null;
        } else {
            if (a == 0 && b == 0) {
                return list;
            } else {
                list.add(-b / a);
                return list;
            }
        }
    }

    public List<Float> calculateQuaraticEquation(float a, float b, float c) {
        List<Float> list = new ArrayList();
        if (a == 0 && b == 0 && c == 0) {
            return list;
        } else {
            if (a == 0) {
                return calculateEquation(b, c);
            } else {
                float x = b * b - 4 * a * c;
                if (x < 0) {
                    return null;
                } else {
                       float delta = (float) Math.sqrt(x);
                        float x1 = (-b - delta) / (2 * a);
                        float x2 = (-b + delta) / (2 * a);
                        list.add(x1);
                        list.add(x2);
                        return list;
                    }

                }
            }
    }
     public void getMessage1(float a, float b,float c, List<Float> list) {
        list.add(a);
        list.add(b);
        list.add(c);
        List<Float> odd = new ArrayList<>();
        List<Float> even = new ArrayList<>();
        List<Float> square = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (checkOdd(list.get(i))) {
                odd.add(list.get(i));
            }
            if (checkEven(list.get(i))) {
                even.add(list.get(i));
            }
            if (checkSquareNumber(list.get(i))) {
                square.add(list.get(i));
            }
        }
        if (odd.size() == 0) {
        } else {
            System.out.print("Number is Odd:");
            for (int i = odd.size()-1 ; i >0; i--) {
                System.out.print(odd.get(i) + ", ");
            }
            System.out.println(odd.get(0));

        }

        if (even.size() == 0) {
        } else {
            System.out.print("Number is even:");
            for (int i = even.size()-1 ; i >0; i--) {
                System.out.print(even.get(i) + ", ");
            }
            System.out.println(even.get(0));

        }
        if (square.size() == 0) {
        } else {
             System.out.print("Number is square:");
            for (int i = 0 ; i <square.size()-1; i++) {
                System.out.print(square.get(i) + ", ");
            }
            System.out.println(square.get(square.size()-1));
        }

    }
    public void getMessage(float a, float b, List<Float> list) {
       
        float c = list.get(0);
        List<Float> listAll = new ArrayList<>();
        listAll.add(a);
        listAll.add(b);
        listAll.add(c);
        List<Float> odd = new ArrayList<>();
        List<Float> even = new ArrayList<>();
        List<Float> square = new ArrayList<>();
        for (int i = 0; i < listAll.size(); i++) {
            if (checkOdd(listAll.get(i))) {
                odd.add(listAll.get(i));
            }
            if (checkEven(listAll.get(i))) {
                even.add(listAll.get(i));
            }
            if (checkSquareNumber(listAll.get(i))) {
                square.add(listAll.get(i));
            }
        }
        if (odd.size() == 0) {
        } else {
            System.out.print("Number is Odd:");
            for (int i =0;i<odd.size()-1; i++) {
                System.out.print(odd.get(i) + ", ");
            }
            System.out.println(odd.get(odd.size() - 1));

        }

        if (even.size() == 0) {
        } else {
            System.out.print("Number is Even:");
            for (int i = 0; i < even.size() - 1; i++) {
                System.out.print(even.get(i) + ", ");

            }
            System.out.println(even.get(even.size() - 1));

        }
        if (square.size() == 0) {
        } else {
            System.out.print("Number is Square:");
            for (int i = 0; i < square.size() - 1; i++) {
                System.out.print(square.get(i) + ", ");
            }
            System.out.println(square.get(square.size() - 1));
        }

    }

    public void superlativeEquation() {
         System.out.println("----- Calculate Equation -----");
        float a = getInput(1);
        float b = getInput(2);
        List<Float> list = new ArrayList();
        list = calculateEquation(a, b);
        if (list == null) {
            System.out.println("No Solution");
            return;
        }
        if (list.size() == 0) {
            System.out.println("Infiniely Solution");
        } else {
            System.out.printf("Solution: x = ");
            System.out.println(list.get(0));
            getMessage(a, b, list);

        }
    }

    public void quaraticEquation() {
         System.out.println("----- Calculate Quaratic Equation -----");
        float a = getInput(1);
        float b = getInput(2);
        float c = getInput(3);
       
        List<Float> list = new ArrayList();
        list = calculateQuaraticEquation(a, b, c);
        if (list == null) {
            List<Float> newlist = new ArrayList();
            System.out.println("No Solution");
            getMessage1(a, b, c, newlist);
            return;
        }
        if (list.size() == 0) {
            System.out.println("Infiniely Solution");
            getMessage1(a, b, c, list);
            return;
        } else {
                if (list.size()==1) {
                    System.out.println("Solution x = "+list.get(0));
                      getMessage1(a, b, c, list);
                      return;
                }
                else{
                System.out.printf("Solution x1 = %.3f  and x2 = %.3f",list.get(0), list.get(1));
                System.out.println("");
                getMessage1(a, b, c, list);
                return;}
            }
        }

    public static void main(String[] args) {
        // TODO code application logic here
       Equation a = new Equation();
        while(true){
            int choice=menu();
            switch(choice){
                case 1: a.superlativeEquation();
                break;
                case 2: a.quaraticEquation();
                break;
                case 3:return;
                     
            }
        }
       

        
    }

}
