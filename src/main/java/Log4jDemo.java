import org.apache.logging.log4j.*;

public class Log4jDemo {

    public static Logger log = LogManager.getLogger(Log4jDemo.class.getName());

    public static void main(String[] args) {
        log.debug("debug message");
        log.info("info message");
        log.error("error message");
        log.fatal("fatal message");
    }
}
