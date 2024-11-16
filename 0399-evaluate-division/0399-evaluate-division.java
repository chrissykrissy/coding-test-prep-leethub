class Solution {
    Map<String, Map<String, Double>> graph; 
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            // 방문 처리를 위한 Set 사용
            Set<String> visited = new HashSet<>();
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, visited);
        }
        return res;
    }
    public double dfs(String a, String b, double total, Set<String> visited) {
        if (!graph.containsKey(a) || !graph.containsKey(b)) {
            return -1.0;
        }
        if (visited.contains(a)) {
            return -1.0;
        }
        visited.add(a);
            //the letter is present in the map
            //1. adj
            //2. not adj <- dfs again
        if (graph.get(a).containsKey(b)){
            return total * graph.get(a).get(b);
        }
        for (Map.Entry e : graph.get(a).entrySet()) {
            double result = dfs(e.getKey().toString(), b, total * (double) e.getValue(), visited);
            if (result != -1.0) {
                return result; // 경로를 찾은 경우 즉시 반환
            }
        }
        return -1.0;
    }


    public void buildGraph(List<List<String>> equations, double[] values) {
        graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1 / value);
        }
    }


}