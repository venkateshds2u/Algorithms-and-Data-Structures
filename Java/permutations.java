
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]



class Solution 
{
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result = permute1(nums, new ArrayList<Integer>(), result);
        return result;
    }
    public static List<List<Integer>> permute1(int[] nums, List<Integer> temp, List<List<Integer>> result)
    {
        if(temp.size()==nums.length)
        {
            result.add(new ArrayList<>(temp));  
            return result;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            permute1(nums, temp, result);
            temp.remove(temp.size()-1);
            
        }
        return result;
    }
}
