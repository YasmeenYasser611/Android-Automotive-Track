import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Guiapp extends Application 
{
    
    public void start(Stage primaryStage) throws Exception 
    {
        Text t = new Text("Hello es 45");
        FlowPane f = new FlowPane(t);
        Scene mys = new Scene(f,200, 200);

        primaryStage.setScene(mys);
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        Application.launch(args);
    }
}

