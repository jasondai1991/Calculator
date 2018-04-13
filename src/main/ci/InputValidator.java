package ci;
import java.util.*;

public class InputValidator {

    private static String Operators = "+-*/";

    public static boolean validate(String input) {
        input = input.trim();
        if (input.equals("")) return false;
        return true;
    }
}
