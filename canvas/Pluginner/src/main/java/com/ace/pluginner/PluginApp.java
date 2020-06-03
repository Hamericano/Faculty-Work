/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.pluginner;

import com.ace.canvas.Canvas;
import com.ace.menu.*;
import com.ace.pluginner.interfaces.IShape;

/**
 *
 * @author catalin
 */
public class PluginApp {
    
    public static void main(String[] args)
    {
        PluginManager pluginMan = new PluginManager();
        Canvas canvas = new Canvas();
        ApplicationMenu menu = new ApplicationMenu(pluginMan, canvas);
        menu.load();
        menu.execute();        
    }
    
}
