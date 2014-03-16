/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(1,n);
    }
    
    private ArrayList<TreeNode> helper(int from, int to){
        ArrayList<TreeNode> ret=new ArrayList<TreeNode>();
        if(from>to){
            ret.add(null);
            return ret;
        }
        else if(from==to){
            ret.add(new TreeNode(from));
            return ret;
        }
        for(int i=from;i<=to;i++){
            ArrayList<TreeNode> leftRet=helper(from,i-1);
            ArrayList<TreeNode> rightRet=helper(i+1,to);
            for(int j=0;j<leftRet.size();j++){
                for(int k=0;k<rightRet.size();k++){
                     TreeNode root=new TreeNode(i);
                     root.left=leftRet.get(j);
                     root.right=rightRet.get(k);
                     ret.add(root);
                }
            }
        }
        return ret;
    }
    
}