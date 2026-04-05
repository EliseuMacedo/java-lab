package section13.abstractmethod.entities;

import section13.abstractmethod.enums.Color;

public class Rectangle extends Shape {
    private Double width;
    private Double height;

    public Rectangle(){}

    public Rectangle(Color color, Double height, Double width) {
        super(color);
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public Double area() {
        return width * height;
    }

}
