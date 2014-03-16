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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode anchor=new ListNode(0);
        anchor.next=head;
        ListNode firstTail=anchor;
        for(int i=0;i<m-1;i++){
            firstTail=firstTail.next;
        }
        ListNode secondHead=null,secondTail=null;
        ListNode iter=firstTail.next;
        for(int i=0;i<n-m+1;i++){
            ListNode next=iter.next;
            if(secondHead==null){
                secondHead=iter;
                secondTail=iter;
            }
            else{
                iter.next=secondHead;
                secondHead=iter;
            }
            iter=next;
        }
        firstTail.next=secondHead;
        secondTail.next=iter;
        return anchor.next;
        
        
    }
}




// another version

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null){
            return null;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode iter = head, lastIter = sentinel;
        for(int i = 0; i < m - 1; i++){
            lastIter = iter;
            iter = iter.next;
        }
        ListNode newHead = iter, newTail = iter, reverseIter = iter.next;
        for(int i = 1; i <= n - m; i++){
            ListNode next = reverseIter.next;
            reverseIter.next = newHead;
            newHead = reverseIter;
            reverseIter = next;
        }
        lastIter.next = newHead;
        newTail.next = reverseIter;
        return sentinel.next;
        
    }
}