package com.ace.triangleplugin;

import com.ace.pluginner.interfaces.*;
import java.util.Scanner;
import java.awt.*;

public class Triangle implements IShape{
    private Scanner scanner = new Scanner(System.in);
    private Point upperLeft;
    private Point lowerRight;
    private String name;

    public Triangle(){}

    public Triangle(Point p1, Point p2) {
        this.name = "Triangle";
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
        System.out.println("Triangle Drawn.");
    }

    @Override
    public void printShapeDetails() {
        int l = (int)(upperLeft.getY() - lowerRight.getY());
        System.out.print(this.name);
        System.out.println();
        getCoordinates();
        System.out.println("\nPerimeter: " + 3 * l + " Area: " + (3 * l)/2);
        System.out.println();
    }

    @Override
    public void read() {
        this.name = "Triangle";
        System.out.println("Enter P1, P2 coordinates:");
        this.upperLeft = new Point(scanner.nextInt(), scanner.nextInt());
        this.lowerRight = new Point(scanner.nextInt(), scanner.nextInt());
    }
}

