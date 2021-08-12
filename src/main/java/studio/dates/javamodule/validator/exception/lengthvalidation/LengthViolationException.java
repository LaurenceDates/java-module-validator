package studio.dates.javamodule.validator.exception.lengthvalidation;

import studio.dates.javamodule.validator.exception.ValidationException;

/**
 * Validation Exception thrown by "length()" validation method,<br>
 * and this is the super class of other length validation exceptions.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 7, 2021)
 */
public class LengthViolationException extends ValidationException {
    /**
     * Constructor with Validation Message as the argument.
     *
     * @param message Exception Message
     */
    public LengthViolationException(String message) {
        super(message);
    }
}
