package part4.loggers;

import part4.models.Event;

/**
 * 03.12.2017
 *
 * @author Robert Bagramov.
 */
public interface EventLogger {
    void logEvent(Event event);
}
