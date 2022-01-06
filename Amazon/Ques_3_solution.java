// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class Main {
        public static void main(String args[]) {
            // taking input using class Scanner
            Scanner sc = new Scanner(System.in);
    
            // taking total count of testcases
            int t = sc.nextInt();
    
            while (t-- > 0) {
                // taking total number of elements
                int n = sc.nextInt();
    
                // taking size of subArrays
                int k = sc.nextInt();
    
                // Declaring and Intializing an array of size n
                int arr[] = new int[n];
    
                // adding all the elements to the array
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
    
                // Calling the method max_of_subarrays of class solve
                // and storing the result in an ArrayList
                ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);
    
                // printing the elements of the ArrayList
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            }
        }
    }// } Driver Code Ends
    
    
    class Solution {
        
       static class sparseTable{
        int n;
        int[][]dp;
        int log2[];
        int P;
        
        void buildTable(int[] arr)
        {
            n=arr.length;
            P=(int)Math.floor(Math.log(n)/Math.log(2));
            
            log2=new int[n+1];
            log2[0]=log2[1]=0;
            for(int i=2;i<=n;i++)
            {
                log2[i]=log2[i/2]+1;
            }
            dp=new int[P+1][n];
            for(int i=0;i<n;i++)
            {
                dp[0][i]=arr[i];
            }
            
            for(int p=1;p<=P;p++)
            {
                for(int i=0;i+(1<<p)<=n;i++)
                {
                    int left=dp[p-1][i];
                    int right=dp[p-1][i+(1<<(p-1))];
                    dp[p][i]=Math.max(left, right);
                }
            }
        }
        
        
        int maxQuery(int l,int r)
        {
            int len=r-l+1;
            int p=(int)Math.floor(log2[len]);
            int left=dp[p][l];
            int right=dp[p][r-(1<<p)+1];
            return Math.max(left, right);
        }
    }
        
        
        static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
            sparseTable sp=new sparseTable();
            sp.buildTable(arr);
            ArrayList<Integer> res=new ArrayList<>();
            int i=0,j=k-1;
            while(j<n)
            {
                res.add(sp.maxQuery(i,j));
                i++;j++;
            }
            
            return res;
        }
    }