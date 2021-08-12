package studio.dates.javamodule.validator.booleanvalidator;

import studio.dates.javamodule.validator.core.NullCheckValidator;
import studio.dates.javamodule.validator.core.StringLengthValidator;
import studio.dates.javamodule.validator.core.StringRegexValidator;
import studio.dates.javamodule.validator.core.NumericRangeValidator;
import studio.dates.javamodule.validator.enums.BorderMethod;
import studio.dates.javamodule.validator.enums.Nullable;

/**
 * BooleanValidator Class provides various common validation methods to validate single value.<br>
 * The result is returned with boolean value.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 9, 2021)
 *
 */
public class BooleanValidator {
    /**
     * Requires target to be null.
     *
     * @param target Validation target.
     * @return Validation result.
     */
    public static boolean isNull(Object target) {
        return NullCheckValidator.isNull(target);
    };

    /**
     * Requires target not to be null.
     *
     * @param target Validation target.
     * @return Validation result.
     */
    public static boolean notNull(Object target) {
        return !NullCheckValidator.isNull(target);
    };

    /**
     * Requires target not to be empty.
     * "Empty" means the target is null or its length = 0.
     *
     * @param target Validation target.
     * @return Validation result.
     */
    public static boolean isEmpty(String target) {
        return NullCheckValidator.isEmpty(target);
    }

    /**
     * Requires the target to be empty, but null is not allowed though.
     * "Empty" means the target length = 0.
     *
     * @param target Validation target.
     * @return Validation result.
     */
    public static boolean isEmptyNotNull(String target) {
        if(NullCheckValidator.isNull(target)){return false;}
        else {return NullCheckValidator.isEmpty(target);}
    }

    /**
     * Requires the target not to be empty.<br>
     * "Empty" means the target is null or its length = 0.
     *
     * @param target Validation target.
     * @return Validation result.
     */
    public static boolean notEmpty(String target) {
        return !NullCheckValidator.isEmpty(target);
    }

    /**
     * Requires the target not to be blank.<br>
     * "Blank" means the target is null, empty, or does not contain any printable character.
     *
     * @param target Validation target.
     * @return Validation result.
     */
    public static boolean notBlank(String target) {
        return !NullCheckValidator.isBlank(target);
    }

    /**
     * Requires the integer target in the specified range.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation target.
     * @param minInclusive Min value (inclusive).
     * @param maxInclusive Max value (inclusive).
     * @return Validation result.
     */
    public static boolean range(int target, int minInclusive, int maxInclusive) {
        return NumericRangeValidator.range(target,minInclusive, maxInclusive);
    }

    /**
     * Requires the long integer target in the specified range.<br>
     * NOTE: For "Long" class, use another variant instead.
     *
     * @param target Validation target.
     * @param minInclusive Min value (inclusive).
     * @param maxInclusive Max value (inclusive).
     * @return Validation result.
     */
    public static boolean range(long target, long minInclusive, int maxInclusive) {
        return NumericRangeValidator.range(target, minInclusive, maxInclusive);
    }

    /**
     * Requires the float/double target in the specified range.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation target.
     * @param min Min value.
     * @param minBorderMethod Defines the min border value is included or not.
     * @param max Max value.
     * @param maxBorderMethod Defines the max border value is included or not.
     * @return Validation result.
     */
    public static boolean range(double target, double min, BorderMethod minBorderMethod, double max, BorderMethod maxBorderMethod) {
        return NumericRangeValidator.range(target, min, minBorderMethod, max, maxBorderMethod);
    }

    /**
     * Requires the integer target in the specified range. This is a variant for integer wrapper classes.
     *
     * @param target Validation target (Wrapper class).
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param minInclusive Min value (inclusive).
     * @param maxInclusive Max value (inclusive).
     * @return Validation result.
     */
    public static boolean range(Number target, Nullable nullable, int minInclusive, int maxInclusive){
        switch (nullable) {
            case NOT_NULL_ALLOW_EMPTY:
            case NOT_EMPTY:
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
            case ALLOW_EMPTY:
            case ALLOW_NULL:
                if (NullCheckValidator.isNull(target)) {return true;}
                break;
        }
        return NumericRangeValidator.range((int) target, minInclusive, maxInclusive);
    }

