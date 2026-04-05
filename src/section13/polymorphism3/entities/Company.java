package section13.polymorphism3.entities;

public class Company extends TaxPayer {
    private Integer numberOfEmployees;

    public Company() {
    }

    public Company(Double anualIncome, String name, Integer numberOfEmployees) {
        super(anualIncome, name);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public final Double tax() {
        Double anualIncome = super.getAnualIncome();
        return numberOfEmployees > 10 ? anualIncome * 0.14 : anualIncome * 0.16;
    }
}
