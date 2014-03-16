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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res=new  ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> buffer=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        pathCollect(root,buffer,res,0,sum);
        return res;
        
    }
    
    private void pathCollect(TreeNode root, ArrayList<Integer> buffer, ArrayList<ArrayList<Integer>> res, int prevSum, int tarSum){
        prevSum+=root.val;
        buffer.add(root.val);
        if(root.left==null && root.right==null){
            if(prevSum==tarSum){
                res.add(new ArrayList<Integer>(buffer));
            }
            buffer.remove(buffer.size()-1);
            return;
        }
        if(root.left!=null){
            pathCollect(root.left,buffer,res,prevSum,tarSum);
        }
        if(root.right!=null){
            pathCollect(root.right,buffer,res,prevSum,tarSum);
        }   
        buffer.remove(buffer.size()-1);
    }
}




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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return res;
        }
        backTrack(new ArrayList<Integer>(), root, sum, res);
        return res;
    }
    
    
    private void backTrack(ArrayList<Integer> prev, TreeNode root, int target, ArrayList<ArrayList<Integer>> res){
        if(root.left == null && root.right == null){
            prev.add(root.val);
            int sum = sumUp(prev);
            if(sum == target){
                ArrayList<Integer> oneRes = new ArrayList<Integer>(prev);
                res.add(oneRes);
            }
            prev.remove(prev.size() - 1);
            return;
        }
        prev.add(root.val);
        if(root.left != null){
            backTrack(prev, root.left, target, res);
        }
        if(root.right != null){
            backTrack(prev, root.right, target, res);
        }
        prev.remove(prev.size() - 1);
    }
    
    private int sumUp(ArrayList<Integer> list){
        int sum = 0;
        for(int element : list){
            sum += element;
        }
        return sum;
    }
    
}