    /**
     * Requires the "Long" integer target in the specified range. This is a variant for "Long" class.
     *
     * @param target Validation target (Wrapper class).
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param minInclusive Min value (inclusive).
     * @param maxInclusive Max value (inclusive).
     * @return Validation result.
     */
    public static boolean range(Long target, Nullable nullable, long minInclusive, int maxInclusive) {
        switch (nullable) {
            case NOT_NULL_ALLOW_EMPTY:
            case NOT_EMPTY:
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
            case ALLOW_EMPTY:
            case ALLOW_NULL:
                if (NullCheckValidator.isNull(target)) {return true;}
                break;
        }
        return NumericRangeValidator.range(target, minInclusive, maxInclusive);
    }

    /**
     * Requires the "Float"/"Double" target in the specified range. This is a variant for wrapper classes.
     *
     * @param target Validation target (Wrapper class).
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param min Min value.
     * @param minBorderMethod Defines the min border value is included or not.
     * @param max Max value.
     * @param maxBorderMethod Defines the max border value is included or not.
     * @return Validation result.
     */
    public static boolean range(Double target, Nullable nullable, double min, BorderMethod minBorderMethod, double max, BorderMethod maxBorderMethod) {
        switch (nullable) {
            case NOT_NULL_ALLOW_EMPTY:
            case NOT_EMPTY:
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
            case ALLOW_EMPTY:
            case ALLOW_NULL:
                if (NullCheckValidator.isNull(target)) {return true;}
                break;
        }
        return NumericRangeValidator.range(target, min, minBorderMethod, max, maxBorderMethod);
    }

    /**
     * Requires the integer target to be larger than or equal to the specified value.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation Target.
     * @param minInclusive Min value (inclusive).
     * @return Validation result.
     */
    public static boolean min(int target, int minInclusive) {
        return NumericRangeValidator.min(target, minInclusive);
    }

    /**
     * Requires the long integer target to be larger than or equal to the specified value.<br>
     * NOTE: For "Long" class, use another variant instead.
     *
     * @param target Validation Target.
     * @param minInclusive Min value (inclusive).
     * @return Validation result.
     */
    public static boolean min(long target, long minInclusive) {
        return NumericRangeValidator.min(target, minInclusive);
    }

    /**
     * Requires the float/double target to be larger than (or equal to) the specified value.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation Target.
     * @param min Min value.
     * @param borderMethod Defines the min border value is included or not.
     * @return Validation result.
     */
    public static boolean min(double target, double min, BorderMethod borderMethod) {
        return NumericRangeValidator.min(target, min, borderMethod);
    }

    /**
     * Requires the integer target to be larger than or equal to the specified value. This is a valiant for wrapper classes.
     *
     * @param target Validation Target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param minInclusive Min value (inclusive).
     * @return Validation result.
     */
    public static boolean min(Number target, Nullable nullable, int minInclusive) {
        switch (nullable) {
            case NOT_NULL_ALLOW_EMPTY:
            case NOT_EMPTY:
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
            case ALLOW_EMPTY:
            case ALLOW_NULL:
                if (NullCheckValidator.isNull(target)) {return true;}
                break;
        }
        return NumericRangeValidator.min((int) target, minInclusive);
    }

    /**
     * Requires the long integer target to be larger than or equal to the specified value. This is a valiant for "Long" class.
     *
     * @param target Validation Target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param minInclusive Min value (inclusive).
     * @return Validation result.
     */
    public static boolean min(Long target, Nullable nullable, long minInclusive) {
        switch (nullable) {
            case NOT_NULL_ALLOW_EMPTY:
            case NOT_EMPTY:
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
            case ALLOW_EMPTY:
            case ALLOW_NULL:
                if (NullCheckValidator.isNull(target)) {return true;}
                break;
        }
        return NumericRangeValidator.min(target, minInclusive);
    }

    /**
     * Requires the float/long target to be larger than (or equal to) the specified value. This is a valiant for wrapper classes.
     *
     * @param target Validation Target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param min Min value.
     * @param borderMethod Defines the max border value is included or not.
     * @return Validation result.
     */
    public static boolean min(Double target, Nullable nullable, double min, BorderMethod borderMethod) {
        switch (nullable) {
            case NOT_NULL_ALLOW_EMPTY:
            case NOT_EMPTY:
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
            case ALLOW_EMPTY:
            case ALLOW_NULL:
                if (NullCheckValidator.isNull(target)) {return true;}
                break;
        }
        return NumericRangeValidator.min(target, min, borderMethod);
    }

