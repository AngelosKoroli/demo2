package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloController {

    public TextField firstName;
    public TextField lastName;
    public TextField grade;
    public Button createUser;
    public Button selectFile;
    public Button bulletinBoard;
    public ImageView imageView;

    public void initialize() throws Exception {
        User.restoreUsers();
    }

    public void nameEntered(){

    }

    public void lastNameEntered(){

    }
    public void gradeEntered(){

    }
    public void selectFile(){

    }
    public void userCreate(){

    }
    public void bbButtonPress(ActionEvent event) throws Exception {
        // Mr. Hernandez wrote this!
        Parent root = FXMLLoader.load(getClass().getResource("View2.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}