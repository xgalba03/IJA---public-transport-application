/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 *
 * @author localadmin
 */
//@JsonDeserialize(converter=Vehicle.VehicleConstructorCall.class);
@JsonDeserialize(converter = Vehicle.VehicleConstructorCall.class)
public class Vehicle implements Drawable, TimeUpdate{
    private Coordinate position;
    private double speed = 0;
    private double distance = 0;
    private Path path;
    @JsonIgnore
    private List<Shape> gui;
    
    private Vehicle(){}
    
    public Vehicle(Coordinate position, double speed, Path path) {
        this.position = position;
        this.speed = speed;
        this.path = path;
        setGui();
      
    }

    public Path getPath() {
        return path;
    }
        
    
    
    private void moveGui(Coordinate coordinate){
        for(Shape shape: gui){
            System.out.println("moveGui");
            shape.setTranslateX((coordinate.getX() - position.getX()) + shape.getTranslateX());
            shape.setTranslateY((coordinate.getY() - position.getY()) + shape.getTranslateY());
        }
    }
    @JsonIgnore
    @Override
    public List<Shape> getGui(){
       
       return gui; 
    }

    
    @Override
    public Integer update(LocalTime time) {
        if(distance >= path.getPathSize()){
            distance = 0;
            this.position = position;
            return -1;  
        }
        distance += speed;
        System.out.println(distance);
        System.out.println(path.getPathSize());

        
        Coordinate coords = path.getCoordinateByDistance(distance);
        moveGui(coords);
        position = coords;
        return 0;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Coordinate getPosition(){
        return position;
    }
    
    public double getSpeed(){
        return speed;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "position=" + position + ", speed=" + speed + '}';
    }

    private void setGui() {
        gui = new ArrayList<>( );
        gui.add(new Circle(position.getX(), position.getY(), 8, Color.BLUE));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class VehicleConstructorCall extends StdConverter<Vehicle, Vehicle>{
        
        @Override
        public Vehicle convert(Vehicle value){
            value.setGui();
            System.out.println("hello\n");
            return value;
        }
    }
    

}
