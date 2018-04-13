package ci;
import java.util.*;

public class InputValidator {
    private static String Operators = "+-*/";

    public static boolean validate(String input) {
        input = input.trim();
        if (input.equals("")) return false;
        boolean hasNumber = false;
        Stack<Character> parentesis = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
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
