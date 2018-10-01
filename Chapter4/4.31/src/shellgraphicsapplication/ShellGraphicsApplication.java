package shellgraphicsapplication;
//Name: Christian Pilley
//Desc: Olympic Rings
//Date:10/1/18 :: 15:28
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ShellGraphicsApplication extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics(stage, "Shell Graphics Application", 700, 700 );
        gc.setLineWidth(3);
        gc.setStroke(Color.BLUE);
        gc.strokeOval(100, 100, 90, 90);
        gc.setStroke(Color.YELLOW);
        gc.strokeOval(150, 150, 90, 90);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(200, 100, 90, 90);
        gc.setStroke(Color.GREEN);
        gc.strokeOval(250, 150, 90, 90);
        gc.setStroke(Color.RED);
        gc.strokeOval(300, 100, 90, 90);
    }
}
