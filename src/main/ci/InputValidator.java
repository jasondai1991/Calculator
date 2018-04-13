package ci;
import java.util.*;

public class InputValidator {
    private static String Operators = "+-*/";
    private static String nums = "1234567890";
    private static String validChars = "+-*/()1234567890.";


    public boolean validate(String input) {
        String[] segs = input.split("\\s+");
        input = String.join("",segs);
        if (input.equals("")) return false;
        Stack<Character> parentesis = new Stack<Character>();
        for (int i = 0; i < input.length()-1; i++) {
            char cur = input.charAt(i);
            if(validChars.indexOf(cur)==-1) return false;
            if (cur == '(') {
                if(!validateForLeftParOrOps(input.charAt(i+1))) return false;
                parentesis.push(cur);
                continue;
            }
            else if (cur == ')') {
                if (parentesis.isEmpty()) return false;
                if(!validateForRightPar(input.charAt(i+1))) return false;
                parentesis.pop();
                continue;
            }
            else if(Operators.indexOf(cur)!=-1){
                if(validateForLeftParOrOps(input.charAt(i+1))) continue;
                return false;
            }
        }
        if(input.charAt(input.length()-1)==')') return parentesis.size()==1;
        else if(nums.indexOf(input.charAt(input.length()-1))!=-1) return parentesis.size()==0;
        else return false;
    }

    private boolean validateForLeftParOrOps(char c){
        return !(nums.indexOf(c)==-1 && c!='(');
    }

    private boolean validateForRightPar(char c){
        return !(nums.indexOf(c)!=-1 || c=='.' || c=='(');
    }
}
