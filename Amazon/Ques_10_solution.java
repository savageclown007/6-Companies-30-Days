// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(nuts, bolts, n);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    void matchPairs(char nuts[], char bolts[], int n) {
    char arr[]={'0','0','0','0','0','0','0','0','0'};
    for(int i=0;i<n;i++){
        if(nuts[i]=='!')arr[0]='!';
        else if(nuts[i]=='#')arr[1]='#';
        else if(nuts[i]=='$')arr[2]='$';
        else if(nuts[i]=='%')arr[3]='%';
        else if(nuts[i]=='&')arr[4]='&';
        else if(nuts[i]=='*')arr[5]='*';
        else if(nuts[i]=='@')arr[6]='@';
        else if(nuts[i]=='^')arr[7]='^';
        else arr[8]='~';
    }
    int count=0;
    for(int i=0;i<9;i++){
        if(arr[i]!='0'){
            nuts[count]=arr[i];
            bolts[count]=arr[i];
            count++;
        }      
    }
}
}