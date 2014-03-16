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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0){
            return null;
        }
        return buildTreeHelper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    
    
    private TreeNode buildTreeHelper(int[] inorder, int fromI, int toI, int[] postorder, int fromP, int toP){
        if(fromI==toI){
            return new TreeNode(inorder[fromI]);
        }
        else if(fromI>toI){
            return null;
        }
        int rootIndex=fromI;
        for(;rootIndex<=toI;rootIndex++){
            if(inorder[rootIndex]==postorder[toP]){
                break;
            }
        }
        TreeNode root=new TreeNode(inorder[rootIndex]);
        TreeNode left=buildTreeHelper(inorder,fromI,rootIndex-1,postorder,fromP,(rootIndex-fromI)+fromP-1);
        TreeNode right=buildTreeHelper(inorder,rootIndex+1,toI,postorder,(rootIndex-fromI)+fromP,toP-1);
        root.left=left;
        root.right=right;
        return root;
    }
}