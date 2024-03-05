package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    HelloController2 cont;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 605);
        cont = fxmlLoader.getController();
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void stop() throws Exception {
        cont.saveData();
    }
    public static void main(String[] args) {
        launch();
    }
}