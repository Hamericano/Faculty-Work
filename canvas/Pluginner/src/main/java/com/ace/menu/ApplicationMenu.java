package com.ace.menu;

import com.ace.canvas.Canvas;
import com.ace.pluginner.PluginManager;
import com.ace.pluginner.interfaces.IShape;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationMenu{
    private Canvas canvas;
    private Scanner scanner = new Scanner(System.in);
    private PluginManager pluginMan;
    private Menu mainMenu = null;
    private Menu subMenu = null;
    
    public ApplicationMenu(PluginManager pluginMan, Canvas canvas)
    {
        this.pluginMan = pluginMan;
        this.canvas = canvas;
    }

    public void load()
    {
        pluginMan.loadPlugins("/plugins");
        ArrayList<IMenuItem> menuItems = new ArrayList();

        int shortCut = 1;
        var plugins = pluginMan.getPlugins();

        for (int i = 0 ; i < plugins.size(); i++)
        {
           var currentPlugin = plugins.get(i); 
           MenuItem currentItem = new MenuItem(plugins.get(i).getDisplayText(), shortCut++, (parameters)->{
               IShape shape = currentPlugin.getShape();
               canvas.setShape(shape);
               canvas.add();
           });
           menuItems.add(currentItem);

        }
        subMenu=new Menu("Add shape",1,menuItems);
        
        mainMenu = new Menu("Main Menu", -1);
        
        mainMenu.addItem(1, "Add Shape",(parameters)->{
               subMenu.execute();
           });
        mainMenu.addItem(2, "Delete Shape", (parameters) ->{
            canvas.printShapes();
            canvas.deleteShape(scanner.nextInt());
        });
        mainMenu.addItem(3, "View Canvas", (parameters) ->{
            canvas.printShapes();
        });
        mainMenu.addItem(4, "Edit Shape", (parameters) ->{
            canvas.printShapes();
            canvas.editShape(scanner.nextInt());
        });
    }

    public void execute()
    {
        mainMenu.execute();
    }

}