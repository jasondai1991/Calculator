package ci;
import java.util.*;

public class Calculator {


    public static String calculate(String input) throws InvalidExpressionException {
        if (!InputValidator.validate(input)) {
            throw new InvalidExpressionException("InvalidInputExpression");
        }
        return "";
    }

    private int add(int a, int b){
        return a+b;
    }

    private int minus(int a, int b){
        return a-b;
    }

    private int multiply(int a, int b){
        return a*b;
    }

    public double divide(int a, int b){
        return (double) a/b;
    }



}
