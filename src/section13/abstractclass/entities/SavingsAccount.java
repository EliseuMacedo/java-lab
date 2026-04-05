package section13.abstractclass.entities;

// final prevents the class from being inherited.
public final class SavingsAccount extends Account {
    private Double interestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }


    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    // Test super class overide method
    @Override
    //  final  prevents the method from being overwritten.
    public final void withdraw(Double ammount) {
        balance -= ammount;
    }


    public void updateBalance() {
        balance += balance * interestRate;
    }
}
