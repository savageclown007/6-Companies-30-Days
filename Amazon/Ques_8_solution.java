// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    
    class GFG {
        public static void main (String[] args) {
            
            //taking input using Scanner class
            Scanner sc = new Scanner(System.in);
            
            //taking total testcases
            int t = sc.nextInt();
            
            while(t-- > 0){
                
                //taking total number of stairs
                int m = sc.nextInt();
                
                //creating an object of class DynamicProgramming
                Solution obj = new Solution();
                
                //calling method of class countWays()
                //of class DynamicProgramming
                System.out.println(obj.countWays(m));
                
            }
            
        }
    }
    // } Driver Code Ends
    
    
    
    class Solution
    {
        //Function to count number of ways to reach the nth stair 
        //when order does not matter.
        Long countWays(int n)
        {
            long dp[]=new long[n+1];
            dp[0]=dp[1]=1;
            for(int i=2;i<=n;i++)
            {
                dp[i]=dp[i-2]+1;
            }
            
            return dp[n];
        }    
    }
    