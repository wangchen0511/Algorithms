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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int min=-1;
        if(root.left!=null){
            min=minDepth(root.left);
        }
        if(root.right!=null){
            int temp=minDepth(root.right);
            if(min<0){
                min=temp;
            }
            else{
                min=min>temp?temp:min;
            }
        }
        return min+1;
        
    }
}