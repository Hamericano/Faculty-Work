package shapes;

import java.awt.*;

public class Circle implements Shape, DrawingStrategy {
    private static double pi = 3.14;
    private double r;
    private Point center;

    public Circle(){}

    public Circle(int x, int y, double r) {
        this.center = new Point(x, y);
        this.r = r;
    }

    public double getR() {
        return r;
    }

    @Override
    public void printShapeDetails() {
        System.out.print("COORDINATES(" + this.center.x + ", " + this.center.y + ") " + ", " + " RADIUS(" + (int)r + ")\n");
    }

    @Override
    public double getArea() {
        return Math.pow((pi * r), 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * pi * r;
    }

    @Override
    public boolean isCircle() {
        return true;
    }

    @Override
    public boolean isRectangle() {
        return false;
    }

    @Override
    public void draw() {
        System.out.println("Circle Drawn.");
    }
}
