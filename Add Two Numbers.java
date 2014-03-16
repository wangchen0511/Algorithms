/**
	Add Two Numbers 
	
	You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	
*/





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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
         ListNode iter1=l1,iter2=l2,newHead=new ListNode(0),newTail;
        newTail=newHead;
        int res=0;
        int addition=0;
        while(l1!=null || l2!=null){
            int temp;
            if(l1==null){
                temp=l2.val+addition;
                l2=l2.next;
            }
            else if(l2==null){
                temp=l1.val+addition;
                l1=l1.next;
            }
            else{
                temp=l1.val+l2.val+addition;
                l1=l1.next;
                l2=l2.next;
            }
            addition=temp/10;
            temp=temp%10;
            newTail.next=new ListNode(temp);
            newTail=newTail.next;
        }
        if(addition!=0){
            newTail.next=new ListNode(addition);
        }
        return newHead.next;
        
    }
}



//no sentinel
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int c = 0;
        while(l1 != null || l2 != null){
            int insertVal;
            if(l1 == null){
                insertVal = l2.val + c;
                l2 = l2.next;
            }else if(l2 == null){
                insertVal = l1.val + c;
                l1 = l1.next;
            }else{
                insertVal = l1.val + l2.val + c;
                l1 = l1.next;
                l2 = l2.next;
            }
            c = insertVal / 10;
            if(head == null){
                head = new ListNode(insertVal % 10);
                tail = head;
            }else{
                tail.next = new ListNode(insertVal % 10);
                tail = tail.next;
            }
        }
        if(c > 0){
            tail.next = new ListNode(c);
        }
        return head;
    }
}
