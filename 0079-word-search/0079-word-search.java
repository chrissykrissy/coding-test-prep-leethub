class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean exist = dfs(board, i, j, word, 0);
                    if(exist) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String s, int index){
        if(index == s.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || index > s.length() || board[i][j] != s.charAt(index)){
            return false;
        }
        char ori = board[i][j];
        board[i][j] = '#';
        boolean result = dfs(board, i+1, j, s, index+1) || dfs(board, i-1, j, s, index+1)
        || dfs(board, i, j-1, s, index+1) || dfs(board, i, j+1, s, index+1);
        board[i][j] = ori;
        return result;
    }
}