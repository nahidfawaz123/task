package com.example.demo.Model;

public class Users {

   private String Id;
   private String Name ;
   private String Email;
   private String Password;
   private String UserName;
   private int LoanAmount;
   private int Balance;



    public Users(String id, String name, String password, String email, String userName1, int loanAmount, int balance) {
        Id = id;
        Name = name;
        Password = password;
        Email = email;
        UserName = userName1;
        LoanAmount = loanAmount;
        Balance = balance;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getLoanAmount() {
        return LoanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        LoanAmount = loanAmount;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }
}
