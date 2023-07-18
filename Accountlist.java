package Accounts;

import java.io.Serializable;
import java.util.*;

public class Accountlist implements Serializable{
    Vector<Account> acclist;

    public Accountlist(){
        acclist = new Vector<>();
    }

    public int search(String item){
        for(int i=0;i<acclist.size();i++){
            if(acclist.get(i).Account_no.equals(item)){
                return i;
            }
        }
        return -1;
    }

    public String addAccount(String name, int login_pin){
        Account temp = new Account(name, login_pin);
        acclist.addElement(temp);
        return temp.Account_no;
    }
    public boolean validate(String account_no, int pin){
        int index = search(account_no);
         if(index == -1){
            return false;
        }
        else{
            if(acclist.get(index).getpin() == pin){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public void removeAccount(){
        Scanner sc = new Scanner(System.in);
        String acc_no;
        System.out.print("Enter your account number to be removed :");
        acc_no = sc.nextLine();
        int index = search(acc_no);
        if(index == -1){
            System.out.println("Invalid account number");
            return;
        }
        else{
            acclist.remove(index);
        }
    }

    public String getName(String acc_no){
        int index = search(acc_no);
        if(index == -1){
            return "Invalid account number";
        }
        else{
            return acclist.get(index).getName();
        }
    }
    public int getBalance(String acc_no){
        int index = search(acc_no);
        if(index == -1){
            return -1;
        }
        else{
            return acclist.get(index).getBal();
        }
    }

    public String viewAccount(String acc_no){
        int index = search(acc_no);
        if(index == -1){
            return "Invalid account number";
        }
        else{
            return acclist.get(index).viewAccount();
        }
    }
    public void UpdateAccount(String acc_no, int amount,int pin,Vector<Integer> transactions){
        int index = search(acc_no);
        if(index !=-1){
            acclist.get(index).updateBal(amount);
            acclist.get(index).updatepin(pin);
            acclist.get(index).updateTransactions(transactions);
        }
    }
    public Vector<Integer> getTransactions(String acc_no){
        int index = search(acc_no);
        Vector<Integer> transactions = new Vector<>();
        if(index != -1){
            transactions = acclist.get(index).getTransactions();
            return transactions;
        }
        else{
            return transactions;
        }
    }
}
