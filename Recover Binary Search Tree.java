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
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeNode[] ret=new TreeNode[2];
        TreeNode[] pre=new TreeNode[1];
        inorder(root,ret,pre);
        int temp=ret[0].val;
        ret[0].val=ret[1].val;
        ret[1].val=temp;
    }
    
    
    
    private void inorder(TreeNode root, TreeNode[] ret, TreeNode[] pre){
        if(root==null){
            return;
        }
        inorder(root.left,ret,pre);
        if(pre[0]!=null){
            if(pre[0].val>root.val){
                if(ret[0]==null){
                    ret[0]=pre[0];
                }
                ret[1]=root;
            }
        }
        pre[0]=root;
        inorder(root.right,ret,pre);
    }
    
}