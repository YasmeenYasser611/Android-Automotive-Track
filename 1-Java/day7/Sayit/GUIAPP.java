import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GUIAPP extends Application
{

    
    
    BorderPane bpane;
    MenuBar mbar;
    Menu file;
    MenuItem sayit;
    TextArea ta;
    
      @Override
    public void init() throws Exception {
        super.init(); 
        ta= new TextArea();
        sayit=new MenuItem("Say It");
        
        file=new Menu("File");
        file.getItems().addAll(sayit);
        
        mbar=new MenuBar();
        mbar.getMenus().addAll(file);
        bpane=new BorderPane();
        bpane.setTop(mbar);
        bpane.setCenter(ta);

    }
    
    
    
    public static void main(String[] args) {
        
        Application.launch(args);
        
    }

  

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Node
        sayit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) 
            {
               
                System.out.println(ta.getText());
           }
        });
        Scene myS=new Scene(bpane,500,200);
        primaryStage.setScene(myS);
        primaryStage.setTitle("ES45 Notepad");
        primaryStage.show();
        
       
    }
    
}
