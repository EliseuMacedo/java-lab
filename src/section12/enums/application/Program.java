package section12.enums.application;

import section12.enums.entities.enums.OrderStatus;
import section12.enums.entities.Order;

import java.util.Date;

// Sample Enum
public class Program {
    public static void main(String[] args){
        Order order = new Order(1270,new Date(), OrderStatus.PENDING_PAYMENT);

        System.out.println();
        System.out.println(order);

        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("SHIPPED");

        System.out.println();
        System.out.println(os1);
        System.out.println(os2);
    }
}
