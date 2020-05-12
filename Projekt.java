/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;
    

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javafx.scene.shape.Line;

/**
 *
 * @author localadmin
 */
public class Projekt extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("layout.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        BorderPane root = loader.load();
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
         
        MainController controller = loader.getController();
        List<Drawable> elements = new ArrayList<>();
        
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(100, 100));
        Vehicle vehicle = new Vehicle(coordinates.get(0), 2, new Path(Arrays.asList(
            new Coordinate(100, 100),
            new Coordinate(500, 500)
        )));
        elements.add(vehicle);
        elements.add(new Street("Test street",  new Coordinate(100, 100), new Coordinate(500, 500))); 
        
        controller.setElements(elements);
        controller.startTime(1);
        
        Data data = new Data(coordinates, vehicle);
        
        YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        ObjectMapper mapper = new ObjectMapper(factory); 
        //Vehicle vehicle1 = mapper.readValue(new File("test.yaml"), Vehicle.class);
        //System.out.println(vehicle1.getPosition());
        mapper.writeValue(new File("test.yaml"), data);
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}