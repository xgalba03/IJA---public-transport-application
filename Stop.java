/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Arrays;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

/**
 *
 * @author Damian
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Stop implements Drawable{
    
    protected String name;
    protected Coordinate c;
    protected String stav;
    private double id;
    private boolean bool;
    @JsonIgnore
    private List<Shape> gui;
    
    private Stop(){}
    
    public Stop(String name,Coordinate c){
        this.name = name;
        this.c = c;
    }
    
    @Override
    public List<Shape> getGui(){
        return Arrays.asList(
                new Circle(c.getX(), c.getY(), 8, Color.GREY),
                new Text(c.getX(),c.getY(), name)
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
    
    public String getName(){
        return this.name;
    } 
    
    public Coordinate getCoordinate(){
        return this.c;
    }
    
    public String getStav(){
        return this.stav;
    } 
}
