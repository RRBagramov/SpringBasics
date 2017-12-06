package part2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 27.11.2017
 *
 * @author Robert Bagramov.
 */
public class Application {
    private Client client;
    private ConsoleEventLogger consoleEventLogger;

    public Application(Client client, ConsoleEventLogger consoleEventLogger) {
        this.client = client;
        this.consoleEventLogger = consoleEventLogger;
    }

    public void logEvent(String message) {
        String idReplaceToNameMsg = message
                .replaceAll(client.getId(), client.getName());
        consoleEventLogger.logEvent(idReplaceToNameMsg);
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("contextPart2.xml");

        Application app = (Application) context.getBean("application");

        app.logEvent("1: Ребята, давайте жить дружно!");

    }
}
