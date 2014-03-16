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
        ListNode tail=head;
        ListNode iter=head.next;
        while(iter!=null){
            if(iter.val==tail.val){
                iter=iter.next;
            }
            else{
                tail.next=iter;
                tail=tail.next;
                iter=iter.next;
            }
        }
        tail.next=null;
        return head;
    }
}