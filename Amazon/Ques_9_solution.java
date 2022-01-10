// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isValid(int mat[][]){
        int row[][]=new int[9][9];
        int col[][]=new int[9][9];
        int box[][][]=new int[3][3][9];
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
               if(mat[i][j]>0 && mat[i][j]<=9)
               {
                    int num=mat[i][j]-1;
                if(row[i][num]!=0)
                return 0;
                row[i][num]=1;
                if(col[j][num]!=0)
                return 0;
                col[j][num]=1;
                if(box[i/3][j/3][num]!=0)
                return 0;
                box[i/3][j/3][num]=1;
               }
               
            }
            
            
        }
        
        
        return 1;
    }
}