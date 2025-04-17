/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.clientapplication;


import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController 
{
    private Socket server;
    private DataInputStream dis;
    private PrintStream dos;

    @FXML
    private TextField tfeild;
    @FXML
    private Button button;
    @FXML
    private TextArea tarea;
    
    
public PrimaryController() {
    try {
        server = new Socket("127.0.0.1", 8008);
        dis = new DataInputStream(server.getInputStream());
        dos = new PrintStream(server.getOutputStream());

        new Thread(new Runnable() 
        {
            
            public void run() 
            {
                try {
                    while (true) {
                        String msg = dis.readLine();
                        if (msg == null) break;
                        
                        Platform.runLater(new Runnable() 
                        {
                           
                            public void run() 
                            {
                                tarea.appendText("Server: " + msg + "\n");
                            }
                        });
                    }
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }).start();
    } 
    catch (IOException e) 
    {
        e.printStackTrace();
    }

}

    @FXML
    private void SendHandler(ActionEvent event)  
    {
        String message = tfeild.getText();
        if (!message.isEmpty()) 
        {
            dos.println("Yasmeen: " + message);
            tarea.appendText("Me: " + message + "\n");
            tfeild.clear();
        }
        
    }
}
