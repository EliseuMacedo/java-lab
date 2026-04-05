package section13.Inheritance.application;


import section13.Inheritance.entities.Account;
import section13.Inheritance.entities.BusinessAccount;
import section13.Inheritance.entities.SavingsAccount;

public class Program {

    public static void main(String[] args) {

        Account acc = new Account(1001, "Alex", 1000.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // UPCASTING (sub classe para super classe)
        // Não dá erro por que a herança é uma relação é um
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        // DOWNCASTING (precisa vir de uma instancia que tenha todos os parametros, nesse caso BusinessAccount)
        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);

        //DOWNCASTING nem sempre vai dar certo, as vezes é preciso testar
        /*O compilador não conhece os métodos/funções de classes específicas
        * por isso não ocorre o erro, esses métodos/funções só são conhecidos no momento da execução (runtime)
        */

        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }
        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }

        acc.withdraw(200.0);
        System.out.println(acc.getBalance());

        // Test super class overide method
        SavingsAccount acc6 = new SavingsAccount(1005, "Grey", 1000.0, 0.01);
        acc6.withdraw(200.0);
        System.out.println(acc6.getBalance());

        //default access method in the generic class
        BusinessAccount acc7 = new BusinessAccount(1006, "Hardman", 1000.0, 2000.0);
        acc7.withdraw(200.0);
        System.out.println(acc7.getBalance());

        //  polymorphism
        /*  Permite que variáveis de mesmo tipo, mais genérico (Account) possam apontar para objetos de tipos
             específicos diferentes (Account, SavingsAccount) tendo comportamentos diferentes conforme o tipo específico.
         */
        Account x = new Account(1020,"Alex", 1000.0);
        Account y = new SavingsAccount(1023,"Maria", 1000.0,0.01);
        x.withdraw(50.0);
        y.withdraw(50.0);

        System.out.println("\npolymorphism");
        System.out.println(x.getBalance());
        System.out.println(y.getBalance());
    }
}
