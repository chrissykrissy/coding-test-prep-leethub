class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n < 2){
            ArrayList<Integer> centroids = new ArrayList<>();
            for(int i = 0; i < n; i++){
                centroids.add(i);
            }
            return centroids;
        }
        ArrayList<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new HashSet<Integer>());
        }

        for(int[] e : edges){
            Integer start = e[0], end = e[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        //initialize the first layer of leaves
        ArrayList<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(graph.get(i).size() == 1){
                leaves.add(i);
            }
        }

        //trim the leaves until reaching the centroids
        int remain = n;
        while(remain > 2){
            remain -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            //remove the current leaves along with the edges
            for(Integer leaf : leaves){
                Integer neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);
                if(graph.get(neighbor).size() == 1){
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;

    }
}