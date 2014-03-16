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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null){
            return null;
        }
        ListNode anchor=new ListNode(0);
        anchor.next=head;
        ListNode iter=head,iterLast=anchor,lastSmall=anchor;
        while(iter!=null){
            if(iter.val<x){
                lastSmall=iter;
                iterLast=iter;
                iter=iter.next;
            }
            else{
                break;
            }
        }
        while(iter!=null){
            if(iter.val<x){
                ListNode next=iter.next;
                iterLast.next=iter.next;
                iter.next=lastSmall.next;
                lastSmall.next=iter;
                lastSmall=iter;
                iter=next;
            }
            else{
                iterLast=iter;
                iter=iter.next;
            }
        }
        return anchor.next;
    }
}