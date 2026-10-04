#include <iostream>

// Base class for shapes
class Rectangle {
protected:
    double width;
    double height;

public:
    Rectangle(double w, double h) : width(w), height(h) {}

    virtual ~Rectangle() = default;

    double area() const {
        return width * height;
    }

    double getWidth() const {
        return width;
    }

    double getHeight() const {
        return height;
    }

    virtual void setWidth(double w) {
        width = w;
    }

    virtual void setHeight(double h) {
        height = h;
    }
};

// Derived class for squares.
// This VIOLATES Liskov Substitution: a square is forced to keep width == height,
// so calling setWidth changes height too and the base class contract is broken.
class Square : public Rectangle {
public:
    explicit Square(double size) : Rectangle(size, size) {}

    void setWidth(double w) override {
        width = height = w;
    }

    void setHeight(double h) override {
        width = height = h;
    }
};

int main() {
    Square s(5);
    s.setWidth(10);
    std::cout << "Area: " << s.area() << std::endl;

    Rectangle* shape = &s;
    shape->setHeight(3);
    std::cout << "Area after setHeight(3): " << shape->area() << std::endl;

    return 0;
}