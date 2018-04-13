package ci;
import java.util.*;

public class InputValidator {
    private static String Operators = "+-*/";
    private static String validChars = "+-*/()1234567890.";


    public static boolean validate(String input) {
        input = input.trim();
        if (input.equals("")) return false;
        boolean hasNumber = false;
        Stack<Character> parentesis = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if(validChars.indexOf(cur)==-1) return false;
            if (cur == '(') {
                parentesis.push(cur);
                continue;
            }
            if (cur == ')') {
                if (parentesis.isEmpty()) return false;
                parentesis.pop();
                continue;
            }
        }
        return parentesis.size()==0;

    }
}
