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
    /*
    approach: 
        2               2 
      /    \             \
    1       3     ->      1
                           \
                            3 

     ^ set that right child to point to 3 

    approach: 
        - go to the greatest value in the left subtree 
        - set its right child to the original root's right child 
        - now we have 1.right pointing to 3
            - set 2.right pointing to 1 
            - set 2.left to null 

    - go all the way to the greatest left subtree value 
    - set the right child of this subtree to current root's right subtree 
        now we have a reference to the right subtree (1)
    - set current node's right to curr left, 
        so we set 2.right to 1 
    */
    public void flatten(TreeNode root) {
        TreeNode curr = root; 
        
        while (curr != null) {
            
            // check if there is a left subtree 
            if (curr.left != null) {

                // go all the way down to the bottom right child of the left subtree 
                TreeNode temp = curr.left; 
                while (temp.right != null) {
                    temp = temp.right; 
                }

                // set the right pointer of this to current "root"s right subtree 
                temp.right = curr.right; 

                // Use the current node's left subtree to replace the original right subtree 
                curr.right = curr.left; 
                curr.left = null; 
            }

            curr = curr.right; 
        }
    }
}