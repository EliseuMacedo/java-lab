package section12.composition.application;

import netscape.javascript.JSObject;
import section12.composition.entities.Department;
import section12.composition.entities.HourContract;
import section12.composition.entities.Worker;
import section12.composition.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/*
   Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário)
   Depois, solicitar do usuário um mês e mostar qual foi o salario do funcionário nessse mês.

    Enter department's name: Design
    Enter worker data:
    Name: Alex
    Level: MID_LEVEL
    Base salary: 1200.00
    How many contracts to this worker? 3
    Enter contract #1 data:
    Date (DD/MM/YYYY): 20/08/2018
    Value per hour: 50.00
    Duration (hours): 20
    Enter contract #2 data:
    Date (DD/MM/YYYY): 13/06/2018
    Value per hour: 30.00
    Duration (hours): 18
    Enter contract #3 data:
    Date (DD/MM/YYYY): 25/08/2018
    Value per hour: 80.00
    Duration (hours): 10

    Enter month and year to calculate income (MM/YYYY): 08/2018
    Name: Alex
    Department: Design
    Income for 08/2018: 3000.00
*/

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");

        System.out.println();
        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        Department department = new Department(departmentName);

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();
        Worker worker = new Worker(name, level, baseSalary, department);


        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date date = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            Integer hours = sc.nextInt();

            HourContract hourContract = new HourContract(date, valuePerHour, hours);
            worker.addContract(hourContract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        Date incomeDate = sdf1.parse(sc.next());

        Double income = worker.income(incomeDate.getYear(), incomeDate.getMonth());
        System.out.println(worker);

        // Print option: 1
        System.out.printf("Income for %s: %.2f%n", sdf1.format(incomeDate), income);
        // Print option: 2
        System.out.println("Income for " + sdf1.format(incomeDate) +  ": " + String.format("%.2f", income));

        sc.close();
    }
}
