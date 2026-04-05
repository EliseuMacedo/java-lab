package section13.abstractclass.entities;

public class BusinessAccount extends Account {

    private Double loanLimit;

    public BusinessAccount() {
        super();
    }


    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    //Descontar uma taxa de 2.0 após o calculo do saque da superclasse
    @Override
    public void withdraw(Double amount) {
        //default access method in the generic class
        super.withdraw(amount);
        balance -=2.0;

    }

    // Protected: Descontar uma taxa de 10.0 por emprestimo
    public void loan(Double amount) {
        if (amount <= loanLimit) {
            balance += amount - 10.0;
        }
    }

    @Override
    public String toString() {
        return "BusinessAccount{" +
                "loanLimit=" + loanLimit +
                "} " + super.toString();
    }
}
