package section13.polymorphism3.application;

import section13.polymorphism3.entities.Company;
import section13.polymorphism3.entities.Individual;
import section13.polymorphism3.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        List<TaxPayer> taxPayers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            //.next() só aceita uma palavra sem espaço, com espaço é o sc.nextLine()
            char c = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();

            if (c == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                taxPayers.add(new Individual(anualIncome, name, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                taxPayers.add(new Company(anualIncome, name, numberOfEmployees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");

        double totalTaxes = 0.0;

        for (TaxPayer taxPayer : taxPayers) {
            totalTaxes += taxPayer.tax();
            System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", taxPayer.tax()));
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", totalTaxes));
        sc.close();
    }
}
