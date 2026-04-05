package section10.vector.application;

import section10.vector.entities.Product;

import java.util.Locale;
import java.util.Scanner;

/*
    Fazer um programa para ler um número inteiro N e os dados (nome e
    preço) de N Produtos. Armazene os N produtos em um vetor. Em
    seguida, mostrar o preço médio dos produtos.
*/

public class VectorSample2 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Product[] vectProduct = new Product[n];

        for (int i = 0; i < vectProduct.length; i++) {
            String name = sc.next();
            double price = sc.nextDouble();
            Product product = new Product(name, price);
            vectProduct[i] = product;
        }

        double sum = 0.0;
        for (Product product : vectProduct) {
            sum += product.getPrice();
        }

        double avg = sum / vectProduct.length;
        System.out.printf("AVERAGE PRICE = %.2f%n", avg);

        sc.close();
    }
}
