package studio.dates.javamodule.validator.exception.nullvalidation;

import studio.dates.javamodule.validator.exception.ValidationException;

/**
 * Validation Exception thrown by "isEmpty()" validation method.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 10, 2021)
 */
public class EmptyViolationException extends ValidationException {
    /**
     * Constructor with Validation Message as the argument.
     *
     * @param message Exception Message
     */
    public EmptyViolationException(String message) {
        super(message);
    }
}
