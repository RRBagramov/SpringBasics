package part4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import part4.loggers.EventLogger;
import part4.models.Client;
import part4.models.Event;

/**
 * 04.12.2017
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
        //Другой интерфейс -ConfigurableApplicationContext контекста, у которого есть метод close()
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("contextPart4.xml");

        Application app = (Application) context.getBean("application");

        Event event = (Event) context.getBean("event");
        Event event2 = (Event) context.getBean("event2");

        app.logEvent(event);
        app.logEvent(event2);

        context.close();
    }
}
