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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode firstProbe=head;
        if(head==null){
            return null;
        }
        for(int i=0;i<n;i++){
            firstProbe=firstProbe.next;
        }
        if(firstProbe==null){
            return head.next;
        }
        ListNode secondProbe=head;
        while(firstProbe.next!=null){
            firstProbe=firstProbe.next;
            secondProbe=secondProbe.next;
        }
        secondProbe.next=secondProbe.next.next;
        return head;
    }
}