package model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TestContact extends TestModelAndPersistence {

    @Test
    public void testContact() {
        assertEquals("Molly Brown", testContact1.getFullName());
        assertEquals("178 Turner Road, Vancouver BC, V8L 9E2", testContact1.getAddress());
        assertEquals("(604) 902-3789", testContact1.getPhoneNum());
        assertEquals("mollybrown@gmail.com", testContact1.getEmail());
        assertEquals("January 9, 2000", testContact1.getBirthday());
        assertEquals("July 21, 2022", testContact1.getDateAdded());
        assertEquals("Walter Gage", testContact1.getLocationMet());
        assertEquals(Contact.Category.FRIEND, testContact1.getCategory());
    }
}