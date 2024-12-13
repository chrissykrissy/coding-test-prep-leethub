class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //two binary search
        //find row
        int i = 0, j = matrix.length-1;
        while (i <= j) {
            int mid = (i + j)/2;
            //행이 마지막인지 확인하거나, 다음 행의 첫 번째 값보다 target이 작은지를 조건에 추가.
            if (matrix[mid][0] <= target && (mid == matrix.length - 1 || matrix[mid + 1][0] > target)) {
                i = mid;
                break;
            }
            if (matrix[mid][0] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        int k = 0;
        int col = matrix[i].length-1;
        while (k <= col) {
            int mid = (k + col)/2;
            if (matrix[i][mid] == target) {
                return true;
            }
            if (matrix[i][mid] > target) {
                col = mid - 1;
            }else {
                k = mid + 1;
            }
        }
        return false;
    }
}