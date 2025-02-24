public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null|| head.next==null) return false;
        
        ListNode fast=head;
        ListNode slow=head;
        while(fast != null){
           if(slow == null) return false;
            slow=slow.next;
            if(fast.next==null) return false;
            fast=fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}