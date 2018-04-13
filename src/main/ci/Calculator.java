package ci;
import java.util.*;

public class Calculator {

    public static String calculate(String input) throws InvalidExpressionException {
        if (!Input.validate(input)) {
            throw new InvalidExpressionException("InvalidInputExpression");
        }
        return "";
    }




}
