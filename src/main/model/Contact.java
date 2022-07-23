package model;

import java.util.Objects;

// Represents a contact containing the contact’s full name, address, phone number, email, and birthday, along with the
// date the user added the contact to the contact list, where the user met the contact, and what Category the contact
// is in. Category represents the type of the contact, and is one of: FAMILY, FRIEND, WORK, or OTHER.
public class Contact {
    String fullName;
    String address;
    String phoneNum;
    String email;
    String birthday;
    String dateAdded;
    String locationMet;
    Category category;

    public enum Category {
        FAMILY, FRIEND, WORK, OTHER
    }

    // EFFECTS: creates a Contact with the given attributes
    public Contact(String fullName,
                   String address,
                   String phoneNum,
                   String email,
                   String birthday,
                   String dateAdded,
                   String locationMet,
                   Category category) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNum = phoneNum;
        this.email = email;
        this.birthday = birthday;
        this.dateAdded = dateAdded;
        this.locationMet = locationMet;
        this.category = category;
    }

    // EFFECTS: returns this as a String of the form “Full name: " + fullName + “\n" +
    // “Address: " + address + “\n" + … + “Category: " + category + "\n" +
    // “-------------------"
    public String contactToString() {
        return "Full name: " + fullName + "\n"
                + "Address: " + address + "\n"
                + "Phone number: " + phoneNum + "\n"
                + "Email: " + email + "\n"
                + "Birthday: " + birthday + "\n"
                + "Date added: " + dateAdded + "\n"
                + "Location met: " + locationMet + "\n"
                + "Category: " + category + "\n"
                + "-------------------";
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getLocationMet() {
        return locationMet;
    }

    public Category getCategory() {
        return category;
    }
}
