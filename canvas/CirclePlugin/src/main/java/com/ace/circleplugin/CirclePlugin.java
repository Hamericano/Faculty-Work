
package com.ace.circleplugin;
import com.ace.pluginner.interfaces.IPluginsAppPlugin;
import com.ace.pluginner.interfaces.IShape;
/**
 *
 * @author catalin
 */
public class CirclePlugin implements IPluginsAppPlugin {

    @Override
    public String getUniqueNameText() {
        return "CirclePlugin";
    }

    @Override
    public String getDisplayText() {
        return "Circle";
    }

    @Override
    public IShape getShape() {
        return new Circle();
    }
    
}
