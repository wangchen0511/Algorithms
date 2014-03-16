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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode newHead=new ListNode(1);
        newHead.next=head;
        ListNode prev=newHead,iter=head;
        while(iter!=null){
            ListNode tail=iter,nextIter,nextPrev;
            for(int i=1;i<k;i++){
                if(tail==null){
                    return newHead.next;
                }
                tail=tail.next;
            }
            if(tail==null){
                return newHead.next;
            }
            else{
                nextIter=tail.next;
                nextPrev=iter;
            }
            while(iter!=tail){
                prev.next=iter.next;
                iter.next=tail.next;
                tail.next=iter;
                iter=prev.next;
            }
            iter=nextIter;
            prev=nextPrev;
        }
        return newHead.next;
    }
}