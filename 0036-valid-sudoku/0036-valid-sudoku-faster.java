class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] checkRow;
        int[] checkCol;
        for(int i = 0; i < board.length; i++){
            checkRow = new int[10];
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.'){
                    if(checkRow[board[i][j]-'0'] > 0){
                        return false;
                    }
                    checkRow[board[i][j]-'0']++;
                }
            }
        }
        for(int i = 0;  i < board.length; i++){
            checkCol = new int[10];
            for(int j = 0; j < board.length; j++){
                if(board[j][i] != '.'){
                    if(checkCol[board[j][i]-'0'] > 0){
                        return false;
                    }
                    checkCol[board[j][i]-'0']++;
                }
            }
        }

                for (int startRow = 0; startRow < board.length; startRow += 3) {
            for (int startCol = 0; startCol < board[0].length; startCol += 3) {
                int[] checkBox = new int[10];
                for (int row = startRow; row < startRow + 3; row++) {
                    for (int col = startCol; col < startCol + 3; col++) {
                        if (board[row][col] != '.') {
                            if (checkBox[board[row][col] - '0'] > 0) {
                                return false;
                            }
                            checkBox[board[row][col] - '0']++;
                        }
                    }
                }
            }
        }

        return true;
    }
}