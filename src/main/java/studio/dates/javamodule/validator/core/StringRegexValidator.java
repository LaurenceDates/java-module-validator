package studio.dates.javamodule.validator.core;

import studio.dates.javamodule.validator.core.regex.Regex;

/**
 * Validator Core (Validation Engine) for Dates Library Validator.<br>
 * This class contains methods for Regular Expression check.<br>
 * NOTE: Direct usage of the methods in this class is not recommended.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 10, 2021)
 */
public class StringRegexValidator {
    /**
     * Check whether the target matches the regular expression.
     *
     * @param target Validation target.
     * @param regex Regular expression.
     * @return Validation result.
     */
    public static boolean regex(String target, String regex) {
        return target.matches(regex);
    }

    /**
     * Check whether the target matches the email format.
     *
     * @param target Validation target.
     * @return Validation result.
     */
    public static boolean email(String target) {
        return target.matches(Regex.email);
    }

    /**
     * Check whether the target matches the http/https format.
     *
     * @param target Validation target.
     * @return Validation result.
     */
    public static boolean http(String target) {
        return target.matches(Regex.http);
    }

    /**
     * Check whether the target matches the phone number format.
     *
     * @param target Validation target.
     * @return Validation result.
     */
    public static boolean phone(String target) {
        return target.matches(Regex.phone);
    }
}
