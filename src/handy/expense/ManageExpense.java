/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handy.expense;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class ManageExpense {

    public int checkIntLimit(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public int checkInputInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public boolean checkFormat(String date) {
        String[] a = date.split("-");

        final String VALID_NAME = "[0-9]*";
        if (a.length != 3) {
            return false;
        } else {
            String year = a[2];
            String day = a[0];
            String month = a[1];
            if (year.length() != 4 || day.length() != 2 || month.length() != 3) {
                return false;
            } else {
                if (day.matches(VALID_NAME) && year.matches(VALID_NAME)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public void getMessageDate(String date) {
        String[] a = date.split("-");
       
        if (checkFormat(date) == false) {
            System.out.println("Wrong format! Please Enter Format (dd-MMM-yyyy)");
            return;
        } else {
             int year = Integer.parseInt(a[2]);
        int day = Integer.parseInt(a[0]);
        String month = a[1];
            if (day > 31 || day <= 0) {
                System.out.println("Day must be from 1 to 31");
            } else {
                if (month.equals("Apr") || month.equals("Jun") || month.equals("Sep") || month.equals("Nov")) {
                    if (day == 31) {
                        System.out.println("This month don't have 31th day");
                    }
                } else {
                    if (month.equals("Feb")) {
                        if (day >= 30) {
                            System.out.println("This month only maximum 29 days");
                        } else {
                            if (isLeapYear(year) == false && day == 29) {
                                System.out.println("There is no 29th day because it is not a leap year");
                            }
                        }
                    } else {
                        if (year < 1) {
                            System.out.println("Year must be >0");
                        }
                        System.out.println("InValid Date!Re-Input");
                    }
                }
            }
        }
    }

    public String getDateString() {
        Scanner sc = new Scanner(System.in);
        DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        sdf.setLenient(false);
        while (true) {
            System.out.print("Enter Date:");
            String date = sc.nextLine().trim();
            try {
                sdf.parse(date);
                return date;
            } catch (Exception e) {
                getMessageDate(date);
            }
        }
    }

    public void addExpense(ArrayList<Expense> list, int id) {
        Scanner sc = new Scanner(System.in);

        String date = getDateString();
        System.out.print("Enter Amount:");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter Content:");
        String content = sc.nextLine();
        list.add(new Expense(id, date, amount, content));
    }

    public int checkIdExist(ArrayList<Expense> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void displayExpense(ArrayList<Expense> list) {
        if (list.size() == 0) {
            System.err.println("List Expenses empty");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%s\n", "ID", "Date", "Amount of money", "Content");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n", list.get(i).getId(), list.get(i).getDate(),
                    list.get(i).getAmount(), list.get(i).getContent());
            total += list.get(i).getAmount();
        }
        System.out.printf("%15s:%10.0f\n", "Total", total);
    }

    public void deleteExpense(ArrayList<Expense> list) {
        System.out.print("Enter id: ");
        int id = checkInputInt();
        int checkIdExist = checkIdExist(list, id);
        if (checkIdExist != -1) {
            list.remove(checkIdExist);
            System.out.println("Delete an expense successful");
            for (int i = id - 1; i < list.size(); i++) {
                list.get(i).setId(list.get(i).getId() - 1);
            }
        } else {

            System.err.println("Delete an expense fail");
        }
    }

    public void display() {
        ArrayList<Expense> le = new ArrayList<>();

        int id = 0;
        while (true) {
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            int choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    addExpense(le, ++id);
                    break;
                case 2:
                    displayExpense(le);
                    break;
                case 3:
                    deleteExpense(le);
                    id--;
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        ManageExpense a = new ManageExpense();
        a.display();
    }
}
