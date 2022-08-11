package ui;

import model.EventLog;
import model.exception.LogException;

/**
 * Defines behaviours that event log printers must support. Code in this class inspired by/copied from
 * <a href="https://github.students.cs.ubc.ca/CPSC210/AlarmSystem/blob/047c12f321ec713fae1f1a5dfdb01688ea1df596/src/main/ca/ubc/cpsc210/alarm/ui/LogPrinter.java">...</a>
 */
public interface LogPrinter {
    /**
     * Prints the log
     * @param el  the event log to be printed
     * @throws LogException when printing fails for any reason
     */
    void printLog(EventLog el) throws LogException;
}
