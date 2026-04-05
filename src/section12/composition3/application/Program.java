package section12.composition3.application;

import section12.composition3.entities.Client;
import section12.composition3.entities.Order;
import section12.composition3.entities.OrderItem;
import section12.composition3.entities.Product;
import section12.composition3.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/*
    Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um
    sumário do pedido conforme exemplo (próxima página). Nota: o instante do pedido deve ser
    o instante do sistema: new Date()

    Enter cliente data:
    Name: Alex Green
    Email: alex@gmail.com
    Birth date (DD/MM/YYYY): 15/03/1985
    Enter order data:
    Status: PROCESSING
    How many items to this order? 2
    Enter #1 item data:
    Product name: TV
    Product price: 1000.00
    Quantity: 1
    Enter #2 item data:
    Product name: Mouse
    Product price: 40.00
    Quantity: 2

    ORDER SUMMARY:
    Order moment: 20/04/2018 11:25:09
    Order status: PROCESSING
    Client: Alex Green (15/03/1985) - alex@gmail.com
    Order items:
    TV, $1000.00, Quantity: 1, Subtotal: $1000.00
    Mouse, $40.00, Quantity: 2, Subtotal: $80.00
    Total price: $1080.00

* */

public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());
        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            Product product = new Product(productName, price);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem item = new OrderItem(quantity, price, product);
            order.addItem(item);
        }
        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order.toString());
        System.out.println("Order items:");

        for (OrderItem orderItem : order.getItems()) {
            System.out.println(orderItem.toString());
        }
        System.out.println("Total price: " + String.format("%.2f", order.total()));

        sc.close();
    }
}
