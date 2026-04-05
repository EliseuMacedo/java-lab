package section13.abstractclass.application;


import section13.abstractclass.entities.Account;
import section13.abstractclass.entities.BusinessAccount;
import section13.abstractclass.entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        //sample abstract class account
        List<Account> accounts = new ArrayList<>();
        Account acc1 = new SavingsAccount(1001,"Alex", 1000.00,0.01);
        accounts.add(acc1);
        Account acc2 = new BusinessAccount(1002,"Bob", 600.00, 2000.00);
        accounts.add(acc2);

        System.out.println();
        // Sample static method
        System.out.println(Account.myStaticMethod());
        System.out.println();
        // print balance for all accounts
        for(Account account:accounts) {
            System.out.println(account.getBalance());
        }
    }
}
