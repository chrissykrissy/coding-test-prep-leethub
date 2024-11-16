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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        if (n == 0) return head;
        k = k%n;
        if (k == 0) return head;
        ListNode newTail = head;
        for (int i = 1; i < n - k; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        ListNode tempNode = newHead;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = head;
        return newHead;
    }
}