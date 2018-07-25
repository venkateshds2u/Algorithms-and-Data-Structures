


Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]




class Solution 
{
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        int start =0;
        helper(candidates, target, new ArrayList<Integer>(), start);
        return result;         
    }
    public void helper(int[] candidates, int target, List<Integer> templist, int start)
    {
        if(target<0)
        {
            return;
        }
        if(target == 0)
        {
            result.add(new ArrayList<>(templist));
        }
        for(int i=0;i<candidates.length;i++)
        {
            if(i>=start)
            {
                
                templist.add(candidates[i]);
                helper(candidates, target-candidates[i], templist, start++); //start++ (Awesome solution)
                templist.remove(templist.size()-1);
            }
            
        }
        
    }
}
