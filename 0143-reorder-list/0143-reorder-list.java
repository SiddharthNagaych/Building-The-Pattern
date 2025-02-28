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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow=head;
        ListNode fast=head;

        while(fast !=null &&fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        } 

        ListNode curr=slow.next;
        ListNode prev=null;
        slow.next=null;
        while(curr != null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }

        // merging two splitted final linked list

        ListNode first=head;
        ListNode second =prev;

        while( second !=null){
            ListNode temp1=first.next;
            ListNode temp2=second.next;

            first.next=second;
            second.next=temp1;

            first=temp1;
            second=temp2;
        }






    }
}