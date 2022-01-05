class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,ans=Integer.MAX_VALUE;
        int sum=0;
        while(j<nums.length)
        {
            sum+=nums[j++];
            
            while(sum>=target)
            {
                ans=Math.min(ans,j-i);
                sum-=nums[i++];
            }
        }
            
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
