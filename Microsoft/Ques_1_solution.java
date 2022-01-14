// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
        int sum=0;
        for(int ele:arr)
            sum+=ele;
        
        boolean dp[][]=new boolean[n+1][sum+2];
        for(int j=0;j<=sum;j++)
        {
            dp[0][j]=false;
        }
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=true;
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1]<=j)
                {
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        
        int ans=Integer.MAX_VALUE;
        
        for(int i=0;i<=sum/2;i++)
        {
            if(dp[n][i])
            {
                ans=Math.min(ans,sum-2*i);
            }
        }
        
        return ans;
        
	} 
}
