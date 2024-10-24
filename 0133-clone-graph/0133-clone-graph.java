/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    /*
    TC : O(N + M) where N is the number of nodes and M is a number of edges
    SC : O(N) visited hash map and recursion stack O(H) height of the graph
    */
    Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        //if the node was already visited before,
        //return the clone from the visited dict
        if(visited.containsKey(node.val)) return visited.get(node.val);
        
        //create a clone for the given node
        Node newNode = new Node(node.val, new ArrayList<Node>());
        visited.put(newNode.val, newNode);
        //iterate through the neighbors to generate their clones
        //and prepare a list of clones neighbors to be added to the cloned node
        for (Node n : node.neighbors){
            newNode.neighbors.add(cloneGraph(n));
        }

        return newNode;
    }
}