package ui;

// Code in this class inspired by/copied from https://github.students.cs.ubc.ca/CPSC210/TellerApp

import model.ContactList;

import java.util.Scanner;

// Address book application that lets user add Contacts, remove Contacts, and print all of their contacts to the
// console (ordered by Category)
public class AddressBook {
    private ContactList contactList;
    private Scanner input;

    // EFFECTS: runs the address book application
    public AddressBook() {
        runAddressBook();
    }

    // MODIFIES: this
    // EFFECTS: initializes a ContactList and processes user input
    private void runAddressBook() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("add")) {
            addContact();
        } else if (command.equals("delete")) {
            removeContact();
        } else if (command.equals("view")) {
            printAllContacts();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes contactList field, initializes input, and sets delimiter
    private void init() {
        contactList = new ContactList();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tadd -> add contact");
        System.out.println("\tdelete -> delete contact");
        System.out.println("\tview -> view contact");
        System.out.println("\tquit -> quit");
    }

    // MODIFIES: this
    // EFFECTS: adds Contact to contactList using input from user
    private void addContact() {
        // stub
    }

    // REQUIRES: user enters a string that matches the fullName of a Contact in listOfContacts
    // MODIFIES: this
    // EFFECTS: removes Contact with name specified by user from contactList's listOfContacts
    private void removeContact() {
        System.out.println("Enter the full name of the contact you wish to remove: ");
        String fullNameInput = input.next();
        contactList.removeContact(fullNameInput);
        System.out.println("Contact deleted successfully.");
    }

    // EFFECTS: prints list of all contacts, ordered by category; prints "" if contactList's listOfContacts is empty
    private void printAllContacts() {
        // stub
    }
}
