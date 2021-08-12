package studio.dates.javamodule.validator.exception.numericrange;

import studio.dates.javamodule.validator.exception.ValidationException;

/**
 * Validation Exception thrown by "range()" validation method,<br>
 * and this is the super class of other numeric value range validation exceptions.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 7, 2021)
 */
public class NumericValueRangeViolationException extends ValidationException {
    /**
     * Constructor with Validation Message as the argument.
     *
     * @param message Exception Message
     */
    public NumericValueRangeViolationException(String message) {
        super(message);
    }
}
