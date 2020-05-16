/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author localadmin
 */
public class Data {
    public List<Street> streets = new ArrayList<>();
    public List<Stop> stops = new ArrayList<>();
    
    private Data(){
    }
    
   /* public Data(List<Coordinate> coordinates, Vehicle vehicle){
        this.coordinates = coordinates;
        this.vehicle = vehicle;
    }*/
    
    public Data(List<Street> streets,List<Stop> stops){
        this.streets = streets;
        this.stops = stops;
    }


    public List<Street> getStreets() {
        return streets;
    }
    
    public List<Stop> getStops() {
        return stops;
    }


    @Override
    public String toString() {
        return "Data{" + "coordinates="  + ", vehicle=" + '}';
    }
    
    
    
    
}
