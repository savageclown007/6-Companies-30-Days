// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int k, int n, int A[]) {
        int dp[][]=new int[k+1][n];
        
        for(int i=1;i<=k;i++)
        {
           int mx=Integer.MIN_VALUE;
           for(int j=1;j<n;j++)
           {
               mx=Math.max(mx,dp[i-1][j-1] - A[j-1]);
               dp[i][j]=Math.max(dp[i][j-1],mx+A[j]);
           }
        }
        
        return dp[k][n-1];
    }
}
