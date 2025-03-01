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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode slow=head;
        ListNode fast=head;

        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode curr=slow;
        ListNode prev=null;

        while(curr !=null){
            ListNode nextNode =curr.next;
            curr.next =prev;
            prev =curr;
            curr =nextNode;
        }

        while(prev != null){
            if(prev.val != head.val){
                return false;
            }

            prev= prev.next;
            head=head.next;
        }


        return true;










    }
}