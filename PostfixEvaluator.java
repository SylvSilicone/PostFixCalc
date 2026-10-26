import java.util.Scanner;
import java.util.Stack;

/** STUDENT FILE: Complete evaluate. Leave all other project files unchanged. */
public class PostfixEvaluator {
    public static int evaluate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new PostFixException("Expression cannot be blank");
        }

        Stack<Integer> stack = new Stack<>();

        try (Scanner tokens = new Scanner(expression)) {
            while (tokens.hasNext()) {
                String token = tokens.next();

                // If the token is an operator, evaluate it.
                if (token.equals("+") || token.equals("-")
                        || token.equals("*") || token.equals("/")) {

                    // An operator requires two operands.
                    if (stack.size() < 2) {
                        throw new PostFixException(
                            "Not enough operands for operator: " + token
                        );
                    }

                    // The first popped value is the RIGHT operand.
                    int right = stack.pop();
                    int left = stack.pop();

                    int result;

                    switch (token) {
                        case "+":
                            result = left + right;
                            break;
                        case "-":
                            result = left - right;
                            break;
                        case "*":
                            result = left * right;
                            break;
                        case "/":
                            result = left / right;
                            break;
                        default:
                            throw new PostFixException("Invalid operator");
                    }

                    stack.push(result);

                } else {
                    // Otherwise, the token must be an integer.
                    try {
                        stack.push(Integer.parseInt(token));
                    } catch (NumberFormatException e) {
                        throw new PostFixException(
                            "Invalid token: " + token
                        );
                    }
                }
            }
        }

        // A valid expression must leave exactly one result.
        if (stack.size() != 1) {
            throw new PostFixException(
                "Malformed expression: expected exactly one result"
            );
        }

        return stack.pop();
    }
}
