package model;

import java.util.ArrayList;
import java.util.List;

// Represents an arbitrarily-sized list of Contacts. INVARIANT: fullName of all contacts is unique.
public class ContactList {
    ArrayList<Contact> listOfContacts;

    // EFFECTS: creates a ContactList whose listOfContacts is an empty ArrayList
    public ContactList() {
        listOfContacts = new ArrayList<>();
    }

    // REQUIRES: any contact with the given fullName is not already in listOfContacts
    // MODIFIES: this
    // EFFECTS: adds Contact with given attributes to listOfContacts
    public void addContact(String fullName, String address,
                           String phoneNum, String email,
                           String birthday, String dateAdded,
                           String locationMet, Contact.Category category) {
        listOfContacts.add(new Contact(fullName, address, phoneNum, email, birthday, dateAdded, locationMet, category));
    }

    // REQUIRES: fullName is a fullName of exactly one contact in listOfContacts
    // MODIFIES: this
    // EFFECTS: removes Contact with given name from listOfContacts
    public void removeContact(String fullName) {
        listOfContacts.removeIf(c -> (c.getFullName() == fullName));
    }

    // EFFECTS: returns all Contacts in listOfContacts as a String, ordered by category: FAMILY->FRIEND->WORK->OTHER,
    // "" if none

    // ContactList.contactsOfCategoryToString gives:
    // empty line
    // CATEGORY1: result from Contact.contactToString (includes ----------)
    // empty line
    // CATEGORY1: result from Contact.contactToString (includes ----------)

    // so to combine multiple categories, we just combine each category to get
    // empty line
    // CATEGORY1: result from Contact.contactToString (includes ----------)
    // empty line
    // CATEGORY1: result from Contact.contactToString (includes ----------)
    // empty line
    // CATEGORY2: result from Contact.contactToString (includes ----------)
    public String listOfContactsToString() {
        return null; // stub
    }

    // EFFECTS: returns all Contacts in listOfContacts as a String, "" if none
    public String contactsOfCategoryToString(Contact.Category category) {
        return null; // stub
    }

    public ArrayList<Contact> getListOfContacts() {
        return listOfContacts;
    }

}
