package shellgraphicsapplication;
//Name: Christian Pilley
//Desc: Java house
//Date: 10/1/2018 :: 16:23
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ShellGraphicsApplication extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics(stage, "Shell Graphics Application", 600, 400 );
        
        //main frame
        gc.setFill(Color.GREY);
        gc.fillRect(50, 200, 150, 400);
        gc.fillRect(200, 250, 200, 150);
        gc.fillRect(400, 200, 150, 400);
        
        gc.fillRect(50, 175, 22.5, 25);
        gc.fillRect(92.5, 175, 22.5, 25);
        gc.fillRect(135, 175, 22.5, 25);
        gc.fillRect(177.5, 175, 22.5, 25);
      
        gc.fillRect(400, 175, 22.5, 25);
        gc.fillRect(442.5, 175, 22.5, 25);
        gc.fillRect(485, 175, 22.5, 25);
        gc.fillRect(527.5, 175, 22.5, 25);
        
        
        
        //outline
        gc.strokeRect(50, 200, 150, 400);
        gc.strokeRect(200, 250, 200, 150);
        gc.strokeRect(400, 200, 150, 400);
        //door
        gc.setFill(Color.SADDLEBROWN);
        gc.fillRoundRect(250, 300, 100, 400, 100, 100);
        gc.strokeRoundRect(250, 300, 100, 400, 100, 100);
        
        
        
        
        // flag 1
        gc.strokeLine(125, 200, 125, 100);
        gc.strokeLine(475, 200, 475, 100);
        gc.setFill(Color.RED);
        double t1x[] = {125,125,200};
        double t2x[] = {475,475,550};
        double t3x[] = {125,125,200};
        double t4x[] = {475,475,550};
        double t1y[] = {100,125,112.5};
        double t2y[] = {100,125,112.5};
        double t3y[] = {107.5, 117.5, 112.5};
        double t4y[] = {107.5, 117.5, 112.5};
        
        
        gc.fillPolygon(t1x, t1y, 3);
        gc.fillPolygon(t2x, t2y, 3);
        gc.setFill(Color.GOLD);
        gc.fillPolygon(t3x, t3y, 3);
        gc.fillPolygon(t4x, t4y, 3);
        gc.setFont(new Font(50));
        gc.strokeText("Castle Java-stien", 100, 50);
        // Drawing code goes here
    }
}
