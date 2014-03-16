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
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int leftPath,rightPath;
        if(root.left==null){
            leftPath=0;
        }
        else{
            int[] sumLeft=new int[1];
            int[] maxLeft=new int[]{root.left.val};
            maxOnePathSum(root.left,sumLeft,maxLeft);
            leftPath=maxLeft[0]>0?maxLeft[0]:0;
        }
        if(root.right==null){
            rightPath=0;
        }
        else{
            int[] sumRight=new int[1];
            int[] maxRight=new int[]{root.right.val};
            maxOnePathSum(root.right,sumRight,maxRight);
            rightPath=maxRight[0]>0?maxRight[0]:0;
        }
        int max=leftPath+rightPath+root.val;
        if(root.left!=null){
            int left=maxPathSum(root.left);
            max=max<left?left:max;
        }
        if(root.right!=null){
            int right=maxPathSum(root.right);
            max=max<right?right:max;
        }
        return max;
        
    }
    
    
    private void maxOnePathSum(TreeNode root, int[] sum, int[] max){
        if(root==null){
            return;
        }
        sum[0]+=root.val;
        if(sum[0]>max[0]){
            max[0]=sum[0];
        }
        maxOnePathSum(root.left,sum,max);
        maxOnePathSum(root.right,sum,max);
        sum[0]=sum[0]-root.val;
    }
    
}





//method 2

still time out

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
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return 0;
        }
        return maxOnePathSum(root).get(1);
    }
    
    
    private ArrayList<Integer> maxOnePathSum(TreeNode root){
        int path,sum;
        ArrayList<Integer> ret=new ArrayList<Integer>();
        ArrayList<Integer> left,right;
        if(root==null){
            ret.add(0);
            ret.add(0);
            return ret;
        }
        left=maxOnePathSum(root.left);
        right=maxOnePathSum(root.right);
        int temp=Math.max(left.get(0),right.get(0));
        path=temp>0?temp+root.val:root.val;
        sum=root.val+(left.get(0)>0?left.get(0):0)+(right.get(0)>0?right.get(0):0);
        if(root.left!=null){
            sum=sum>=left.get(1)?sum:left.get(1);
        }
        if(root.right!=null){
            sum=sum>=right.get(1)?sum:right.get(1);
        }
        ret.add(path);
        ret.add(sum);
        return ret;
    }
    
}






public class Solution{
	private static DataPack{
		public int minOnePath;
		public int minPath;
		public Solution(int minOnePath, int minPath){
			this.minOnePath = minOnePath;
			this.minPath = minPath;
		}
	}
	
	
	public DataPack solution(TreeNode root){
		if(root == null){
			return null;
		}
		if(root.left == null && root.right == null){
			return new DataPack(root.val, root.val);
		}
		DataPack left = solution(root.left);
		DataPack right = solution(root.right);
		int minOnePath, minPath;
		if(left == null){
			minOnePath = root.val + right.minOnePath;
			minPath = Math.max(minOnePath, right.minPath);
		}else if(right == null){
			minOnePath = root.val + left.minOnePath;
			minPath = Math.max(minOnePath, left.minPath);
		}else{
			minOnePath = root.val + Math.max(left.minOnePath, right.minOnePath);
			minPath = Math.max(minOnePath, left.minPath);
			minPath = Math.max(minPath, right.minPath);
		}
		return new DataPack(minOnePath, minPath);
	}
}