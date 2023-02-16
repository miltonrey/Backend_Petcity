package unillanos.foodtainer.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidateField {

    private ValidateField() {
        throw new IllegalStateException("Utility class for mapping.");
    }

    public static boolean validateEmailFormat(String email) {
        if (email.isBlank()) {
            return false;
        }
        Pattern validEmailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = validEmailRegex.matcher(email);
        return matcher.find();
    }

}
