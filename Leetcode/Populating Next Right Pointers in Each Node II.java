/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return;
        }
        connect(root.left);
        connect(root.right);
        TreeLinkNode lL=root.left,rL=root.right;
        while(lL!=null){
            TreeLinkNode lR=lL;
            while(lL!=null){
                if(lL.left!=null){
                    lL=lL.left;
                    break;
                }
                if(lL.right!=null){
                    lL=lL.right;
                    break;
                }
                lL=lL.next;
            }
            while(lR.next!=null){
                lR=lR.next;
            }
            lR.next=rL;
            while(rL!=null){
                if(rL.left!=null){
                    rL=rL.left;
                    break;
                }
                if(rL.right!=null){
                    rL=rL.right;
                    break;
                }
                rL=rL.next;
            }
        }
    }
}




/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if((root == null) || (root.left == null && root.right == null)){
            return;
        }   
        connect(root.left);
        connect(root.right);
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        while(left != null && right != null){
            TreeLinkNode nextLeft = findNextLeft(left);
            while(left.next != null){
                left = left.next;
            }
            left.next = right;
            left = nextLeft;
            right = findNextLeft(right);
        }
    }
    
    private TreeLinkNode findNextLeft(TreeLinkNode left){
        while(left != null){
            if(left.left != null){
                return left.left;
            }else if(left.right != null){
                return left.right;
            }
            left = left.next;
        }
        return left;
    }
    
    
}