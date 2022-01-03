// Question Link: https://practice.geeksforgeeks.org/problems/total-decoding-messages1235/1/

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String str)
    {
        int n=str.length();
        
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;
        
        if(str.charAt(0)=='0')
        return 0;
        
        for(int i=2;i<=n;i++)
        {
            int cnt1=0,cnt2=0;
            if(str.charAt(i-1)>'0')
            cnt1=dp[i-1];
            
            if(str.charAt(i-2)=='1' || (str.charAt(i-2)=='2' && str.charAt(i-1)<'7'))
            cnt2=dp[i-2];
            
            dp[i]=(cnt1+cnt2)%((int)1e9+7);
        }
        
        return dp[n];
    }
}