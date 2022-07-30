package model;

import org.junit.jupiter.api.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class TestContactList {
    private ContactList testContactList;
    private Contact testContact1;
    private Contact testContact2;

    @BeforeEach
    public void setUp() {
        testContactList = new ContactList();
        testContact1 = new Contact(
                "Molly Brown",
                "178 Turner Road, Vancouver BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
        testContact2 = new Contact(
                "Bob Li",
                "1345 Blankar Terrace, Edmonton AB, H7T 9P4",
                "(403) 124-6784",
                "bobli@gmail.com",
                "November 16, 1999",
                "May 1, 2022",
                "Business conference",
                Contact.Category.WORK);
    }

    @Test
    public void testContactList() {
        assertEquals(0, testContactList.getListOfContacts().size());
    }

    @Test
    public void testAddContactSingle() {
        testContactListAddtestContact1();
        assertEquals(1, testContactList.getListOfContacts().size());
        Contact contact1 = testContactList.getListOfContacts().get(0);
        assertTrue(contactFieldsEqual(testContact1, contact1));
    }

    @Test
    public void testAddContactCumulative() {
        testContactListAddtestContact1();
        testContactListAddtestContact2();
        assertEquals(2, testContactList.getListOfContacts().size());
        Contact contact1 = testContactList.getListOfContacts().get(0);
        assertTrue(contactFieldsEqual(testContact1, contact1));
        Contact contact2 = testContactList.getListOfContacts().get(1);
        assertTrue(contactFieldsEqual(testContact2, contact2));
    }

    // removes a single Contact from a listOfContacts of size 1
    @Test
    public void testRemoveContactSingle() {
        testContactListAddtestContact1();
        testContactList.removeContact("Molly Brown");
        assertEquals(0, testContactList.getListOfContacts().size());
    }

    // removes two Contacts from a listOfContacts of size 3
    @Test
    public void testRemoveContactCumulative() {
        testContactListAddtestContact1();
        testContactListAddtestContact2();
        testContactListAddtestContact3();
        testContactList.removeContact("Bob Li");
        testContactList.removeContact("Julie Allo");
        assertEquals(1, testContactList.getListOfContacts().size());
        Contact contact1 = testContactList.getListOfContacts().get(0);
        assertTrue(contactFieldsEqual(testContact1, contact1));
    }

    // TESTING HELPER METHOD(S) & TEST(S)

    // MODIFIES: this, testContactList
    // EFFECTS: adds testContact1 to testContactList
    private void testContactListAddtestContact1() {
        testContactList.addContact("Molly Brown",
                "178 Turner Road, Vancouver BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
    }

    // MODIFIES: this, testContactList
    // EFFECTS: adds testContact2 to testContactList
    private void testContactListAddtestContact2() {
        testContactList.addContact("Bob Li",
                "1345 Blankar Terrace, Edmonton AB, H7T 9P4",
                "(403) 124-6784",
                "bobli@gmail.com",
                "November 16, 1999",
                "May 1, 2022",
                "Business conference",
                Contact.Category.WORK);
    }

    // MODIFIES: this, testContactList
    // EFFECTS: adds testContact3 to testContactList
    private void testContactListAddtestContact3() {
        testContactList.addContact("Julie Allo",
                "4 Ruffert Street, Kelowna BC, A5T 2Y6",
                "(604) 854-4397",
                "julieallow@gmail.com",
                "",
                "June 3, 2021",
                "The hospital",
                Contact.Category.OTHER);
    }

    // EFFECTS: return true iff the contents of all the fields of both Contacts are equal
    private boolean contactFieldsEqual(Contact contactA, Contact contactB) {
        return Objects.equals(contactA.getFullName(), contactB.getFullName())
                && Objects.equals(contactA.getAddress(), contactB.getAddress())
                && Objects.equals(contactA.getPhoneNum(), contactB.getPhoneNum())
                && Objects.equals(contactA.getEmail(), contactB.getEmail())
                && Objects.equals(contactA.getBirthday(), contactB.getBirthday())
                && Objects.equals(contactA.getDateAdded(), contactB.getDateAdded())
                && Objects.equals(contactA.getLocationMet(), contactB.getLocationMet())
                && Objects.equals(contactA.getCategory(), contactB.getCategory());
    }

    @Test
    public void testContactFieldsEqualReturnTrue() {
        Contact contactFieldsEqualTestContact1 = new Contact(
                "Molly Brown",
                "178 Turner Road, Vancouver BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
        assertTrue(contactFieldsEqual(testContact1, contactFieldsEqualTestContact1));
    }

    @Test
    public void testContactFieldsEqualReturnFalse() {
        Contact contactFieldsEqualTestContact1 = new Contact(
                "Molly Brown",
                "178 Turner Road, Vancouver BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.OTHER);
        assertFalse(contactFieldsEqual(testContact1, contactFieldsEqualTestContact1));
    }
}
