import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.apache.commons.validator.routines.EmailValidator;

public class ValidityChecks {
    private final static String DATE_FORMAT = "yyyy-MM-dd";

    public static void main(String[] args){
        System.out.println("isEmailValid: " + isEmailValid("tomzimy_1@cmail.carleton.ca"));
        System.out.println("isDatevalid: " + isDateValid("2017-01-09"));
        System.out.println("isNumbervalid: " + isNumberValid("222."));
        System.out.println("isStringValid: " + isTextValid("ljk7"));
    }

    public static boolean isEmailValid(String email){
        return EmailValidator.getInstance(false).isValid(email);
    }

    public static boolean isDateValid(String date){
        DateTimeFormatter f = DateTimeFormatter.ofPattern (DATE_FORMAT);
        try {
            LocalDate ld = LocalDate.parse ( date , f );
            return true;
        } catch ( DateTimeParseException e ) {
            System.out.println ( "ERROR: " + e );
        }
        return false;
    }//https://stackoverflow.com/questions/226910/how-to-sanity-check-a-date-in-java by Basil Bourque

    public static boolean isNumberValid(String number){
        return number.matches("^[0-9]*$");
    }//https://stackoverflow.com/questions/10575624/java-string-see-if-a-string-contains-only-numbers-and-not-letters/10575676 by tokhi

    public static boolean isTextValid(String text){
        return !text.matches(".*\\d.*");
    }//https://stackoverflow.com/questions/6344867/checking-whether-a-string-contains-a-number-value-in-java by Shef
}
