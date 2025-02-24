class Solution {
    private Map<Integer, Integer> bobPath;
    private boolean[] visited;
    private List<List<Integer>> tree;
    private int maxIncome = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        tree = new ArrayList<>();
        bobPath = new HashMap<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        //form tree with edges
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        //find the path taken by bob to reach node 0 and the times it takes to get there
        findBobPath(bob, 0);

        Arrays.fill(visited, false);
        findAlicePath(0,0,0, amount);
        return maxIncome;
    }

    //DFS to find Bob's path
    private boolean findBobPath(int sourceNode, int time) {
        //mark and set time node is reached
        bobPath.put(sourceNode, time);
        visited[sourceNode] = true;

        //destination for bob is found
        if (sourceNode == 0) {
            return true;
        }

        //traverse through unvisited nodes
        for (int adjacentNode : tree.get(sourceNode)) {
            if (!visited[adjacentNode] && findBobPath(adjacentNode, time + 1)) {
                return true;
            }
        }

        //if node 0 isn't reached, remove current node from path
        bobPath.remove(sourceNode);
        return false;
    }

    //dfs to find Alice's optimal path
    private void findAlicePath(
        int sourceNode, int time, int income, int[] amount
    ) {
        //mark node as explored
        visited[sourceNode] = true;

        //Alice reaches the node first
        if (!bobPath.containsKey(sourceNode) || time < bobPath.get(sourceNode)) {
            income += amount[sourceNode];
        } 
        //Alice and bob reach the node at the same time
        else if (time == bobPath.get(sourceNode)) {
            income += amount[sourceNode]/2;
        }

        //update max value if current node is a new leaf
        if (tree.get(sourceNode).size() == 1 && sourceNode != 0) {
            maxIncome = Math.max(maxIncome, income);
        }


        //traverse through unvisited nodes
        for (int adj : tree.get(sourceNode)) {
            if (!visited[adj]) {
                findAlicePath(adj, time + 1, income, amount);
            }
        }
    }
}
