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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        ArrayList<Integer> ret=new ArrayList<Integer>();
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
        while(stack.size()>0){
            TreeNode lastNode=stack.pop();
            ret.add(lastNode.val);
            lastNode=lastNode.right;
            while(lastNode!=null){
                stack.push(lastNode);
                lastNode=lastNode.left;
            }
        }
        return ret;
    }
}