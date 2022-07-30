package model;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class TestContactList {
    private ContactList testContactList;
    private Contact testContact1;
    private Contact testContact2;
    private Contact testContact3;
    private Contact testContact4;
    private Contact testContact5;
    private ArrayList<Contact> testListOfContacts;
    private String testListOfContactsToStringResult;
    private String testContact3ContactToStringResult;
    private String testContact4ContactToStringResult;

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
        testContact3 = new Contact(
                "Julie Allo",
                "4 Ruffert Street, Kelowna BC, A5T 2Y6",
                "(604) 854-4397",
                "julieallow@gmail.com",
                "",
                "June 3, 2021",
                "The hospital",
                Contact.Category.OTHER);
        testContact4 = new Contact(
                "",
                "56 Singer Crescent, Canmore AB, R3E 8I4",
                "(403) 223-3421",
                "hair@thehairplace.com",
                "",
                "March 27, 2021",
                "",
                Contact.Category.OTHER);
        testContact5 = new Contact(
                "Pete Hamilton",
                "21 Throllalach Way, Vancouver BC, N2D 7H1",
                "(403) 893-2343",
                "peteham@hotmail.com",
                "July 7, 1970",
                "October 16, 2007",
                "",
                Contact.Category.FAMILY);
        testListOfContacts = new ArrayList<>();
        testListOfContactsToStringResult = "\n" + "Full name: " + "Pete Hamilton" + "\n"
                + "Address: " + "21 Throllalach Way, Vancouver BC, N2D 7H1" + "\n"
                + "Phone number: " + "(403) 893-2343" + "\n"
                + "Email: " + "peteham@hotmail.com" + "\n"
                + "Birthday: " + "July 7, 1970" + "\n"
                + "Date added: " + "October 16, 2007" + "\n"
                + "Location met: " + "" + "\n"
                + "Category: " + Contact.Category.FAMILY + "\n"
                + "-------------------"
                + "\n" + "Full name: " + "Molly Brown" + "\n"
                + "Address: " + "178 Turner Road, Vancouver BC, V8L 9E2" + "\n"
                + "Phone number: " + "(604) 902-3789" + "\n"
                + "Email: " + "mollybrown@gmail.com" + "\n"
                + "Birthday: " + "January 9, 2000" + "\n"
                + "Date added: " + "July 21, 2022" + "\n"
                + "Location met: " + "Walter Gage" + "\n"
                + "Category: " + Contact.Category.FRIEND + "\n"
                + "-------------------"
                + "\n" + "Full name: " + "Bob Li" + "\n"
                + "Address: " + "1345 Blankar Terrace, Edmonton AB, H7T 9P4" + "\n"
                + "Phone number: " + "(403) 124-6784" + "\n"
                + "Email: " + "bobli@gmail.com" + "\n"
                + "Birthday: " + "November 16, 1999" + "\n"
                + "Date added: " + "May 1, 2022" + "\n"
                + "Location met: " + "Business conference" + "\n"
                + "Category: " + Contact.Category.WORK + "\n"
                + "-------------------"
                + "\n" + "Full name: " + "Julie Allo" + "\n"
                + "Address: " + "4 Ruffert Street, Kelowna BC, A5T 2Y6" + "\n"
                + "Phone number: " + "(604) 854-4397" + "\n"
                + "Email: " + "julieallow@gmail.com" + "\n"
                + "Birthday: " + "" + "\n"
                + "Date added: " + "June 3, 2021" + "\n"
                + "Location met: " + "The hospital" + "\n"
                + "Category: " + Contact.Category.OTHER + "\n"
                + "-------------------"
                + "\n" + "Full name: " + "" + "\n"
                + "Address: " + "56 Singer Crescent, Canmore AB, R3E 8I4" + "\n"
                + "Phone number: " + "(403) 223-3421" + "\n"
                + "Email: " + "hair@thehairplace.com" + "\n"
                + "Birthday: " + "" + "\n"
                + "Date added: " + "March 27, 2021" + "\n"
                + "Location met: " + "" + "\n"
                + "Category: " + Contact.Category.OTHER + "\n"
                + "-------------------";
        testContact3ContactToStringResult = "Full name: " + "Julie Allo" + "\n"
                + "Address: " + "4 Ruffert Street, Kelowna BC, A5T 2Y6" + "\n"
                + "Phone number: " + "(604) 854-4397" + "\n"
                + "Email: " + "julieallow@gmail.com" + "\n"
                + "Birthday: " + "" + "\n"
                + "Date added: " + "June 3, 2021" + "\n"
                + "Location met: " + "The hospital" + "\n"
                + "Category: " + Contact.Category.OTHER + "\n"
                + "-------------------";
        testContact4ContactToStringResult = "Full name: " + "" + "\n"
                + "Address: " + "56 Singer Crescent, Canmore AB, R3E 8I4" + "\n"
                + "Phone number: " + "(403) 223-3421" + "\n"
                + "Email: " + "hair@thehairplace.com" + "\n"
                + "Birthday: " + "" + "\n"
                + "Date added: " + "March 27, 2021" + "\n"
                + "Location met: " + "" + "\n"
                + "Category: " + Contact.Category.OTHER + "\n"
                + "-------------------";
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

    @Test
    public void setTestListOfContactsToStringEmpty() {
        assertEquals("",
                testContactList.listOfContactsToString());
    }

    @Test
    public void testListOfContactsToStringInOrder() {
        testContactListAddtestContact5();
        testContactListAddtestContact1();
        testContactListAddtestContact2();
        testContactListAddtestContact3();
        testContactListAddtestContact4();
        assertEquals(testListOfContactsToStringResult,
                testContactList.listOfContactsToString());
    }

    @Test
    public void testListOfContactsToStringOutOfOrder() {
        testContactListAddtestContact1();
        testContactListAddtestContact3();
        testContactListAddtestContact4();
        testContactListAddtestContact5();
        testContactListAddtestContact2();
        assertEquals(testListOfContactsToStringResult,
                testContactList.listOfContactsToString());
    }

    @Test
    public void testContactsOfCategoryToStringReturnEmptyString() {
        testContactListAddtestContact1();
        testContactListAddtestContact2();
        assertEquals("", testContactList.contactsOfCategoryToString(Contact.Category.FAMILY));
    }

    @Test
    public void testContactsOfCategoryToStringFindOnceInstance() {
        testContactListAddtestContact1();
        testContactListAddtestContact2();
        testContactListAddtestContact3();
        assertEquals("\n" + testContact3ContactToStringResult,
                testContactList.contactsOfCategoryToString(Contact.Category.OTHER));
    }

    @Test
    public void testContactsOfCategoryToStringFindTwoInstances() {
        testContactListAddtestContact1();
        testContactListAddtestContact2();
        testContactListAddtestContact3();
        testContactListAddtestContact4();
        assertEquals("\n" + testContact3ContactToStringResult
                        + "\n" + testContact4ContactToStringResult,
                testContactList.contactsOfCategoryToString(Contact.Category.OTHER));
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

    // MODIFIES: this, testContactList
    // EFFECTS: adds testContact4 to testContactList
    private void testContactListAddtestContact4() {
        testContactList.addContact("",
                "56 Singer Crescent, Canmore AB, R3E 8I4",
                "(403) 223-3421",
                "hair@thehairplace.com",
                "",
                "March 27, 2021",
                "",
                Contact.Category.OTHER);
    }

    // MODIFIES: this, testContactList
    // EFFECTS: adds testContact5 to testContactList
    private void testContactListAddtestContact5() {
        testContactList.addContact("Pete Hamilton",
                "21 Throllalach Way, Vancouver BC, N2D 7H1",
                "(403) 893-2343",
                "peteham@hotmail.com",
                "July 7, 1970",
                "October 16, 2007",
                "",
                Contact.Category.FAMILY);
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
    public void testcontactFieldsEqualReturnTrue() {
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
    public void testcontactFieldsEqualReturnFalse() {
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
