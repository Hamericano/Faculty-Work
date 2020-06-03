package shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sketch {
    private List<Shape> shapes = new ArrayList<>();
    private DrawingStrategy strategy;

    private Scanner scanner = new Scanner(System.in);

    public void drawGeometricShape() {
        strategy.draw();
    }

    public void setStrategy(DrawingStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void printShapes() {
        for (int i = 0; i < getShapes().size(); i++) {
            Shape shape = getShapes().get(i);
            System.out.print((i + 1) + ".");
            shape.printShapeDetails();
        }
    }

    public void modify(int number){
        for (int i = 0; i < getShapes().size(); i++) {
            Shape shape = getShapes().get(i);
            if(number == i){
                if(shape.isCircle()){
                    getShapes().remove(number);
                    System.out.print("New X: ");
                    int x = scanner.nextInt();
                    System.out.print("New Y: ");
                    int y = scanner.nextInt();
                    System.out.print("New R: ");
                    int r = scanner.nextInt();
                    Circle circle = new Circle(x, y, r);
                    getShapes().add(circle);
                    break;
                }
                else if(shape.isRectangle()){
                    getShapes().remove(number);
                    System.out.print("New X and Y of the upper point: ");
                    int x1 = scanner.nextInt();
                    int y1 = scanner.nextInt();
                    Point upperPoint = new Point(x1, y1);
                    System.out.print("New X and Y of the lower point: ");
                    int x2 = scanner.nextInt();
                    int y2 = scanner.nextInt();
                    Point lowerPoint = new Point(x2, y2);
                    Rectangle rectangle = new Rectangle(upperPoint, lowerPoint);
                    getShapes().add(rectangle);
                    break;
                }
            }
        }
    }
}
