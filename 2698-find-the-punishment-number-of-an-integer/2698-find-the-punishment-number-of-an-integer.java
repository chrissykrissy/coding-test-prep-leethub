class Solution {
    public int punishmentNumber(int n) {
        int punishment = 0; 

        for (int curr = 1; curr <= n; curr++) {
            int sq = curr * curr;

            if (canPartition(sq, curr)) {
                punishment += sq;
            }
        }
        
        return punishment;
    }

    public boolean canPartition(int num, int target) {
        if (num < target || target < 0) {
            return false;
        }

        if (num == target) {
            return true;
        }
        
        return (canPartition(num/10, target-(num % 10)) || canPartition(num/100, target-(num % 100)) || canPartition(num/1000, target - (num % 1000)));
    }
}