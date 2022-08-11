package model.exception;

/**
 * Represents the exception that can occur when
 * printing the event log. Code in this class inspired by/copied from
 * <a href="https://github.students.cs.ubc.ca/CPSC210/AlarmSystem/blob/047c12f321ec713fae1f1a5dfdb01688ea1df596/src/main/ca/ubc/cpsc210/alarm/model/exception/LogException.java">...</a>
 */
public class LogException extends Exception {
    public LogException() {
        super("Error printing log");
    }

    // EFFECTS: Constructs a new LogException with the specified detail message.
    public LogException(String msg) {
        super(msg);
    }
}