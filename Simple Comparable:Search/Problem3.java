/* Following the specification in the README.md file, provide your 
 * Problem3.java class.
 */

public class Problem3{
   
    public static int partA(int n){
        int sum = 0;
        for(int i = 0; i < 23; i++) {
            for ( int j = 0; j < n ; j++) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public static int partB(int n){
        int sum = 0;
        for (int i = 0; i < n ; i++){
            for (int k = i ; k < n ; k++){
                sum = sum + 1;
            }
        }
        return sum;
    }

    public static int foo(int n, int k) { //returns the exponent needed to make k^(exp) = n
        if(n<=k)
            return 1;
        else
            return foo(n/k,k) + 1;
    }

    public static final void main(String[] args){

        int[] nums = new int[] {10,20,40,80,160,1000,2000,4000,8000,16000};
//run partA
        for (int i = 0; i < nums.length; i++){
            long startTime = System.nanoTime();
            int result = partA(nums[i]);
            long endTime = System.nanoTime();
            System.out.println("The partA program for n of " + nums[i] + 
                               " ran at a time of " + (endTime-startTime));

        }
//run partB
        for (int j = 0; j < nums.length; j++){
            long startTime = System.nanoTime();
            int result = partB(nums[j]);
            long endTime = System.nanoTime();
            System.out.println("The partB program for n of " + nums[j] + 
                               " ran at a time of " + (endTime-startTime));

        }    
//run partC
        for (int k = 0; k < nums.length; k++){
            long startTime = System.nanoTime();
            int result = foo(nums[k], 2); // 2 as k for all n 
            long endTime = System.nanoTime();
            System.out.println("The foo (partC) program for n of " + nums[k] + 
                               " ran at a time of " + (endTime-startTime));

        }  
        
    }
}



    