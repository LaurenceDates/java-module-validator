package studio.dates.javamodule.validator.exception;

/**
 * List of messages (formats) for exception messages.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 12, 2021)
 */
public class ExceptionMessage {
    /**
     * Validation Exception message format.
     */
    public static final String format = "[ %s ] %s"; // The first "%s" is the name of the field or the validator. The second "%s" is the exception message.

    /**
     * Default message for validation exception.
     */
    public static final String validationExceptionMessage = "Validation Exception.";
    /**
     * NullViolationException message.
     */
    public static final String nullViolationMessage = "Must be NULL.";
    /**
     * EmptyViolationException message.
     */
    public static final String emptyViolationMessage = "Must be EMPTY.";
    /**
     * NotNullViolationException message.
     */
    public static final String notNullViolationMessage = "Must NOT be NULL.";
    /**
     * NotEmptyViolationException message.
     */
    public static final String notEmptyViolationMessage = "Must NOT be EMPTY.";
    /**
     * NotBlankViolationException message.
     */
    public static final String notBlankViolationMessage = "Must NOT be BLANK.";

    /**
     * NumericValueRangeViolationException message format for integer value.
     */
    public static final String numericRangeViolationException1 = "Value expected to be in the following range: %d (inclusive) - %d (inclusive).";
    /**
     * NumericValueRangeViolationException message for float/double value.
     */
    public static final String numericRangeViolationException2 = "Value expected to be in the following range: %f (%s) - %f (%s).";
    /**
     * MinValueViolationException message for integer value.
     */
    public static final String minValueViolationMessage1 = "Min value is %d (inclusive)";
    /**
     * MinValueViolationException message for float/double value.
     */
    public static final String minValueViolationMessage2 = "Min value is %f (%s)";
    /**
     * MaxValueViolationException message for integer value.
     */
    public static final String maxValueViolationMessage1 = "Max value is %d (inclusive).";
    /**
     * MaxValueViolationException message for float/double value.
     */
    public static final String maxValueViolationMessage2 = "Max value is %f (%s).";

    /**
     * LengthViolationException message for range requirement.
     */
    public static final String lengthViolationMessage1 = "String length is not in its required range: %d (inclusive) - %d (inclusive). Provided string length is %d.";
    /**
     * LengthViolationException message for fixed requirement.
     */
    public static final String lengthViolationMessage2 = "String length is required to be %d. Provided string length is %d.";
    /**
     * MinLengthViolationException message.
     */
    public static final String minLengthViolationMessage = "Min string length is %d (inclusive). Provided string length is %d.";
    /**
     * MaxLengthViolationException message.
     */
    public static final String maxLengthViolationMessage = "Max string length is %d (inclusive). Provided string length is %d.";

    /**
     * StringFormatViolationException message.
     */
    public static final String stringFormatViolationMessage = "String does not match the required format.";
    /**
     * EmailFormatViolationException message.
     */
    public static final String emailFormatViolationMessage = "String must match Email format.";
    /**
     * HttpFormatViolationException message
     */
    public static final String httpFormatViolationMessage = "String must match http(or https) URI format.";
    /**
     * PhoneFormatViolationException message.
     */
    public static final String phoneFormatViolationMessage = "String must match phone number format.";

    /**
     * Message for unexpected exceptions.
     */
    public static final String unexpectedExceptionMessage =
            """
                    Error Detected while executing Dates Library Validator. This exception is unexpected to be caught, and this may mean the library has bugs itself.
                    If you caught this exception in your regular usage, please inform the developer of the library with detailed information. Developer will then try to resolve this exception.
                    Thank you for your patience.""";
}
