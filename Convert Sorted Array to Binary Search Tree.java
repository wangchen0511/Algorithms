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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null){
            return null;
        }
        return sortList(num,0,num.length-1);
    }
    
    private TreeNode sortList(int[] num, int from, int to){
        if(from==to){
            return new TreeNode(num[from]);
        }
        else if(from>to){
            return null;
        }
        int mid=(to-from+1)/2+from;
        TreeNode root=new TreeNode(num[mid]);
        TreeNode left=sortList(num,from,mid-1);
        TreeNode right=sortList(num,mid+1,to);
        root.left=left;
        root.right=right;
        return root;
    }
}