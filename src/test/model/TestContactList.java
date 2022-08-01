package model;

import org.junit.jupiter.api.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class TestContactList extends TestModelAndPersistence {
    private ContactList testContactList;

    @BeforeEach
    public void setUp() {
        testContactList = new ContactList();
    }

    @Test
    public void testContactList() {
        assertEquals(0, testContactList.getListOfContacts().size());
    }

    @Test
    public void testAddContactSingle() {
        addTestContact1ToContactList(testContactList);
        assertEquals(1, testContactList.getListOfContacts().size());
        Contact contact1 = testContactList.getListOfContacts().get(0);
        assertTrue(contactFieldsEqual(testContact1, contact1));
    }

    @Test
    public void testAddContactCumulative() {
        addTestContact1ToContactList(testContactList);
        addTestContact2ToContactList(testContactList);
        assertEquals(2, testContactList.getListOfContacts().size());
        Contact contact1 = testContactList.getListOfContacts().get(0);
        assertTrue(contactFieldsEqual(testContact1, contact1));
        Contact contact2 = testContactList.getListOfContacts().get(1);
        assertTrue(contactFieldsEqual(testContact2, contact2));
    }

    // removes a single Contact from a listOfContacts of size 1
    @Test
    public void testRemoveContactSingle() {
        addTestContact1ToContactList(testContactList);
        testContactList.removeContact("Molly Brown");
        assertEquals(0, testContactList.getListOfContacts().size());
    }

    // removes two Contacts from a listOfContacts of size 3
    @Test
    public void testRemoveContactCumulative() {
        addTestContact1ToContactList(testContactList);
        addTestContact2ToContactList(testContactList);
        addTestContact3ToContactList(testContactList);
        testContactList.removeContact("Bob Li");
        testContactList.removeContact("Julie Allo");
        assertEquals(1, testContactList.getListOfContacts().size());
        Contact contact1 = testContactList.getListOfContacts().get(0);
        assertTrue(contactFieldsEqual(testContact1, contact1));
    }

    // TESTING HELPER METHOD(S) & TEST(S)

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
