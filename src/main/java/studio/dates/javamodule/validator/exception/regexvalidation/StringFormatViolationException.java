package studio.dates.javamodule.validator.exception.regexvalidation;

import studio.dates.javamodule.validator.exception.ValidationException;

/**
 * Validation Exception thrown by "regex()" validation method,<br>
 * and this is the super class of other regex validation exceptions.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 7, 2021)
 */
public class StringFormatViolationException extends ValidationException {
    /**
     * Constructor with Validation Message as the argument.
     *
     * @param message Exception Message
     */
    public StringFormatViolationException(String message) {
        super(message);
    }
}
