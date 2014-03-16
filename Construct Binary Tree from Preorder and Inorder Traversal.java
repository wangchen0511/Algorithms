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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
          if(preorder==null || preorder.length==0){
              return null;
          }
          return buildTreeHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int from, int to, int[] inorder, int from1, int to1){
        if(from==to){
            return new TreeNode(preorder[from]);
        }
        else if(from>to){
            return null;
        }
        int rootIndexInorder=from1;
        for(;rootIndexInorder<=to1;rootIndexInorder++){
            if(inorder[rootIndexInorder]==preorder[from]){
                break;
            }
        }
        int leftLastIndex=from;
        if(rootIndexInorder>from1){
            for(;leftLastIndex<=to;leftLastIndex++){
                if(preorder[leftLastIndex]==inorder[rootIndexInorder-1]){
                    break;
                }
            }
        }
        TreeNode root=new TreeNode(preorder[from]);
        TreeNode left=buildTreeHelper(preorder,from+1,leftLastIndex,inorder,from1,rootIndexInorder-1);
        TreeNode right=buildTreeHelper(preorder,leftLastIndex+1,to,inorder,rootIndexInorder+1,to1);
        root.left=left;
        root.right=right;
        return root;
        
    }
}


//The above method based on that it is binary serach tree. The following is better one!
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
          if(preorder==null || preorder.length==0){
              return null;
          }
          return buildTreeHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int from, int to, int[] inorder, int from1, int to1){
        if(from==to){
            return new TreeNode(preorder[from]);
        }
        else if(from>to){
            return null;
        }
        int rootIndexInorder=from1;
        for(;rootIndexInorder<=to1;rootIndexInorder++){
            if(inorder[rootIndexInorder]==preorder[from]){
                break;
            }
        }
        TreeNode root=new TreeNode(preorder[from]);
        TreeNode left=buildTreeHelper(preorder,from+1,(rootIndexInorder-from1)+from,inorder,from1,rootIndexInorder-1);
        TreeNode right=buildTreeHelper(preorder,(rootIndexInorder-from1)+from+1,to,inorder,rootIndexInorder+1,to1);
        root.left=left;
        root.right=right;
        return root;
        
    }
}