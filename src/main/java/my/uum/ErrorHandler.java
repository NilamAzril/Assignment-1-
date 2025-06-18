package my.uum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@code ErrorHandler} class provides centralized error handling functionality.
 * <p>
 * It logs error messages using SLF4J and optionally prints the stack trace for debugging purposes.
 * </p>
 */
public class ErrorHandler {

    /** Logger instance for logging error messages */
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    /**
     * Handles an exception by logging its message and optionally printing the stack trace.
     *
     * @param e the exception to be handled
     */
    public static void handleError(Exception e) {
        // Log the error message
        logger.error("An error occurred: {}", e.getMessage());

        // Optionally, print the stack trace for debugging purposes
        e.printStackTrace();
    }
}
