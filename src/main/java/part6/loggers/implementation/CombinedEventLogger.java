package part6.loggers.implementation;

import part6.loggers.EventLogger;
import part6.models.Event;

import java.util.Collection;

/**
 * 07.12.2017
 *
 * @author Robert Bagramov.
 */
public class CombinedEventLogger implements EventLogger {

    Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
