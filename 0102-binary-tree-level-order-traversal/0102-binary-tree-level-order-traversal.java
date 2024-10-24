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
    class LevelNode{
        TreeNode root;
        int level;
        LevelNode(TreeNode root, int level){
            this.root = root;
            this.level =  level;
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>(); 
        List<List<Integer>> ret = new ArrayList<>();
        Queue<LevelNode> q = new LinkedList<>();
        q.offer(new LevelNode(root, 0));
        while(!q.isEmpty()){
            LevelNode curr = q.poll();
            if(ret.size() <= curr.level){
                ret.add(new ArrayList<>());
            }
            ret.get(curr.level).add(curr.root.val);
            if(curr.root.left != null){
                q.offer(new LevelNode(curr.root.left, curr.level+1));
            }
            if(curr.root.right != null){
                q.offer(new LevelNode(curr.root.right, curr.level+1));
            }
        }
        return ret;
    }
}