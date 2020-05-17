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

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;


/**
 *
 * @author localadmin
 */
//@JsonDeserialize(converter=Vehicle.VehicleConstructorCall.class);
@JsonDeserialize(converter = Vehicle.VehicleConstructorCall.class)
public class Vehicle implements Drawable, TimeUpdate{
    private Coordinate position;
    private double speed = 0;
    private double distance;
    private double id = 0;
    private boolean done = false;
    private boolean zastavka = false;
    private double cakanie = 0;
    private Integer current;
    private MyLine linka;
    private Path path;
    private MainController control;
    @JsonIgnore
    private List<Shape> gui;
    
    
    
    private Vehicle(){}
    
    public Vehicle(Coordinate position, double speed, Path path, double ID, MyLine linka, MainController control, double distance) {
        this.id = ID;
        this.position = position;
        this.speed = speed;
        this.path = path;
        this.done = false;
        this.zastavka = false;
        this.linka = linka;
        this.control = control;
        this.distance = distance;
        this.current = 1;
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
            System.out.println("moveGui"+ this.position +"get"+shape.getTranslateX());
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
        if(this.distance >= path.getPathSize()){
            this.distance = 0;
            this.position = position;
            this.done = true;    
            this.current = 0;
            return -1;  
        }
        
        System.out.print("Vzdialenost:" + this.distance+ "\n");
        

          
       // moveGui(coords);
       // position = coords;
        
        if(this.zastavka == false){
            for(Integer i = current;i < zastavky.size();i++){
                System.out.println("Porovnavam " + floor(this.position.getX())+ " plus " + floor(this.position.getY())+ " VS " + zastavky.get(i).getX()+ " a " + zastavky.get(i).getY());
                if(((floor(this.position.getX()) == zastavky.get(i).getX()) || (ceil(this.position.getX()) == zastavky.get(i).getX()))
                    && ((floor(this.position.getY()) == zastavky.get(i).getY()) || (ceil(this.position.getY()) == zastavky.get(i).getY()))){
                    System.out.println("ZASTAVKA YEAH" + " " + " " + "");
                    this.zastavka = true;
                    this.current = i+1;
                    return 2;
                }
            }
        }
  
        if(this.zastavka == false){
            this.distance += speed;
            Coordinate coords = path.getCoordinateByDistance(this.distance); 
            moveGui(coords);
            position = coords;
        }
        else{
            System.out.println("Cakam"+"");
            cakanie++;
            if(cakanie > 4){
                this.zastavka = false;
                this.distance += speed;
                Coordinate coords = path.getCoordinateByDistance(this.distance); 
                moveGui(coords);
                position = coords;
                cakanie = 0;
            }
        }             
        return 0;
    }
    
    public Coordinate getPosition(){
        return position;
    }
    
    public double getSpeed(){
        return speed;
    }
    
    private void highLight(Shape bus){
        //List<Coordinate> zastavky = this.path.getPath();
        control.removeHighlight();
        System.out.println("Highlighting");
        String zastavky = "";
        for(Integer i = 0;i < this.linka.stops.size();i++){
                System.out.println(this.linka.stops.get(i).name);
                zastavky = zastavky + (this.linka.stops.get(i).name) + "\n";     
            }
        control.poriadok.setText(zastavky);
        //bus.setFill(Color.RED);
        
        for(Integer i = 0;i < this.path.path.size()-1;i++){
                Coordinate start = new Coordinate(this.path.path.get(i).getX(),this.path.path.get(i).getY());
                Coordinate end = new Coordinate(this.path.path.get(i+1).getX(),this.path.path.get(i+1).getY());
                double id = 99;
                Street street = new Street("",start,end,id);
                //Line line = new Line(this.path.path.get(i).getX(),this.path.path.get(i).getY(),this.path.path.get(i+1).getX(),this.path.path.get(i+1).getY()); 
                //line.setStroke(Color.YELLOW);
                //line.setStrokeWidth(2);
                //gui.add(line);
                this.control.content.getChildren().addAll(street.getGui());
                control.elements.add(street);
                System.out.println(street);
            }
    }

    @Override
    public String toString() {
        return "Vehicle{" + "position=" + position + ", speed=" + speed + ", id=" + id + '}';
    }

    private void setGui() {
        gui = new ArrayList<>( );
        Circle bus = new Circle(position.getX(), position.getY(), 8, Color.BLUE);
        
        bus.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                System.out.println("Whadup");
                highLight(bus);
            }
        });
        //bus.toFront();
        gui.add(bus);
        gui.add( new Text(position.getX(), position.getY(), "10"));

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
