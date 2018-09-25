package shellgraphicsapplication;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import java.util.Random;
import javafx.scene.text.Font;
public class ShellGraphicsApplication extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GraphicsContext context = JIGraphicsUtility.setUpGraphics(stage, "Random stuff", 700, 400 );
        context.setStroke(Color.RED);
        context.setLineWidth(5);
        context.strokeLine(75,60,250,60);
        context.strokeLine(250, 60, 250, 160);
        context.setFill(Color.AQUAMARINE);
        context.fillRect(400, 200, 75, 50);
        
        context.setStroke(Color.PEACHPUFF);
        context.setLineWidth(2);
        context.strokeRect(200, 200, 75, 50);
        
        Random rand = new Random();
        int red = rand.nextInt(256);
        int green = rand.nextInt(256);
        int blue = rand.nextInt(256);
        
        int endX = rand.nextInt((int) stage.getWidth());
        int endY = rand.nextInt((int) stage.getHeight());
        
        context.strokeLine(0,0, endX, endY);
        
        
        Color color = Color.rgb(red, green, blue);
        
        context.setFill(color);
        
        context.fillOval(15, 150, 85, 30);
        
        context.setStroke(color);
        context.strokeLine(0, 0, 700, 400);
        String message = "how much wood would a woodchuck chuck if a wood "
                + "chuck could chuck wood";
        Font font = new Font(12);
        context.setFont(font);
        context.fillText(message, endX, endY);
        context.strokeText(message, endX, endY);
        int x = 275;
        int y = 100;
        context.setFill(Color.CORAL);
        context.fillOval(x, y+20, 120, 160);
        context.setFill(Color.GOLDENROD);
        context.fillRect(x+30, y, 60, 30);
        context.setStroke(Color.DARKGOLDENROD);
        context.setLineWidth(3.1);
        context.strokeLine(x, y+30, x+120, y+30);
        context.setFill(Color.WHITE);
        context.fillRect(0,0, 699, 399);
        
        int startX = 175;
        int startY = 120;
        context.setFill(color);
        context.beginPath();
        context.moveTo(startX, startY);
        context.lineTo(startX -50, startY + 175);
        context.lineTo(startX + 50, startY + 175);
        context.closePath();
        
        context.setStroke(Color.CRIMSON);
        context.stroke();
        
        
        
        // Drawing code goes here
    }
}
