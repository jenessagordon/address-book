package persistence;

import model.Contact;
import model.ContactList;
import model.TestModelAndPersistence;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestJsonReader extends TestModelAndPersistence {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ContactList cl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyContactList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyContactList.json");
        try {
            ContactList cl = reader.read();
            assertEquals(0, cl.getListOfContacts().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralContactList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralContactList.json");
        try {
            ContactList cl = reader.read();
            List<Contact> listOfContacts = cl.getListOfContacts();
            assertEquals(2, listOfContacts.size());
            checkContact("Molly Brown",
                    "178 Turner Road, Vancouver BC, V8L 9E2",
                    "(604) 902-3789",
                    "mollybrown@gmail.com",
                    "January 9, 2000",
                    "July 21, 2022",
                    "Walter Gage",
                    Contact.Category.FRIEND,
                    listOfContacts.get(0));
            checkContact("Bob Li",
                    "1345 Blankar Terrace, Edmonton AB, H7T 9P4",
                    "(403) 124-6784",
                    "bobli@gmail.com",
                    "November 16, 1999",
                    "May 1, 2022",
                    "Business conference",
                    Contact.Category.WORK,
                    listOfContacts.get(1));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
