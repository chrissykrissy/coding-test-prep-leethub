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
    private int preI = 0;
    private int postI = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        //preorder = root, left, right
        //postorder = left, right, root
        return constructTree(preorder, postorder);
    }

    private TreeNode constructTree(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preI++]);

        if (root.val != post[postI]) {
            root.left = constructTree(pre, post);
        }

        if (root.val != post[postI]) {
            root.right = constructTree(pre, post);
        }

        postI++;
        return root;
    }
}