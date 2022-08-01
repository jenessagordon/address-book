package persistence;

import model.Contact;
import model.ContactList;
import model.TestModelAndPersistence;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Code in this class inspired by/copied from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/
// d31979d8a993d63c3a8c13c8add7f9d1753777b6/src/test/persistence/JsonWriterTest.java
public class TestJsonWriter extends TestModelAndPersistence {

    @Test
    void testWriterInvalidFile() {
        try {
            ContactList cl = new ContactList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyContactList() {
        try {
            ContactList cl = new ContactList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyContactList.json");
            writer.open();
            writer.write(cl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyContactList.json");
            cl = reader.read();
            assertEquals(0, cl.getListOfContacts().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralContactList() {
        try {
            ContactList cl = new ContactList();
            addTestContact1ToContactList(cl);
            addTestContact2ToContactList(cl);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralContactList.json");
            writer.open();
            writer.write(cl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralContactList.json");
            cl = reader.read();
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
            fail("Exception should not have been thrown");
        }
    }
}
