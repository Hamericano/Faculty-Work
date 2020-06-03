package com.ace.circleplugin;

import com.ace.pluginner.interfaces.IShape;

import java.awt.*;
import java.util.Scanner;


public class Circle implements IShape{
    private Scanner scanner = new Scanner(System.in);
    private int r;
    private Point point;
    private String name;

    public Circle(){}
    public Circle(Point p, int radius) {
        this.point = p;
        this.r = r;
        this.name = "Circle";
    }

    @Override
    public void printShapeDetails() {
        System.out.print(this.name);
        System.out.println();
        getCoordinates();
        double area = Math.pow((3.14 * r),2);
        System.out.println("\nRadius: " + this.getR() + " Area: " + area + " Perimeter: " + (2 * 3.14 * r));
        System.out.println();

    }

    @Override
    public void read() {
        this.name = "Circle";
        System.out.println("Enter point coordinates:");
        this.point = new Point(scanner.nextInt(), scanner.nextInt());
        System.out.println("Enter radius:");
        this.r = scanner.nextInt();
    }

    public int getR() {
        return r;
    }

    @Override
    public void getCoordinates() {
        System.out.print("Center point: " + "P( " + (int)this.point.getX() + " , " + (int)this.point.getX() + " )");
    }

    @Override
    public void print() {
        System.out.println("Circle Drawn.");
    }

}
