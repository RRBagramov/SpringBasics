package part4.loggers.implementation;

import part4.loggers.EventLogger;
import part4.models.Event;

import java.util.List;

/**
 * 06.12.2017
 *
 * @author Robert Bagramov.
 */
public class CacheFileEventLogger extends FileEventLogger implements EventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for (Event event:cache) {
            super.logEvent(event);
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }

    public void setCache(List<Event> cache) {
        this.cache = cache;
    }
}
