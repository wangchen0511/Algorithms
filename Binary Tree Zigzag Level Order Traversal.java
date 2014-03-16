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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return ret;
        }
        ArrayList<TreeNode> helper=new ArrayList<TreeNode>();
        ArrayList<Integer> firstLevel=new ArrayList<Integer>();
        firstLevel.add(root.val);
        boolean isReverse=true;
        helper.add(root);
        ret.add(firstLevel);
        while(true){
            ArrayList<TreeNode> nextHelperLevel=new ArrayList<TreeNode>();
            ArrayList<Integer> nextLevelRet=new ArrayList<Integer>();
            for(int i=helper.size()-1;i>=0;i--){
                TreeNode temp=helper.get(i);
                if(!isReverse){
                    if(temp.left!=null){
                        nextHelperLevel.add(temp.left);
                        nextLevelRet.add(temp.left.val);
                    }
                    if(temp.right!=null){
                        nextHelperLevel.add(temp.right);
                        nextLevelRet.add(temp.right.val);
                    }
                }
                else{
                    if(temp.right!=null){
                        nextHelperLevel.add(temp.right);
                        nextLevelRet.add(temp.right.val);
                    }
                    if(temp.left!=null){
                        nextHelperLevel.add(temp.left);
                        nextLevelRet.add(temp.left.val);
                    }
                }
                
            }
            isReverse=!isReverse;
            if(nextHelperLevel.size()==0){
                break;
            }
            else{
                helper=nextHelperLevel;
                ret.add(nextLevelRet);
            }
        }
        return ret;
    }
}