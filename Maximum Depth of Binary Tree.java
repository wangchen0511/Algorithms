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
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;       
        }
        int max=-1;
        if(root.left!=null){
            max=maxDepth(root.left);
        }
        if(root.right!=null){
            if(max<0){
                max=maxDepth(root.right);
            }
            else{
                int right=maxDepth(root.right);
                max=max<right?right:max;
            }
        }
        return max+1;
    }
}




//much better
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
    public int maxDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}