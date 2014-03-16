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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return ret;
        }
        ArrayList<TreeNode> helper=new ArrayList<TreeNode>();
        ArrayList<Integer> firstLevel=new ArrayList<Integer>();
        firstLevel.add(root.val);
        helper.add(root);
        ret.add(firstLevel);
        while(true){
            ArrayList<TreeNode> nextHelperLevel=new ArrayList<TreeNode>();
            ArrayList<Integer> nextLevelRet=new ArrayList<Integer>();
            for(int i=0;i<helper.size();i++){
                TreeNode temp=helper.get(i);
                if(temp.left!=null){
                    nextHelperLevel.add(temp.left);
                    nextLevelRet.add(temp.left.val);
                }
                if(temp.right!=null){
                    nextHelperLevel.add(temp.right);
                    nextLevelRet.add(temp.right.val);
                }
                
            }
            if(nextHelperLevel.size()==0){
                break;
            }
            else{
                helper=nextHelperLevel;
                ret.add(nextLevelRet);
            }
        }
        ArrayList<ArrayList<Integer>> newRet=new ArrayList<ArrayList<Integer>>();
        for(int i=ret.size()-1;i>=0;i--){
            newRet.add(ret.get(i));
        }
        
        return newRet;
    }
}