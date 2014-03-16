/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null){
            return null;
        }
        ListNode newHead=null,tail=null;
        ListNode iter=head;
        while(iter!=null){
            if(iter.next==null || iter.next.val!=iter.val){
                if(newHead==null){
                    newHead=iter;
                    tail=iter;
                }
                else{
                    tail.next=iter;
                    tail=tail.next;
                }
                iter=iter.next;
            }
            else{
                while(iter.next!=null && iter.val==iter.next.val){
                    iter=iter.next;
                }
                iter=iter.next;
            }
        }
        if(tail!=null){
            tail.next=null;
        }
        return newHead;
    }
}