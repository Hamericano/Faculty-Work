package shapes;

import java.awt.*;

public class Rectangle implements Shape, DrawingStrategy {
    private Point upperLeft;
    private Point lowerRight;

    public Rectangle(){}

    public Rectangle(Point p1, Point p2) {
        this.upperLeft = new Point(Math.min(p1.x, p2.x), Math.max(p1.y, p2.y));
        this.lowerRight = new Point(Math.max(p1.x, p2.x), Math.min(p1.y, p2.y));
    }

    @Override
    public void printShapeDetails() {
        System.out.print("LENGTH(" + Math.abs((int)(upperLeft.getX() - lowerRight.getX())) + ")" + ", " + " WIDTH(" + Math.abs((int)(upperLeft.getY() - lowerRight.getY())) + ")\n");
    }

    @Override
    public double getArea() {
        return (upperLeft.getY() - lowerRight.getY()) * (upperLeft.getX() - lowerRight.getX());
    }

    @Override
    public double getPerimeter() {
        return 2 * (upperLeft.getY() - lowerRight.getY()) + 2 * (upperLeft.getX() - lowerRight.getX());
    }

    @Override
    public boolean isCircle() {
        return false;
    }

    @Override
    public boolean isRectangle() {
        return true;
    }

    @Override
    public void draw(){
        System.out.println("Rectangle Drawn.");
    }
}
