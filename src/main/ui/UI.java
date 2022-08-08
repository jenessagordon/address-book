package ui;

import model.Contact;
import model.ContactList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class UI {
    protected static final String JSON_STORE = "./data/contactList.json";
    protected ContactList contactList = new ContactList();
    protected JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    protected JsonReader jsonReader = new JsonReader(JSON_STORE);

    // REQUIRES: stringCategoryInput is one of: "family", "friend", "work", or "other"
    // EFFECTS: returns Contact.Category corresponding to stringCategoryInput
    protected Contact.Category stringToCategory(String stringCategoryInput) {
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

    // EFFECTS: returns Contacts in contactList's listOfContacts as a String ordered by category:
    // FAMILY->FRIEND->WORK->OTHER, "" if none
    protected String listOfContactsToString() {
        return contactsOfCategoryToString(Contact.Category.FAMILY)
                + contactsOfCategoryToString(Contact.Category.FRIEND)
                + contactsOfCategoryToString(Contact.Category.WORK)
                + contactsOfCategoryToString(Contact.Category.OTHER);
    }

    // EFFECTS: returns all Contacts of Category category in contactList's listOfContacts as a String, "" if none
    private String contactsOfCategoryToString(Contact.Category category) {
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
    private String contactToString(Contact c) {
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
    protected void saveContactList() {
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
    protected void loadContactList() {
        try {
            contactList = jsonReader.read();
            System.out.println("Loaded contact list from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
