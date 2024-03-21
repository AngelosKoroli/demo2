package com.example.demo2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.*;

import static com.example.demo2.State.allStates;

public class HelloController2 {
    public TextField Statement;
    public Button Ask;
    public Button Answer;
    public Button logout;
    public TableView<State> tableView;
    public TableColumn<State, String> ask;
    public TableColumn<State, String> answer;
    public Boolean textPickedBoolean;

    public Label feedback;

    static User currentUser;


    public void initialize() throws Exception {
        System.out.println("The current user is: " + currentUser.getFirstName() + " " + currentUser.getLastName());
        State.restoreStates();

        ask.setCellValueFactory(new PropertyValueFactory<State, String>("ask"));
        ask.setCellFactory(TextFieldTableCell.forTableColumn());
        ask.setOnEditCommit(event -> {
            State cellData = event.getRowValue();
            cellData.setAsk(event.getNewValue());
        });

        answer.setCellValueFactory(new PropertyValueFactory<State, String>("answer"));
            /*    answer.setCellFactory(TextFieldTableCell.forTableColumn());

        answer.setOnEditCommit(event -> {
            State cellData = event.getRowValue();
            cellData.setAnswer(event.getNewValue());
        });
        */

    }

    public void StatementEntered() {
        textPickedBoolean = true;
    }

    public void AskButtonPressed() {
        State newQ =  new State(null, null,Statement.getText(),null);
        tableView.getItems().add(newQ);
        Statement.setText(null);
        textPickedBoolean = false;
    }

    public void AnswerButtonPressed() {
        if (tableView.getSelectionModel().getSelectedItem() == null) {
            feedback.setText("Select question row BEFORE answering.");
            return;
        }

        // which row is selected?
        State oldQ = tableView.getSelectionModel().getSelectedItem();
        oldQ.setAnswer(Statement.getText());
        feedback.setText("Question answered!");
        tableView.refresh();
    }

        public void LogOutButtonPressed(ActionEvent event) throws Exception {
        // Mr. Hernandez wrote this!
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void restoreData() throws Exception {
        File fileForData = new File("Angelos");
        FileInputStream inputStream = new FileInputStream(fileForData);
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
        Integer numOfSavedObjects = (Integer) objInputStream.readObject();
        for (int i = 0; i < numOfSavedObjects; i = i + 1) {
            State eachData = (State) objInputStream.readObject();
            tableView.getItems().add(eachData);
        }
        inputStream.close();
    }

    void saveData() throws Exception {
        File fileForData = new File("Angelos");
        FileOutputStream outputStream = new FileOutputStream(fileForData);
        ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
        objOutputStream.writeObject(tableView.getItems().size());
        for (State eachData : tableView.getItems()) {
            objOutputStream.writeObject(eachData);
        }
        objOutputStream.flush();
    }
}
