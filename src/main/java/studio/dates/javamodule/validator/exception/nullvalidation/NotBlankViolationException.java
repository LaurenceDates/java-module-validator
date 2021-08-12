package studio.dates.javamodule.validator.exception.nullvalidation;

import studio.dates.javamodule.validator.exception.ValidationException;

/**
 * Validation Exception thrown by "notBlank()" validation method.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 7, 2021)
 */
public class NotBlankViolationException extends ValidationException {
    /**
     * Constructor with Validation Message as the argument.
     *
     * @param message Exception Message
     */
    public NotBlankViolationException(String message) {
        super(message);
    }
}
