// Question Link: https://practice.geeksforgeeks.org/problems/run-length-encoding/1/

// { Driver Code Starts
    import java.util.*;
 
    class RLEncoding
    {
       public static void main(String[] args) 
       {
     
          Scanner sc = new Scanner(System.in);
        
          int T = sc.nextInt();
          sc.nextLine();
          while(T>0)
          {
              
            String str = sc.nextLine();
            
            GfG g = new GfG();
            System.out.println(g.encode(str));
            
          
            T--;
          }
       }
    }
    
    // } Driver Code Ends
    
    
    class GfG
     {
        String encode(String str)
        {
            StringBuilder ans=new StringBuilder();
            int cnt=0;
            int i=0;
            while(i<str.length())
            {
                ans.append(str.charAt(i));
                cnt=0;
                int j=i;
                while(j<str.length() && str.charAt(j)==str.charAt(i))
                {
                    cnt++;
                    j++;
                }
                i=j;
                ans.append(cnt);
            }
            
            return ans.toString();
        }
        
     }