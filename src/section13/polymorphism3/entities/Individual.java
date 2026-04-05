package section13.polymorphism3.entities;

public class Individual extends TaxPayer {
    private Double healthExpenditures;

    public Individual() {
    }

    public Individual(Double anualIncome, String name, Double healthExpenditures) {
        super(anualIncome, name);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public final Double tax() {
        Double anualIncome = super.getAnualIncome();
        double tax = 0.0;
        if (anualIncome < 20_000) {
            tax = anualIncome * 0.15;
        } else {
            tax = anualIncome * 0.25;
        }
        if (healthExpenditures > 0.0) {
            tax -= healthExpenditures * 0.5;
        }
        return tax;
    }
}
