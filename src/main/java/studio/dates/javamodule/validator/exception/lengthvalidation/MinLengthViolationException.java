package studio.dates.javamodule.validator.exception.lengthvalidation;

/**
 * Validation Exception thrown by "minLength()" validation method,
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 7, 2021)
 */
public class MinLengthViolationException extends LengthViolationException {
    /**
     * Constructor with Validation Message as the argument.
     *
     * @param message Exception Message
     */
    public MinLengthViolationException(String message) {
        super(message);
    }
}
