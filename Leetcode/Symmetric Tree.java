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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return true;
        }
        return isSym(root.left,root.right);
    }
    
    private boolean isSym(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        else if(left==null || right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return isSym(left.left,right.right) & isSym(left.right,right.left);
    }
}