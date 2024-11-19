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
class BSTIterator {

    /*
    approach: 
    - utilize in-order traversal but with a manual next() function 
    - in-order traversal: 
        - use a stack 
        - when we keep going, push node and then set pointer to the left child 
        - when we process a node (or call next), we pop and push the right child 
            - this step guarantees the in-order property 
    */

    Stack<TreeNode> stk;

    public BSTIterator(TreeNode root) {
        this.stk = new Stack<>(); 
        push(root);
    }

    public void push(TreeNode node) {
        while (node != null) {
            stk.push(node);
            node = node.left; 
        }
    }
    
    public int next() {
        TreeNode curr = stk.pop();
        push(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */