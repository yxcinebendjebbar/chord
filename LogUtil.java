import java.util.logging.*;

public class LogUtil {
    public static Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);
        logger.setUseParentHandlers(false);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.INFO);

        logger.addHandler(handler);
        logger.setLevel(Level.INFO);
        return logger;
    }
}
