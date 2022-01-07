// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int p[] = new int[n];
            for(int i = 0;i < n;i++)
                p[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixChainOrder(p, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static class name{
        char x;
        public name(char x)
        {
            this.x=x;
        }
    }
    
    static void util(int[][] split,int i,int j,StringBuilder s,name x)
    {
        if(i==j)
        {
            s.append(x.x++);
            return;
        }
        
        s.append("(");
        
        util(split,i,split[i][j],s,x);
        
        util(split, split[i][j]+1,j,s,x);
        
        s.append(")");
    }
    
    static String matrixChainOrder(int arr[], int n){
        int dp[][]=new int[n][n];
        int split[][]=new int[n][n];
        for(int i=0;i<n;  i++){
            dp[i][i] = 0;
        }
        for(int L=2; L<n; L++)
        {
            for(int i=1; i<n-L+1; i++){
                int j = i+L-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++)
                {
                    int temp = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                
                    if(temp<dp[i][j])
                    {  
                        dp[i][j] = temp;
                        split[i][j] = k;
                        
                    }
                }
            }    
                
        }
        StringBuilder ans=new StringBuilder();
        name x=new name('A');
        util(split,1,n-1,ans,x);
        return ans.toString();
        
    }
}