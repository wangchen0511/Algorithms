public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0){
            return 0;
        }
        return searchInsertRange(A,0,A.length-1,target);
    }
    
    private int searchInsertRange(int[] A, int start, int end, int target){
        int mid=(start+end)/2;
        if(A[mid]==target){
            return mid;
        }
        else if(A[mid]>target){
            if(mid==start){
                return 0;
            }
            else{
                if(A[mid-1]<target){
                    return mid;
                }
                else{
                    return searchInsertRange(A,start,mid-1,target);
                }
            }
        }
        else{
            if(mid==end){
                return end+1;
            }
            else{
                if(A[mid+1]>target){
                    return mid+1;
                }
                else{
                    return searchInsertRange(A,mid+1,end,target);
                }
            }
        }
    }
}