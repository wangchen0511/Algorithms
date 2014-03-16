/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length=0;
        ListNode iter=head;
        while(iter!=null){
            length++;
            iter=iter.next;
        }
        return sortedList(head,length);
    }
    
    
    private TreeNode sortedList(ListNode head, int length){
        if(length==1){
            return new TreeNode(head.val);
        }
        else if(length==0){
            return null;
        }
        int mid=length/2;
        ListNode midList=head;
        for(int i=0;i<mid;i++){
            midList=midList.next;
        }
        TreeNode root=new TreeNode(midList.val);
        TreeNode left=sortedList(head,mid);
        TreeNode right=sortedList(midList.next,length-mid-1);
        root.left=left;
        root.right=right;
        return root;
    }
    
}