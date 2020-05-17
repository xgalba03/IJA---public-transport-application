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
import java.time.LocalTime;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.shape.Line;

/**
 *
 * @author localadmin
 */
public class Projekt extends Application {
    private LocalTime time = LocalTime.now();
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        BorderPane root = loader.load();
        
        Scene scene = new Scene(root,800,600);
        
        primaryStage.setScene(scene);
        primaryStage.show();
         
        MainController controller = loader.getController();
        List<Drawable> elements = new ArrayList<>();
        
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(100, 300));
        coordinates.add(new Coordinate(100, 200));
        coordinates.add(new Coordinate(200, 200));
        coordinates.add(new Coordinate(300, 300));
        
        Street ulica1 = new Street("Test streetC",  new Coordinate(200, 100), new Coordinate(300, 200), 3);
        Street ulica2 = new Street("Test streetB",  new Coordinate(500, 500), new Coordinate(100, 800), 4);
        Street ulica3 = new Street("Test street2",  new Coordinate(100, 200), new Coordinate(500, 500), 5);
        
        Street ulica4 = new Street("Antoninska",   new Coordinate(100, 100), new Coordinate(200, 200), 5);
        Street ulica5 = new Street("Mukacevova",   new Coordinate(200, 200), new Coordinate(300, 300), 6);
        Street ulica6 = new Street("Stefanikova",  new Coordinate(300, 300), new Coordinate(200, 400), 7);
        Street ulica7 = new Street("Roosveltova",  new Coordinate(200, 400), new Coordinate(300, 500), 8);
        
        Street ulica8 =  new Street("",  new Coordinate(100,300), new Coordinate(300,150), 9);
        Street ulica9 =  new Street("",  new Coordinate(300,150), new Coordinate(400,400), 10);
        Street ulica10 = new Street("",  new Coordinate(400,400), new Coordinate(400,500), 11);
        Street ulica11 = new Street("",  new Coordinate(400,500), new Coordinate(100,200), 12);
        
        
        Street ulica12 =  new Street("",  new Coordinate(100,100), new Coordinate(100,200), 13);
        Street ulica13 =  new Street("",  new Coordinate(100,200), new Coordinate(100,300), 14);
        Street ulica14 = new Street("",  new Coordinate(100,300), new Coordinate(100,500), 15);
        Street ulica15 = new Street("",  new Coordinate(100,500), new Coordinate(300,500), 16);
        Street ulica16 = new Street("",  new Coordinate(300,500), new Coordinate(400,500), 17);
        Street ulica17 = new Street("",  new Coordinate(400,500), new Coordinate(500,300), 18);
        Street ulica18 = new Street("",  new Coordinate(500,300), new Coordinate(300,150), 19);
        Street ulica19 = new Street("",  new Coordinate(300,150), new Coordinate(400,100), 20);
        
        Path linka1 = new Path(Arrays.asList(new Coordinate(200, 100),new Coordinate(300, 200)));
        Path linka2 = new Path(Arrays.asList(new Coordinate(100, 200),new Coordinate(500, 500),new Coordinate(100, 800)));
        
        //linka1.addStreet(ulica1);
        //linka1.addStreet(ulica2);
        
       /* Vehicle vehicle = new Vehicle(
            coordinates.get(1), 
            2, 
            linka2,1);
        
        Vehicle vehicle2 = new Vehicle(
            coordinates.get(0), 
            2, 
            linka1,2);*/
        
       /* elements.add(vehicle);
        elements.add(vehicle2);*/
        //elements.add(new Street("Test streetA",  new Coordinate(100, 100), new Coordinate(500, 500))); 
        elements.add(ulica1); 
        elements.add(ulica2); 
        elements.add(ulica3); 
        
        //controller.setElements(elements);
        //elements.remove(vehicle);
        //System.out.println("Elementy: ");
        //System.out.print(elements);
        //controller.setElements(elements);
        //controller.removeElement(vehicle);
        //controller.startTime(1);
        
        MyLine line = new MyLine("10");
        line.stops.add(new Stop("Technicke muzeum",new Coordinate(100,100)));
        line.stops.add(new Stop("Skacelova",new Coordinate(200,200)));
        line.stops.add(new Stop("Trefejova",new Coordinate(300,300)));
        line.stops.add(new Stop("Juzna",new Coordinate(200,400)));
        line.stops.add(new Stop("Hlavna",new Coordinate(300,500)));
        Path path = new Path(Arrays.asList(line.stops.get(0).c,line.stops.get(1).c,line.stops.get(2).c,line.stops.get(3).c,line.stops.get(4).c));
        
        
        
        
        
        MyLine line2 = new MyLine("20");
        line2.stops.add(new Stop("Ceska",new Coordinate(100,300)));
        line2.stops.add(new Stop("Rybkova",new Coordinate(300,150)));
        line2.stops.add(new Stop("Kravi hora",new Coordinate(400,400)));
        line2.stops.add(new Stop("Silingrovo namesti",new Coordinate(400,500)));
        line2.stops.add(new Stop("Tabor",new Coordinate(100,200)));
        Path path2 = new Path(Arrays.asList(line2.stops.get(0).c,line2.stops.get(1).c,line2.stops.get(2).c,line2.stops.get(3).c,line2.stops.get(4).c));
        
        
        MyLine line3 = new MyLine("30");
        line3.stops.add(new Stop("Technicke muzeum",new Coordinate(100,100)));
        line3.stops.add(new Stop("Tabor",new Coordinate(100,200)));
        line3.stops.add(new Stop("Ceska",new Coordinate(100,300)));
        line3.stops.add(new Stop("Semillaso",new Coordinate(100,500)));
        line3.stops.add(new Stop("Hlavna",new Coordinate(300,500)));
        line3.stops.add(new Stop("Silingrovo namesti",new Coordinate(400,500)));
        line3.stops.add(new Stop("Zbojnova",new Coordinate(500,300)));
        line3.stops.add(new Stop("Rybkova",new Coordinate(300,150)));
        line3.stops.add(new Stop("Kolejni",new Coordinate(400,100)));
        Path path3 = new Path(Arrays.asList(line3.stops.get(0).c,line3.stops.get(1).c,line3.stops.get(2).c,line3.stops.get(3).c,line3.stops.get(4).c,
                line3.stops.get(5).c,line3.stops.get(6).c,line3.stops.get(7).c,line3.stops.get(8).c));
        for(Integer i =0; i < 10; i++){
            double medzera = (path.getPathSize()/10);
            double distance = (medzera*i);
            Coordinate start = path.getCoordinateByDistance(medzera*i);
            System.out.print("Path size:"+medzera+"Start:"+start);
            line.vehicles.add(new Vehicle(start,1,path,1,line,controller,distance));
        }
        for(Integer i =0; i < 10; i++){
            double medzera = (path2.getPathSize()/10);
            double distance = (medzera*i);
            Coordinate start = path2.getCoordinateByDistance(medzera*i);
            System.out.print("Path size:"+medzera+"Start:"+start);
            line2.vehicles.add(new Vehicle(start,1,path2,1,line2,controller,distance));
        }
        for(Integer i =0; i < 10; i++){
            double medzera = (path3.getPathSize()/10);
            double distance = (medzera*i);
            Coordinate start = path3.getCoordinateByDistance(medzera*i);
            System.out.print("Path size:"+medzera+"Start:"+start);
            line3.vehicles.add(new Vehicle(start,1,path3,1,line3,controller,distance));
        }
        
        //Data data = new Data(coordinates, vehicle);
        /*List<MyLine> lines = new ArrayList<>();
        lines.add(line);
        lines.add(line2);*/
        
        List<Drawable> elements_two = new ArrayList<>();
        /*
        elements_two.add(ulica4);
        elements_two.add(ulica5);
        elements_two.add(ulica6);
        elements_two.add(ulica7);
        elements_two.add(ulica8);
        elements_two.add(ulica9);
        elements_two.add(ulica10);
        elements_two.add(ulica11);
        

        for (int i = 0; i < line2.stops.size(); i++) {
            elements_two.add(line2.stops.get(i));
        }
        for (int i = 0; i < line.stops.size(); i++) {
            elements_two.add(line.stops.get(i));
        }*/
        /*
        for (int i = 0; i < line.vehicles.size(); i++) {
            elements_two.add(line.vehicles.get(i));
        }
        for (int i = 0; i < line2.vehicles.size(); i++) {
            elements_two.add(line2.vehicles.get(i));
        }
        for (int i = 0; i < line3.vehicles.size(); i++) {
            elements_two.add(line3.vehicles.get(i));
        }
        */
        YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        ObjectMapper mapper = new ObjectMapper(factory); 
        mapper.findAndRegisterModules();
        //mapper.writeValue(new File("test.yaml"), data);
        
        
        Data read_data = mapper.readValue(getClass().getResource("/map_lines.yaml"), Data.class);
        
        for (int i = 0; i < read_data.streets.size(); i++) {
            read_data.streets.get(i).setGui();
            elements_two.add(read_data.streets.get(i));
        }
        for (int i = 0; i < read_data.lines.size(); i++) {
            for (int j = 0; j < read_data.lines.get(i).stops.size(); j++) {
                elements_two.add(read_data.lines.get(i).stops.get(j));
            }
            for (int j = 0; j < read_data.lines.get(i).vehicles.size(); j++) {
                read_data.lines.get(i).vehicles.get(j).setController(controller);
                read_data.lines.get(i).vehicles.get(j).setGui();
                elements_two.add(read_data.lines.get(i).vehicles.get(j));
            }
        }
        for (int i = 0; i < line.vehicles.size(); i++) {
            elements_two.add(line.vehicles.get(i));
        }
        for (int i = 0; i < line2.vehicles.size(); i++) {
            elements_two.add(line2.vehicles.get(i));
        }
        for (int i = 0; i < line3.vehicles.size(); i++) {
            elements_two.add(line3.vehicles.get(i));
        }

        //elements_two.add(vehicle2);
        controller.setElements(elements_two);
        controller.startTime(1);
        
        List<Street> list_of_streets = new ArrayList<>();
        
        list_of_streets.add(ulica4);
        list_of_streets.add(ulica5);
        list_of_streets.add(ulica6);
        list_of_streets.add(ulica7);
        list_of_streets.add(ulica8);
        list_of_streets.add(ulica9);
        list_of_streets.add(ulica10);
        list_of_streets.add(ulica11);
        list_of_streets.add(ulica12);
        list_of_streets.add(ulica13);
        list_of_streets.add(ulica14);
        list_of_streets.add(ulica15);
        list_of_streets.add(ulica16);
        list_of_streets.add(ulica17);
        list_of_streets.add(ulica18);
        list_of_streets.add(ulica19);
        
        List<Stop> list_of_stops = new ArrayList<>();
        
        list_of_stops.add(new Stop("Technicke muzeum",new Coordinate(100,100)));
        list_of_stops.add(new Stop("Skacelova",new Coordinate(200,200)));
        list_of_stops.add(new Stop("Trefejova",new Coordinate(300,300)));
        list_of_stops.add(new Stop("Juzna",new Coordinate(200,400)));
        list_of_stops.add(new Stop("Hlavna",new Coordinate(300,500)));
        list_of_stops.add(new Stop("Ceska",new Coordinate(100,300)));
        list_of_stops.add(new Stop("Rybkova",new Coordinate(300,150)));
        list_of_stops.add(new Stop("Kravi hora",new Coordinate(400,400)));
        list_of_stops.add(new Stop("Silingrovo namesti",new Coordinate(400,500)));
        list_of_stops.add(new Stop("Tabor",new Coordinate(100,200)));
        
        List<MyLine> list_of_lines = new ArrayList<>();
        list_of_lines.add(line);
        list_of_lines.add(line2);
        list_of_lines.add(line3);
        
        controller.giveLines(list_of_lines);
        
        Data data = new Data(list_of_streets,list_of_lines);
        /*
        
        YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        ObjectMapper mapper = new ObjectMapper(factory); 
        mapper.findAndRegisterModules();
        //
        
        Data read_data = mapper.readValue(new File("test.yaml"), Data.class);
        for (int i = 0; i < read_data.stops.size(); i++) {
            System.out.println("STOP: "+read_data.stops.get(i).name);
        }*/
       
       //mapper.writeValue(new File("test.yaml"), data);

    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
