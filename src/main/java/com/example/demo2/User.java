package com.example.demo2;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    static ArrayList<User> allUsers;
    private String firstName;
    private String lastName;
    private int id;
    private Image image;

    public User(String firstName, String lastName, int id, Image image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.image = image;
        if (allUsers == null) {
            allUsers = new ArrayList<User>();
        }
        allUsers.add(this);
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

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String toString() {
        return "User: " + firstName + " " + lastName + " id: " + id;
    }

    static void saveUsers() {

    }

    static void restoreUsers() throws Exception {
        //Alexander, M'Kiri		Female	9193860
        
        File datafile = new File("StudentsData");
        Scanner datascanner = new Scanner(datafile);

        while (datascanner.hasNext()) {
            String line = datascanner.nextLine();
            System.out.println(line);
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("\t");
            String name = lineScanner.next();
            String lastName = name.substring(0, name.lastIndexOf(','));
            String firstName = name.substring(name.lastIndexOf(',') + 1, name.length());
            String skip1 = lineScanner.next();
            String gender = lineScanner.next();
            int id = lineScanner.nextInt();
            User newUser = new User(firstName, lastName, id, null);
            System.out.println(newUser);
        }
    }
}
