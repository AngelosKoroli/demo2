package com.example.demo2;

import javafx.scene.image.Image;

public class User {

    private String firstName;
    private String lastName;
    private int grade;
    private Image image;

    public User(String firstName, String lastName, int grade, Image image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
