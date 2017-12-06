package part3.loggers;

import part3.models.Event;

/**
 * 27.11.2017
 *
 * @author Robert Bagramov.
 */
public interface EventLogger {
    void logEvent(Event event);
}
