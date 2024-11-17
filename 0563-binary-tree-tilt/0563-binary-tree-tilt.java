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
    int sum = 0;
    public int findTilt(TreeNode root) {
        //1. diff between leaves
        //2. sum of the left tree, sum of the right tree
        //3. total sum
        if (root == null) return 0;
        calcTilt(root);
        return sum;
    }
    public int calcTilt(TreeNode root) {
        int left = 0, right = 0;
        if (root.left != null) {
            left = calcTilt(root.left);
        }
        if (root.right != null) {
            right = calcTilt(root.right);
        }

        int ret = root.val;
        root.val = Math.abs(left-right);
        sum += root.val;
        return ret + left + right;
    }
}