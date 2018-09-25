package shellgraphicsapplication;

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class ShellGraphicsApplication extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics(stage, "Shell Graphics Application", 700, 400 );
        
        // Drawing code goes here
    }
}
