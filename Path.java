/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

/**
 *
 * @author localadmin
 */
public class Path {
    private List<Coordinate> path;

    private Path(){}
    
    public Path(List<Coordinate> path) {
        this.path = path;
    }

    public List<Coordinate> getPath() {
        return path;
    }
    
    
    private double getDistanceBetweenCoordinates(Coordinate a, Coordinate b){
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
    public Coordinate getCoordinateByDistance(double distance){
        double length = 0;
        double currentLength = 0;
        
        Coordinate a = null;
        Coordinate b = null;        
        
        for(int i = 0; i < path.size() - 1; i++){
             a = path.get(i);
             b = path.get(i+1);
            
            currentLength = getDistanceBetweenCoordinates(a,b);
            if(length + currentLength >= distance){
                break;
            }
            length += currentLength;
        }
        
        if(a == null || b == null)
            return null;
        double driven = (distance - length)/currentLength;
        
        return new Coordinate(a.getX() + (b.getX() - a.getX()) * driven, a.getY() + (b.getY() - a.getY()) * driven);
    }
    
    @JsonIgnore
    public double getPathSize(){
        double size = 0;
            for(int i = 0; i < path.size() - 1; i++){
                size += getDistanceBetweenCoordinates(path.get(i), path.get(i+1));
            }         
        return size;
    }
    
}