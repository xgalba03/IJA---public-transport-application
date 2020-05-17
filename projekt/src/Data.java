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
    //public List<Stop> stops = new ArrayList<>();
    public List<MyLine> lines = new ArrayList<>();
    
    private Data(){
    }
    
   /* public Data(List<Coordinate> coordinates, Vehicle vehicle){
        this.coordinates = coordinates;
        this.vehicle = vehicle;
    }*/
    
    public Data(List<Street> streets,List<MyLine> lines){
        this.streets = streets;
        this.lines = lines;
    }


    public List<Street> getStreets() {
        return this.streets;
    }
    
    public List<MyLine> getLines() {
        return this.lines;
    }


    @Override
    public String toString() {
        return "Data{" + "coordinates="  + ", vehicle=" + '}';
    }
    
    
    
    
}
