/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    Recursive: 
    - if the node is p or q, return it 
    - if the node is not p or q 
        - search for it in the left subtree and the right subtree 
        - if both return non-null, then the current node is the LCA 
        - if left subtree returns nothing, then both p and q have to be in the right subtree 
        - same logic for vice versa 
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftCandidate = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCandidate = lowestCommonAncestor(root.right, p, q);

        // This node is the LCA 
        // because these two will have returned P and Q 
        if (leftCandidate != null && rightCandidate != null) {
            return root;
        }
        else if (leftCandidate == null) {
            return rightCandidate; // LCA has to be in the right subtree 
        } 
        else if (rightCandidate == null) {
            return leftCandidate; // LCA has to be in the left subtree 
        }

        return null;
    }
}