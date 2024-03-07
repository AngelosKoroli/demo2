package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 605);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void stop() throws Exception {
        User.saveUsers();
        State.saveStates();
    }
    //hi
    public static void main(String[] args) {
        launch();
    }
}