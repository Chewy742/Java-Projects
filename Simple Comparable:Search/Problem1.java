/* Problem1.java - fill in the main method as directed. */

/* Achuth Nair, an2771. I created an array of 10 Rectangles with random lengths 
 * and widths from 1-10 and printed the largest perimeter */


public class Problem1 {
  
  public static <AnyType extends Comparable<AnyType>>  AnyType findMax(AnyType[] arr) {
    int maxIndex = 0;
    for (int i = 1; i < arr.length; i++)
      if ( arr[i].compareTo(arr[maxIndex]) > 0 )
         maxIndex = i;
      return arr[maxIndex];
  }
  
  
  public static final void main(String[] args) {
    
    //I'll create 10 Rectangle objects 
    Rectangle[] myRectangles = new Rectangle[10];
    
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
    Rectangle r10 = new Rectangle(5,7);
    myRectangles[9] = r10;

// did this first, commenting out random stuff
    for (int i = 0; i < 10; i++){
//         int length = (int)(Math.random()*9)+1;
//         int width = (int)(Math.random()*9)+1;
//         Rectangle toAdd = new Rectangle(length, width);
        System.out.println(myRectangles[i]);
//         myRectangles[i] = toAdd;
    }
//I'm going to print out the perimeter of the largest Rectangle to check. 
    System.out.println("The perimeter of the largest Rectangle(s) is: " 
                       + findMax(myRectangles).getPerimeter() 
                       + " and this rectangle is: " + findMax(myRectangles));
          
    
  }
  
 
}


