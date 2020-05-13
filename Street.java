/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import java.util.Arrays;
import java.util.List;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

/**
 *
 * @author localadmin
 */
public class Street implements Drawable{
    private Coordinate start;
    private Coordinate stop;
    private String name;
    private double id;
    private boolean bool;
    public Street(String name, Coordinate start, Coordinate stop, double id){
        this.name = name;
        this.start = start;
        this.stop = stop;
        this.id = id;
    }

    
    @Override
    public List<Shape> getGui(){
        return Arrays.asList(
                new Text(start.getX() + (Math.abs(start.getX() - stop.getX()) /2), start.getY() + (Math.abs(start.getY() - stop.getY()) /2), name), 
                new Line(start.getX(), start.getY(), stop.getX(), stop.getY())
        ); 
    } 
    
    @Override
    public double getID(){
        return this.id;
    } 
    
    @Override
    public boolean getBool(){
        return true;
    } 
}
