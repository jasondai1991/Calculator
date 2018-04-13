package ci;
import java.util.*;

public class Calculator {
    private String Operators ="+-*/";

    public boolean validateInput(String input){
        input = input.trim();
        if(input.equals("")) return false;
        boolean lastSymbleOperator = false;
        Stack<Character> parentesis = new Stack<Character>();
        for(int i=0;i<input.length();i++){
            char cur = input.charAt(i);
            if(cur==' ') continue;
            if(Operators.indexOf(cur)!=-1){
                if(lastSymbleOperator) return false;
                lastSymbleOperator = true;
            }
            if(cur=='(') parentesis.push(cur);
            if(cur==')'){
                if(parentesis.isEmpty()) return false;
                parentesis.pop();
            }
        }
        return true;
    }



}
