package ui;

import java.io.FileNotFoundException;

// Code in this class inspired by/copied from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/
// d31979d8a993d63c3a8c13c8add7f9d1753777b6/src/main/ui/Main.java
public class Main {
    public static void main(String[] args) {
        try {
            new AddressBook();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
