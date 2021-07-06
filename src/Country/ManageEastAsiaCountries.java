/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Country;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class ManageEastAsiaCountries {

  
public  int menu(){
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending");
        System.out.println("5. Exit");
        int choice =getChoice(1, 5, "Enter Your choice:");
        return choice;
    }
    public int getChoice(int min, int max, String s) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(s);
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    System.err.format("Please input in range[%d,%d]", min, max);
                    System.out.println("");
                }
                else
                return n;
            } catch (Exception e) {  
                System.out.println("Must be input number");
            }
        }
    }

    public  String checkInputString(String s) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(s);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else {
                return result;
            }
        }
    }
  public  boolean checkCodeExist( String countryCode,ArrayList<Country> country){
      if (country.size()==0) return false;
        for (Country cou : country) {
            if (cou.getCountryCode().equalsIgnoreCase(countryCode)) {
                return true;
            }
        }
        return false;
    }
    
    private double getInputArea(String s) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(s);
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Only nature number!!!");
            }
        }
    }

    public String getInputCode(String s, ArrayList<Country> country) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(s);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else {
                if (checkCodeExist(result, country)) {
                    System.out.println("Code Exist! Re-Enter");
                } else {
                    return result;
                }
            }
        }
    }
   public ArrayList<Country> getNewArrayList(ArrayList<Country> country){
       ArrayList<Country> a=new ArrayList<Country>();
       for (int i=0;i<country.size();i++){
          a.add(country.get(i));
       }
       return a;
   }
    public void addCountryInformation(ArrayList<Country> country) {
        if (country.size() == 3) {
            System.err.println("Only add 11 country");
            return;
        }
        String countryCode = getInputCode("Enter Code of Country:", country);
        String countryName = checkInputString("Enter Name of Country:");
        double totalArea = getInputArea("Enter Total Area:");
        String countryTerrain = checkInputString("Enter terrain of Country:");
        country.add(new Country(countryCode, countryName, (float) totalArea, countryTerrain));
        System.out.println("Add Success");
    }

    public void displayCountryInfomation(ArrayList<Country> country) {
        System.out.printf("%-10s%-25s%-20s%s\n", "ID", "Name", "Total Area","Terrain");
        for (Country cou : country) {
            cou.display();
        }
    }

    public void searchInfomationByName(ArrayList<Country> country) {
        String name = checkInputString("Enter the name you want to search for:");
        System.out.printf("%-10s%-25s%-20s%s\n", "ID", "Name", "Total Area","Terrain");
                for (int i = 0; i < country.size(); i++) {         
                if (country.get(i).getCountryCode().contains(name)) {
                country.get(i).display();
                return;        
            }
        }
    }
    public void sortInformationByAscendingOrder(ArrayList<Country> country){
         ArrayList result=getNewArrayList(country);
         Collections.sort(result);
         displayCountryInfomation(result);
    }

}
