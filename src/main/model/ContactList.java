package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writeable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Represents an arbitrarily-sized list of Contacts. INVARIANT: fullName of all contacts is unique.
public class ContactList implements Writeable {
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

    public List<Contact> getListOfContacts() {
        return listOfContacts;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("listOfContacts", listOfContactsToJson());
        return json;
    }

    // EFFECTS: returns listOfContacts in this ContactList as a JSONArray
    private JSONArray listOfContactsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Contact c : listOfContacts) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }

}
