


Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]








class Solution 
{
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        int start =0;
        Arrays.sort(candidates);
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
            if(!result.contains(templist))
            {
                result.add(new ArrayList<>(templist));    
            }
            
        }
        for(int i=0;i<candidates.length;i++)
        {
            if(i>=start)
            {
                
                templist.add(candidates[i]);
                helper(candidates, target-candidates[i], templist, ++start);
                templist.remove(templist.size()-1);
            }
            
            
        }
        
    }
}
