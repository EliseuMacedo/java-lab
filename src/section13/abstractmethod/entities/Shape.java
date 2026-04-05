package section13.abstractmethod.entities;

import section13.abstractmethod.enums.Color;

public abstract class Shape {
    private Color color;

    public Shape(){
    }

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    // Sample abstract method
    public abstract Double area();
}
