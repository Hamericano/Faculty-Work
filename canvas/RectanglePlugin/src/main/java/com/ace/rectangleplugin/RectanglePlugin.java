/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.rectangleplugin;
import com.ace.pluginner.interfaces.IPluginsAppPlugin;
import com.ace.pluginner.interfaces.IShape;
/**
 *
 * @author catalin
 */
public class RectanglePlugin implements IPluginsAppPlugin {

    @Override
    public String getUniqueNameText() {
        return "RectanglePlugin";
    }

    @Override
    public String getDisplayText() {
        return "Rectangle";
    }

    @Override
    public IShape getShape() {
        return new Rectangle();
    }
    
}
