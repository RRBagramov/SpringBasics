package part1;

/**
 * 27.11.2017
 *
 * @author Robert Bagramov.
 */
public class Application {
    private Client client;
    private ConsoleEventLogger consoleEventLogger;

    public void logEvent(String message) {
        String idReplaceToNameMsg = message
                .replaceAll(client.getId(), client.getName());
        consoleEventLogger.logEvent(idReplaceToNameMsg);
    }

    public static void main(String[] args) {
        Application app = new Application();

        app.client = new Client("1", "Винни-Пух");
        app.consoleEventLogger = new ConsoleEventLogger();

        app.logEvent("1: Воздушным шаром можно кого хочешь утешить.");
    }
}
