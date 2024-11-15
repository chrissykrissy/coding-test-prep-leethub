/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //add as complete numbers
        int num1 = 0;
        int num2 = 0; 
        int count = 1;
        while (l1 != null){
            num1 += l1.val * count;
            l1 = l1.next;
            count *= 10;
        }
        count = 1;
        while (l2 != null) {
            num2 += l2.val * count;
            l2 = l2.next;
            count *= 10;
        }
        int sum = num1 + num2;
        if (sum == 0) return new ListNode(0);

        ListNode ret = new ListNode();
        ListNode dummy = ret;
        while (sum != 0) {
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next;
            sum /= 10;
        }

        return ret.next;

    }
}