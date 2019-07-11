/* Create your Rectangle.java from scratch here.  Make sure 
 * you include all the methods indicated in the assignment,
 * even if it appears that you're not using them in the main 
 * of the tester.  Remember, this needs to extend Comparable. */

/* Achuth Nair, an2771 */

public class Rectangle implements Comparable<Rectangle>{
    
    private int length;
    private int width;
    
    public Rectangle(int l, int w){
        length = l;
        width = w;
    }
    
    public int getWidth(){
        return width;
    }
    public int getLength(){
        return length;
    }
    public int getPerimeter(){ //for my ease of use
        return (length*2)+(width*2);
    }
    public int compareTo(Rectangle other){
        if (this.getPerimeter() > other.getPerimeter()){
            return 1;
        }else if (this.getPerimeter() == other.getPerimeter()){
            return 0;
        }else{
            return -1;
        }
    }
    public String toString(){ //toString to print easier
        return "Length: " + length + " and Width: " + width;
    }
}