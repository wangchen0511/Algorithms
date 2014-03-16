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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return;
        }
        TreeNode[] ret=flattenHelper(root);
        ret[1].right=null;
    }
    
    
    
    private TreeNode[] flattenHelper(TreeNode root){
        TreeNode[] ret=new TreeNode[2];
        if(root==null){
            return ret;
        }
        ret[0]=root;
        TreeNode[] left=flattenHelper(root.left);
        TreeNode[] right=flattenHelper(root.right);
        root.left=null;
        ret[1]=root;
        if(left[0]!=null){
            root.right=left[0];
            ret[1]=left[1];
        }
        if(right[0]!=null){
            ret[1].right=right[0];
            ret[1]=right[1];
        }
        return ret;
        
    }
}




//method 2
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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return;
        }
        LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        TreeNode lastOne=null;
        stack.add(root);
        while(stack.size()>0){
            TreeNode current=stack.pop();
            if(current.right!=null){
                stack.push(current.right);
            }
            if(current.left!=null){
                stack.push(current.left);
            }
            current.left=null;
            if(lastOne!=null){
                lastOne.right=current;
            }
            lastOne=current;
        }
        lastOne.right=null;
    }
}