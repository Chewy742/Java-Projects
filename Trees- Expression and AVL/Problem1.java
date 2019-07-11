/* Following the specification in the README.md file, provide your 
 * Problem1 class.
 */

public class Problem1{
    
    
    public static final void main(String[] args) {
        
        ExpressionTree practice = new ExpressionTree("20 -5 90 3 / * +");
        System.out.println("Here is the postfix expression (should be: 20 -5 90 3 / * +): " + practice.postfix());
        System.out.println("Here is the prefix expression (should be: + 20 * -5 / 90 3): " + practice.prefix());
        System.out.println("Here is the infix expression (should be: (20 + (-5 * (90 / 3)))) with appropriate paranthesis: " + practice.infix());
        System.out.println(" Here is the evaluation: should be -130: " + practice.eval());

    }
}