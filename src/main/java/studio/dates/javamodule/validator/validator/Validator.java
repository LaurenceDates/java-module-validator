package studio.dates.javamodule.validator.validator;

import studio.dates.javamodule.validator.core.NullCheckValidator;
import studio.dates.javamodule.validator.core.NumericRangeValidator;
import studio.dates.javamodule.validator.core.StringLengthValidator;
import studio.dates.javamodule.validator.core.StringRegexValidator;
import studio.dates.javamodule.validator.enums.BorderMethod;
import studio.dates.javamodule.validator.enums.Nullable;
import studio.dates.javamodule.validator.exception.ExceptionMessage;
import studio.dates.javamodule.validator.exception.ValidationException;
import studio.dates.javamodule.validator.exception.lengthvalidation.LengthViolationException;
import studio.dates.javamodule.validator.exception.lengthvalidation.MaxLengthViolationException;
import studio.dates.javamodule.validator.exception.lengthvalidation.MinLengthViolationException;
import studio.dates.javamodule.validator.exception.nullvalidation.*;
import studio.dates.javamodule.validator.exception.numericrange.MaxValueViolationException;
import studio.dates.javamodule.validator.exception.numericrange.MinValueViolationException;
import studio.dates.javamodule.validator.exception.numericrange.NumericValueRangeViolationException;
import studio.dates.javamodule.validator.exception.regexvalidation.EmailFormatViolationException;
import studio.dates.javamodule.validator.exception.regexvalidation.HttpFormatViolationException;
import studio.dates.javamodule.validator.exception.regexvalidation.PhoneFormatViolationException;
import studio.dates.javamodule.validator.exception.regexvalidation.StringFormatViolationException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Validator Class provides various common validation methods to validate single value.<br>
 * If the target value does not match the required conditions, method throws a Validation Exception.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 10, 2021)
 *
 */
public class Validator {
    /**
     * Requires target to be null.
     *
     * @param target Validation target.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NullViolationException Validation Exception thrown when the target is not null.
     */
    public static void isNull(Object target, String name) throws NullViolationException {
        if(!NullCheckValidator.isNull(target)) {throwException(NullViolationException.class, name, ExceptionMessage.nullViolationMessage);}
    }

    /**
     * Requires target not to be null.
     *
     * @param target Validation target.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown when the target is null.
     */
    public static void notNull(Object target, String name) throws NotNullViolationException {
        if(NullCheckValidator.isNull(target)) {throwException(NotNullViolationException.class, name, ExceptionMessage.notNullViolationMessage);}
    }

    /**
     * Requires target not to be empty.<br>
     * "Empty" means the target is null or its length = 0.
     *
     * @param target Validation target.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws EmptyViolationException Validation Exception thrown when the target is not empty.
     */
    public static void isEmpty(String target, String name)  throws EmptyViolationException{
        if(NullCheckValidator.isEmpty(target)) {throwException(EmptyViolationException.class, name, ExceptionMessage.emptyViolationMessage);}
    }

    /**
     * Requires the target to be empty, but null is not allowed though.<br>
     * "Empty" means the target length = 0.
     *
     * @param target Validation target.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws EmptyViolationException Validation Exception thrown when the target is not empty.
     * @throws NotNullViolationException Validation Exception thrown when the target is null.
     */
    public static void isEmptyNotNull(String target, String name) throws NotNullViolationException, EmptyViolationException {
        if(NullCheckValidator.isNull(target)) {throwException(NotNullViolationException.class, name, ExceptionMessage.notNullViolationMessage);}
        if(!NullCheckValidator.isEmpty(target)) {throwException(EmptyViolationException.class, name, ExceptionMessage.emptyViolationMessage);}
    }

    /**
     * Requires the target not to be empty.<br>
     * "Empty" means the target is null or its length = 0.
     *
     * @param target Validation target.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotEmptyViolationException Validation Exception thrown when the target is empty.
     */
    public static void notEmpty(String target, String name) throws NotEmptyViolationException {
        if(NullCheckValidator.isEmpty(target)) {throwException(NotEmptyViolationException.class, name, ExceptionMessage.notEmptyViolationMessage);}
    }

