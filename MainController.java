/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import javafx.fxml.FXML;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author localadmin
 */
public class MainController implements Initializable {
    @FXML
    public Pane content;
    private Timer timer;
    List<Drawable> elements = new ArrayList<>();
    private LocalTime time = LocalTime.now();
    private List<TimeUpdate> updates = new ArrayList<>();
    
    @FXML
    private TextField timeScale;
    @FXML
    private TextField clock;
    @FXML
    public TextArea poriadok;
    
    @FXML
    private void onTimeScaleChange(){
        try{
            float scale = Float.parseFloat(timeScale.getText());
            if(scale <= 0){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Time Scale");
                alert.show();
                return;
            }
            timer.cancel();
            startTime(scale);
        } catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Time Scale");
            alert.show();
        }  
    }
    
    @FXML
    private void removeHighlight(){
        System.out.print("Removing highlights");
        //Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Time Scale");
        //    alert.show();
        for (Drawable drawable : elements){
            System.out.print("ID:" + drawable.getID()+ "" + "\n \n \n");
            if (drawable.getID() == 99.0){
                System.out.print("Odstranujem"+ "" + "\n \n \n");
                content.getChildren().removeAll(drawable.getGui());
            }
        }
    }
    
    @FXML
    private void hhh(ScrollEvent event){
        event.consume();
        double zoom = event.getDeltaY() > 0 ? 1.1 : 0.9;
        content.setScaleX(zoom * content.getScaleX());
        content.setScaleY(zoom * content.getScaleY());
        content.layout();
    }
    

    public void setElements(List<Drawable> elements) {
        this.elements = elements;
        for (Drawable drawable : elements){
            content.getChildren().addAll(drawable.getGui());
            if(drawable instanceof TimeUpdate){
                updates.add((TimeUpdate)drawable);
            }
        }
    }
    
    public void removeElement(){
        for (Drawable drawable : elements){
            if (drawable.getBool() == true){
                content.getChildren().removeAll(drawable.getGui());
            }
        }
    }
    
    @FXML
    public void writeTime(){
        clock.setText(time.toString());
        timeScale.getText();
    }
    
    
    public void startTime(double scale){
        elements = this.elements;
        timer = new Timer(false);
        
        timer.scheduleAtFixedRate(new TimerTask(){
        @Override
        public void run(){
            time = time.plusSeconds(1);
            for(TimeUpdate update : updates){
               System.out.print("Update " + update + "čas je:" + time);
               Integer returner = update.update(time);
               writeTime();
               
               if (returner == 2){
                   System.out.print("Zastavka............................");
                   Platform.runLater(new Runnable() {              
                    @Override
                    public void run() {
                        System.out.println("Stojim:\n \n \n ");
                    }
                    });
                       System.out.println("Stojim:\n \n \n ");
               }
               
              /* if (returner == -1){
                System.out.println("END:\n \n \n ");
                updates.remove(update);
                Platform.runLater(new Runnable() {              
                    @Override
                    public void run() {
                        removeElement();
                    }
                });
                break;
               }*/
            } 
        }
        }, 0, (long )(1000 / scale));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
