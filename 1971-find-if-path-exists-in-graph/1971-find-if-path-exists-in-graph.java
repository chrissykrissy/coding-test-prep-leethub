class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int from = q.poll();
            if (from == destination) return true;
            List<Integer> neighbors = graph.get(from);
            for (int i = 0; i < neighbors.size(); i++) {
                int to = neighbors.get(i);
                if (!visited[to]) {
                    visited[to] = true;
                    q.add(neighbors.get(i));
                }
            }
        }
        return false;
    }
}