    /**
     * Requires the target not to be blank.<br>
     * "Blank" means the target is null, empty, or does not contain any printable character.
     *
     * @param target Validation Target.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotBlankViolationException Validation Exception thrown when the target is blank.
     */
    public static void notBlank(String target, String name) throws NotBlankViolationException {
        if(NullCheckValidator.isBlank(target)) {throwException(NotBlankViolationException.class, name, ExceptionMessage.notBlankViolationMessage);}
    }

    /**
     * Requires the integer target in the specified range.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation target.
     * @param minInclusive Min value (inclusive).
     * @param maxInclusive Max value (inclusive).
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NumericValueRangeViolationException Validation Exception thrown when the target value is out of range.
     */
    public static void range(int target, int minInclusive, int maxInclusive, String name) throws NumericValueRangeViolationException {
        if(!NumericRangeValidator.range(target,minInclusive,maxInclusive)) {
            String message = String.format(ExceptionMessage.numericRangeViolationException1, minInclusive, maxInclusive);
            throwException(NumericValueRangeViolationException.class, name, message);}
    }

    /**
     * Requires the long integer target in the specified range. This is a variant for long integers.<br>
     * NOTE: For "Long" class, use another variant instead.
     *
     * @param target Validation target.
     * @param minInclusive Min value (inclusive).
     * @param maxInclusive Max value (inclusive).
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NumericValueRangeViolationException Validation Exception thrown when the target value is out of range.
     */
    public static void range(long target, long minInclusive, int maxInclusive, String name) throws NumericValueRangeViolationException {
        if(!NumericRangeValidator.range(target,minInclusive,maxInclusive)) {
            String message = String.format(ExceptionMessage.numericRangeViolationException1, minInclusive, maxInclusive);
            throwException(NumericValueRangeViolationException.class, name, message);}
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
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NumericValueRangeViolationException Validation Exception thrown when the target value is out of range.
     */
    public static void range(double target, double min, BorderMethod minBorderMethod, double max, BorderMethod maxBorderMethod, String name) throws NumericValueRangeViolationException {
        if(!NumericRangeValidator.range(target, min, minBorderMethod, max, maxBorderMethod)) {
            String message = String.format(ExceptionMessage.numericRangeViolationException2, min, minBorderMethod.getMessage(), max, maxBorderMethod.getMessage());
            throwException(NumericValueRangeViolationException.class, name, message);}
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
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws NumericValueRangeViolationException Validation Exception thrown when the target value is out of range.
     */
    public static void range(Number target, Nullable nullable, int minInclusive, int maxInclusive, String name) throws NotNullViolationException, NumericValueRangeViolationException {
        if(numberNullCheck(target, nullable, name)) {return;}
        if(!NumericRangeValidator.range((int) target, minInclusive, maxInclusive)) {
            String message = String.format(ExceptionMessage.numericRangeViolationException1, minInclusive, maxInclusive);
            throwException(NumericValueRangeViolationException.class, name, message);}
    }

    /**
     * Requires the long integer target in the specified range. This is a variant for "Long" class.
     *
     * @param target Validation target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param minInclusive Min value (inclusive).
     * @param maxInclusive Max value (inclusive).
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws NumericValueRangeViolationException Validation Exception thrown when the target value is out of range.
     */
    public static void range(Long target, Nullable nullable, long minInclusive, int maxInclusive, String name) throws NotNullViolationException, NumericValueRangeViolationException {
        if(numberNullCheck(target, nullable, name)) {return;}
        if(!NumericRangeValidator.range(target, minInclusive, maxInclusive)) {
            String message = String.format(ExceptionMessage.numericRangeViolationException1, minInclusive, maxInclusive);
            throwException(NumericValueRangeViolationException.class, name, message);}
    }

    /**
     * Requires the float/double target in the specified range. This is a variant for wrapper classes.
     *
     * @param target Validation target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param min Min value.
     * @param minBorderMethod Defines the min border value is included or not.
     * @param max Max value.
     * @param maxBorderMethod Defines the max border value is included or not.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws NumericValueRangeViolationException Validation Exception thrown when the target value is out of range.
     */
    public static void range(Double target, Nullable nullable, double min, BorderMethod minBorderMethod, double max, BorderMethod maxBorderMethod, String name) throws NotNullViolationException, NumericValueRangeViolationException {
        if(numberNullCheck(target, nullable, name)){return;}
        String message = String.format(ExceptionMessage.numericRangeViolationException2, min, minBorderMethod.getMessage(), max, maxBorderMethod.getMessage());
        if(!NumericRangeValidator.range(target, min, minBorderMethod, max, maxBorderMethod)) {throwException(NumericValueRangeViolationException.class, name, message);}
    }

    /**
     * Requires the integer target to be larger than or equal to the specified value.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation Target.
     * @param minInclusive Min value (inclusive).
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws MinValueViolationException Validation Exception thrown when the target value is smaller than min value.
     */
    public static void min(int target, int minInclusive, String name) throws MinValueViolationException {
        if(!NumericRangeValidator.min(target, minInclusive)){
            String message = String.format(ExceptionMessage.minValueViolationMessage1, minInclusive);
            throwException(MinValueViolationException.class, name, message);}
    }

    /**
     * Requires the long integer target to be larger than or equal to the specified value.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation Target.
     * @param minInclusive Min value (inclusive).
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws MinValueViolationException Validation Exception thrown when the target value is smaller than min value.
     */
    public static void min(long target, long minInclusive, String name) throws MinValueViolationException {
        if(!NumericRangeValidator.min(target, minInclusive)){
            String message = String.format(ExceptionMessage.minValueViolationMessage1, minInclusive);
            throwException(MinValueViolationException.class, name, message);}
    }

    /**
     * Requires the float/double target to be larger than (or equal to) the specified value.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation Target.
     * @param min Min value.
     * @param borderMethod Defines the min border value is included or not.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws MinValueViolationException Validation Exception thrown when the target value is smaller than (or equal to) min value.
     */
    public static void min(double target, double min, BorderMethod borderMethod, String name) throws MinValueViolationException {
        if(!NumericRangeValidator.min(target, min, borderMethod)) {
            String message = String.format(ExceptionMessage.minValueViolationMessage2, min, borderMethod.getMessage());
            throwException(MinValueViolationException.class, name, message);
        }
    }

    /**
     * Requires the integer target to be larger than or equal to the specified value. This is a variant for wrapper classes.
     *
     * @param target Validation Target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param minInclusive Min value (inclusive).
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws MinValueViolationException Validation Exception thrown when the target value is smaller than min value.
     */
    public static void min(Number target, Nullable nullable, int minInclusive, String name) throws NotNullViolationException, MinValueViolationException {
        if(numberNullCheck(target, nullable, name)) {return;}
        if(!NumericRangeValidator.min((int) target, minInclusive)) {
            String message = String.format(ExceptionMessage.minValueViolationMessage1, minInclusive);
            throwException(MinValueViolationException.class, name, message);
        }
    }

    /**
     * Requires the long integer target to be larger than or equal to the specified value. This is a variant for "Long" class.
     *
     * @param target Validation Target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param minInclusive Min value (inclusive).
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws MinValueViolationException Validation Exception thrown when the target value is smaller than min value.
     */
    public static void min(Long target, Nullable nullable, long minInclusive, String name) throws NotNullViolationException, MinValueViolationException {
        if(numberNullCheck(target, nullable, name)) {return;}
        if(!NumericRangeValidator.min(target, minInclusive)) {
            String message = String.format(ExceptionMessage.minValueViolationMessage1, minInclusive);
            throwException(MinValueViolationException.class, name, message);
        }
    }

    /**
     * Requires the float/double target to be larger than (or equal to) the specified value. This is a variant for wrapper classes.
     *
     * @param target Validation Target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param min Min value.
     * @param borderMethod Defines the min border value is included or not.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws MinValueViolationException Validation Exception thrown when the target value is smaller than (or equal to) min value.
     */
    public static void min(Double target, Nullable nullable, double min, BorderMethod borderMethod, String name) throws NotNullViolationException, MinValueViolationException {
        if(numberNullCheck(target, nullable, name)) {return;}
        if(!NumericRangeValidator.min(target, min, borderMethod)) {
            String message = String.format(ExceptionMessage.minValueViolationMessage2, min, borderMethod);
            throwException(MinValueViolationException.class, name, message);
        }
    }

    /**
     * Requires the integer target to be smaller than or equal to the specified value.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation Target.
     * @param maxInclusive Max value (inclusive).
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws MaxValueViolationException Validation Exception thrown when the target value is larger than max value.
     */
    public static void max(int target, int maxInclusive, String name) throws MaxValueViolationException {
        if(!NumericRangeValidator.max(target, maxInclusive)) {
            String message = String.format(ExceptionMessage.maxValueViolationMessage1, maxInclusive);
            throwException(MaxValueViolationException.class, name, message);
        }
    }

    /**
     * Requires the long integer target to be smaller than or equal to the specified value.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation Target.
     * @param maxInclusive Max value (inclusive).
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws MaxValueViolationException Validation Exception thrown when the target value is larger than max value.
     */
    public static void max(long target, long maxInclusive, String name) throws MaxValueViolationException {
        if(!NumericRangeValidator.max(target, maxInclusive)) {
            String message = String.format(ExceptionMessage.maxValueViolationMessage1, maxInclusive);
            throwException(MaxValueViolationException.class, name, message);
        }
    }

    /**
     * Requires the float/double target to be smaller than (or equal to) the specified value.<br>
     * NOTE: For wrapper classes, use another variant instead.
     *
     * @param target Validation Target.
     * @param max Max value.
     * @param borderMethod Defines the max border value is included or not.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws MaxValueViolationException Validation Exception thrown when the target value is larger than (or equal to) max value.
     */
    public static void max(double target, double max, BorderMethod borderMethod, String name) throws MaxValueViolationException {
        if(!NumericRangeValidator.max(target, max, borderMethod)) {
            String message = String.format(ExceptionMessage.maxValueViolationMessage2, max, borderMethod);
            throwException(MaxValueViolationException.class, name, message);
        }
    }

    /**
     * Requires the integer target to be smaller than or equal to the specified value. This is a variant for wrapper classes.
     *
     * @param target Validation Target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param maxInclusive Max value (inclusive).
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws MaxValueViolationException Validation Exception thrown when the target value is larger than max value.
     */
    public static void max(Number target, Nullable nullable, int maxInclusive, String name) throws NotNullViolationException, MaxValueViolationException {
        if(numberNullCheck(target, nullable, name)) {return;}
        if(!NumericRangeValidator.max((int) target, maxInclusive)) {
            String message = String.format(ExceptionMessage.maxValueViolationMessage1, maxInclusive);
            throwException(MaxValueViolationException.class, name, message);
        }
    }

    /**
     * Requires the long integer target to be smaller than or equal to the specified value. This is a variant for "Long" class.
     *
     * @param target Validation Target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param maxInclusive Max value (inclusive).
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws MaxValueViolationException Validation Exception thrown when the target value is larger than max value.
     */
    public static void max(Long target, Nullable nullable, long maxInclusive, String name) throws NotNullViolationException, MaxValueViolationException {
        if(numberNullCheck(target, nullable, name)) {return;}
        if(!NumericRangeValidator.max(target, maxInclusive)) {
            String message = String.format(ExceptionMessage.maxValueViolationMessage1, maxInclusive);
            throwException(MaxValueViolationException.class, name, message);
        }
    }

    /**
     * Requires the float/double target to be smaller than (or equal to) the specified value. This is a variant for wrapper classes.
     *
     * @param target Validation Target.
     * @param nullable Two options:<br>
     *                 NOT_NULL: If null, the validation fails.<br>
     *                 ALLOW_NULL: If null, the validation succeeds.<br>
     *                 NOTE: Using other values are not recommended.
     * @param max Max value.
     * @param borderMethod Defines the max border value is included or not.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws MaxValueViolationException Validation Exception thrown when the target value is larger than (or equal to) max value.
     */
    public static void max(Double target, Nullable nullable, double max, BorderMethod borderMethod, String name) throws NotNullViolationException, MaxValueViolationException {
        if(numberNullCheck(target, nullable, name)) {return;}
        if(!NumericRangeValidator.max(target, max, borderMethod)) {
            String message = String.format(ExceptionMessage.maxValueViolationMessage2, max, borderMethod.getMessage());
            throwException(MaxValueViolationException.class, name, message);
        }
    }


    /**
     * Check whether the target matches its min and max length requirement.<br>
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
     * @param maxInclusive Max length (inclusive).
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws NotEmptyViolationException Validation Exception thrown if "nullable" is set NOT_EMPTY but the target is EMPTY.
     * @throws LengthViolationException Violation Exception thrown if the target length is out of range.
     */
    public static void length(String target, Nullable nullable, int minInclusive, int maxInclusive, String name) throws NotNullViolationException, NotEmptyViolationException, LengthViolationException {
        if(stringNullCheck(target, nullable, name)) {return;}
        if(!StringLengthValidator.length(target, minInclusive, maxInclusive)) {
            String message = String.format(ExceptionMessage.lengthViolationMessage1, maxInclusive, maxInclusive, target.length());
            throwException(LengthViolationException.class, name, message);}

    }

    /**
     * Check whether the target matches its fixed length requirement.<br>
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
     * @param length length.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws NotEmptyViolationException Validation Exception thrown if "nullable" is set NOT_EMPTY but the target is EMPTY.
     * @throws LengthViolationException Violation Exception thrown if the target length does not match the fixed length.
     */
    public static void length(String target, Nullable nullable, int length, String name) throws NotNullViolationException, NotEmptyViolationException, LengthViolationException {
        if(stringNullCheck(target, nullable, name)) {return;}
        if(!StringLengthValidator.length(target, length)) {
            String message = String.format(ExceptionMessage.lengthViolationMessage2, length, target.length());
            throwException(LengthViolationException.class, name, message);
        }
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
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws NotEmptyViolationException Validation Exception thrown if "nullable" is set NOT_EMPTY but the target is EMPTY.
     * @throws MinLengthViolationException Violation Exception thrown if the target length does not match its min length requirement.
     */
    public static void min(String target, Nullable nullable, int minInclusive, String name) throws NotNullViolationException, NotEmptyViolationException, MinLengthViolationException {
        if(stringNullCheck(target, nullable, name)) {return;}
        if(!StringLengthValidator.min(target, minInclusive)) {
            String message = String.format(ExceptionMessage.minLengthViolationMessage, minInclusive, target.length());
            throwException(MinLengthViolationException.class, name, message);
        }
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
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws NotEmptyViolationException Validation Exception thrown if "nullable" is set NOT_EMPTY but the target is EMPTY.
     * @throws MaxLengthViolationException Violation Exception thrown if the target length does not match its max length requirement.
     */
    public static void max(String target, Nullable nullable, int maxInclusive, String name) throws NotNullViolationException, NotEmptyViolationException, MaxLengthViolationException {
        if(stringNullCheck(target, nullable, name)) {return;}
        if(!StringLengthValidator.max(target, maxInclusive)) {
            String message = String.format(ExceptionMessage.maxLengthViolationMessage, maxInclusive, target.length());
            throwException(MaxLengthViolationException.class, name, message);
        }
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
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws NotEmptyViolationException Validation Exception thrown if "nullable" is set NOT_EMPTY but the target is EMPTY.
     * @throws StringFormatViolationException Validation Exception thrown if the target string does not match the regular expression.
     */
    public static void regex(String target, Nullable nullable, String regex, String name) throws NotNullViolationException, NotEmptyViolationException, StringFormatViolationException {
        if(stringNullCheck(target, nullable, name)) {return;}
        if(!StringRegexValidator.regex(target, regex)) {
            throwException(StringFormatViolationException.class, name, ExceptionMessage.stringFormatViolationMessage);
        }
    }

    /**
     * Check whether the target matches email format.
     *
     * @param target Validation target.
     * @param nullable Six options:<br>
     *                 NOT_NULL: If the target is NULL, then the validation fails.<br>
     *                 ALLOW_NULL: If the target is NULL, then the validation succeeds, and skips the following validation process.<br>
     *                 NOT_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation fails.<br>
     *                 ALLOW_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     *                 ALLOW_NULL_NOT_EMPTY: If the target is null, then the validation succeeds, and skips the following validation process. But if the target is empty (length = 0), then validation fails.<br>
     *                 NOT_NULL_ALLOW_EMPTY: If the target is null, then the validation fails. But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws NotEmptyViolationException Validation Exception thrown if "nullable" is set NOT_EMPTY but the target is EMPTY.
     * @throws EmailFormatViolationException Validation Exception thrown if the target string does not match email format.
     */
    public static void email(String target, Nullable nullable, String name) throws NotNullViolationException, NotEmptyViolationException, EmailFormatViolationException {
        if(stringNullCheck(target, nullable, name)) {return;}
        if(!StringRegexValidator.email(target)) {
            throwException(EmailFormatViolationException.class, name, ExceptionMessage.emailFormatViolationMessage);
        }
    }

    /**
     * Check whether the target matches http/https uri format.
     *
     * @param target Validation target.
     * @param nullable Six options:<br>
     *                 NOT_NULL: If the target is NULL, then the validation fails.<br>
     *                 ALLOW_NULL: If the target is NULL, then the validation succeeds, and skips the following validation process.<br>
     *                 NOT_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation fails.<br>
     *                 ALLOW_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     *                 ALLOW_NULL_NOT_EMPTY: If the target is null, then the validation succeeds, and skips the following validation process. But if the target is empty (length = 0), then validation fails.<br>
     *                 NOT_NULL_ALLOW_EMPTY: If the target is null, then the validation fails. But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws NotEmptyViolationException Validation Exception thrown if "nullable" is set NOT_EMPTY but the target is EMPTY.
     * @throws HttpFormatViolationException Validation Exception thrown if the target string does not match http uri format.
     */
    public static void http(String target, Nullable nullable, String name) throws NotNullViolationException, EmptyViolationException, HttpFormatViolationException {
        if(stringNullCheck(target, nullable, name)) {return;}
        if(!StringRegexValidator.http(target)) {
            throwException(HttpFormatViolationException.class, name, ExceptionMessage.httpFormatViolationMessage);
        }
    }

    /**
     * Check whether the target matches phone number format.<br>
     * NOTE: This method only provide basic format check for phone numbers worldwide, but cannot check whether it matches the regional format.
     *
     * @param target Validation target.
     * @param nullable Six options:<br>
     *                 NOT_NULL: If the target is NULL, then the validation fails.<br>
     *                 ALLOW_NULL: If the target is NULL, then the validation succeeds, and skips the following validation process.<br>
     *                 NOT_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation fails.<br>
     *                 ALLOW_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     *                 ALLOW_NULL_NOT_EMPTY: If the target is null, then the validation succeeds, and skips the following validation process. But if the target is empty (length = 0), then validation fails.<br>
     *                 NOT_NULL_ALLOW_EMPTY: If the target is null, then the validation fails. But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.
     * @param name Name of the field to be checked. This parameter is used for the exception message.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws NotEmptyViolationException Validation Exception thrown if "nullable" is set NOT_EMPTY but the target is EMPTY.
     * @throws PhoneFormatViolationException Validation Exception thrown if the target string does not match phone number format.
     */
    public static void phone(String target, Nullable nullable, String name) throws NotNullViolationException, EmptyViolationException, PhoneFormatViolationException {
        if(stringNullCheck(target, nullable, name)) {return;}
        if(!StringRegexValidator.phone(target)) {
            throwException(PhoneFormatViolationException.class, name, ExceptionMessage.phoneFormatViolationMessage);
        }
    }

    /**
     * Private internal method to throw Validation Exception.
     *
     * @param exceptionClass Exception class to be thrown.
     * @param name Field name.
     * @param message Exception Message.
     */
    private static void throwException(Class<? extends ValidationException> exceptionClass, String name, String message) throws ValidationException {
        Constructor<? extends ValidationException> constructor;
        try {
            constructor = exceptionClass.getConstructor(String.class);
            throw constructor.newInstance(formatMessage(name, message));
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.err.println(ExceptionMessage.unexpectedExceptionMessage);
            e.printStackTrace();
        }
    }

    /**
     * private internal method to format exception message.
     *
     * @param name Field name.
     * @param exceptionMessage Exception Message.
     * @return Formatted Message is returned.
     */
    private static String formatMessage(String name, String exceptionMessage) {
        return String.format(ExceptionMessage.format, name, exceptionMessage);
    }

    /**
     * Private internal method for null check of numeric values.
     *
     * @param target Validation target
     * @param nullable Nullability of the target.
     * @param name Field name.
     * @return true: validation is finished, and the following process can be skipped.<br>
     *         false: validation is not finished, and the following process need to be proceeded.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     */
    private static boolean numberNullCheck(Number target, Nullable nullable, String name) throws NotNullViolationException {
        switch (nullable) {
            case NOT_NULL:
            case NOT_EMPTY:
            case NOT_NULL_ALLOW_EMPTY:
                if (NullCheckValidator.isNull(target)) {throwException(NotBlankViolationException.class, name, ExceptionMessage.notNullViolationMessage);}
                break;
            case ALLOW_NULL:
            case ALLOW_EMPTY:
            case ALLOW_NULL_NOT_EMPTY:
                if (NullCheckValidator.isNull(target)) {return true;}
                break;
        }
        return false;
    }

    /**
     * Private internal method for null check
     *
     * @param target Validation target.
     * @param nullable Six options:<br>
     *                 NOT_NULL: If the target is NULL, then the validation fails.<br>
     *                 ALLOW_NULL: If the target is NULL, then the validation succeeds, and skips the following validation process.<br>
     *                 NOT_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation fails.<br>
     *                 ALLOW_EMPTY: If the target is EMPTY (NULL or length = 0), then the validation succeeds, and skips the following validation process.<br>
     *                 ALLOW_NULL_NOT_EMPTY: If the target is null, then the validation succeeds, and skips the following validation process. But if the target is empty (length = 0), then validation fails.<br>
     *                 NOT_NULL_ALLOW_EMPTY: If the target is null, then the validation fails. But if the target is not null but empty (length=0), then the validation succeeds, and skips the following validation process.
     * @param name Name of the field
     * @return true: validation is finished, and the following process can be skipped.<br>
     *         false: validation is not finished, and the following process need to be proceeded.
     * @throws NotNullViolationException Validation Exception thrown if "nullable" is set NOT_NULL but the target is NULL.
     * @throws NotEmptyViolationException Validation Exception thrown if "nullable" is set NOT_EMPTY but the target is EMPTY.
     */
    private static boolean stringNullCheck(String target, Nullable nullable, String name) throws NotNullViolationException, NotEmptyViolationException {
        switch (nullable) {
            case NOT_NULL:
                if(NullCheckValidator.isNull(target)) {throwException(NotBlankViolationException.class, name, ExceptionMessage.notNullViolationMessage);}
                break;
            case ALLOW_NULL:
                if(NullCheckValidator.isNull(target)) {return true;}
                break;
            case NOT_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {throwException(NotEmptyViolationException.class, name, ExceptionMessage.notEmptyViolationMessage);}
                break;
            case ALLOW_EMPTY:
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
            case ALLOW_NULL_NOT_EMPTY:
                if(NullCheckValidator.isNull(target)) {return true;}
                if(NullCheckValidator.isEmpty(target)) {throwException(NotEmptyViolationException.class, name, ExceptionMessage.notEmptyViolationMessage);}
                break;
            case NOT_NULL_ALLOW_EMPTY:
                if(NullCheckValidator.isNull(target)) {throwException(NotNullViolationException.class, name, ExceptionMessage.notNullViolationMessage);}
                if(NullCheckValidator.isEmpty(target)) {return true;}
                break;
        }
        return false;
    }
}
