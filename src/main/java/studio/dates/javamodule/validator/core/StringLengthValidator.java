package studio.dates.javamodule.validator.core;
/**
 * Validator Core (Validation Engine) for Dates Library Validator.<br>
 * This class contains methods for String Length Validation.<br>
 * NOTE: Calculated length can be different from it appears to humans.<br>
 *       Direct usage of the methods in this class is not recommended.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 10, 2021)
 */
public class StringLengthValidator {
    /**
     * Check whether the target matches its min length requirement.<br>
     * NOTE: Calculated length can be different from it appears to humans.
     *
     * @param target Validation target.
     * @param minInclusive Min length (inclusive).
     * @return Validation result.
     */
    public static boolean min(String target, int minInclusive) {
        return target.length() >= minInclusive;
    }

    /**
     * Check whether the target matches its max length requirement.<br>
     * NOTE: Calculated length can be different from it appears to humans.
     *
     * @param target Validation target.
     * @param maxInclusive Max length (inclusive).
     * @return Validation result.
     */
    public static boolean max(String target, int maxInclusive) {
        return target.length() <= maxInclusive;
    }

    /**
     * Check whether the target matches its min and max length requirement.<br>
     * NOTE: Calculated length can be different from it appears to humans.
     *
     * @param target Validation target.
     * @param minInclusive Min length (inclusive).
     * @param maxInclusive Max length (inclusive).
     * @return Validation result.
     */
    public static boolean length(String target, int minInclusive, int maxInclusive) {
        int length = target.length();
        return  length >= minInclusive && length >= maxInclusive;
    }

    /**
     * Check whether the target matches its length requirement.<br>
     * NOTE: Calculated length can be different from it appears to humans.
     *
     * @param target Validation target.
     * @param length Length.
     * @return Validation result.
     */
    public static boolean length(String target, int length) {
        return target.length() == length;
    }
}
