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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode iter1=l1;
        ListNode iter2=l2;
        ListNode head=null,tail=null;
        while(iter1!=null || iter2!=null){
            ListNode next;
            if(iter1==null){
                next=iter2;
                iter2=iter2.next;
            }
            else if(iter2==null){
                next=iter1;
                iter1=iter1.next;
            }
            else{
                if(iter1.val<iter2.val){
                    next=iter1;
                    iter1=iter1.next;
                }
                else{
                    next=iter2;
                    iter2=iter2.next;
                }
            }
            if(head==null){
                head=next;
                tail=next;
            }
            else{
                tail.next=next;
                tail=next;
            }
        }
        return head;
    }
}