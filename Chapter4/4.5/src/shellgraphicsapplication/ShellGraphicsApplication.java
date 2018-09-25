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
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics(stage, "Shell Graphics Application", 1000, 1000 );
        
        
        
        
        gc.strokeRect(390, 475, 300, 200);
        gc.strokeOval(300,500,100,100);   // bottom of face
        gc.strokeLine(320, 450, 320, 475);// left eye
        gc.strokeLine(380, 450, 380, 475);// right eye
        gc.strokeLine(340, 535, 340, 550);// left nostril
        gc.strokeLine(360, 535, 360, 550);// right nostril
        gc.strokeRect(310, 380, 20, 30); //left horn
        gc.strokeRect(370, 380, 20, 30);//right horn
        gc.strokeRect(0, 0, 0, 0);
        
        
        gc.beginPath();
        gc.moveTo(300,550);    
        gc.lineTo(300, 450);
        
        gc.arc(300, 420, 10, 10, 90, 180);
        gc.moveTo(300, 410);
        gc.lineTo(400, 410);
        gc.moveTo(400, 430);
        gc.arc(400, 420, 10, 10, -90, 180);
        gc.lineTo(400,550);
        
        
        
      
        gc.stroke();
        // Drawing code goes here
    }
}
