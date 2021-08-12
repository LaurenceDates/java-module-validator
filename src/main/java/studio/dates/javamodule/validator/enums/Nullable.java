package studio.dates.javamodule.validator.enums;

/**
 * Enum used to specify the nullability of the target value during validations.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 8, 2021)
 */
public enum Nullable {
    /**
     * If the target is NULL, then the validation fails.
     */
    NOT_NULL,
    /**
     * If the target is NULL, then the validation succeeds, and skips the following validation process.
     */
    ALLOW_NULL,
    /**
     * If the target is EMPTY (NULL or length = 0), then the validation fails.
     * NOTE: Being Empty is only possible for string value. If this option is selected for numeric target, this behaves just as "ALLOW_NULL".<br>
     */
    NOT_EMPTY,
    /**
     * If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     * NOTE: Being Empty is only possible for string value. If this option is selected for numeric target, this behaves just as "ALLOW_NULL".
     */
    ALLOW_EMPTY,
    /**
     * If the target is null, then the validation succeeds, and skips the following validation process.<br>
     * But if the target is empty (length = 0), then validation fails.<br>
     * NOTE: Being Empty is only possible for string value. If this option is selected for numeric target, this behaves just as "ALLOW_NULL".
     */
    ALLOW_NULL_NOT_EMPTY,
    /**
     * If the target is null, then the validation fails.<br>
     * But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.<br>
     * NOTE: Being Empty is only possible for string value. If this option is selected for numeric target, this behaves just as "NOT_NULL".
     */
    NOT_NULL_ALLOW_EMPTY;
}
