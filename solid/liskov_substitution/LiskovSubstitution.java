package SystemDesignRoadmap.solid.liskov_substitution;

// Base class for shapes
class Rectangle {
    protected double width;
    protected double height;

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    public double area() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double w) {
        width = w;
    }

    public void setHeight(double h) {
        height = h;
    }
}

// Derived class for squares.
// This VIOLATES Liskov Substitution: a square is forced to keep width == height,
// so calling setWidth changes height too and the base class contract is broken.
class Square extends Rectangle {
    public Square(double size) {
        super(size, size);
    }

    @Override
    public void setWidth(double w) {
        width = height = w;
    }

    @Override
    public void setHeight(double h) {
        width = height = h;
    }
}

public class LiskovSubstitution {
    public static void main(String[] args) {
        Square s = new Square(5);
        s.setWidth(10);
        System.out.println("Area: " + s.area());

        Rectangle shape = s;
        shape.setHeight(3);
        System.out.println("Area after setHeight(3): " + shape.area());
    }
}
