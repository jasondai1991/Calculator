package ci;

public class Operator {

    public static double operation(char op, double a, double b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if(b==0) throw new ArithmeticException();
                return a / b;
        }
        return 0;
    }


}
