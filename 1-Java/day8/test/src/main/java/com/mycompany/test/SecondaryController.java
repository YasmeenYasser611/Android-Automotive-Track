package com.mycompany.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class SecondaryController {

    @FXML
    private MenuItem New;
    @FXML
    private MenuItem open;
    @FXML
    private MenuItem open_l;
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem save_l;
    @FXML
    private MenuItem exit;
    @FXML
    private MenuItem undo;
    @FXML
    private MenuItem cut;
    @FXML
    private MenuItem copy;
    @FXML
    private MenuItem past;
    @FXML
    private MenuItem delete;
    @FXML
    private MenuItem select_all;
    @FXML
    private MenuItem about;
    @FXML
    private TextArea ta;

     @FXML
    private void NewHandle(ActionEvent event)  {
         ta.clear();
        
    }
     @FXML
    private void openHandle(ActionEvent event)  {
        FileChooser OpenfileChooser = new FileChooser();
        OpenfileChooser.setTitle("Open");          
        File file = OpenfileChooser.showOpenDialog(null);
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
     @FXML
    private void saveHandle(ActionEvent event)  {
        FileChooser SavefileChooser = new FileChooser();
        SavefileChooser.setTitle("Save");                
File file =SavefileChooser.showSaveDialog(null);
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
     @FXML
    private void save_lHandle(ActionEvent event) {
            
                FileChooser SavefileChooser_l = new FileChooser();
        SavefileChooser_l.setTitle("Save");
               File file =SavefileChooser_l.showSaveDialog(null);
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
     @FXML
    private void exitHandle(ActionEvent event)  {
        Platform.exit();
    }
     @FXML
    private void undoHandle(ActionEvent event) {
        ta.undo();
    }
     @FXML
    private void cutHandle(ActionEvent event)  {
        ta.cut();
    }
 @FXML
    private void copyHandle(ActionEvent event)  {
        ta.copy();
    }
     @FXML
    private void pastHandle(ActionEvent event)  {
        ta.paste();
    }
     @FXML
    private void deleteHandle(ActionEvent event) {
        ta.deleteText(ta.getSelection());
    }
     @FXML
    private void select_allHandle(ActionEvent event)  {
        ta.selectAll();
    }
     @FXML
    private void aboutHandle(ActionEvent event)  {
  
                   Alert  alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("About Notepad");
                    alert.setHeaderText("Yasmeen's Notepad");
                    alert.setContentText("Developer: Yasmeen\n Version: 1.0 \nContact: yasmeenyasser611@gmail.com");
                    alert.showAndWait();
           }

    @FXML
    private void open_lHandle(ActionEvent event) {
    
            
        FileChooser OpenfileChooser_l = new FileChooser();
        OpenfileChooser_l.setTitle("Open");    
                File file = OpenfileChooser_l.showOpenDialog(null);
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



}