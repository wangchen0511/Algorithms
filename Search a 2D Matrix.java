public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix==null || matrix.length==0){
            return false;
        }
        int start=0,tail=matrix.length*matrix[0].length-1;
        while(true){
            if(start>tail){
                return false;
            }
            int mid=(start+tail)/2;
            int midValue=matrix[mid/matrix[0].length][mid%matrix[0].length];
            if(midValue==target){
                return true;
            }
            else if(midValue<target){
                start=mid+1;
            }
            else{
                tail=mid-1;
            }
        }
    }
}