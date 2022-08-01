package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestModelAndPersistence {
    public Contact testContact1 = new Contact(
            "Molly Brown",
            "178 Turner Road, Vancouver BC, V8L 9E2",
            "(604) 902-3789",
            "mollybrown@gmail.com",
            "January 9, 2000",
            "July 21, 2022",
            "Walter Gage",
            Contact.Category.FRIEND);
    public Contact testContact2 = new Contact(
            "Bob Li",
            "1345 Blankar Terrace, Edmonton AB, H7T 9P4",
            "(403) 124-6784",
            "bobli@gmail.com",
            "November 16, 1999",
            "May 1, 2022",
            "Business conference",
            Contact.Category.WORK);
    public Contact testContact3 = new Contact(
            "Julie Allo",
            "4 Ruffert Street, Kelowna BC, A5T 2Y6",
            "(604) 854-4397",
            "julieallow@gmail.com",
            "",
            "June 3, 2021",
            "The hospital",
            Contact.Category.OTHER);

    // MODIFIES: cl
    // EFFECTS: adds testContact1 to cl
    public void addTestContact1ToContactList(ContactList cl) {
        cl.addContact("Molly Brown",
                "178 Turner Road, Vancouver BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
    }

    // MODIFIES: cl
    // EFFECTS: adds testContact2 to cl
    public void addTestContact2ToContactList(ContactList cl) {
        cl.addContact("Bob Li",
                "1345 Blankar Terrace, Edmonton AB, H7T 9P4",
                "(403) 124-6784",
                "bobli@gmail.com",
                "November 16, 1999",
                "May 1, 2022",
                "Business conference",
                Contact.Category.WORK);
    }

    // MODIFIES: cl
    // EFFECTS: adds testContact3 to cl
    public void addTestContact3ToContactList(ContactList cl) {
        cl.addContact("Julie Allo",
                "4 Ruffert Street, Kelowna BC, A5T 2Y6",
                "(604) 854-4397",
                "julieallow@gmail.com",
                "",
                "June 3, 2021",
                "The hospital",
                Contact.Category.OTHER);
    }

    // EFFECTS: checks whether the given contact has all the given attributes
    protected void checkContact(String fullName, String address, String phoneNum, String email, String birthday,
                                String dateAdded, String locationMet, Contact.Category category, Contact contact) {
        assertEquals(fullName, contact.getFullName());
        assertEquals(fullName, contact.getFullName());
        assertEquals(fullName, contact.getFullName());
        assertEquals(fullName, contact.getFullName());
        assertEquals(fullName, contact.getFullName());
        assertEquals(fullName, contact.getFullName());
        assertEquals(fullName, contact.getFullName());
        assertEquals(category, contact.getCategory());
    }
}