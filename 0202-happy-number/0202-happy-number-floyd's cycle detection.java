class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && fast != slow) {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        }
        return fast == 1;
    }
    public int getNext(int n) {
        int total = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            total += d * d;
        }
        return total;
    }
}