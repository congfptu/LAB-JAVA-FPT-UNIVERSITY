/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handy.expense;

/**
 *
 * @author asus
 */
public class Expense {
      private int id;
      private String date;
      private double Amount;
      private String content;

    public Expense() {
    }

    public Expense(int id, String date, double Amount, String content) {
        this.id = id;
        this.date = date;
        this.Amount = Amount;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
      
}
