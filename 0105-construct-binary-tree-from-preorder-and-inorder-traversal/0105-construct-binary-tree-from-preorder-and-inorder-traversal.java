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
    int currPre = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(map, preorder, 0, preorder.length-1);

    }

    private TreeNode build(Map<Integer, Integer> map, int[] preorder, int left, int right){
        if(left > right) return null;
        int rootVal = preorder[currPre++];
        int inRootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = build(map, preorder, left, inRootIndex-1);
        root.right = build(map, preorder, inRootIndex+1, right);
        return root;
    }
}