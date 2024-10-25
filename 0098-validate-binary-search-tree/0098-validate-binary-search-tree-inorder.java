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
    public boolean isValidBST(TreeNode root) {
        return isValidLeaf(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidLeaf(TreeNode root, long lower, long upper){
        if(root == null || root.right == null && root.left == null) return true;
        if(root.left != null && (root.left.val >= root.val || root.left.val >= upper || root.left.val <= lower)){
            return false;
        }
        if(root.right != null && (root.right.val <= root.val || root.right.val <= lower || root.right.val >= upper)){
            return false;
        }
        boolean right = isValidLeaf(root.right, root.val, upper);
        boolean left = isValidLeaf(root.left, lower, root.val);
        return left && right;    
    }
}