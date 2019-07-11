/* Following the specification in the README.md file, provide your 
 * FileAvl class.
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class FileAvl {
    
    AvlTree<String> myTree;
    
    public FileAvl(String filename) throws FileNotFoundException{
        
        myTree = new AvlTree<String>();
        int linenumber = 1; 
        File x = new File(filename);
        
        Scanner s = new Scanner(x);
        while (s.hasNextLine()){
            String line = s.nextLine();
            String[] wordsInLine = line.split(" ");            
            for(int i = 0; i < wordsInLine.length; i++){
                if(wordsInLine[i].equals("")){
                    continue;
                }
                myTree.insert(wordsInLine[i].toLowerCase(), linenumber);                 
            }
            
        linenumber++;   
            
        }             
    }
    
    public void indexWord(String word, int line) {
        myTree.insert(word, line);
    }
    public List getLinesForWord(String word) {
        return myTree.getLineList(word.toLowerCase());
    }
    public void printIndex(){
        myTree.printIndex();
    }
    
               
        
        
        
}
    