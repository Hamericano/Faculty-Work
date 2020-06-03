package com.ace.canvas;

/**
 *
 * @author MIHAI
 */

import com.ace.pluginner.interfaces.IShape;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.Point;

public class Canvas {
    private IShape shape;
    private ArrayList<IShape> shapes = new ArrayList<>();

    public List<IShape> getShapeList() {
        return shapes;
    }
    
    public void setShape(IShape shape){
        this.shape = shape;
    }

    public void add(){
        shape.read();
        shapes.add(shape);
        shape.print();
        shape.printShapeDetails();
    }

    public void printShapes() {
        for (int i = 0; i < shapes.size(); i++) {
            System.out.print((i + 1) + ". ");
            shapes.get(i).printShapeDetails();
        }
    }

    public void editShape(int position) {
        position = position - 1;
        if(shapes.get(position) != null){
            shapes.get(position).read();
        }
    }
    
    public void deleteShape(int pos) {
        pos = pos - 1;
        for (int i = 0; i < shapes.size(); i++) {
            if (pos == i) {
                shapes.remove(i);
            }
        }
    }

}
