/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.paint.Color;
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
    @JsonIgnore
    private List<Shape> gui;
    public Street(String name, Coordinate start, Coordinate stop, double id){
        this.name = name;
        this.start = start;
        this.stop = stop;
        this.id = id;
        setGui();
    }

    
    @Override
    public List<Shape> getGui(){
        return gui; 
    } 
    
    
    private void setGui() {
        gui = new ArrayList<>( );
        Line ulica = new Line(start.getX(), start.getY(), stop.getX(), stop.getY());
        Text meno = new Text((Math.abs(start.getX() + stop.getX()) /2),  (Math.abs(start.getY() + stop.getY()) /2), name);
        if(this.id == 99.0){
            ulica.setStroke(Color.YELLOW);
            ulica.setStrokeWidth(2);
        }
        gui.add(meno);
        gui.add(ulica);

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