    /**
     * Requires the integer target to be smaller than or equal to the specified value.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation Target.
     * @param maxInclusive Max value (inclusive).
     * @return Validation result.
     */
    public static boolean max(int target, int maxInclusive) {
        return NumericRangeValidator.max(target, maxInclusive);
    }

    /**
     * Requires the long integer target to be smaller than or equal to the specified value.<br>
     * NOTE: For "Long" class, use another variant instead.
     *
     * @param target Validation Target.
     * @param maxInclusive Max value (inclusive).
     * @return Validation result.
     */
    public static boolean max(long target, long maxInclusive) {
        return NumericRangeValidator.max(target, maxInclusive);
    }

    /**
     * Requires the float/double target to be smaller than (or equal to) the specified value.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation Target.
     * @param max Max value.
     * @param borderMethod Defines the min border value is included or not.
     * @return Validation result.
     */
    public static boolean max(double target, double max, BorderMethod borderMethod) {
        return NumericRangeValidator.max(target, max, borderMethod);
    }

    /**
     * Requires the integer target to be smaller than or equal to the specified value. This is a valiant for wrapper classes.
     *
     * @param target Validation Target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param maxInclusive Max value (inclusive).
     * @return Validation result.
     */
    public static boolean max(Number target, Nullable nullable, int maxInclusive) {
        switch (nullable) {
            case NOT_NULL_ALLOW_EMPTY:
            case NOT_EMPTY:
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
            case ALLOW_EMPTY:
            case ALLOW_NULL:
                if (NullCheckValidator.isNull(target)) {return true;}
                break;
        }
        return NumericRangeValidator.max((int) target, maxInclusive);
    }

    /**
     * Requires the long integer target to be smaller than or equal to the specified value. This is a valiant for "Long" class.
     *
     * @param target Validation Target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param maxInclusive Max value (inclusive).
     * @return Validation result.
     */
    public static boolean max(Long target, Nullable nullable, long maxInclusive) {
        switch (nullable) {
            case NOT_NULL_ALLOW_EMPTY:
            case NOT_EMPTY:
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
            case ALLOW_EMPTY:
            case ALLOW_NULL:
                if (NullCheckValidator.isNull(target)) {return true;}
                break;
        }
        return NumericRangeValidator.min(target, maxInclusive);
    }

    /**
     * Requires the float/long target to be smaller than (or equal to) the specified value. This is a valiant for wrapper classes.
     *
     * @param target Validation Target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param max Max value.
     * @param borderMethod Defines the max border value is included or not.
     * @return Validation result.
     */
    public static boolean max(Double target, Nullable nullable, double max, BorderMethod borderMethod) {
        switch (nullable) {
            case NOT_NULL_ALLOW_EMPTY:
            case NOT_EMPTY:
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
            case ALLOW_EMPTY:
            case ALLOW_NULL:
                if (NullCheckValidator.isNull(target)) {return true;}
                break;
        }
        return NumericRangeValidator.max(target, max, borderMethod);
    }

    /**
     * Check whether the target matches its min and max length requirement.<br>
     * NOTE: Calculated length can be different from it appears to humans.
     *
     * @param target Validation target.
     * @param nullable Six options:<br>
     *                 NOT_NULL: If the target is NULL, then the validation fails.<br>
     *                 ALLOW_NULL: If the target is NULL, then the validation succeeds, and skips the following validation process<br>
     *                 NOT_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation fails.<br>
     *                 ALLOW_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     *                 ALLOW_NULL_NOT_EMPTY: If the target is null, then the validation succeeds, and skips the following validation process. But if the target is empty (length = 0), then validation fails.<br>
     *                 NOT_NULL_ALLOW_EMPTY: If the target is null, then the validation fails. But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.
     * @param minInclusive Min length (inclusive).
     * @param maxInclusive Max length (inclusive).
     * @return Validation result.
     */
    public static boolean length(String target, Nullable nullable, int minInclusive, int maxInclusive) {
        switch (nullable) {
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL:
                if(NullCheckValidator.isNull(target)) {return true;}
                break;
            case NOT_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case ALLOW_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
                if(NullCheckValidator.isNull(target)) {return true;}
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case NOT_NULL_ALLOW_EMPTY:
                if(NullCheckValidator.isNull(target)) {return false;}
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
        }
        return StringLengthValidator.length(target, minInclusive, maxInclusive);
    }

