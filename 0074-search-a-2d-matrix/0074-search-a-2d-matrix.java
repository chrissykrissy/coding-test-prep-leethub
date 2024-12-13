class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //two binary searches

        //search row
        int top = 0, bot = matrix.length-1;
        while(top <= bot){
            int mid = top + (bot - top) / 2;
            if(target > matrix[mid][matrix[0].length-1]){
                top = mid + 1;
            }else if (target < matrix[mid][0]){
                bot = mid - 1;
            }else{
                break;
            }
        }
        if(top > bot) return false;
        int row = top + (bot-top)/2;
        int l = 0, r = matrix[0].length-1;
        while(l <= r){
            int m =  l + (r - l)/2;
            if (target > matrix[row][m]){
                l = m + 1;
            }else if (target < matrix[row][m]){
                r = m - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}