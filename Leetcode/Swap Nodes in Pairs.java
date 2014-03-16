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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode prev=new ListNode(0);
        ListNode iter=head,newHead=prev;
        prev.next=head;
        while(iter!=null){
            ListNode temp=iter.next;
            if(temp==null){
                break;
            }
            prev.next=temp;
            iter.next=temp.next;
            temp.next=iter;
            prev=iter;
            iter=iter.next;
        }
        return newHead.next;
    }
}