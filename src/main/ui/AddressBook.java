package ui;

import model.Contact;
import model.ContactList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

// Address book application that lets user add Contacts, remove Contacts, and print all of their contacts to the
// console (ordered by Category). Code in this class inspired by/copied from
// https://github.students.cs.ubc.ca/CPSC210/TellerApp and https://github.students.cs.ubc.ca/CPSC210/
// JsonSerializationDemo/blob/d31979d8a993d63c3a8c13c8add7f9d1753777b6/src/main/ui/WorkRoomApp.java
public class AddressBook {
    private static final String JSON_STORE = "./data/contactList.json";
    private ContactList contactList;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the address book application
    public AddressBook() throws FileNotFoundException {
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
        contactList = new ContactList();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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

    // REQUIRES: stringCategoryInput is one of: "family", "friend", "work", or "other"
    // EFFECTS: returns Contact.Category corresponding to stringCategoryInput
    private Contact.Category stringToCategory(String stringCategoryInput) {
        if (Objects.equals(stringCategoryInput, "family")) {
            return Contact.Category.FAMILY;
        } else if (Objects.equals(stringCategoryInput, "friend")) {
            return Contact.Category.FRIEND;
        } else if (Objects.equals(stringCategoryInput, "work")) {
            return Contact.Category.WORK;
        } else {
            return Contact.Category.OTHER;
        }
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

    // EFFECTS: returns Contacts in contactList's listOfContacts as a String ordered by category:
    // FAMILY->FRIEND->WORK->OTHER, "" if none
    public String listOfContactsToString() {
        return  contactsOfCategoryToString(Contact.Category.FAMILY)
                + contactsOfCategoryToString(Contact.Category.FRIEND)
                + contactsOfCategoryToString(Contact.Category.WORK)
                + contactsOfCategoryToString(Contact.Category.OTHER);
    }

    // EFFECTS: returns all Contacts of Category category in contactList's listOfContacts as a String, "" if none
    public String contactsOfCategoryToString(Contact.Category category) {
        StringBuilder acc = new StringBuilder();
        for (Contact c : contactList.getListOfContacts()) {
            if (Objects.equals(c.getCategory(), category)) {
                acc.append("\n").append(contactToString(c));
            }
        }
        return acc.toString();
    }

    // EFFECTS: returns c as a String of the form “Full name: " + c.getFullName() + “\n" +
    // “Address: " + c.getAddress() + “\n" + … + “Category: " + c.getCategory() + "\n" +
    // “-------------------"
    public String contactToString(Contact c) {
        return "Full name: " + c.getFullName() + "\n"
                + "Address: " + c.getAddress() + "\n"
                + "Phone number: " + c.getPhoneNum() + "\n"
                + "Email: " + c.getEmail() + "\n"
                + "Birthday: " + c.getBirthday() + "\n"
                + "Date added: " + c.getDateAdded() + "\n"
                + "Location met: " + c.getLocationMet() + "\n"
                + "Category: " + c.getCategory() + "\n"
                + "-------------------";
    }

    // EFFECTS: saves contactList to file
    private void saveContactList() {
        try {
            jsonWriter.open();
            jsonWriter.write(contactList);
            jsonWriter.close();
            System.out.println("Saved contact list to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: assigns the ContactList read from file to contactList
    private void loadContactList() {
        try {
            contactList = jsonReader.read();
            System.out.println("Loaded contact list from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
