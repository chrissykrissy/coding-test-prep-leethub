/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(n % 2 == 0) return new ArrayList<>();
        map.put(0, List.of(new TreeNode()));
        map.put(1, List.of(new TreeNode(0)));
        return makeTree(n);
    }

    public List<TreeNode> makeTree(int n){
        if (map.containsKey(n)){
            return map.get(n);
        }
        List<TreeNode> list = new ArrayList<>();
        for (int left = 1; left < n; left+=2){
            int right = n - left - 1;
            List<TreeNode> leftTree = makeTree(left);
            List<TreeNode> rightTree = makeTree(right);
            for (TreeNode t1 : leftTree){
                for (TreeNode t2 : rightTree){
                    list.add(new TreeNode(0, t1, t2));
                }
            }
            
        }
        map.put(n, list);
        return list;
    }

}