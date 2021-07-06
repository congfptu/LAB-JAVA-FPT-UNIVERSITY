/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;


import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author congfptu
 */
public class Manager {
    private final static Scanner in = new Scanner(System.in);
    private static final String BINARY_VALID = "[0-1]+";
    private static final String DECIMAL_VALID = "[0-9]+";
    private static final String HEXADECIMAL_VALID = "[0-9A-Fa-f]+";

    //check user input number limit
    public int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input number binary
    public  String checkInputBinary() {
        System.out.print("Enter number binary: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim();
            if (result.matches(BINARY_VALID)) {
                return result;
            }
            System.err.println("Must be enter 0 or 1");
            System.out.print("Enter again: ");
        }
    }

    //    //check user input number binary
    public String checkInputDecimal() {
        System.out.print("Enter number decimal: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim();
            if (result.matches(DECIMAL_VALID)) {
                return result;
            }
            System.err.println("Must be enter 0-9");
            System.out.print("Enter again: ");
        }
    }

    //    //check user input number binary
    public String checkInputHexaDecimal() {
        System.out.print("Enter number hexadecimal: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim();
            if (result.matches(HEXADECIMAL_VALID)) {
                return result;
            }
            System.err.println("Must be enter 0-9 A-F");
            System.out.print("Enter again: ");
        }
    }
    
    //display menu
    public int menu(){
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexa.");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 4);
        return choice;
    }

    //display choose conver
    public int displayConvert(String from, String toCase1, String toCase2) {
        System.out.println("1. Convert form " + from + " to " + toCase1);
        System.out.println("2. Convert form " + from + " to " + toCase2);
        System.out.print("Enter your choice: ");
        int result = checkInputIntLimit(1, 2);
        return result;
    }
    //allow user convert from binary
    public void convertFromBinary(String binary) {
        int choice = displayConvert("binary", "decimal", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Decimal: "
                        + convertBinaryToDecimal(binary)
                );
                break;
            case 2:
                System.out.println("Hexadecimal: "
                        + convertBinaryToHexa(binary));
                break;
        }
    }

    //allow user convert from binary
    public  void convertFromDecimal(String decimal) {
        int choice = displayConvert("decimal", "binary", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + convertDecimalToBinary(decimal)
                );
                break;
            case 2:
                System.out.println("Hexadecimal: "
                        + convertDecimalToHexa(decimal));
                break;
        }
    }

    //allow user convert from binary
    public void convertFromHexa(String hexa) {
        int choice = displayConvert("hexa", "binary", "decimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + convertHexaToBinary(hexa)
                );
                break;
            case 2:
                System.out.println("Decimal: "
                        + convertHexaToDecimal(hexa));
                break;
        }
    }
    //allow user convert from binary to decimal
    public String convertBinaryToDecimal(String binary) {
        BigInteger decimal= BigInteger.ZERO;
        BigInteger base = new BigInteger("2");
        for (int i = 0; i < binary.length() ; i++) {
            if(binary.charAt(i)=='1'){
                decimal=decimal.add(base.pow(binary.length()-1-i));
            }
        }
        return decimal.toString();
   }

    //allow user convert from binary to decimal
    public String convertBinaryToHexa(String binary) {
        String decimal = convertBinaryToDecimal(binary);
        String hexa = convertDecimalToHexa(decimal);
        return hexa;
    }

    

    //allow user convert from binary to decimal
    public String convertHexaToBinary(String hexadecimal) {
        String decimal = convertHexaToDecimal(hexadecimal);
        String binary = convertDecimalToBinary(decimal);
        return binary;
    }

    //allow user convert from binary to decimal
    public  String convertDecimalToBinary(String decimal) {
        char[] binDigits = {'0','1'};
        String binary = "";
        BigInteger deci = new BigInteger(decimal);
        while(deci.intValue()!=0){
            BigInteger remainder = deci.mod(new BigInteger("2"));
            binary = binDigits[remainder.intValue()] + binary;
            deci=deci.divide(new BigInteger("2"));
        }
        return binary;
    }

    //allow user convert from decimal to hexa
    public  String convertDecimalToHexa(String decimal) {
        String hexa = "";
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};    
        BigInteger deci = new BigInteger(decimal);
        while (deci.intValue() != 0) {
            System.out.format("%d:16 =  ",deci);
            BigInteger remainder = deci.mod(new BigInteger("16"));
            hexa = hexDigits[remainder.intValue()] + hexa;
            deci = deci.divide(new BigInteger("16"));
            System.out.format("%d remainder %d\n",deci ,remainder);
        }
        return hexa;
    }
    //allow user convert from hexa to decimal
    public  String convertHexaToDecimal(String hexadecimal) {
        String digits = "0123456789ABCDEF";  
             hexadecimal = hexadecimal.toUpperCase();  
             BigInteger decimal= BigInteger.ZERO;
             for (int i = 0; i <hexadecimal.length() ; i++)  
             {  
                 char c = hexadecimal.charAt(i);  
                 int d = digits.indexOf(c);
                 BigInteger value = new BigInteger(Integer.toString(d));
                 BigInteger base = new BigInteger("16");
                 decimal =decimal.add(base.pow(hexadecimal.length()-1-i).multiply(value));  
             }  
             return decimal.toString(); 
    }
}
