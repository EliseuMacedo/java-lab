package section9.entities;

public class Account {

    private int accountNumber;
    private String holder;
    private double balance;

    public Account() {
    }

    public Account(int accountNumber, String holder, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        depositValue(initialDeposit);
    }

    public Account(int accountNumber, String holder) {
        this.accountNumber = accountNumber;
        this.holder = holder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void depositValue(double depositValue) {
        this.balance += depositValue;
    }

    public void withdrawValue(double withdrawValue) {
        final double WITHDRAW_FEE = 5.0;
        this.balance -= withdrawValue + WITHDRAW_FEE;
    }
    public void handleObj(Account account){

    }

    public void handleObj1(){
        handleObj(this);
    }

    @Override
    public String toString() {
        return "Account " +
                accountNumber +
                ", Holder: "
                + holder +
                ", Balance: $ "
                + String.format("%.2f",balance);
    }
}
