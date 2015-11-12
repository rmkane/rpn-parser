package rpn.calculator.core.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//General configuration:
// - https://logging.apache.org/log4j/2.x/manual/configuration.html
// Quick reference:
// - http://alesnosek.com/blog/2015/05/11/java-logging-quick-reference/
// JSON configuration:
// - http://stackoverflow.com/questions/21435990/log4j-2-json-configuration
// Levels, appenders, and filters:
// - http://www.journaldev.com/7128/apache-log4j-2-tutorial-configuration-levels-appenders-lookup-layouts-and-filters-example
public class LogExample {
	private static final Logger LOG = LogManager.getLogger(LogExample.class);

	public static void main(String[] args) {
		LOG.trace("a trace message.");
		LOG.debug("a debug message.");
		LOG.info("an info message.");
		LOG.warn("a warn message.");
		LOG.error("a error message.");
		LOG.fatal("a fatal message.");
	}
}