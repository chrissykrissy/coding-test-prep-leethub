class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>(); 

        if (n == 1) {
            res.add(0);
            return res; 
        }

        // create adjacency matrix
        // index is node, value at index is set of all of the node's neighbors 
        List<Set<Integer>> graph = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge: edges) {
            int a = edge[0], b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // process first row of leaves 
        List<Integer> leaves = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            // get nodes with only one neighbor = leaf nodes 
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // continuously "trim" the outer leaves of the graph 
        // until there are only 2 or less nodes remaining 
        while (n > 2) {
            n -= leaves.size(); 
            List<Integer> newLeaves = new ArrayList<>(); 

            // for every leaf, check its neighbors 
            for (int leaf: leaves) {
                for (int neighbor: graph.get(leaf)) {

                    // remove this leaf 
                    graph.get(neighbor).remove(leaf);

                    // if we encounter a new leaf after removing a nodes neighbor, add this to the leaf list 
                    if (graph.get(neighbor).size() == 1) {
                        newLeaves.add(neighbor);
                    }
                }
            }
            leaves = newLeaves;
        }

        return leaves; 
    }
}