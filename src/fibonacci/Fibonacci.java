/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author asus
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public void printFibonacci(int count, int n1, int n2) {

        //ignore the comma in the last number and exit
        if (count == 1) {
            System.out.print(n2);
           //System.out.println(" Number:" + (45 - count + 1));
            return;
        } else {
            System.out.print(n1 + ", ");
          // System.out.println(" Number:" + (45 - count + 1));
            printFibonacci(count - 1, n2, n1 + n2);
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Fibonacci fibo=new Fibonacci();
        fibo.printFibonacci(45, 0, 1);

    }

}
