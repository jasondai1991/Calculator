package ci;

import java.util.*;

public class Calculator {


    public static Double calculate(String input) throws CalculatorException {
        String[] segs = input.split("\\s+");
        input = String.join("",segs);
        if (!InputValidator.isValid(input)) {
            throw new CalculatorException("InvalidInputExpression");
        }
        String operators = "+-/*";
        Stack<Character> ops = new Stack<Character>();// the stack that stores operators (including parentheses)
        Stack<Double> vals = new Stack<Double>();
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            if (Character.isDigit(curChar)) {
                StringBuilder sb = new StringBuilder();
                sb.append(curChar);
                // iteratively calculate each number
                while (i < input.length()-1 && (Character.isDigit(input.charAt(i+1)) || input.charAt(i+1)=='.'))  {
                    sb.append(input.charAt(i+1));
                    i++;
                }
                vals.push(Double.parseDouble(sb.toString()));
            } else if (curChar == '(') {
                ops.push(curChar);
            } else if (curChar == ')') {
                // do the math when we encounter a ')' until '('
                while (ops.peek() != '(') {
                    try{
                        vals.push(operation(ops.pop(), vals.pop(), vals.pop()));
                    }catch (ArithmeticException e){
                        throw new CalculatorException("Denominator is Zero");
                    }
                }
                ops.pop(); // get rid of '(' in the ops stack
            } else if (operators.indexOf(curChar)!=-1) {
                while (!ops.isEmpty() && precedence(curChar, ops.peek())){
                    try{
                        vals.push(operation(ops.pop(), vals.pop(), vals.pop()));
                    }catch (ArithmeticException e){
                        throw new CalculatorException("Denominator is Zero");
                    }
                }
                ops.push(curChar);
            }
        }
        while (!ops.isEmpty()) {
            try{
                vals.push(operation(ops.pop(), vals.pop(), vals.pop()));
            }catch (ArithmeticException e){
                throw new CalculatorException("Denominator is Zero");
            }
        }
        return vals.pop();
    }

    private static double operation(char op, double a, double b) {
        switch (op) {
            case '+': return a + b;
            case '-': return b-a;
            case '*': return a * b;
            case '/':
                if(a==0) throw new ArithmeticException();
                return b/a;
        }
        return 0;
    }



    // helper function to check precedence of current operator and the uppermost operator in the ops stack
    private static boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }
}
