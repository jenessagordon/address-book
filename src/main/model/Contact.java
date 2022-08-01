package model;

import org.json.JSONObject;
import persistence.Writeable;

// Represents a contact containing the contact’s full name, address, phone number, email, and birthday, along with the
// date the user added the contact to the contact list, where the user met the contact, and what Category the contact
// is in. Category represents the type of the contact, and is one of: FAMILY, FRIEND, WORK, or OTHER.
public class Contact implements Writeable {
    private String fullName;
    private String address;
    private String phoneNum;
    private String email;
    private String birthday;
    private String dateAdded;
    private String locationMet;
    private Category category;

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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("fullName", fullName);
        json.put("address", address);
        json.put("phoneNum", phoneNum);
        json.put("email", email);
        json.put("birthday", birthday);
        json.put("dateAdded", dateAdded);
        json.put("locationMet", locationMet);
        json.put("category", category);
        return json;
    }
}
