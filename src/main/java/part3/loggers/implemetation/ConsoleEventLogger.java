package part3.loggers.implemetation;

import part3.models.Event;
import part3.loggers.EventLogger;

/**
 * 27.11.2017
 *
 * @author Robert Bagramov.
 */
public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
