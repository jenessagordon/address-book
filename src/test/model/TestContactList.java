package model;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestContactList {
    private ContactList testContactList;
    private Contact testContact1;
    private Contact testContact2;
    private Contact testContact3;
    private Contact testContact4;
    private Contact testContact5;
    private ArrayList<Contact> testListOfContacts = new ArrayList<>();
    private String testListOfContactsToStringResult;
    private String testContact3ContactToStringResult;
    private String testContact4ContactToStringResult;

    // TODO: reduce duplication in this class

    @BeforeEach
    public void setUp() {
        testContactList = new ContactList();
        testContact1 = new Contact(
                "Molly Brown",
                "178 Turner Road, Vancouver, BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
        testContact2 = new Contact(
                "Bob Li",
                "1345 Blankar Terrace, Edmonton, AB, H7T 9P4",
                "(403) 124-6784",
                "bobli@gmail.com",
                "November 16, 1999",
                "May 1, 2022",
                "Business conference",
                Contact.Category.WORK);
        testContact3 = new Contact(
                "Julie Allo",
                "4 Ruffert Street, Kelowna, BC, A5T 2Y6",
                "(604) 854-4397",
                "julieallow@gmail.com",
                "",
                "June 3, 2021",
                "The hospital",
                Contact.Category.OTHER);
        testContact4 = new Contact(
                "",
                "56 Singer Crescent, Canmore, AB, R3E 8I4",
                "(403) 223-3421",
                "hair@thehairplace.com",
                "",
                "March 27, 2021",
                "",
                Contact.Category.OTHER);
        testContact5 = new Contact(
                "Pete Hamilton",
                "21 Throllalach Way, Vancouver, BC, N2D 7H1",
                "(403) 893-2343",
                "peteham@hotmail.com",
                "July 7, 1970",
                "October 16, 2007",
                "",
                Contact.Category.FAMILY);
        testListOfContactsToStringResult = "\n" + "Full name: " + "Pete Hamilton" + "\n"
                + "Address: " + "21 Throllalach Way, Vancouver, BC, N2D 7H1" + "\n"
                + "Phone number: " + "(403) 893-2343" + "\n"
                + "Email: " + "peteham@hotmail.com" + "\n"
                + "Birthday: " + "July 7, 1970" + "\n"
                + "Date added: " + "October 16, 2007" + "\n"
                + "Location met: " + "" + "\n"
                + "Category: " + Contact.Category.FAMILY + "\n"
                + "-------------------"
                + "\n" + "Full name: " + "Molly Brown" + "\n"
                + "Address: " + "178 Turner Road, Vancouver, BC, V8L 9E2" + "\n"
                + "Phone number: " + "(604) 902-3789" + "\n"
                + "Email: " + "mollybrown@gmail.com" + "\n"
                + "Birthday: " + "January 9, 2000" + "\n"
                + "Date added: " + "July 21, 2022" + "\n"
                + "Location met: " + "Walter Gage" + "\n"
                + "Category: " + Contact.Category.FRIEND + "\n"
                + "-------------------"
                + "\n" + "Full name: " + "Bob Li" + "\n"
                + "Address: " + "1345 Blankar Terrace, Edmonton, AB, H7T 9P4" + "\n"
                + "Phone number: " + "(403) 124-6784" + "\n"
                + "Email: " + "bobli@gmail.com" + "\n"
                + "Birthday: " + "November 16, 1999" + "\n"
                + "Date added: " + "May 1, 2022" + "\n"
                + "Location met: " + "Business conference" + "\n"
                + "Category: " + Contact.Category.WORK + "\n"
                + "-------------------"
                + "\n" + "Full name: " + "Julie Allo" + "\n"
                + "Address: " + "4 Ruffert Street, Kelowna, BC, A5T 2Y6" + "\n"
                + "Phone number: " + "(604) 854-4397" + "\n"
                + "Email: " + "julieallow@gmail.com" + "\n"
                + "Birthday: " + "" + "\n"
                + "Date added: " + "June 3, 2021" + "\n"
                + "Location met: " + "The hospital" + "\n"
                + "Category: " + Contact.Category.OTHER + "\n"
                + "-------------------"
                + "\n" + "Full name: " + "" + "\n"
                + "Address: " + "56 Singer Crescent, Canmore, AB, R3E 8I4" + "\n"
                + "Phone number: " + "(403) 223-3421" + "\n"
                + "Email: " + "hair@thehairplace.com" + "\n"
                + "Birthday: " + "" + "\n"
                + "Date added: " + "March 27, 2021" + "\n"
                + "Location met: " + "" + "\n"
                + "Category: " + Contact.Category.OTHER + "\n"
                + "-------------------";
        testContact3ContactToStringResult = "Full name: " + "Julie Allo" + "\n"
                + "Address: " + "4 Ruffert Street, Kelowna, BC, A5T 2Y6" + "\n"
                + "Phone number: " + "(604) 854-4397" + "\n"
                + "Email: " + "julieallow@gmail.com" + "\n"
                + "Birthday: " + "" + "\n"
                + "Date added: " + "June 3, 2021" + "\n"
                + "Location met: " + "The hospital" + "\n"
                + "Category: " + Contact.Category.OTHER + "\n"
                + "-------------------";
        testContact4ContactToStringResult = "Full name: " + "" + "\n"
                + "Address: " + "56 Singer Crescent, Canmore, AB, R3E 8I4" + "\n"
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
        testListOfContacts.add(testContact1);
        testContactList.addContact("Molly Brown",
                "178 Turner Road, Vancouver, BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
        assertEquals(testListOfContacts, testContactList.getListOfContacts());
    }

    @Test
    public void testAddContactCumulative() {
        testListOfContacts.add(testContact1);
        testListOfContacts.add(testContact2);
        testContactList.addContact("Molly Brown",
                "178 Turner Road, Vancouver, BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
        testContactList.addContact("Bob Li",
                "1345 Blankar Terrace, Edmonton, AB, H7T 9P4",
                "(403) 124-6784",
                "bobli@gmail.com",
                "November 16, 1999",
                "May 1, 2022",
                "Business conference",
                Contact.Category.WORK);
        assertEquals(testListOfContacts, testContactList.getListOfContacts());
    }

    // removes a single Contact from a listOfContacts of size 1
    @Test
    public void testRemoveContactSingle() {
        testContactList.addContact("Molly Brown",
                "178 Turner Road, Vancouver, BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
        testContactList.removeContact("Molly Brown");
        assertEquals(testListOfContacts, testContactList.getListOfContacts());
    }

    // removes two Contacts from a listOfContacts of size 3
    @Test
    public void testRemoveContactCumulative() {
        testListOfContacts.add(testContact1);
        testContactList.addContact("Molly Brown",
                "178 Turner Road, Vancouver, BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
        testContactList.addContact("Bob Li",
                "1345 Blankar Terrace, Edmonton, AB, H7T 9P4",
                "(403) 124-6784",
                "bobli@gmail.com",
                "November 16, 1999",
                "May 1, 2022",
                "Business conference",
                Contact.Category.WORK);
        testContactList.addContact("Julie Allo",
                "4 Ruffert Street, Kelowna, BC, A5T 2Y6",
                "(604) 854-4397",
                "julieallow@gmail.com",
                "",
                "June 3, 2021",
                "The hospital",
                Contact.Category.OTHER);
        testContactList.removeContact("Bob Li");
        testContactList.removeContact("Julie Allo");
        assertEquals(testListOfContacts, testContactList.getListOfContacts());
    }

    @Test
    public void testListOfContactsToStringInOrder() {
        testContactList.addContact("Pete Hamilton",
                "21 Throllalach Way, Vancouver, BC, N2D 7H1",
                "(403) 893-2343",
                "peteham@hotmail.com",
                "July 7, 1970",
                "October 16, 2007",
                "",
                Contact.Category.FAMILY);
        testContactList.addContact("Molly Brown",
                "178 Turner Road, Vancouver, BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
        testContactList.addContact("Bob Li",
                "1345 Blankar Terrace, Edmonton, AB, H7T 9P4",
                "(403) 124-6784",
                "bobli@gmail.com",
                "November 16, 1999",
                "May 1, 2022",
                "Business conference",
                Contact.Category.WORK);
        testContactList.addContact("Julie Allo",
                "4 Ruffert Street, Kelowna, BC, A5T 2Y6",
                "(604) 854-4397",
                "julieallow@gmail.com",
                "",
                "June 3, 2021",
                "The hospital",
                Contact.Category.OTHER);
        testContactList.addContact("",
                "56 Singer Crescent, Canmore, AB, R3E 8I4",
                "(403) 223-3421",
                "hair@thehairplace.com",
                "",
                "March 27, 2021",
                "",
                Contact.Category.OTHER);
        assertEquals(testListOfContactsToStringResult,
                testContactList.listOfContactsToString());
    }

    @Test
    public void testListOfContactsToStringOutOfOrder() {
        testContactList.addContact("Molly Brown",
                "178 Turner Road, Vancouver, BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
        testContactList.addContact("Julie Allo",
                "4 Ruffert Street, Kelowna, BC, A5T 2Y6",
                "(604) 854-4397",
                "julieallow@gmail.com",
                "",
                "June 3, 2021",
                "The hospital",
                Contact.Category.OTHER);
        testContactList.addContact("",
                "56 Singer Crescent, Canmore, AB, R3E 8I4",
                "(403) 223-3421",
                "hair@thehairplace.com",
                "",
                "March 27, 2021",
                "",
                Contact.Category.OTHER);
        testContactList.addContact("Pete Hamilton",
                "21 Throllalach Way, Vancouver, BC, N2D 7H1",
                "(403) 893-2343",
                "peteham@hotmail.com",
                "July 7, 1970",
                "October 16, 2007",
                "",
                Contact.Category.FAMILY);
        testContactList.addContact("Bob Li",
                "1345 Blankar Terrace, Edmonton, AB, H7T 9P4",
                "(403) 124-6784",
                "bobli@gmail.com",
                "November 16, 1999",
                "May 1, 2022",
                "Business conference",
                Contact.Category.WORK);
        assertEquals(testListOfContactsToStringResult,
                testContactList.listOfContactsToString());
    }

    @Test
    public void testContactsOfCategoryToStringReturnEmptyString() {
        testContactList.addContact("Molly Brown",
                "178 Turner Road, Vancouver, BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
        testContactList.addContact("Bob Li",
                "1345 Blankar Terrace, Edmonton, AB, H7T 9P4",
                "(403) 124-6784",
                "bobli@gmail.com",
                "November 16, 1999",
                "May 1, 2022",
                "Business conference",
                Contact.Category.WORK);
        assertEquals("", testContactList.contactsOfCategoryToString(Contact.Category.FAMILY));
    }

    @Test
    public void testContactsOfCategoryToStringFindOnceInstance() {
        testContactList.addContact("Molly Brown",
                "178 Turner Road, Vancouver, BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
        testContactList.addContact("Bob Li",
                "1345 Blankar Terrace, Edmonton, AB, H7T 9P4",
                "(403) 124-6784",
                "bobli@gmail.com",
                "November 16, 1999",
                "May 1, 2022",
                "Business conference",
                Contact.Category.WORK);
        testContactList.addContact("Julie Allo",
                "4 Ruffert Street, Kelowna, BC, A5T 2Y6",
                "(604) 854-4397",
                "julieallow@gmail.com",
                "",
                "June 3, 2021",
                "The hospital",
                Contact.Category.OTHER);
        assertEquals("\n" + testContact3ContactToStringResult,
                testContactList.contactsOfCategoryToString(Contact.Category.OTHER));
    }

    @Test
    public void testContactsOfCategoryToStringFindTwoInstances() {
        testContactList.addContact("Molly Brown",
                "178 Turner Road, Vancouver, BC, V8L 9E2",
                "(604) 902-3789",
                "mollybrown@gmail.com",
                "January 9, 2000",
                "July 21, 2022",
                "Walter Gage",
                Contact.Category.FRIEND);
        testContactList.addContact("Bob Li",
                "1345 Blankar Terrace, Edmonton, AB, H7T 9P4",
                "(403) 124-6784",
                "bobli@gmail.com",
                "November 16, 1999",
                "May 1, 2022",
                "Business conference",
                Contact.Category.WORK);
        testContactList.addContact("Julie Allo",
                "4 Ruffert Street, Kelowna, BC, A5T 2Y6",
                "(604) 854-4397",
                "julieallow@gmail.com",
                "",
                "June 3, 2021",
                "The hospital",
                Contact.Category.OTHER);
        testContactList.addContact("",
                "56 Singer Crescent, Canmore, AB, R3E 8I4",
                "(403) 223-3421",
                "hair@thehairplace.com",
                "",
                "March 27, 2021",
                "",
                Contact.Category.OTHER);
        assertEquals("\n" + testContact3ContactToStringResult
                        + "\n" + testContact4ContactToStringResult,
                testContactList.contactsOfCategoryToString(Contact.Category.OTHER));
    }
}