    /**
     * Check whether the target matches its length requirement.<br>
     * NOTE: Calculated length can be different from it appears to humans.
     *
     * @param target Validation target.
     * @param length Length.
     * @param nullable Six options:<br>
     *                 NOT_NULL: If the target is NULL, then the validation fails.<br>
     *                 ALLOW_NULL: If the target is NULL, then the validation succeeds, and skips the following validation process.<br>
     *                 NOT_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation fails.<br>
     *                 ALLOW_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     *                 ALLOW_NULL_NOT_EMPTY: If the target is null, then the validation succeeds, and skips the following validation process. But if the target is empty (length = 0), then validation fails.<br>
     *                 NOT_NULL_ALLOW_EMPTY: If the target is null, then the validation fails. But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.
     * @return Validation result.
     */
    public static boolean length(String target, Nullable nullable, int length) {
        switch (nullable) {
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL:
                if(NullCheckValidator.isNull(target)) {return true;}
                break;
            case NOT_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case ALLOW_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
                if(NullCheckValidator.isNull(target)) {return true;}
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case NOT_NULL_ALLOW_EMPTY:
                if(NullCheckValidator.isNull(target)) {return false;}
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
        }
        return StringLengthValidator.length(target, length);
    }

    /**
     * Check whether the target matches its min length requirement.<br>
     * NOTE: Calculated length can be different from it appears to humans.
     *
     * @param target Validation target.
     * @param nullable Six options:<br>
     *                 NOT_NULL: If the target is NULL, then the validation fails.<br>
     *                 ALLOW_NULL: If the target is NULL, then the validation succeeds, and skips the following validation process.<br>
     *                 NOT_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation fails.<br>
     *                 ALLOW_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     *                 ALLOW_NULL_NOT_EMPTY: If the target is null, then the validation succeeds, and skips the following validation process. But if the target is empty (length = 0), then validation fails.<br>
     *                 NOT_NULL_ALLOW_EMPTY: If the target is null, then the validation fails. But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.
     * @param minInclusive Min length (inclusive).
     * @return Validation result.
     */
    public static boolean minLength(String target, Nullable nullable, int minInclusive) {
        switch (nullable) {
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL:
                if(NullCheckValidator.isNull(target)) {return true;}
                break;
            case NOT_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case ALLOW_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
                if(NullCheckValidator.isNull(target)) {return true;}
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case NOT_NULL_ALLOW_EMPTY:
                if(NullCheckValidator.isNull(target)) {return false;}
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
        }
        return StringLengthValidator.min(target, minInclusive);
    }

    /**
     * Check whether the target matches its max length requirement.<br>
     * NOTE: Calculated length can be different from it appears to humans.
     *
     * @param target Validation target.
     * @param nullable Six options:<br>
     *                 NOT_NULL: If the target is NULL, then the validation fails.<br>
     *                 ALLOW_NULL: If the target is NULL, then the validation succeeds, and skips the following validation process.<br>
     *                 NOT_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation fails.<br>
     *                 ALLOW_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     *                 ALLOW_NULL_NOT_EMPTY: If the target is null, then the validation succeeds, and skips the following validation process. But if the target is empty (length = 0), then validation fails.<br>
     *                 NOT_NULL_ALLOW_EMPTY: If the target is null, then the validation fails. But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.
     * @param maxInclusive Max length (inclusive).
     * @return Validation result.
     */
    public static boolean maxLength(String target, Nullable nullable, int maxInclusive) {
        switch (nullable) {
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL:
                if(NullCheckValidator.isNull(target)) {return true;}
                break;
            case NOT_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case ALLOW_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
                if(NullCheckValidator.isNull(target)) {return true;}
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case NOT_NULL_ALLOW_EMPTY:
                if(NullCheckValidator.isNull(target)) {return false;}
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
        }
        return StringLengthValidator.max(target, maxInclusive);
    }

