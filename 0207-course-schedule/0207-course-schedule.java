class Solution {
    /*
    approach: 
    - topological sort
    - maintain indegree array where indegree[i] = how many nodes come before node i 
    - use matrix representation of graph where matrix[i][j] = directed edge from i -> j 
    - build graph 

    - utilize BFS search for topological sort 
    - add nodes with indegree of 0 from queue 
    - add queues neighbors 
    - once a node is processed increment a count 
    - check that the count equals to the number of nodes to verify correctness 

    time: o(m + n)
    space: o(m + n) 
    here m is the number of 'nodes' and n is the number of courses 
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Maintain indegree array where indegree[i] = how many classes come before node i 
        int[] indegree = new int[numCourses];
        
        // Maintain matrix representation of graph where matrix[i][j] means there is an edge from i -> j 
        int[][] graph = new int[numCourses][numCourses];
        
        // Build graph 
        for (int[] prereq: prerequisites) {
            int a = prereq[0], b = prereq[1]; // b is prereq for a 
            if (graph[b][a] == 0) {
                indegree[a]++;
            }
            graph[b][a] = 1;
        }

        int count = 0; 

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {

            // if indegree is 0 that means there are no prerequisites so we can directly start with these 
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            count++; // we take this class 

            // for this class, check what classes we must offer to the queue next 
            for (int i = 0; i < numCourses; i++) {
                if (graph[course][i] != 0) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }

        return count == numCourses;
    }
}