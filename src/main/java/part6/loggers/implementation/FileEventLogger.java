package part6.loggers.implementation;

import org.apache.commons.io.FileUtils;
import part6.loggers.EventLogger;
import part6.models.Event;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * 04.12.2017
 *
 * @author Robert Bagramov.
 */
public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void init() throws IOException {
        file = new File(fileName);
        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file " + fileName);
        } else if (!file.exists()) {
            file.createNewFile();
        }
    }

}
