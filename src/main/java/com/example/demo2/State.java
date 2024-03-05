package com.example.demo2;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class State implements Serializable {
    static ArrayList<State> allStates;
    private User Asker;
    private User Responder;
    private String Ask;
    private String Answer;

    public State(User asker, User responder, String ask, String answer) {
        Asker = asker;
        Responder = responder;
        Ask = ask;
        Answer = answer;
        if (allStates == null) {
            allStates = new ArrayList<State>();
        }
        allStates.add(this);
    }

    public User getAsker() {
        return Asker;
    }

    public void setAsker(User asker) {
        Asker = asker;
    }

    public User getResponder() {
        return Responder;
    }

    public void setResponder(User responder) {
        Responder = responder;
    }

    public String getAsk() {
        return Ask;
    }

    public void setAsk(String ask) {
        Ask = ask;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    static void saveStates() {

    }

    static void restoreStates() {

    }

}