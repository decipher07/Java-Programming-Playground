import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Callable;

// import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
// import javafx.scene.layout.BackgroundImage;
// import javafx.scene.layout.BackgroundPosition;
// import javafx.scene.layout.BackgroundRepeat;
// import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.image.Image;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Circle;
// import javafx.scene.shape.Line;
// import javafx.scene.shape.Polygon;
// import javafx.scene.shape.Rectangle;
// import javafx.scene.text.Font;
// import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SampleLayout extends Application {

    @Override
    public void start(Stage stage) throws Exception
    {
        //Creating an image 
        Image image = new Image(new FileInputStream("/home/nopc/Desktop/Github-Clones/Java-Programming/JavaFX Practise/car.jpeg"));  
        
        //Setting the image view 
        ImageView imageView = new ImageView(image); 
        
        //Setting the position of the image 
        imageView.setX(50); 
        imageView.setY(270); 
        
        //setting the fit height and width of the image view 
        imageView.setFitHeight(200); 
        imageView.setFitWidth(100); 
        imageView.setRotate(imageView.getRotate() - 49);

        //Setting the preserve ratio of the image view 
        imageView.setPreserveRatio(true);  
        
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(600);
        translate.setDuration(Duration.millis(5000));
        translate.setCycleCount(500);
        translate.setNode(imageView);
        translate.play();

        //Creating an image 
        Image image12 = new Image(new FileInputStream("/home/nopc/Desktop/Github-Clones/Java-Programming/JavaFX Practise/car.jpeg"));  
        
        //Setting the image view 
        ImageView imageView12 = new ImageView(image12); 
        
        //Setting the position of the image 
        imageView12.setX(1000); 
        imageView12.setY(270);
        
        //setting the fit height and width of the image view 
        imageView12.setFitHeight(200); 
        imageView12.setFitWidth(100); 
        imageView12.setRotate(imageView12.getRotate() - 49 - 180);

        //Setting the preserve ratio of the image view 
        imageView12.setPreserveRatio(true);  
        
        TranslateTransition translate12 = new TranslateTransition();
        translate12.setByX(-600);
        translate12.setDuration(Duration.millis(5000));
        translate12.setCycleCount(500);
        translate12.setNode(imageView12);
        translate12.play();

        // AnimationTimer collisionTimer = new AnimationTimer() {
        //     @Override
        //     public void handle (long timestamp ){
        //     if ( imageView.getBoundsInParent().intersects(imageView12.getBoundsInParent()))
        //         System.out.println("Hit");
        //         // translate.stop();
        //         // translate12.stop();
        //     }
        // };

        // if ( imageView.getBoundsInParent().intersects(imageView12.getBoundsInParent()))
        //     System.out.println("JALDLKAJ");

        // collisionTimer.start();

        //Creating a Group object  
        Group root = new Group();  
        
        //Creating a scene object 
        Scene scene = new Scene(root, 1500, 500);

        Image background = new Image(new FileInputStream("/home/nopc/Desktop/Github-Clones/Java-Programming/JavaFX Practise/landscape.jpeg"));  
        
        //Setting the image view 
        ImageView backImage = new ImageView(background); 
        backImage.setFitWidth(1500);
        backImage.setFitHeight(500);

        root.getChildren().add(backImage);

        // scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        //Setting title to the Stage 
        stage.setTitle("Loading an image");
        
        root.getChildren().add(imageView);
        root.getChildren().add(imageView12);


        ObservableBooleanValue colliding = Bindings.createBooleanBinding(new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                return imageView.getBoundsInParent().intersects(imageView12.getBoundsInParent());
            }
    
        }, imageView.boundsInParentProperty(), imageView12.boundsInParentProperty());
    
        colliding.addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    System.out.println("Colliding");
                    translate.stop();
                    translate12.stop();
                    
                    
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
    

        //Adding scene to the stage 
        stage.setScene(scene);
        
        //Displaying the contents of the stage 
        stage.show(); 


        // Group root = new Group();
        // Scene scene = new Scene(root, 600, 600, Color.LIGHTSKYBLUE);
        // TranslateTransition translate = new TranslateTransition();
        
        
        // Image image = new Image(new FileInputStream("/home/nopc/Desktop/Github-Clones/Java-Programming/JavaFX Practise/car.jpeg"));
        // ImageView imageView = new ImageView(image); 
      
        // imageView.setX(50); 
        // imageView.setY(25); 
        
        // //setting the fit height and width of the image view 
        // imageView.setFitHeight(455); 
        // imageView.setFitWidth(500); 
  

        // ImageView image = new ImageView("car.jpeg");
        // translate.setNode(imageView);
        // translate.setByX(250);
        // translate.play();
        // Text text = new Text();
        // text.setText("HELLO WORLD");
        // text.setX(50);
        // text.setY(50);
        // text.setFont(Font.font("Verdana", 50));
        // text.setFill(Color.GREEN);

        // Line line = new Line();
        // line.setStartX(100);
        // line.setStartY(100);
        // line.setEndX(200);
        // line.setEndY(100);
        // line.setStrokeWidth(5);

        // Rectangle rectangle = new Rectangle();
        // rectangle.setX(200);
        // rectangle.setY(300);
        // rectangle.setWidth(100);
        // rectangle.setHeight(200);
        // rectangle.setFill(Color.BLUE);
        // rectangle.setStrokeWidth(5);
        // rectangle.setStroke(Color.BLACK);

        // Polygon triangle = new Polygon();
        // triangle.getPoints().setAll(
        //     200.0, 200.0,
        //     300.0, 300.0,
        //     200.0, 300.0
        // );
        // triangle.setFill(Color.YELLOW);

        // Circle circle = new Circle();
        // circle.setCenterX(250);
        // circle.setCenterY(450);
        // circle.setRadius(50);
        // circle.setFill(Color.ORANGE);

        // root.getChildren().add(text);
        // root.getChildren().add(line);
        // root.getChildren().add(rectangle);
        // root.getChildren().add(triangle);
        // root.getChildren().add(circle);

        // stage.setScene(scene);
        // stage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
