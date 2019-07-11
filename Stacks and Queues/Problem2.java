/* Following the specification in the README.md file, provide your 
 * Problem2 class.
 */

public class Problem2{
    
    
    public static final void main(String[] args) {
            
	TwoStackQueue<String> q = new TwoStackQueue<String>();
        
    //0
	System.out.println(q.size());
        
        
     //Potter 
     //4
     //Harry 
     //3
     //you 
     //2
     //love 
     //1
     //I
     //0 
     //null
     //yeet
     //
         
            
                     
    q.enqueue("Potter");
	q.enqueue("Harry");
    q.enqueue("you");
    q.enqueue("love");
    q.enqueue("I");
    while(!q.isEmpty()){
        System.out.println(q.dequeue());
        System.out.println(q.size());
    }
    System.out.println(q.dequeue()); //should return null
        
     //should print yeet!
     q.enqueue("here");
     q.enqueue("we");
     q.enqueue("go!");
     q.dequeue();
     q.enqueue("yeet!");
     q.dequeue();
     q.dequeue();
     System.out.println(q.dequeue());
    }
    
    
}