/* Following the specification in the README.md file, provide your 
 * ExpressionTree class.
 */
import java.util.*;

public class ExpressionTree {
    
        /* Your constructor should take in a string containing the postfix expression that you
         * are using to build your expression tree. */
        private ExpressionNode root;
        
        public ExpressionTree(String expression) {
            
            String s = expression; 
            MyStack<ExpressionNode> build = new MyStack<ExpressionNode>();
            String[] splitString = s.split(" ");
            for (int i = 0; i < splitString.length; i++){
                if (splitString[i].equals("+") || splitString[i].equals("-") || splitString[i].equals("/") || splitString[i].equals("*")){
                    ExpressionNode right = build.pop();
                    ExpressionNode left = build.pop();
                    ExpressionNode topush = new ExpressionNode(splitString[i], left, right);
                    build.push(topush);
                }else{
                    ExpressionNode number = new ExpressionNode(splitString[i], null, null);
                    build.push(number);
                }                
            }
            if(build.size() != 1){
                throw new RuntimeException("Invalid Postfix Expression.");
            }
            root = build.peek();
         
        }
//eval shit 
        public int eval(){            
              return eval(root);         
        }       
        private int eval(ExpressionNode t){ 
            if (t.data.equals("+") == false && t.data.equals("-") == false && t.data.equals("*") == false && t.data.equals("/") == false){
                return Integer.parseInt(t.data); //remember to cite where you got this! 
            }
            int left = eval(t.left);
            int right = eval(t.right);
            return apply(t.data, left, right);
        }
        
        private int apply(String operator, int l, int r){
            if(operator.equals("*")){
                return l*r;
            }else if(operator.equals("+")){
                return l+r;
            }else if(operator.equals("/")){
                return l/r;
            }else{
                return l-r;
            }
        }
//Postfix    
        public String postfix() {
            return postfix(root, "");              
        }
    
        private String postfix(ExpressionNode t, String s){                       
            String toreturn = s;             
            if (t != null){               
                toreturn += postfix(t.left, toreturn) + postfix(t.right, toreturn) + t.data + " ";                
            }
            return toreturn;           
        }
    
//Prefix    
        public String prefix() {
            return prefix(root, "");             
        }
        private String prefix(ExpressionNode t, String s){           
            
            String toreturn = s; 
            
            if (t != null){               
                toreturn += t.data + " " + prefix(t.left, toreturn) + prefix(t.right, toreturn);                
            }
            return toreturn;
            
        }
//Infix   
        public String infix() {
            return infix(root, "");             
        }
        private String infix(ExpressionNode t, String s){           
            
            String toreturn = s; 
            
            if (t != null){               
                toreturn += "(" + infix(t.left, toreturn) + t.data + " " + infix(t.right, toreturn) + ")";
            }
            return toreturn;            
        }
       
        private static class ExpressionNode{
            
            String data;
            ExpressionNode left;
            ExpressionNode right;
            
            public ExpressionNode(String d){
                this(d, null, null);
            }
            
            public ExpressionNode(String d, ExpressionNode lft, ExpressionNode rt){
                data = d;
                left = lft;
                right = rt;
            }
            
        }
    
         /* You will need to provide the private, recursive versions of these methods, 
          * the instance variable(s), and any static nested class that you might need below */
     
}