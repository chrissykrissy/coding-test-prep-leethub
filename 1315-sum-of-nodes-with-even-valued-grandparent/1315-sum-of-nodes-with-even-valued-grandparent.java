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
    public int sumEvenGrandparent(TreeNode root) {
        return solve(root, -1, -1);
    }

    public int solve(TreeNode root, int parent, int gParent){
        if (root == null){
            return 0;
        }
        return solve(root.left, root.val, parent) + 
        solve(root.right, root.val, parent) + 
        (gParent % 2 != 0 ? 0 : root.val);
    }
}