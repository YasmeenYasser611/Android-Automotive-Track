/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.regester;

import com.mycompany.regester.database.DAO;
import com.mycompany.regester.database.UserDTO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author yasmeen
 */
public class RegisterController implements Initializable {


    @FXML
    private TextField mail;
    @FXML
    private TextField password;
    @FXML
    private Button register;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void RegisterHandle(ActionEvent event) 
    {
        String emailInput = mail.getText();
        String passwordInput = password.getText();

        if (emailInput.isEmpty() || passwordInput.isEmpty()) {
            showAlert("Error", "All fields are required.");
            return;
        }


        try 
        {
            DAO.register(new UserDTO(emailInput, passwordInput ));
            showAlert("Success", "Registration successful!");
        
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            showAlert("Error", "Registration failed. Try again.");
        }
    }
    
    @FXML
    private void BackHandler(ActionEvent event) throws IOException {
          App.setRoot("primary");
    }
    
    private void showAlert(String title, String message) 
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    
}
