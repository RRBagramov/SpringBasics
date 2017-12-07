package part6.loggers;

import part6.models.Event;

/**
 * 03.12.2017
 *
 * @author Robert Bagramov.
 */
public interface EventLogger {
    void logEvent(Event event);
}
