package studio.dates.javamodule.validator.core;

import studio.dates.javamodule.validator.core.regex.Regex;

/**
 * Validator Core (Validation Engine) for Dates Library Validator.<br>
 * This class contains methods for null check.<br>
 * NOTE: Direct usage of the methods in this class is not recommended.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 10, 2021)
 */
public class NullCheckValidator {
    /**
     * Requires target to be null.
     *
     * @param target Validation target.
     * @return Validation result.
     */
    public static boolean isNull(Object target) {
        return target == null;
    };

    /**
     * Requires target not to be empty.<br>
     * "Empty" means the target is null or its length = 0.
     *
     * @param target Validation target.
     * @return Validation result.
     */
    public static boolean isEmpty(String target) {
        boolean isNull = isNull(target);
        if (isNull) {return true;}
        else {return target.length() == 0;}
    }

    /**
     * Requires the target to be blank.<br>
     * "Blank" means the target is null, empty, or does not contain any printable character.
     *
     * @param target Validation target.
     * @return Validation result.
     */
    public static boolean isBlank(String target) {
        if(isEmpty(target)) {return true;}
        else {
            return target.matches(Regex.blank);
        }
    }
}
