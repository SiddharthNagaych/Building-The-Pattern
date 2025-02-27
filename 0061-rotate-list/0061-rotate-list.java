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
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Calculate the length of the list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Normalize k to be within the length of the list
        k = k % length;
        if (k == 0) {
            return head; // No rotation needed
        }

        // Find the new tail (length - k - 1 steps from the head)
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        // The new head is the node after the new tail
        ListNode newHead = newTail.next;

        // Break the list and form the rotated list
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}