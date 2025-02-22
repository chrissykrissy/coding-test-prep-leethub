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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stk = new Stack<>();
        int index = 0;
        
        while (index < traversal.length()) {
            int depth = 0;
            
            while (index < traversal.length() && traversal.charAt(index) == '-') {
                depth++;
                index++;
            }

            int value = 0;
            while (index < traversal.length() && Character.isDigit(traversal.charAt(index))) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            TreeNode node = new TreeNode(value);

            while (stk.size() > depth) {
                stk.pop();
            }

            if (!stk.empty()) {
                if (stk.peek().left == null) {
                    stk.peek().left = node;
                } else {
                    stk.peek().right = node;
                }
            }

            stk.push(node);
        }
        while (stk.size() > 1) {
            stk.pop();
        }

        return stk.peek();
    }
}