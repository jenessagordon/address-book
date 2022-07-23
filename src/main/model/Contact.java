package model;

public class Contact {

    public enum Category {
        FAMILY, FRIEND, WORK, OTHER
    }

    // EFFECTS: creates a Contact with the given attributes
    public Contact(String fullName, String address,
                   String phoneNum, String email,
                   String birthday, String dateAdded,
                   String locationMet, Category category) {
        // stub
    }

    // EFFECTS: returns this as a String of the form “Full name: " + fullName + “\n" +
    // “Address: " + address + “\n" + … + “Category: " + category + "\n" +
    // “-------------------"
    public String contactToString() {
        return null; // stub
    }

    public String getFullName() {
        return null; // stub
    }

    public String getAddress() {
        return null; // stub
    }

    public String getPhoneNum() {
        return null; // stub
    }

    public String getEmail() {
        return null; // stub
    }

    public String getBirthday() {
        return null; // stub
    }

    public String getDateAdded() {
        return null; // stub
    }

    public String getLocationMet() {
        return null; // stub
    }

    public Category getCategory() {
        return null; // stub
    }
}
