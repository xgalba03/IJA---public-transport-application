/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import java.util.List;
import javafx.scene.shape.Shape;

/**
 *
 * @author localadmin
 */
public interface Drawable {
    List<Shape> getGui();
    double getID();
    boolean getBool();
}
