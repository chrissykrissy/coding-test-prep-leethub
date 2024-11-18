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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            long sum = 0;
            double div = q.size();
            for (int i = 0; i < div; i++) {
                TreeNode popped = q.poll();
                sum += popped.val;
                if (popped.left != null) {
                    q.add(popped.left);
                }
                if (popped.right != null) {
                    q.add(popped.right);
                }
            }
            ret.add(sum/div);
        }
        return ret;
    }
}