import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Callable;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;

public class CarAccident extends Application {

    @Override
    public void start (Stage stage) throws Exception {
        
        // Add a car image
        Image carOverview = new Image(new FileInputStream("/home/nopc/Desktop/Github-Clones/Java-Programming/JavaFX Practise/car.jpeg"));
        ImageView carOneImageView = new ImageView(carOverview);
        carOneImageView.setFitHeight(200);
        carOneImageView.setFitWidth(100);
        carOneImageView.setRotate(carOneImageView.getRotate() - 49);
        carOneImageView.setPreserveRatio(true);

        // Setting the coords for car
        carOneImageView.setX(50);
        carOneImageView.setY(270);
        
        // Translation 
        TranslateTransition translateCarOne = new TranslateTransition();
        translateCarOne.setByX(600);
        translateCarOne.setDuration(Duration.millis(5000));
        translateCarOne.setCycleCount(500);
        translateCarOne.setNode(carOneImageView);
        translateCarOne.play();
        
        // Add another car image
        Image carTwoOverview = new Image(new FileInputStream("/home/nopc/Desktop/Github-Clones/Java-Programming/JavaFX Practise/car.jpeg"));
        ImageView carTwoImageView = new ImageView(carTwoOverview);
        carTwoImageView.setFitHeight(200);
        carTwoImageView.setFitWidth(100);
        carTwoImageView.setRotate(carTwoImageView.getRotate() - 49 - 180);
        carTwoImageView.setPreserveRatio(true);

        // Setting the coords for the other car
        carTwoImageView.setX(1000);
        carTwoImageView.setY(270);
        
        // Translation of the Other Car
        TranslateTransition translateCarTwo = new TranslateTransition();
        translateCarTwo.setByX(-600);
        translateCarTwo.setDuration(Duration.millis(5000));
        translateCarTwo.setCycleCount(500);
        translateCarTwo.setNode(carTwoImageView);
        translateCarTwo.play();

        // Background
        Image backgroundOverview = new Image(new FileInputStream("/home/nopc/Desktop/Github-Clones/Java-Programming/JavaFX Practise/landscape.jpeg"));
        ImageView backgroundImageView = new ImageView(backgroundOverview);
        backgroundImageView.setFitHeight(500);
        backgroundImageView.setFitWidth(1500);


        // Create configurations for running
        Group root = new Group();
        Scene scene = new Scene(root, 1500, 500);

        root.getChildren().addAll( backgroundImageView, carOneImageView, carTwoImageView );

        ObservableBooleanValue colliding = Bindings.createBooleanBinding(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return carOneImageView.getBoundsInParent().intersects(carTwoImageView.getBoundsInParent());
            }
        }, carOneImageView.boundsInParentProperty(), carTwoImageView.boundsInParentProperty());
        
        colliding.addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    System.out.println("Colliding");
                    translateCarOne.stop();
                    translateCarTwo.stop();
                    
                    
                    try {
                        String path = "/home/nopc/Downloads/Songs/Zedd.mp3";  
              
                        //Instantiating Media class  
                        Media media = new Media(new File(path).toURI().toString());  
                          
                        //Instantiating MediaPlayer class   
                        MediaPlayer mediaPlayer = new MediaPlayer(media);  
                          
                        //by setting this property to true, the audio will be played   
                        mediaPlayer.setAutoPlay(true);  

                        mediaPlayer.play();
                        
                        //Creating an image 
                        Image image = new Image(new FileInputStream("/home/nopc/Desktop/Github-Clones/Java-Programming/JavaFX Practise/boom.jpeg"));  
                                
                        //Setting the image view 
                        ImageView imageView = new ImageView(image); 
    
                        //Setting the position of the image 
                        imageView.setX(550); 
                        imageView.setY(300); 
    
                        //setting the fit height and width of the image view 
                        imageView.setFitHeight(50); 
                        imageView.setFitWidth(50);

                        root.getChildren().add(imageView);
                    } catch ( Exception e ){
                        System.out.println(e);
                    }
                } else {
                    System.out.println("Not colliding");
                }
            }
        });
        
        
        stage.setScene(scene);
        stage.show();        
        
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
