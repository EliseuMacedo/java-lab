package section13.abstractMethod.application;

import section13.abstractMethod.entities.Circle;
import section13.abstractMethod.entities.Rectangle;
import section13.abstractMethod.entities.Shape;
import section13.abstractMethod.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/*
    Fazer um programa para ler os dados de N figuras (N fornecido
    pelo usuário), e depois mostrar as áreas destas figuras na
    mesma ordem em que foram digitadas.
*/
/*
    Enter the number of shapes: 2
    Shape #1 data:
    Rectangle or Circle (r/c)? r
    Color (BLACK/BLUE/RED): BLACK
    Width: 4.0
    Height: 5.0
    Shape #2 data:
    Rectangle or Circle (r/c)? c
    Color (BLACK/BLUE/RED): RED
    Radius: 3.0
    SHAPE AREAS:
    20.00
    28.27
*/

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        List<Shape> shapes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.println("Shape #" + i + " data: ");
            System.out.print("Rectangle or Circle (r/c)? ");
            char c = sc.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next());

            if (c == 'r') {
                System.out.print("Width: ");
                Double width = sc.nextDouble();
                System.out.print("Height: ");
                Double height = sc.nextDouble();
                shapes.add(new Rectangle(color, height, width));
            } else {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                shapes.add(new Circle(color, radius));
            }
        }

        System.out.println();
        System.out.println("SHAPE AREAS:");

        for (Shape shape : shapes) {
            System.out.printf("%.2f%n", shape.area());
        }

        sc.close();
    }
}
