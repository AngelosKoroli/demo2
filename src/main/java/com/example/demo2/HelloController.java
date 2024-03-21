package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HelloController {

    public TextField firstName;
    public TextField lastName;
    public TextField idText;
    public Button loginButton;
    public Button selectFile;
    public Button bulletinBoard;
    public ImageView imageView;

    public void initialize() throws Exception {
        User.restoreUsers();
    }

    public void nameEntered(){

    }

    public void lastNameEntered() {

    }

    public void selectFile(ActionEvent event) throws FileNotFoundException {
        // Brandon is gonna do this !!!!
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage)(((Node)(event.getSource())).getScene().getWindow());
        File selectedFile = fileChooser.showOpenDialog(stage);
        Image selectedImage = new Image(new FileInputStream(selectedFile));
        imageView.setImage(selectedImage);
        System.out.println(selectedFile);
    }
    public void LogIn(){
        // abdi is gonna do this

        // identify user
        HelloController2.currentUser = User.allUsers.get(0);
        bulletinBoard.setDisable(false);
        //write code here
        int IDEntered = Integer.parseInt(idText.getText());
        for ( User eachUser: User.allUsers) {
               if (IDEntered == eachUser.getID()) {
                   HelloController2.currentUser = eachUser;
               }
        }
        firstName.setText(HelloController2.currentUser.getFirstName());
        lastName.setText(HelloController2.currentUser.getLastName());
        // auto fill first and last name:

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