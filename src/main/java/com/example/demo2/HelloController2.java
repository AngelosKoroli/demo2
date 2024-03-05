package com.example.demo2;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.*;

public class HelloController2 {
    public TextField Statement;
    public Button Ask;
    public Button Answer;
    public TableView<State> tableView;
    public TableColumn<State, String> ask;
    public TableColumn<State, String> answer;

    public void initialize() throws Exception {
        if(false) {
            this.restoreData();
        }
        ask.setCellValueFactory(new PropertyValueFactory<State, String>("ask"));
        ask.setCellFactory(TextFieldTableCell.forTableColumn());
        ask.setOnEditCommit(event -> {
            State cellData = event.getRowValue();
            cellData.setAsk(event.getNewValue());
        });

        answer.setCellValueFactory(new PropertyValueFactory<State, String>("answer"));
        answer.setCellFactory(TextFieldTableCell.forTableColumn());
        answer.setOnEditCommit(event -> {
            State cellData = event.getRowValue();
            cellData.setAnswer(event.getNewValue());
        });


    }

    public void StatementEntered() {

    }

    public void AskButtonPressed() {

    }

    public void AnswerButtonPressed() {

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
