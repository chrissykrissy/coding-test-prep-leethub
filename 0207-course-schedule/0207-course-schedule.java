class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            map.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(map, visited, i)) return false;
        }
        return true;
    }
    private boolean dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int course){

        if(map.get(course).isEmpty()) return true;
        if(visited.contains(course)) return false;

        visited.add(course);
        for(int pre : map.get(course)){
            if(!dfs(map, visited, pre)) return false;
        }
        visited.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}