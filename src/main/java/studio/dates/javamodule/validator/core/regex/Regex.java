package studio.dates.javamodule.validator.core.regex;

/**
 * List of regex used in Dates Library Validator.
 *
 * @author Laurence B. Yamamoto (DatesStudio in Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 9, 2021)
 */
public class Regex {
    /**
     * Regular expression for checking blank string.
     */
    public static final String blank = "[\u0000-\u0020\u2003\u3000]*";    // u0009-u000c: tabs, lf and cr, u0020: space, u2003: em space, u3000 ideographic space
    /**
     * Regular expression for email format.
     */
    public static final String email = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"; // https://emailregex.com/ (Aug. 9, 2021)
    /**
     * Regular expression for http/https uri format.
     */
    public static final String http = "^(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"; // https://urlregex.com/ (Aug. 9, 2021)
    /**
     * Regular expression for phone number format.
     */
    public static final String phone = "^\\+?[\\d\\W]{,32}";
}
