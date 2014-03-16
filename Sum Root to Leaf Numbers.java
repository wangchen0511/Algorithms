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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> buffer=new ArrayList<TreeNode>();
        int[] sum=new int[1];
        if(root==null){
            return sum[0];
        }
        traversePaths(buffer,sum,root);
        return sum[0];
    }
    
    private void traversePaths(ArrayList<TreeNode> buffer, int[] sum, TreeNode root){
        buffer.add(root);
        if(root.left==null && root.right==null){
            sum[0]+=getInt(buffer);
        }
        else{
            if(root.left!=null){
                traversePaths(buffer,sum,root.left);
            }
            if(root.right!=null){
                traversePaths(buffer,sum,root.right);
            }
        }
        buffer.remove(buffer.size()-1);
    }
    
    private int getInt(ArrayList<TreeNode> buffer){
        int sum=0;
        for(int i=0;i<buffer.size();i++){
            sum=sum*10+buffer.get(i).val;
        }
        return sum;
    }
}