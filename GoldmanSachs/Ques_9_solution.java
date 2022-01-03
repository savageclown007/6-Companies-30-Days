// Question Link: https://practice.geeksforgeeks.org/problems/number-following-a-pattern3126/1

// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        Stack<Integer> st=new Stack<>();
        StringBuilder ans=new StringBuilder();
        int num=1;
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='D')
            {
                st.push(num++);
            }
            else
            {
                st.push(num++);
                while(!st.isEmpty()){
                    ans.append(Integer.toString(st.pop()));
                }
            }
            
        }
        
        st.push(num++);
        while(!st.isEmpty())
        {
             ans.append(Integer.toString(st.pop()));
        }
        
        return ans.toString();
    }
}
