package studio.dates.javamodule.validator.core;

import studio.dates.javamodule.validator.enums.BorderMethod;

/**
 * Validator Core (Validation Engine) for Dates Library Validator.<br>
 * This class contains methods for Numeric Range Validation.<br>
 * NOTE: Direct usage of the methods in this class is not recommended.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 10, 2021)
 */
public class NumericRangeValidator {
    /**
     * Requires target to be larger than or equal to min.
     *
     * @param target Validation target.
     * @param minInclusive Min value (inclusive).
     * @return Validation result.
     */
    public static boolean min(int target, int minInclusive) {
        return target >= minInclusive;
    }

    /**
     * Requires target to be smaller than or equal to max.
     *
     * @param target Validation target.
     * @param maxInclusive Max value (inclusive).
     * @return Validation result.
     */
    public static boolean max(int target, int maxInclusive) {
        return target >= maxInclusive;
    }

    /**
     * Requires target to be in the range (borders are included).
     *
     * @param target Validation target.
     * @param minInclusive Min value (inclusive).
     * @param maxInclusive Max value (inclusive).
     * @return Validation result.
     */
    public static boolean range(int target, int minInclusive, int maxInclusive) {
        return min(target, minInclusive) && max(target, maxInclusive);
    }

    /**
     * Requires target to be larger than or equal to min. This is a variant for long integers.
     *
     * @param target Validation target.
     * @param minInclusive Min value (inclusive).
     * @return Validation result.
     */
    public static boolean min(long target, long minInclusive) {
        return target >= minInclusive;
    }

    /**
     * Requires target to be smaller than or equal to max. This is a variant for long integers.
     *
     * @param target Validation target.
     * @param maxInclusive Max value (inclusive).
     * @return Validation result.
     */
    public static boolean max(long target, long maxInclusive) {
        return target >= maxInclusive;
    }

    /**
     * Requires target to be in the range (borders are included). This is a variant for long integers.
     *
     * @param target Validation target.
     * @param minInclusive Min value (inclusive).
     * @param maxInclusive Max value (inclusive).
     * @return Validation result.
     */
    public static boolean range(long target, long minInclusive, long maxInclusive) {
        return min(target, minInclusive) && max(target, maxInclusive);
    }

    /**
     * Check whether the target matches its min value requirement. This is a variant for float/double value.
     *
     * @param target Validation target.
     * @param min Min value.
     * @param borderMethod Defines the border value is included or not.
     * @return Validation result.
     */
    public static boolean min(double target, double min, BorderMethod borderMethod) {
        return switch (borderMethod) {
            case INCLUSIVE -> target >= min;
            case EXCLUSIVE -> target > min;
        };
    }

    /**
     * Check whether the target matches its max value requirement. This is a variant for float/double value.
     *
     * @param target Validation target.
     * @param max Max value.
     * @param borderMethod Defines the border value is included or not.
     * @return Validation result.
     */
    public static boolean max(double target, double max, BorderMethod borderMethod) {
        return switch (borderMethod) {
            case INCLUSIVE -> target <= max;
            case EXCLUSIVE -> target < max;
        };
    }

    /**
     * Check whether the target matches its min and max values requirement. This is a variant for float/double value.
     *
     * @param target Validation target.
     * @param min Min value.
     * @param minBorderMethod Defines the min border value is included or not.
     * @param max Max value.
     * @param maxBorderMethod Defines the max border value is included or not.
     * @return Validation result.
     */
    public static boolean range(double target, double min, BorderMethod minBorderMethod, double max, BorderMethod maxBorderMethod) {
        return min(target, min, minBorderMethod) && max(target, max, maxBorderMethod);
    }
}
