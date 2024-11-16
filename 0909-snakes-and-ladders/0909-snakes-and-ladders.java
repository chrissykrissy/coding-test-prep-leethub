class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Collections.reverse(Arrays.asList(board)); 
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            //[sq, moves]
            int[] popped = q.poll();
            for (int i = 1; i < 7; i++) {
                int next = popped[0] + i;
                int[] coord = intToPos(next, n);
                if (board[coord[0]][coord[1]] != -1) {
                    next = board[coord[0]][coord[1]];
                }
                if (next == n * n) {
                    return popped[1] + 1;
                }
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.offer(new int[]{next, popped[1]+1});
                }
            }
        }
        return -1;
    }

    public int[] intToPos(int sq, int n) {
        int row = (sq - 1) / n; 
        int col = (sq - 1) % n; 
        if (row % 2 != 0) {
            col = n - 1 - col;
        }
        return new int[] {row, col};
    }
}