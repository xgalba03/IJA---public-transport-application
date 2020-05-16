/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Damian
 */
public class MyLine {
    
    protected String name;
    protected List<Vehicle> vehicles;
    protected List<Stop> stops;
    
    public MyLine(){}
    
    public MyLine(String name){
        this.name = name;
        this.vehicles = new ArrayList<>();
        this.stops = new ArrayList<>();
    }
    
    public MyLine(String name,List<Vehicle> vehicles,List<Stop> stops){
        this.name = name;
        this.vehicles = vehicles;
        this.stops = stops;
    }
    
    void addStopToLine(Stop s){
        this.stops.add(s);
    }
    
    void addVehicleToLine(Vehicle v){
        this.vehicles.add(v);
    }
    
}
