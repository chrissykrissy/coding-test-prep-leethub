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
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;
        while (!q.isEmpty()) {
            sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return sum;
    }
}