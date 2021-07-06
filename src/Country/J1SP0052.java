/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Country;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class J1SP0052 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManageEastAsiaCountries manage=new ManageEastAsiaCountries();
        ArrayList<Country> country = new ArrayList<>();
        
        //loop until user want to exist
        while (true) {
            int choice =  manage.menu();
            switch (choice) {
                case 1:
                    manage.addCountryInformation(country);
                    break;
                case 2:
                    manage.displayCountryInfomation(country);
                    break;
                case 3:
                    manage.searchInfomationByName(country);
                    break;
                case 4:
                    manage.sortInformationByAscendingOrder(country);
                    break;
                case 5:
                    return;
            }
        }
    }
    }
    