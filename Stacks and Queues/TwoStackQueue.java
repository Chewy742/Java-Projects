/* Following the specification in the README.md file, provide your 
 * TwoStackQueue class.
 */


public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
    
    private int size;
    private MyStack<AnyType> stack1;
    private MyStack<AnyType> stack2;
    
    public TwoStackQueue(){
        size = 0;
        stack1 = new MyStack<AnyType>();
        stack2 = new MyStack<AnyType>();
    }
    
    public void enqueue(AnyType x){
        stack1.push(x);
        size++;
    }


    public AnyType dequeue(){
        
        
        if(isEmpty()){
            return null;
        }
        size--;
        if(stack2.isEmpty()){
            while(stack1.isEmpty() != true){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
            return stack2.pop();
        }
               
    }


    public boolean isEmpty(){
        return (size == 0);
    }

    
    public int size(){
        return size;
    }
    
    
}