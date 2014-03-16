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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isBalancedHelper(root).isBalanced;
    }
    
    
    private class DataPackage{
        public int max;
        public boolean isBalanced;
    }
    
    private DataPackage isBalancedHelper(TreeNode root){
        DataPackage ret=new DataPackage();
        if(root==null){
            ret.max=0;
            ret.isBalanced=true;
            return ret;
        }
        DataPackage left=isBalancedHelper(root.left);
        DataPackage right=isBalancedHelper(root.right);
        if(!left.isBalanced || !right.isBalanced){
            ret.isBalanced=false;
            return ret;
        }
        else{
            ret.max=Math.max(left.max,right.max)+1;
            if(Math.abs(left.max-right.max)>1){
                ret.isBalanced=false;
            }
            else{
                ret.isBalanced=true;
            }
            return ret;
        }
    }
}