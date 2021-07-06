/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

import j1.s.p0011.Manager;

/**
 *
 * @author congfptu
 */
public class J1SP0011 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 //loop until user want to exit
 Manager a=new Manager();
        while (true) {
            int choice = a.menu();
            switch (choice) {
                case 1:
                    String binary = a.checkInputBinary();
                    a.convertFromBinary(binary);
                    break;
                case 2:
                    String decimal = a.checkInputDecimal();
                    a.convertFromDecimal(decimal);
                    break;
                case 3:
                    String hexa = a.checkInputHexaDecimal();
                   a.convertFromHexa(hexa);
                    break;
                case 4:
                    return;
            }
        }
    }
    
}
