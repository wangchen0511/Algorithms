//this method check if there is a path from any node to any node, so that equal to the sum. Not same as the requirement! 

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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return false;
        }
        if(hasPathSumRoot(root,0,sum)){
            return true;
        }
        return hasPathSum(root.left,sum) | hasPathSum(root.right,sum);
        
    }


    private boolean hasPathSumRoot(TreeNode root, int prevSum, int tarSum){
        if(root==null){
            return false;
        }
        prevSum+=root.val;
        if(prevSum==tarSum){
            return true;
        }
        if(hasPathSumRoot(root.left,prevSum,tarSum) || hasPathSumRoot(root.right,prevSum,tarSum)){
            return true;
        }
        return false;
    }

}




//method 2 the following is the problem's requirement.
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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return false;
        }
        return hasPathSumRoot(root,0,sum);
        
    }


    private boolean hasPathSumRoot(TreeNode root, int prevSum, int tarSum){
        prevSum+=root.val;
        if(root.left==null && root.right==null){
            return tarSum==prevSum;
        }
        if(root.left!=null){
            if(hasPathSumRoot(root.left,prevSum,tarSum)){
                return true;
            }
        }
        if(root.right!=null){
            if(hasPathSumRoot(root.right,prevSum,tarSum)){
                return true;
            }
        }
        return false;
    }

}