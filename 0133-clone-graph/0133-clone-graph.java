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
    TC : O(N + M) N is num of nodes and M is num of edges
    SC : O(N) visited hashMap, recursion stack O(Height of the graph) H < N so
    */
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        //if the node was already visited before
        //return the clone from the visited dic
        if(visited.containsKey(node)){
            return visited.get(node);
        }

        //create a clone for the given node
        // note that we don't have cloned neighbors yet
        Node cloneNode = new Node(node.val, new ArrayList<>());
        //the key is original node and the v is the clone node
        visited.put(node, cloneNode);

        //iterate the neighbors to generate their clones
        //prepare a list of cloned neighbors to be added to the cloned node
        for(Node n : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(n));
        }
        return cloneNode;
    }
}