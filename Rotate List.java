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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null){
            return head;
        }
        else if(n==0){
            return head;
        }
        ListNode tail=head;
        ListNode newTail=head;
        ListNode newHead;
        for(int i=0;i<n;i++){
            tail=tail.next;
            if(tail==null){
                tail=head;
            }
        }
        if(tail==head){
            return head;
        }
        while(tail.next!=null){
            newTail=newTail.next;
            tail=tail.next;
        }
        newHead=newTail.next;
        tail.next=head;
        newTail.next=null;
        return newHead;
    }
}