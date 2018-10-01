package shellgraphicsapplication;
//Name: Christian Pilley
//Desc: Tic-Tac-Toe
//Date:10/1/18 :: 15:36
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class ShellGraphicsApplication extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics(stage, "Shell Graphics Application", 700, 700 );
        
        
        
        
        gc.setLineWidth(4);
        gc.strokeLine(233, 0, 233, 700);
        gc.strokeLine(466, 0, 466, 700);
        
        gc.strokeLine(0, 233, 700, 233);
        gc.strokeLine(0, 466, 700, 466);
        
        gc.strokeOval(50,50, 133,133);
        gc.strokeOval(516, 283, 133, 133);
        
        gc.strokeLine(50,283,183,416);
        gc.strokeLine(50,416,183,283);
        
        
        
        
        
        // Drawing code goes here
    }
}
