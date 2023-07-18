package Accounts;

import java.util.Vector;

public class Account{
    String Account_holder_name;
    String Account_no;
    int Balance;
    int login_pin;
    Vector<Integer> transactions;
    static int Account_no_creator = 1024;

    public Account(String name, int login_pin){
        this.Account_holder_name = name;
        Account_no = String.valueOf(Account_no_creator);
        Account_no_creator++;
        this.Balance = 0;
        this.login_pin = login_pin;
        this.transactions = new Vector<>();
    }

    String getName(){
        return Account_holder_name;
    }
    String getAccno(){
        return Account_no;
    }
    String viewAccount(){
        return "NAME :" + Account_holder_name+"\nACCOUNT NO. : " + Account_no +"\nBALANCE : " + Balance;
    }
    int getBal(){
        return Balance;
    }
    void updateBal(int amount){
        this.Balance = amount;
    }
    int getpin(){
        return login_pin;
    }
    void updatepin(int pin){
        this.login_pin = pin; 
    }
    void addTransaction(int Amount){
        transactions.add(Amount);
    }
    Vector<Integer> getTransactions(){
        return transactions;
    }
    void updateTransactions(Vector<Integer> transactions){
        this.transactions = transactions;
    }
}