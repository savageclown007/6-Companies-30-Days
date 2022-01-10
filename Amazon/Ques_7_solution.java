// { Driver Code Starts
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
                String A = br.readLine().trim();
                Solution ob = new Solution();
                String ans = ob.FirstNonRepeating(A);
                System.out.println(ans);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution
    {
        public String FirstNonRepeating(String A)
        {
            HashMap<Character,Integer> freq=new HashMap<>();
            Queue<Character> q=new LinkedList<>();
            char fnr=A.charAt(0);
            StringBuilder ans=new StringBuilder();
            
            for(int i=0;i<A.length();i++)
            {
                freq.put(A.charAt(i),freq.getOrDefault(A.charAt(i),0)+1);
                q.add(A.charAt(i));
                
                
                if(fnr!='#' && freq.get(fnr)==1)
                {
                    ans.append(fnr);
                }
                else
                {
                    fnr='#';
                
                
                    while(!q.isEmpty() && freq.get(q.peek())!=1)
                        q.poll();
                    
                    if(!q.isEmpty())
                    {
                        fnr=q.peek();
                    }
                
                     ans.append(fnr);
                }
            }
            
            return ans.toString();
        }
    }