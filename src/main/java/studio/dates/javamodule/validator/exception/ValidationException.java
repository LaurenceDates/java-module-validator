package studio.dates.javamodule.validator.exception;

/**
 * Validation Exception class is the parent class of all other exception classes thrown in validation process in this library.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 7, 2021)
 */
public class ValidationException extends RuntimeException {

    /**
     * Constructor with Validation Message as the argument.
     * @param message Exception Message
     */
    public ValidationException (String message){
        super(message);
    }
}
