package persistence;

import model.Contact;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJson {
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
