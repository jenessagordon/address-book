package persistence;

import model.Contact;
import model.ContactList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads ContactList from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads ContactList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ContactList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseContactList(jsonObject);
    }

    // EFFECTS: reads source file as String and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses ContactList from jsonObject and returns it
    private ContactList parseContactList(JSONObject jsonObject) {
        ContactList cl = new ContactList();
        addListOfContacts(cl, jsonObject);
        return cl;
    }

    // MODIFIES: cl
    // EFFECTS: parses Contacts from jsonObject and adds them to ContactList
    private void addListOfContacts(ContactList cl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("listOfContacts");
        for (Object json : jsonArray) {
            JSONObject nextContact = (JSONObject) json;
            addContact(cl, nextContact);
        }
    }

    // MODIFIES: cl
    // EFFECTS: parses Contact from jsonObject and adds it to ContactList
    private void addContact(ContactList cl, JSONObject jsonObject) {
        String fullName = jsonObject.getString("fullName");
        String address = jsonObject.getString("address");
        String phoneNum = jsonObject.getString("phoneNum");
        String email = jsonObject.getString("email");
        String birthday = jsonObject.getString("birthday");
        String dateAdded = jsonObject.getString("dateAdded");
        String locationMet = jsonObject.getString("locationMet");
        Contact.Category category = Contact.Category.valueOf(jsonObject.getString("category"));

        cl.addContact(fullName, address, phoneNum, email, birthday, dateAdded, locationMet, category);
    }
}
