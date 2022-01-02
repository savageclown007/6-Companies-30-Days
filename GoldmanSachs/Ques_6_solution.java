// Question Link: https://leetcode.com/problems/greatest-common-divisor-of-strings/submissions/

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))
            return new String("");
        
        int gcdVal=gcd(str1.length(),str2.length());
        return str2.substring(0, gcdVal);
            
        
    }
    
    public static int gcd(int a, int b)
    {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
}