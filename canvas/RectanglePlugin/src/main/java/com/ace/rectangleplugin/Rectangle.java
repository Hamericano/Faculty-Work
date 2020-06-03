package com.ace.rectangleplugin;
import com.ace.pluginner.interfaces.IShape;
import java.awt.Point;
import java.util.Scanner;

public class Rectangle implements IShape{
    private Scanner scanner = new Scanner(System.in);
    private Point upperLeft;
    private Point lowerRight;
    private String name;

    public Rectangle(){}

    public Rectangle(Point p1, Point p2) {
        this.name = "Rectangle";
        this.upperLeft = new Point(Math.min(p1.x, p2.x), Math.max(p1.y, p2.y));
        this.lowerRight = new Point(Math.max(p1.x, p2.x), Math.min(p1.y, p2.y));
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public Point getLowerRight() {
        return lowerRight;
    }

    @Override
    public void getCoordinates() {
        System.out.print("Coordinates: P1(" + (int)this.upperLeft.getX() + " , " + (int)this.upperLeft.getY() + "), P2(" + (int)this.lowerRight.getX() + " , " + (int)this.lowerRight.getY() + ")");
    }

    @Override
    public void print() {
        System.out.println("Rectangle Drawn.");
    }

    @Override
    public void printShapeDetails() {
        System.out.print(this.name);
        System.out.println();
        getCoordinates();
        System.out.println("\nArea: " + (upperLeft.getY() - lowerRight.getY()) * (upperLeft.getX() - lowerRight.getX()) + 
                " Perimeter: " + (2 * (upperLeft.getY() - lowerRight.getY()) + 2 * (upperLeft.getX() - lowerRight.getX())) );
        System.out.println();
    }

    @Override
    public void read() {
        this.name = "Rectangle";
        System.out.println("Enter P1, P2 coordinates:");
        this.upperLeft = new Point(scanner.nextInt(), scanner.nextInt());
        this.lowerRight = new Point(scanner.nextInt(), scanner.nextInt());
    }
}