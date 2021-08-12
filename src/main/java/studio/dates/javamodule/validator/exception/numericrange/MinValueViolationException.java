package studio.dates.javamodule.validator.exception.numericrange;

/**
 * Validation Exception thrown by "min()" validation method,
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 7, 2021)
 */
public class MinValueViolationException extends NumericValueRangeViolationException {
    /**
     * Constructor with Validation Message as the argument.
     *
     * @param message Exception Message
     */
    public MinValueViolationException(String message) {
        super(message);
    }
}
