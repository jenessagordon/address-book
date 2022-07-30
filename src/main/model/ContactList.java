package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Represents an arbitrarily-sized list of Contacts. INVARIANT: fullName of all contacts is unique.
public class ContactList {
    private List<Contact> listOfContacts;

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
        listOfContacts.removeIf(c -> (Objects.equals(c.getFullName(), fullName)));
    }

    // EFFECTS: returns all Contacts in listOfContacts as a String, ordered by category: FAMILY->FRIEND->WORK->OTHER,
    // "" if none
    public String listOfContactsToString() {
        return  contactsOfCategoryToString(Contact.Category.FAMILY)
                + contactsOfCategoryToString(Contact.Category.FRIEND)
                + contactsOfCategoryToString(Contact.Category.WORK)
                + contactsOfCategoryToString(Contact.Category.OTHER);
    }

    // EFFECTS: returns all Contacts of Category category in listOfContacts as a String, "" if none
    public String contactsOfCategoryToString(Contact.Category category) {
        StringBuilder acc = new StringBuilder();
        for (Contact c : listOfContacts) {
            if (Objects.equals(c.getCategory(), category)) {
                acc.append("\n").append(c.contactToString());
            }
        }
        return acc.toString();
    } //TODO investigate UI-relatedness

    public List<Contact> getListOfContacts() {
        return listOfContacts;
    }

}
