package section13.polymorphism.entities;

public class Employee {
    private String name;
    private Integer hours;
    private Double valuePerHour;

    public Employee() {
    }

    public Employee(Integer hours, String name, Double valuePerHour) {
        this.hours = hours;
        this.name = name;
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Double payment() {
        return valuePerHour * hours;
    }

    @Override
    public String toString() {
        return  name + " - $ " + String.format("%.2f",payment());
    }
}
