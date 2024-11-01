/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb){
        if(root != null){
            sb.append(String.valueOf(root.val)).append(",");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }else{
            sb.append("N").append(",");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        // q.poll();
        return preOrder(q);
    }

    private TreeNode preOrder(Queue<String> q){
        String val = q.poll();
        if("N".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = preOrder(q);
        root.right = preOrder(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));