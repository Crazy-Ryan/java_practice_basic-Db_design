package userInterface;

import java.util.regex.Pattern;

public class FormatCheckUtil {

    private static Pattern loginPattern;

    static {
        String loginFormat = "[^,]+,[^,]+";
        loginPattern = Pattern.compile(loginFormat);
    }

    private static boolean formatCheck(Pattern pattern, String text) {
        return pattern.matcher(text).matches();
    }

    public static boolean loginFormatCheck(String input) {
        return formatCheck(loginPattern, input);
    }
}
