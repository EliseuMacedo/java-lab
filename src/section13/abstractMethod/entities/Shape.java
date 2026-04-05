package section13.abstractMethod.entities;

import section13.abstractMethod.enums.Color;

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
