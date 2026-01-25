package OOPs.encapsulation;

public class BankAccount {
    private String accountholder;
    private double balance;

    BankAccount(String accountholder, double initialbalance) {
        this.accountholder = accountholder;
        this.balance = initialbalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountholder() {
        return accountholder;
    }

    public void setAccountholder(String accountholder) {
        this.accountholder = accountholder;
    }
}