    /**
     * Check whether the target matches the regular expression.
     *
     * @param target Validation target.
     * @param nullable Six options:<br>
     *                 NOT_NULL: If the target is NULL, then the validation fails.<br>
     *                 ALLOW_NULL: If the target is NULL, then the validation succeeds, and skips the following validation process.<br>
     *                 NOT_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation fails.<br>
     *                 ALLOW_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     *                 ALLOW_NULL_NOT_EMPTY: If the target is null, then the validation succeeds, and skips the following validation process. But if the target is empty (length = 0), then validation fails.<br>
     *                 NOT_NULL_ALLOW_EMPTY: If the target is null, then the validation fails. But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.
     * @param regex Regular expression.
     * @return Validation result.
     */
    public static boolean regex(String target, Nullable nullable, String regex) {
        switch (nullable) {
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL:
                if(NullCheckValidator.isNull(target)) {return true;}
                break;
            case NOT_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case ALLOW_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
                if(NullCheckValidator.isNull(target)) {return true;}
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case NOT_NULL_ALLOW_EMPTY:
                if(NullCheckValidator.isNull(target)) {return false;}
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
        }
        return StringRegexValidator.regex(target,regex);
    }

    /**
     * Check whether the target matches the email format.
     *
     * @param target Validation target.
     * @param nullable Six options:<br>
     *                 NOT_NULL: If the target is NULL, then the validation fails.<br>
     *                 ALLOW_NULL: If the target is NULL, then the validation succeeds, and skips the following validation process.<br>
     *                 NOT_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation fails.<br>
     *                 ALLOW_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     *                 ALLOW_NULL_NOT_EMPTY: If the target is null, then the validation succeeds, and skips the following validation process. But if the target is empty (length = 0), then validation fails.<br>
     *                 NOT_NULL_ALLOW_EMPTY: If the target is null, then the validation fails. But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.
     * @return Validation result.
     */
    public static boolean email(String target, Nullable nullable) {
        switch (nullable) {
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL:
                if(NullCheckValidator.isNull(target)) {return true;}
                break;
            case NOT_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case ALLOW_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
                if(NullCheckValidator.isNull(target)) {return true;}
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case NOT_NULL_ALLOW_EMPTY:
                if(NullCheckValidator.isNull(target)) {return false;}
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
        }
        return StringRegexValidator.email(target);
    }

    /**
     * Check whether the target matches the http/https format.
     *
     * @param target Validation target.
     * @param nullable Six options:<br>
     *                 NOT_NULL: If the target is NULL, then the validation fails.<br>
     *                 ALLOW_NULL: If the target is NULL, then the validation succeeds, and skips the following validation process.<br>
     *                 NOT_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation fails.<br>
     *                 ALLOW_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     *                 ALLOW_NULL_NOT_EMPTY: If the target is null, then the validation succeeds, and skips the following validation process. But if the target is empty (length = 0), then validation fails.<br>
     *                 NOT_NULL_ALLOW_EMPTY: If the target is null, then the validation fails. But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.
     * @return Validation result.
     */
    public static boolean http(String target, Nullable nullable) {
        switch (nullable) {
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL:
                if(NullCheckValidator.isNull(target)) {return true;}
                break;
            case NOT_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case ALLOW_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
                if(NullCheckValidator.isNull(target)) {return true;}
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case NOT_NULL_ALLOW_EMPTY:
                if(NullCheckValidator.isNull(target)) {return false;}
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
        }
        return StringRegexValidator.http(target);
    }

    /**
     * Check whether the target matches the phone number format.
     *
     * @param target Validation target.
     * @param nullable Six options:<br>
     *                 NOT_NULL: If the target is NULL, then the validation fails.<br>
     *                 ALLOW_NULL: If the target is NULL, then the validation succeeds, and skips the following validation process.<br>
     *                 NOT_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation fails.<br>
     *                 ALLOW_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     *                 ALLOW_NULL_NOT_EMPTY: If the target is null, then the validation succeeds, and skips the following validation process. But if the target is empty (length = 0), then validation fails.<br>
     *                 NOT_NULL_ALLOW_EMPTY: If the target is null, then the validation fails. But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.
     * @return Validation result.
     */
    public static boolean phone(String target, Nullable nullable) {
        switch (nullable) {
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {return false;}
                break;
            case ALLOW_NULL:
                if(NullCheckValidator.isNull(target)) {return true;}
                break;
            case NOT_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case ALLOW_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
                if(NullCheckValidator.isNull(target)) {return true;}
                if(NullCheckValidator.isEmpty(target)) {return false;}
                break;
            case NOT_NULL_ALLOW_EMPTY:
                if(NullCheckValidator.isNull(target)) {return false;}
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
        }
        return StringRegexValidator.phone(target);
    }
}
