/* Following the specification in the README.md file, provide your 
 * MyStack class.
 */

import java.util.LinkedList;

public class MyStack<AnyType>{
    
    private int size; 
    private LinkedList<AnyType> myList;
    
    public MyStack(){
        size = 0; 
        myList = new LinkedList<AnyType>(); 
    }
    
    public void push(AnyType x){
        myList.add(0, x);
        size++;
    }
    public AnyType pop(){
        if(isEmpty()){
            return null;
        }
        size--;
        return myList.remove(0);
    }
    public AnyType peek(){
        if(isEmpty()){
            return null;
        }
        return myList.get(0);
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    public int size(){
        return size;
    }
    
}