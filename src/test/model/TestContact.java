package model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TestContact {
    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact(
                "Molly Brown",
                "178 Turner Rd, Vancouver BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
    }

    @Test
    public void testContact() {
        assertEquals("Molly Brown", contact.getFullName());
        assertEquals("178 Turner Rd, Vancouver BC, V8L 9E2", contact.getAddress());
        assertEquals("(604) 902-3789", contact.getPhoneNum());
        assertEquals("mollybrown@gmail.com", contact.getEmail());
        assertEquals("January 9, 2000", contact.getBirthday());
        assertEquals("July 21, 2022", contact.getDateAdded());
        assertEquals("Walter Gage", contact.getLocationMet());
        assertEquals(Contact.Category.FRIEND, contact.getCategory());
    }
}