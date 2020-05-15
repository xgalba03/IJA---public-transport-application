/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.StdConverter;
import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.round;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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
    private double id = 0;
    private boolean done = false;  
    private Path path;
    @JsonIgnore
    private List<Shape> gui;
    
    
    
    private Vehicle(){}
    
    public Vehicle(Coordinate position, double speed, Path path, double ID) {
        this.id = ID;
        this.position = position;
        this.speed = speed;
        this.path = path;
        this.done = false;
        setGui();
      
    }

    public Path getPath() {
        return path;
    }
    
    @Override
    public double getID(){
        return this.id;
    }
    
    @Override
    public boolean getBool(){
        return this.done;
    }
        
    
    
    private void moveGui(Coordinate coordinate){
        for(Shape shape: gui){
            System.out.println("moveGui"+ this.position);
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
        List<Coordinate> zastavky = this.path.getPath();
        if(distance >= path.getPathSize()){
            //distance = 0;
            //this.position = position;
            this.done = true;           
            return -1;  
        }
        

        distance += speed;
        System.out.println(distance);
        System.out.println(path.getPathSize());

        
        Coordinate coords = path.getCoordinateByDistance(distance);
        moveGui(coords);
        position = coords;
        
        for(Integer i = 0;i < zastavky.size();i++){
            System.out.println("Porovnavam " + floor(this.position.getX())+ " plus " + floor(this.position.getY())+ " VS " + zastavky.get(i).getX()+ " a " + zastavky.get(i).getY());
            if((floor(this.position.getX()) == zastavky.get(i).getX() && floor(this.position.getY()) == zastavky.get(i).getY())
                || (ceil(this.position.getX()) == zastavky.get(i).getX() && ceil(this.position.getY()) == zastavky.get(i).getY())
                    || (floor(this.position.getX()) == zastavky.get(i).getX() && ceil(this.position.getY()) == zastavky.get(i).getY())
                    || (ceil(this.position.getX()) == zastavky.get(i).getX() && floor(this.position.getY()) == zastavky.get(i).getY())){
                System.out.println("ZASTAVKA YEAH" + " " + " " + "");
                return 2;
            }
        }
        
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
        return "Vehicle{" + "position=" + position + ", speed=" + speed + ", id=" + id + '}';
    }

    private void setGui() {
        gui = new ArrayList<>( );
        Circle circle = new Circle(position.getX(), position.getY(), 8, Color.BLUE);
        
        circle.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                System.out.println("Whadup");
                circle.setFill(Color.RED);
            }
        });
        gui.add(circle);
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
