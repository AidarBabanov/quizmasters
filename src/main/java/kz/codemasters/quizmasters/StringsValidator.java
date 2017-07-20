package kz.codemasters.quizmasters;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aidar on 7/15/17.
 *
 */
public class StringsValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String NAME_PATTERN = "^[\\p{L}\\s'.-]+$";

//            Password validation
//            ^                 # start-of-string
//            (?=.*[0-9])       # a digit must occur at least once
//            (?=.*[a-z])       # a lower case letter must occur at least once
//            (?=.*[A-Z])       # an upper case letter must occur at least once
//            (?=.*[!@#$%^&+=]) # a special character must occur at least once
//            (?=\S+$)          # no whitespace allowed in the entire string
//            .{8,}             # anything, at least eight places though
//            $                 # end-of-string

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$";

    public boolean validateEmail(final String hex, FacesContext context) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        if (!validate(hex)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong email", "Pattern is wrong"));
            return false;
        }
        return true;
    }

    public boolean validateName(final String hex, FacesContext context) {
        if(hex.trim().length() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fill empty fields", ""));
            return false;
        }
        pattern = Pattern.compile(NAME_PATTERN);
        if (!validate(hex)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong name", "Pattern is wrong"));
            return false;
        }
        return true;
    }

    public boolean validatePassword(final String hex, FacesContext context) {
        pattern = Pattern.compile(PASSWORD_PATTERN);
//        if (!validate(hex)){
//            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong password", "Pattern is wrong"));
//            return false;
//        }
        return true;
    }

    /**
     * Validate hex with regular expression
     *
     * @param hex hex for validation
     * @return true valid hex, false invalid hex
     */
    private boolean validate(final String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
