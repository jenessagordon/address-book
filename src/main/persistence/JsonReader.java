package persistence;

import model.ContactList;
import org.json.JSONObject;

import java.io.IOException;

// Represents a reader that reads ContactList from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        // stub
    }

    // EFFECTS: reads ContactList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ContactList read() throws IOException {
        return null; // stub
    }

    // EFFECTS: reads source file as String and returns it
    private String readFile(String source) throws IOException {
        return null; // stub
    }

    // EFFECTS: parses ContactList from jsonObject and returns it
    private ContactList parseContactList(JSONObject jsonObject) {
        return null; // stub
    }

    // MODIFIES: cl
    // EFFECTS: parses Contacts from jsonObject and adds them to ContactList
    private void addListOfContacts(ContactList cl, JSONObject jsonObject) {
        // stub
    }

    // MODIFIES: cl
    // EFFECTS: parses Contact from jsonObject and adds it to ContactList
    private void addContact(ContactList cl, JSONObject jsonObject) {
        // stub
    }
}
