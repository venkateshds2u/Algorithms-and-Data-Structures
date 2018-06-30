

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.








class Solution {
    public int lengthOfLIS(int[] nums) {
        int result=0;
        int[] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int count = 0;
            int temp = 0;
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    if(temp<dp[j])
                    {
                        temp = dp[j];
                    }
                }
            }
            dp[i]=temp+1;
        }
        for(int k=0;k<nums.length;k++)
        {
            if(result < dp[k])
            {
                result = dp[k];
            }
        }
        return result;
        
    }
}
