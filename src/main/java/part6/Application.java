package part6;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import part6.loggers.EventLogger;
import part6.models.Client;
import part6.models.Event;

import java.util.Map;

/**
 * 04.12.2017
 *
 * @author Robert Bagramov.
 */
public class Application {
    private Client client;
    private EventLogger defaultEventLogger;
    private Map<EventType, EventLogger> loggers;

    public Application(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultEventLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(EventType type, Event event) {
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultEventLogger;
        }

        String idReplaceToNameMsg = event.getMessage()
                .replaceAll(client.getId(), client.getName());
        event.setMessage(idReplaceToNameMsg);

        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("contextPart8.xml");

        Application app = (Application) context.getBean("application");

        Event event = (Event) context.getBean("event");
        Event event2 = (Event) context.getBean("event2");

        app.logEvent(EventType.INFO, event);
        app.logEvent(EventType.ERROR, event2);

        context.close();
    }
}
