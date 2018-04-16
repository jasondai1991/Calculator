package ci;
import java.util.*;

public class InputValidator {
    private static String Operators = "+-*/";
    private static String nums = "1234567890";
    private static String validChars = "+-*/()1234567890.";


    public static boolean isValid(String input) {
        String[] segs = input.split("\\s+");
        input = String.join("",segs);
        if (input.equals("")) return false;
        Stack<Character> parentesis = new Stack<Character>();
        boolean prevDot =false;
        if(!validateForLeftParOrOps(input.charAt(0))) return false;
        for (int i = 0; i < input.length()-1; i++) {
            char cur = input.charAt(i);
            if(validChars.indexOf(cur)==-1) return false;
            if (cur == '(') {
                if(!validateForLeftParOrOps(input.charAt(i+1))) return false;
                parentesis.push(cur);
                prevDot =false;
                continue;
            }
            else if (cur == ')') {
                if (parentesis.isEmpty()) return false;
                if(!validateForRightPar(input.charAt(i+1))) return false;
                parentesis.pop();
                prevDot = false;
                continue;
            }
            else if(Operators.indexOf(cur)!=-1){
                if(!validateForLeftParOrOps(input.charAt(i+1))) return false;
                prevDot = false;
                continue;
            }
            else if(cur=='.'){
                if(nums.indexOf(input.charAt(i+1))==-1 || prevDot) return false;
                prevDot = true;
                continue;
            }
            else{
                if(input.charAt(i+1)=='(') return false;
                continue;
            }
        }
        if(input.charAt(input.length()-1)==')') return parentesis.size()==1;
        else if(nums.indexOf(input.charAt(input.length()-1))!=-1) return parentesis.size()==0;
        else return false;
    }

    private static boolean validateForLeftParOrOps(char c){
        return !(nums.indexOf(c)==-1 && c!='(');
    }

    private static boolean validateForRightPar(char c){
        return !(nums.indexOf(c)!=-1 || c=='.' || c=='(');
    }
}
