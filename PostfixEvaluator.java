import java.util.Scanner;
import java.util.Stack;
/** STUDENT FILE: Complete evaluate. Leave all other project files unchanged. */
public class PostfixEvaluator {
    /**
     * Evaluates a space-separated postfix expression using integer arithmetic.
     * Supported operators: +, -, *, / (integer division).
     *
     * @throws PostFixException for blank, malformed, or invalid expressions
     * @throws ArithmeticException for division by zero
     */
    public static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        Scanner tokens = new Scanner(expression);
        stack.push(tokens.nextInt());
        for(int i = 0; i < stack.size(); i++)
        {
            int int1 = stack.pop();
            int int2 = stack.pop();
            String s = tokens.next();
            if(s.equals("+"))
            {
                return int1 + int2;
            }
            else if(s.equals("-"))
            {
                return int1 - int2;
            }
            else if(s.equals("*"))
            {
                return int1 * int2;
            }
            else if(s.equals("*"))
            {
                return int1/int2;
            }
        }
        tokens.close();

        // TODO 1: Process tokens one at a time.
        // TODO 2: If a token is an integer, push it onto the stack.
        // TODO 3: If it is +, -, *, or /, pop two operands.
        //         IMPORTANT: the first popped number is the RIGHT operand.
        // TODO 4: Calculate and push the result.
        // TODO 5: Reject unknown tokens and expressions with too few operands.
        // TODO 6: After processing, require EXACTLY one result on the stack.
        //         Catch stack underflow/overflow or check before operations.
        // Close the Scanner when you are finished.

        tokens.close();
        throw new UnsupportedOperationException("TODO: implement postfix evaluation");
    }
}
