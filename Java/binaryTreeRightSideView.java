
class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        map.put(null, -1);
        dfsRecursiveSolution(root, null);
        return list;
    }
    public void dfsRecursiveSolution(TreeNode node, TreeNode parent)
    {
        if(node!=null)
        {
            map.put(node, map.get(parent)+1);
            if(map.get(node)==list.size())
            {
                list.add(node.val);
            }
            dfsRecursiveSolution(node.right, node);
            dfsRecursiveSolution(node.left, node);
        }
       
    }
}
