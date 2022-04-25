import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.TriangleMesh;

public class UnderstandingSmiley extends Application {
    
    @Override
    public void start ( Stage stage ) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 400);

        Circle circle = new Circle();
        circle.setCenterX(200);
        circle.setCenterY(200);
        circle.setRadius(100);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(170);
        ellipse.setCenterY(170);
        ellipse.setRadiusX(15);
        ellipse.setRadiusY(10);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);

        Ellipse ep2 = new Ellipse();
        ep2.setCenterX(225);
        ep2.setCenterY(170);
        ep2.setRadiusX(15);
        ep2.setRadiusY(10);
        ep2.setFill(Color.WHITE);
        ep2.setStroke(Color.BLACK);

        Circle c1 = new Circle();
        c1.setCenterX(225);
        c1.setCenterY(170);
        c1.setRadius(3);
        c1.setFill(Color.BLACK);
        c1.setStroke(Color.BLACK);


        Circle c2 = new Circle();
        c2.setCenterX(170);
        c2.setCenterY(170);
        c2.setRadius(3);
        c2.setFill(Color.BLACK);
        c2.setStroke(Color.BLACK);

        Polygon nose = new Polygon ( 200, 200, 220, 220, 180, 220 );
        nose.setFill(Color.BLACK);
        nose.setStroke(Color.BLACK);

        int radius = 100;
        Arc smile = new Arc();
        smile.setCenterX(0);
        smile.setCenterY(0);
        smile.setRadiusX(20);
        smile.setRadiusY(20);
        smile.setLength(170);
        smile.setStroke(Color.BLACK);
        smile.setType(ArcType.OPEN);
        smile.setFill(Color.WHITE);
        smile.setStroke(Color.BLACK);

        Rotate rotate = new Rotate();
        rotate.setAngle(175);
        rotate.setPivotX(95);
        rotate.setPivotY(120);
        smile.getTransforms().add(rotate);

        Line line1 = new Line(10,50,150,50); //Line(startX,startY,endX,en
        Rectangle rect = new Rectangle();
        rect.setX(50);
        rect.setY(20);
        rect.setWidth(100);
        rect.setHeight(150);

        // root.getChildren().addAll(circle, ellipse, ep2, c1, c2, nose, smile, line1, rect );

        Circle cir = new Circle(50, 100, 50);
        cir.setFill(Color.RED);
        cir.setStroke(Color.BLACK);

        TranslateTransition translate = new TranslateTransition();
        translate.setByX(400);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(500);
        translate.setAutoReverse(true);
        translate.setNode(cir);
        translate.play();

        // root.getChildren().addAll(cir);

        Box box = new Box();
        box.setWidth(70);
        box.setDepth(50);
        box.setHeight(100);

        // PerspectiveCamera camera = new PerspectiveCamera();
        // camera.setTranslateX(100);
        // camera.setTranslateY(50);
        // camera.setTranslateZ(-90);
        // scene.setCamera(camera);

        Box box1 = new Box();
        Box box2 = new Box();
        //Setting properties for second box
        box2.setTranslateX(450); box2.setTranslateY(300); box2.setTranslateZ(100);
        box2.setHeight(150); box2.setWidth(50); box2.setDepth(400);
        //Setting properties for first box
        box1.setHeight(100); box1.setWidth(100); box1.setDepth(400); box1.setTranslateX(200); box1.setTranslateY(200); box1.setTranslateZ(200);
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateX(100); camera.setTranslateY(100); camera.setTranslateZ(50); 

        root.getChildren().add(box);

        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
