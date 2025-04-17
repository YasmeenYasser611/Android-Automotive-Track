import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import java.io.*;


public class Notepad extends Application
{

    BorderPane bpane;
    MenuBar mbar;
    Menu file, edit, help;
    MenuItem New, Open , save_l , Open_l ,  Save, Exit;
    MenuItem Undo, Cut, Copy, Paste, Delete, SelectAll;
    MenuItem Help;
    TextArea ta;
    FileChooser OpenfileChooser;
    FileChooser SavefileChooser;
    FileChooser OpenfileChooser_l;
    FileChooser SavefileChooser_l;
    Alert alert;

    public void init() throws Exception 
    {
        super.init(); 
        ta= new TextArea();

        New=new MenuItem("New");
        New.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        Open=new MenuItem("Open");
        Open.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        Save=new MenuItem("Save");
        Save.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        
        Open_l=new MenuItem("Open_l");
        Open_l.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        save_l=new MenuItem("save_l");
        save_l.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));

        Exit=new MenuItem("Exit");
        Exit.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
        file=new Menu("File");
        file.getItems().addAll(New ,new SeparatorMenuItem() ,Open,new SeparatorMenuItem() , Save,new SeparatorMenuItem() ,   Open_l ,new SeparatorMenuItem() , save_l ,new SeparatorMenuItem(), Exit );
        
        Undo=new MenuItem("Undo");
        Undo.setAccelerator(KeyCombination.keyCombination("Ctrl+Z"));
        Cut=new MenuItem("Cut");
        Cut.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        Copy=new MenuItem("Copy");
        Copy.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        Paste=new MenuItem("Past");
        Paste.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));
        Delete=new MenuItem("Delete");
        Delete.setAccelerator(KeyCombination.keyCombination("Del"));
        SelectAll=new MenuItem("Select All");
        SelectAll.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        edit=new Menu("Edit");
        edit.getItems().addAll(Undo ,new SeparatorMenuItem(),Cut ,new SeparatorMenuItem(), Copy ,new SeparatorMenuItem(), Paste ,new SeparatorMenuItem(),Delete ,new SeparatorMenuItem(), SelectAll );
        
        Help=new MenuItem("About Notepad");
        Help.setAccelerator(KeyCombination.keyCombination("F1"));
        help=new Menu("Help");
        help.getItems().addAll(Help );
 
        
        mbar=new MenuBar();
        mbar.getMenus().addAll(file ,edit , help );
        
        bpane=new BorderPane();
        bpane.setTop(mbar);
        bpane.setCenter(ta);

      
        SavefileChooser = new FileChooser();
        SavefileChooser.setTitle("Save");
      
        OpenfileChooser = new FileChooser();
        OpenfileChooser.setTitle("Open");

        SavefileChooser_l = new FileChooser();
        SavefileChooser_l.setTitle("Save");
      
        OpenfileChooser_l = new FileChooser();
        OpenfileChooser_l.setTitle("Open");
      

    }
    
    public void start(Stage primaryStage) throws Exception 
    {
        
        
        New.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
               ta.clear();
                
           }
        });
        Open.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
               
                File file = OpenfileChooser.showOpenDialog(primaryStage);
                if (file != null) 
                {
                try 
                {
                    FileInputStream fis = new FileInputStream(file);
                    DataInputStream dis = new DataInputStream(fis);
                    String data=dis.readUTF();
                    ta.setText(data);
                    dis.close();
                    fis.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
                }
           }
        });
        Save.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
                
               File file =SavefileChooser.showSaveDialog(primaryStage);
               if (file != null) 
                {
                try 
                {
                    FileOutputStream fos = new FileOutputStream(file);
                    DataOutputStream dos = new DataOutputStream(fos);
                    dos.writeUTF(ta.getText());
                    dos.flush();
                    dos.close();
                    fos.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
                }
                
           }
        });

        Open_l.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
               
                File file = OpenfileChooser_l.showOpenDialog(primaryStage);
                if (file != null) 
                {
                try 
                {
                    FileInputStream fis = new FileInputStream(file);
                    int size = fis.available();
                    byte [] b = new byte[size];
                    fis.read(b);
                    ta.setText(new String(b));
                    fis.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
                }
           }
        });
        save_l.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
                
               File file =SavefileChooser_l.showSaveDialog(primaryStage);
               if (file != null) 
                {
                try 
                {
                    FileOutputStream fos = new FileOutputStream(file);
                    byte[] b = ta.getText().getBytes();
                    fos.write(b);
                    fos.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
                }
                
           }
        });


        Exit.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
               Platform.exit();
                
           }
        });
        Undo.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
               
                ta.undo();
           }
        });
        Cut.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
                ta.cut();
                
            }
        });
        Copy.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
               
                ta.copy();
            }
        });
        Paste.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
               
                ta.paste();
            }
        });
        Delete.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
               
                ta.deleteText(ta.getSelection());
            }
        });
        SelectAll.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
               
                ta.selectAll();
            }
        });
        Help.setOnAction(new EventHandler<ActionEvent>()
        {
            
            public void handle(ActionEvent event) 
            {
               
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("About Notepad");
                    alert.setHeaderText("Yasmeen's Notepad");
                    alert.setContentText("Developer: Yasmeen\n Version: 1.0 \nContact: yasmeenyasser611@gmail.com");
                    alert.showAndWait();
           }
        });


        Scene myS=new Scene(bpane,500,200);
        primaryStage.setScene(myS);
        primaryStage.setTitle("Yasmeen Notepad");
        primaryStage.initStyle(StageStyle.DECORATED); 
        primaryStage.show();
        
       
    }

    public static void main(String[] args) 
    {
        
        Application.launch(args);
        
    }
    
}

