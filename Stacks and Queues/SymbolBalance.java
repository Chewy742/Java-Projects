/* Following the specification in the README.md file, provide your 
 * SymbolBalance class.
 */

import java.util.Scanner;
import java.io.*;

public class SymbolBalance{
    
    public static final void main(String[] args) {
        
        File x = new File(args[0]);
                      
        try{
            
            Scanner s = new Scanner(x);  
            
            MyStack stacky = new MyStack(); 
            int linenumber = 1;
            boolean getOut = false;
            boolean inComment = false;
            boolean inQuotes = false;
            
            while (s.hasNextLine()){
                String next = s.nextLine();
                
                for (int i = 0; i < next.length(); i++){        
                    //check if its in a comment, ignore
                    if(inComment){
                        if(i < next.length()-1 && next.charAt(i) == '*' && next.charAt(i+1) == '/' ){
                           stacky.pop();
                           inComment = false;
                        }
                    //check if its in a quote, ignore
                    }else if(inQuotes){ 
                        if(next.charAt(i) == '"'){
                            stacky.pop();
                            inQuotes = false;
                        }   
                    //otherwise check for open/close symbols
                    }else{                           
                        //check open symbols
                        //with special consideratioon for a comment /*                    
                        if (i < next.length()-1 && next.charAt(i) == '/' && next.charAt(i+1) == '*'){
                            stacky.push(next.charAt(i+1));
                            inComment = true;
                        }
                        //dealing w " separately cause its a lil bitch
                        if(next.charAt(i) == '"'){
                            stacky.push(next.charAt(i));
                            inQuotes = true;
                        }
                        //is it an open symbol
                        if (next.charAt(i) == '(' || next.charAt(i) == '{' || next.charAt(i) == '[' ){                                                 
                            stacky.push(next.charAt(i));
                            
                        }                                                                                                                           
                        //CLOSE SYMBOLS                        
                        //check close symbols, special case of finding close symbol first. 
                        if ((next.charAt(i) == ')' || next.charAt(i) == '}' || next.charAt(i) == ']') && stacky.size() == 0){
                            System.out.println(linenumber + ": Empty");
                                getOut = true;    
                                break;
                        }
                        //check close symbols, cases of mismatched symbols
                        if (next.charAt(i) == ')'){
                            if((char)(stacky.peek()) == '('){
                                stacky.pop();
                            }else{
                                System.out.println(linenumber + ": " + next.charAt(i) + "," + stacky.pop());
                                getOut = true;
                            }               
                        }else if(next.charAt(i) == '}'){
                            if((char)(stacky.peek()) == '{'){
                                stacky.pop();
                            }else{
                                System.out.println(linenumber + ": " + next.charAt(i) + "," + stacky.pop());
                                getOut = true;
                            }
                        }else if(next.charAt(i) == ']'){
                            if((char)(stacky.peek()) == '['){
                                stacky.pop();
                            }else{
                                System.out.println(linenumber + ": " + next.charAt(i) + "," + stacky.pop());
                                getOut = true;
                            }
                        }
                    }  
                    if(getOut == true){
                        break;
                    }
                }
                if (getOut == true){
                    break;
                }
                linenumber++; 
            }
            //by the end, we either have a coorrect file or a non-empty stack.         
            if (getOut == false){
                if (stacky.size() == 0){ //all good!
                   System.out.println("Correct");
                }
                if (stacky.size() != 0){ //Not empty
                   System.out.println("Non-empty stack: " + stacky.pop() + ", " + (stacky.size()+1));
                }
            }
        }catch (FileNotFoundException e){
           System.out.println("ruh, roh, not a file!!");
        }                              
    }   
}
