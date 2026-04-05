package section14.exception.samples;

import java.util.*;

public class _01_tryCatchSample {

    public static void main(String[] args) {

        List<String> listName = Arrays.asList("Bob", "Alex", "Green", "Maria");

        for (String name : listName) {
            System.out.println(name);
        }
        System.out.println();

//        Print array position
        System.out.println("Position 0: " + listName.get(0));
        System.out.println("Position 1: " + listName.get(1));
        System.out.println("Position 2: " + listName.get(2));
        System.out.println("Position 3: " + listName.get(3));

        System.out.println();
        System.out.println("Displaying a non-existent position");


        try {
            System.out.println("Position 4: " + listName.get(4));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Position not found!");
        }


        System.out.println();
        System.out.println("Another sample exception.");

        Scanner sc = new Scanner(System.in);
        System.out.println("Number: ");

        try {
            int n = sc.nextInt();

            System.out.print("Entered number: " + n);
        }catch (InputMismatchException e) {
            System.out.println("Invalid value! " + e.getCause());
        }

        sc.close();
        System.out.println();
        System.out.println("End program!");
    }
}
