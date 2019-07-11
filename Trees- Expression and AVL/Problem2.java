/* Following the specification in the README.md file, provide your 
 * Problem2 class.
 */

import java.io.*;
import java.util.*;

public class Problem2{
        
    public static final void main(String[] args){
        
        
        try{
            
            FileAvl fa = new FileAvl("test.txt");
            //for my benefit not the prompt 
            List test1 = fa.getLinesForWord("war");
            System.out.println("This should return 2 and 5: " + test1);
            
            fa.printIndex();
            
        }catch (FileNotFoundException e){
            System.out.println("ruh, roh, not a file!!");
        }
        
        
        
        
    }
    
}