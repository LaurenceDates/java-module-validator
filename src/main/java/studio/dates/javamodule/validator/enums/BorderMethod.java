package studio.dates.javamodule.validator.enums;

/**
 * Enum used to specify whether border value is included or excluded during validation process.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 9, 2021)
 */
public enum BorderMethod {
    /**
     * Border value is included in the range.
     */
    INCLUSIVE("inclusive"),
    /**
     * Border value is excluded from the range.
     */
    EXCLUSIVE("exclusive");

    /**
     * String used for Validation Exception message.
     */
    private final String message;

    /**
     * Getter for "message" field.
     * @return Validation Exception message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Constructor with message (used for Validation Exception message) as the argument.
     *
     * @param message String used for Validation Exception message.
     */
    BorderMethod(String message) {
        this.message = message;
    }
}
