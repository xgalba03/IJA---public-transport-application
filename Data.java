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
    private List<Coordinate> coordinates;
    private Vehicle vehicle;
    private List<MyLine> lines;
    
    private Data(){
    }
    
   /* public Data(List<Coordinate> coordinates, Vehicle vehicle){
        this.coordinates = coordinates;
        this.vehicle = vehicle;
    }*/
    
    public Data(List<MyLine> line){
        this.lines = line;
    }


    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
    
    public List<MyLine> getLines() {
        return lines;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "Data{" + "coordinates=" + coordinates + ", vehicle=" + vehicle + '}';
    }
    
    
    
    
}
