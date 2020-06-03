package shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MyFirstApp {
    public static void main(String[] args) {
        System.out.println(" === Sketch Work === ");
        Menu mainMenu = initializeMainMenu();
        mainMenu.execute();

    }

    private static Menu initializeMainMenu() {
        Scanner scanner = new Scanner(System.in);
        Sketch mySketch = new Sketch();
        List<IMenuItem> mainMenuItems = new ArrayList();
        List<IMenuItem> addShapeMenu = new ArrayList();

        addShapeMenu.add(new MenuItem("Add Circle",
                1,
                (parameters) -> {
                    System.out.println("Enter the X, Y and the RADIUS of the center of the circle: ");
                    Shape circle = new Circle(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble());
                    mySketch.getShapes().add(circle);
                    mySketch.setStrategy(new Circle());
                    mySketch.drawGeometricShape();
                    System.out.println();
                }));

        addShapeMenu.add(new MenuItem("Add Rectangle",
                2,
                (parameters) -> {
                    System.out.println("Enter the X and Y of the upper point: ");
                    Point upperPoint = new Point(scanner.nextInt(), scanner.nextInt());
                    System.out.println("Enter the X and Y of the lower point: ");
                    Point lowerPoint = new Point(scanner.nextInt(), scanner.nextInt());

                    Shape rectangle = new Rectangle(upperPoint, lowerPoint);

                    mySketch.getShapes().add(rectangle);
                    mySketch.setStrategy(new Rectangle());
                    mySketch.drawGeometricShape();
                    System.out.println();
                }));

        mainMenuItems.add(new Menu("Add Shape", 1, addShapeMenu));
        mainMenuItems.add(new MenuItem("Remove Shape",
                2,
                (parameters) -> {
                    System.out.print("What shape do you wish to REMOVE?\n");
                    mySketch.printShapes();
                    int pick = scanner.nextInt();
                    mySketch.getShapes().remove((pick - 1));
                    System.out.println();
                }));

        mainMenuItems.add(new MenuItem("Modify Shape",
                3,
                (parameters) -> {
                    System.out.print("What shape do you wish to MODIFY?\n");
                    mySketch.printShapes();
                    int pick = scanner.nextInt();
                    mySketch.modify((pick - 1));
                    System.out.println();
                }));

        mainMenuItems.add(new MenuItem("Print All Shapes",
                4,
                (parameters) -> {
                    System.out.print("Printing . . . \n");
                    mySketch.printShapes();
                    System.out.println();
                }));

        return new Menu("Main Menu", 0, mainMenuItems);
    }
}

