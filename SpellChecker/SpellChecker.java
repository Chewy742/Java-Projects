/* Following the specification in the README.md file, provide your 
 * SpellChecker class.
 */

import java.util.HashSet;
import java.util.*;
import java.io.*;

public class SpellChecker{
    
    private HashSet<String> myDict = new HashSet<String>();
    
    public SpellChecker(String filename) throws FileNotFoundException{
        File x = new File(filename);
        Scanner s = new Scanner(x);
        int i = 0; 
        while (s.hasNextLine()){
            String line = s.nextLine();
            myDict.add(line.toLowerCase());      
        }
    }

    
    public List<String> getIncorrectWords(String filename) throws FileNotFoundException{
        
        List<String> processedWords = getWordsToCheck(filename);
        ArrayList<String> incorrectWords = new ArrayList<String>();
        for (String checkWord : processedWords){
            if(!myDict.contains(checkWord)){
                incorrectWords.add(checkWord);
            }
        }
        return incorrectWords;
    }
    //returns the words to check, that have been processed
    private List<String> getWordsToCheck(String filename) throws FileNotFoundException{
        File x = new File(filename);
        Scanner s = new Scanner(x);
        ArrayList<String> processedWords = new ArrayList<String>();
        
        while (s.hasNextLine()){
            String line = s.nextLine();
            if (line.equals("")){
                continue;
            }
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++){
                processedWords.add(processNow(words[i]));
            }
        }
        return processedWords;
    }
    //processes one word- either just lowercase, or split the string to delete the first or last things
    private String processNow(String word){
        
        if(Character.isLetterOrDigit(word.charAt(0)) && Character.isLetterOrDigit(word.charAt(word.length()-1))){
            return word.toLowerCase();
        }
        
        if(!Character.isLetterOrDigit(word.charAt(0)) && !Character.isLetterOrDigit(word.charAt(word.length()-1)) ){
            return word.substring(1, word.length()-1).toLowerCase();
        }else if(Character.isLetterOrDigit(word.charAt(0)) && !Character.isLetterOrDigit(word.charAt(word.length()-1))){
            return word.substring(0, word.length()-1).toLowerCase();
        }else{
            return word.substring(1, word.length()).toLowerCase();
        }        
    }
    
      
    public List<String> getSuggestions(String word){
        ArrayList<String> suggestions = new ArrayList<String>();
        List<String> inserts = getInserts(word.toLowerCase());
        List<String> swaps = getSwaps(word.toLowerCase());
        List<String> deletes = getDeletes(word.toLowerCase());

        for (String insertword: inserts){
            if(!suggestions.contains(insertword)){
                suggestions.add(insertword);
            }           
        }
        for( String swapword: swaps){
            if(!suggestions.contains(swapword)){
                suggestions.add(swapword);
            }
        }
        for (String deleteword: deletes){
            if(!suggestions.contains(deleteword)){
                suggestions.add(deleteword);
            }
        }
        
        return suggestions;
        
    } 
    private char[] getAlphabet(){
        return "abcdefghijklmnopqrstuvwxyz".toCharArray(); // cite this 
    }
    private List<String> getInserts(String word){ 
        ArrayList<String> inserts = new ArrayList<String>();
        char[] alphabet = getAlphabet();
        for (int i = 0; i < word.length()+1; i++){
            for (char letter: alphabet){
                String beginning = word.substring(0, i);
                String add = Character.toString(letter);
                String end = word.substring(i, word.length());
                String toAdd = beginning + add + end;
                if(myDict.contains(toAdd)){
                    inserts.add(toAdd);                
                }
            }
        }
        return inserts;
    }
    private List<String> getSwaps(String word){ 
        ArrayList<String> swaps = new ArrayList<String>();
        char[] alphabet = getAlphabet();
        for (int i = 0; i < word.length()-1; i++){
            String beginning = word.substring(0, i);
            String next = Character.toString(word.charAt(i+1));
            String current = Character.toString(word.charAt(i));
            String end = word.substring(i+2, word.length());
            String toAdd = beginning + next + current + end;
//             System.out.println(toAdd);
            if(myDict.contains(toAdd)){
                swaps.add(toAdd);                
            }
        }
        return swaps;
    }
    private List<String> getDeletes(String word){ 
        ArrayList<String> deletes = new ArrayList<String>();
        char[] alphabet = getAlphabet();
        for (int i = 0; i < word.length(); i++){
            String beginning = word.substring(0, i);
            String end = word.substring(i+1, word.length());
            String toAdd = beginning + end;
//             System.out.println(toAdd);
            if(myDict.contains(toAdd)){
                deletes.add(toAdd);                
            }
        }
        return deletes;
    }
    
}