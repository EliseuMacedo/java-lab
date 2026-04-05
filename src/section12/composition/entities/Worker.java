package section12.composition.entities;

import section12.composition.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    // The list of attributes should not be included in the constructor.
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        setDepartment(department);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public Double income(Integer year, Integer month) {

        Double income = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract contract : contracts) {
            cal.setTime(contract.getDate());
            int contractYear = cal.get(Calendar.YEAR);
            int contractMonth = 1 + cal.get(Calendar.MONTH);

            if (contractYear == year && contractMonth == month) {
                income += contract.totalValue();
            }

        }
        return income;
    }

    @Override
    public String toString() {
        return
                "Name: " + name +
                        "\nDepartment: " + department.getName();


    }

//    @Override
//    public String toString() {
//         String toString =
//                "\n\nName: '" + name + '\'' +
//                "\nLevel: " + level +
//                "\nBaseSalary: " + baseSalary +
//                "\nDepartment: " + department.getName() + "\n";
//                for(HourContract HourContract:hourContracts){
//                    toString  = toString.concat(HourContract.toString());
//                }
//
//        return toString;
//    }
}
