package com.example.demo2;

import java.io.IOException;
import java.io.Serializable;

public class State implements Serializable {
    private String Ask;
    private String Answer;

    public State(String Ask, String Answer) throws IOException {
        this.Ask = Ask;
        this.Answer = Answer;
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
}
