package ui;

import model.Contact;

import java.util.Scanner;

// Represents an address book application that lets user add Contacts, remove Contacts, and print all of their contacts
// to the console (ordered by Category). Code in this class inspired by/copied from
// https://github.students.cs.ubc.ca/CPSC210/TellerApp and https://github.students.cs.ubc.ca/CPSC210/
// JsonSerializationDemo/blob/d31979d8a993d63c3a8c13c8add7f9d1753777b6/src/main/ui/WorkRoomApp.java
public class CLI extends UI {
    private Scanner input;

    // EFFECTS: runs the address book application
    public CLI() {
        runAddressBook();
    }

    // MODIFIES: this
    // EFFECTS: initializes a ContactList and processes user input
    private void runAddressBook() {
        boolean keepGoing = true;
        String command;

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
        } else if (command.equals("save")) {
            saveContactList();
        } else if (command.equals("load")) {
            loadContactList();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes contactList field, initializes input, and sets delimiter
    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tadd -> add contact");
        System.out.println("\tdelete -> delete contact");
        System.out.println("\tview -> view contact");
        System.out.println("\tsave -> save contact list to file");
        System.out.println("\tload -> load contact list from file");
        System.out.println("\tquit -> quit");
    }

    // MODIFIES: this
    // EFFECTS: adds Contact to contactList using input from user
    private void addContact() {
        String fullNameInput = getFullNameInput();
        String addressInput = getAddressInput();
        String phoneNumInput = getPhoneNumInput();
        String emailInput = getEmailInput();
        String birthdayInput = getBirthdayInput();
        String dateAddedInput = getDateAddedInput();
        String locationMetInput = getLocationMetInput();
        Contact.Category categoryInput = getCategoryInput();

        contactList.addContact(fullNameInput, addressInput,
                phoneNumInput, emailInput,
                birthdayInput, dateAddedInput,
                locationMetInput, categoryInput);
        System.out.println("Contact added successfully!");
    }

    // EFFECTS: gets fullName input that the user wants to add to contactList
    private String getFullNameInput() {
        System.out.println("Enter the full name of the contact you wish to add:");
        return input.next();
    }

    // EFFECTS: gets address input that the user wants to add to contactList
    private String getAddressInput() {
        System.out.println("Enter the address:");
        return input.next();
    }

    // EFFECTS: gets phoneNum input that the user wants to add to contactList
    private String getPhoneNumInput() {
        System.out.println("Enter the phone number:");
        return input.next();
    }

    // EFFECTS: gets email input that the user wants to add to contactList
    private String getEmailInput() {
        System.out.println("Enter the email:");
        return input.next();
    }

    // EFFECTS: gets birthday input that the user wants to add to contactList
    private String getBirthdayInput() {
        System.out.println("Enter the birthday:");
        return input.next();
    }

    // EFFECTS: gets dateAdded input that the user wants to add to contactList
    private String getDateAddedInput() {
        System.out.println("Enter today's date:");
        return input.next();
    }

    // EFFECTS: gets locationMet input that the user wants to add to contactList
    private String getLocationMetInput() {
        System.out.println("Enter the name of the location where you met them:");
        return input.next();
    }

    // EFFECTS: gets category input that the user wants to add to contactList
    private Contact.Category getCategoryInput() {
        System.out.println("Enter a category that is one of 'family', 'friend', 'work', or 'other':");
        return stringToCategory(input.next());
    }

    // REQUIRES: user enters a string that matches the fullName of a Contact in listOfContacts
    // MODIFIES: this
    // EFFECTS: removes Contact with name specified by user from contactList's listOfContacts
    private void removeContact() {
        System.out.println("Enter the full name of the contact you wish to remove:");
        String fullNameInput = input.next();
        contactList.removeContact(fullNameInput);
        System.out.println("Contact deleted successfully.");
    }

    // EFFECTS: prints list of all contacts, ordered by category; prints "\n" if contactList's listOfContacts is empty
    private void printAllContacts() {
        System.out.println("YOUR CONTACT LIST:");
        System.out.println(listOfContactsToString());
    }
}
