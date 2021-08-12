package studio.dates.javamodule.validator.exception.regexvalidation;

/**
 * Validation Exception thrown by "phone()" validation method,
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 9, 2021)
 */
public class PhoneFormatViolationException extends StringFormatViolationException {
    /**
     * Constructor with Validation Message as the argument.
     *
     * @param message Exception Message
     */
    public PhoneFormatViolationException(String message) {
        super(message);
    }
}