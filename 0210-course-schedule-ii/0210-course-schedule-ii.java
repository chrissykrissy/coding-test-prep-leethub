class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //return order of v where you can traverse the whole graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            graph.putIfAbsent(p[1], new ArrayList<>());
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            order[index++] = course;
            if (graph.containsKey(course)) {
                for (int next : graph.get(course)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.add(next);
                    }
                }
            }
        }
        return index == numCourses ? order : new int[0];
        
    }

}