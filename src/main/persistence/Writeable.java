package persistence;

import org.json.JSONObject;

// Code in this class inspired by/copied from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/
// d31979d8a993d63c3a8c13c8add7f9d1753777b6/src/main/persistence/Writable.java
public interface Writeable {
    // EFFECTS: returns this as a JSON object
    JSONObject toJson();
}
