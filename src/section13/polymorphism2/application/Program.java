package section13.polymorphism2.application;

import section13.polymorphism2.entities.ImportedProduct;
import section13.polymorphism2.entities.Product;
import section13.polymorphism2.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
    Fazer um programa para ler os dados de N
    produtos (N fornecido pelo usuário). Ao final,
    mostrar a etiqueta de preço de cada produto na
    mesma ordem em que foram digitados.
    Todo produto possui nome e preço. Produtos
    importados possuem uma taxa de alfândega, e
    produtos usados possuem data de fabricação.
    Estes dados específicos devem ser
    acrescentados na etiqueta de preço conforme
    exemplo (próxima página). Para produtos
    importados, a taxa e alfândega deve ser
    acrescentada ao preço final do produto
*/

/*
    Enter the number of products: 3
    Product #1 data:
    Common, used or imported (c/u/i)? i
    Name: Tablet
    Price: 260.00
    Customs fee: 20.00
    Product #2 data:
    Common, used or imported (c/u/i)? c
    Name: Notebook
    Price: 1100.00
    Product #3 data:
    Common, used or imported (c/u/i)? u
    Name: Iphone
    Price: 400.00
    Manufacture date (DD/MM/YYYY): 15/03/2017
    PRICE TAGS:
    Tablet $ 280.00 (Customs fee: $ 20.00)
    Notebook $ 1100.00
    Iphone (used) $ 400.00 (Manufacture date: 15/03/2017)
*/

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> products = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char c = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (c == 'i') {
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                //Up casting and polymorphism
                products.add(new ImportedProduct(name,price,customsFee));
            }
            else if(c == 'c'){
                products.add(new Product(name,price));
            }
            else{
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                sc.nextLine();
                Date manufactureDate =sdf.parse(sc.nextLine());
                //Up casting and polymorphism
                products.add(new UsedProduct(name,price,manufactureDate));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");

        for (Product product:products){
            System.out.println(product.priceTag());
        }
        sc.close();
    }
}
