package com.mycompany.regester;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


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
public class LoginController implements Initializable {


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
    private void LoginHandle(ActionEvent event) 
    {
    String emailInput = mail.getText();
    String passwordInput = password.getText();

    if (emailInput.isEmpty() || passwordInput.isEmpty()) 
    {
        showAlert("Error", "All fields are required.");
        return;
    }

    try 
    {
        boolean success = DAO.login(new UserDTO(emailInput, passwordInput));

        if (success) 
        {
            showAlert("Success", "Login successful!");
           
        } 
        else 
        {
            showAlert("Error", "Invalid email or password.");
        }
    } 
    catch (SQLException ex) {
        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        showAlert("Error", "Login failed due to a database error.");
    }
}

    private void showAlert(String title, String message) 
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void BackHandler(ActionEvent event) throws IOException {
          App.setRoot("primary");
    }

}
