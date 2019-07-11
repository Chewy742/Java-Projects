/* Following the specification in the README.md file, provide your 
 * Problem2.java class. */
import java.util.Arrays;

public class Problem2{
    
    public static <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x){
        return recursiveHelper(a,x, 0, a.length-1);
    }
    private static <AnyType extends Comparable<AnyType>> int recursiveHelper(AnyType[] a, AnyType x, 
                                                                            int start, int end){
        //base cases- if we've found it (or we've run out of options)
        int s = start;
        int e = end;        
        int mid = (s + e)/2;
        
        if (s > e){
            return -1;
        }
        if (a[mid].compareTo(x) == 0){
            return mid;
        }else if(a[mid].compareTo(x) < 0){ //the value is in the upper half, change start
            return recursiveHelper(a, x, mid+1, e);
        }else{ //the value is in the lower half, change end 
            return recursiveHelper(a, x, s, mid-1);
        }
    }
    
    public static final void main(String[] args) {
        
//did this stuff first, changing
        Rectangle[] myRectangles = new Rectangle[10];
//         for (int i = 0; i < 9; i++){
//             int length = (int)(Math.random()*9)+1;
//             int width = (int)(Math.random()*9)+1;
//             Rectangle toAdd = new Rectangle(length, width);
//             myRectangles[i] = toAdd;
//         }

        Rectangle r1 = new Rectangle(2,2);
        myRectangles[0] = r1;
        Rectangle r2 = new Rectangle(2,3);
        myRectangles[1] = r2;
        Rectangle r3 = new Rectangle(4,2);
        myRectangles[2] = r3;
        Rectangle r4 = new Rectangle(5,5);
        myRectangles[3] = r4;
        Rectangle r5 = new Rectangle(6,7);
        myRectangles[4] = r5;
        Rectangle r6 = new Rectangle(3,2);
        myRectangles[5] = r6;
        Rectangle r7 = new Rectangle(1,2);
        myRectangles[6] = r7;
        Rectangle r8 = new Rectangle(9,10);
        myRectangles[7] = r8;
        Rectangle r9 = new Rectangle(3,4);
        myRectangles[8] = r9;
        
        myRectangles[9] = new Rectangle(5,6);
        Rectangle toSearch = new Rectangle(5,6); // should return a value, 9
        Rectangle toSearch2 = new Rectangle(11, 11); //should return -1
        Rectangle toSearch3 = new Rectangle(3,2); //should return the first rectangle with the same perimeter
               // which is the 2nd one (returns 1)
        
        Arrays.sort(myRectangles);
        for (int j = 0; j < myRectangles.length; j++){
            System.out.println(myRectangles[j]);
        }
            
        System.out.println("Index of a rectangle equal to the one passed in is: " + binarySearch(myRectangles, toSearch));
        System.out.println("Index of a rectangle equal to the one passed in is: " + binarySearch(myRectangles, toSearch2));
        System.out.println("Index of a rectangle equal to the one passed in is: " + binarySearch(myRectangles, toSearch3));
        
        
    }
}

