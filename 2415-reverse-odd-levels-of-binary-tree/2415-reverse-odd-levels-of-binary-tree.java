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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode popped = q.poll();
                if (popped.left != null) q.offer(popped.left);
                if (popped.right != null) q.offer(popped.right);
            }
            level++;
            if (level % 2 == 1 && !q.isEmpty()) {
                int[] nums = new int[q.size()];
                int i = 0;
                for (TreeNode node : q) {
                    nums[i++] = node.val; 
                }
                int j = q.size() - 1;
                for (TreeNode node : q) {
                    node.val = nums[j--];
                }
            }
        }
        return root;
    }
}