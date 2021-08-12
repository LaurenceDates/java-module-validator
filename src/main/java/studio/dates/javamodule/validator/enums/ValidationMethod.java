package studio.dates.javamodule.validator.enums;

/**
 * Enum defines Validation Methods.<br>
 *     1. SYNCHRONOUS: Process validation methods not depending on the result of other methods. Multiple Validation Exceptions can be thrown.<br>
 *     2. SEQUENTIAL: Process validation methods sequentially. If one method throws an exception, then stops validating. Only one Validation Exception can be thrown.<br>
 * NOTE: This method selection is only applicable for Throwing validation methods. Boolean Methods only can be SEQUENTIAL.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 9, 2021)
 */
public enum ValidationMethod {
    /**
     * Process validation methods not depending on the result of other methods. Multiple Validation Exceptions can be thrown.
     */
    SYNCHRONOUS,
    /**
     * Process validation methods sequentially. If one method throws an exception, then stops validating. Only one Validation Exception can be thrown.
     */
    SEQUENTIAL;
}
