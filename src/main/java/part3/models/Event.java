package part3.models;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 27.11.2017
 *
 * @author Robert Bagramov.
 */
public class Event {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private int id;
    private String message;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.id = AUTO_ID.getAndIncrement();

        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "id = " + id + "\n" +
                "message='" + message + '\'' + "\n" +
                "date = " + dateFormat.format(date) + "\n";
    }
}
