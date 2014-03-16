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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return true;
        }
        return isValidHelper(root).isValid;
        
    }
    
    private class DataPack{
        public int min;
        public int max;
        public boolean isValid; 
    }
    
    private DataPack isValidHelper(TreeNode root){
        DataPack ret=new DataPack();
        if(root.left==null && root.right==null){
            ret.min=root.val;
            ret.max=root.val;
            ret.isValid=true;
            return ret;
        }
        DataPack left,right;
        int min=0,max=0;
        if(root.left!=null){
            left=isValidHelper(root.left);
            if(!left.isValid || left.max>=root.val){
                ret.isValid=false;
                return ret;
            }
            min=left.min;
            max=left.max;
        }
        if(root.right!=null){
            right=isValidHelper(root.right);
            if(!right.isValid || root.val>=right.min){
                ret.isValid=false;
                return ret;
            }
            if(root.left!=null){
                min=Math.min(min,right.min);
                max=Math.max(max,right.max);
            }
            else{
                min=right.min;
                max=right.max;
            }
        }
        ret.min=Math.min(min,root.val);
        ret.max=Math.max(max,root.val);
        ret.isValid=true;
        return ret;
    }
}