package studio.dates.javamodule.validator.exception.regexvalidation;

/**
 * Validation Exception thrown by "email()" validation method,
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 7, 2021)
 */
public class EmailFormatViolationException extends StringFormatViolationException {
    /**
     * Constructor with Validation Message as the argument.
     *
     * @param message Exception Message
     */
    public EmailFormatViolationException(String message) {
        super(message);
    }
}
