package studio.dates.javamodule.validator.exception.regexvalidation;

/**
 * Validation Exception thrown by "http()" validation method,
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 7, 2021)
 */
public class HttpFormatViolationException extends StringFormatViolationException {
    /**
     * Constructor with Validation Message as the argument.
     *
     * @param message Exception Message
     */
    public HttpFormatViolationException(String message) {
        super(message);
    }
}
