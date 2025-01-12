class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) return false;

        int open = 0;
        int unlocked = 0;

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                unlocked++;
            } else if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } else if (unlocked > 0) {
                    unlocked--;
                } else {
                    return false;
                }
            }
        }

        int balance = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                balance--;
                unlocked--;
            } else if (s.charAt(i) == '(') {
                balance++;
                open--;
            } else if (s.charAt(i) == ')') {
                balance--;
            }

            if (balance > 0) {
                return false;
            }

            if (unlocked == 0 && open == 0) {
                break;
            }
        }

        if (open > 0) {
            return false;
        }

        return true;
    }
}