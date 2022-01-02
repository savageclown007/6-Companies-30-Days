// Question Link: https://practice.geeksforgeeks.org/problems/ugly-numbers2254/1/#

// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
    
                System.out.println(new Solution().getNthUglyNo(n));
            }
        }
    }// } Driver Code Ends
    
    
    class Solution {
        /* Function to get the nth ugly number*/
        long getNthUglyNo(int n) {
            // code here
            long dp[]=new long[n+1];
            dp[1]=1;
            int idx1=1,idx2=1,idx3=1;
            for(int i=2;i<=n;i++)
            {
                long val1=dp[idx1]*2L;
                long val2=dp[idx2]*3L;
                long val3=dp[idx3]*5L;
                
                long min=Math.min(val1,Math.min(val2,val3));
                
                dp[i]=min;
                if(min==val1)
                idx1++;
                if(min==val2)
                idx2++;
                if(min==val3)
                idx3++;
            }
            
            return dp[n];
        }
    }
