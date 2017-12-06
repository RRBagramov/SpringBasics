package part3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import part3.loggers.EventLogger;
import part3.models.Client;
import part3.models.Event;

/**
 * 27.11.2017
 *
 * @author Robert Bagramov.
 */
public class Application {
    private Client client;
    private EventLogger eventLogger;

    public Application(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(Event event) {
        String idReplaceToNameMsg = event.getMessage()
                .replaceAll(client.getId(), client.getName());
        event.setMessage(idReplaceToNameMsg);

        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("contextPart3.xml");

        Application app = (Application) context.getBean("application");

        Event event = (Event) context.getBean("event");
        Event event2 = (Event) context.getBean("event2");

        app.logEvent(event);
        app.logEvent(event2);
    }
}
