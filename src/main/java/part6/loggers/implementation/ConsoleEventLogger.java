package part6.loggers.implementation;

import part6.loggers.EventLogger;
import part6.models.Event;

/**
 * 04.12.2017
 *
 * @author Robert Bagramov.
 */
public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
