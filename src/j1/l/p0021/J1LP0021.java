/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class J1LP0021 {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        ArrayList<Student> ls = new ArrayList<>();
        Validation validation = new Validation();
        Manager a=new Manager();
      
        int count = 0;
        //loop until user want to exit program
        while (true) {
            //Show menu option
            a.menu();
            int choice = validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    a.createStudent(count, ls);
                    break;
                case 2:
                    a.findAndSort(ls);
                    break;
                case 3:
                    a.updateOrDelete(count, ls);
                    break;
                case 4:
                    a.report(ls);
                    break;
                case 5:
                    return;
            }

        }
    }

}

