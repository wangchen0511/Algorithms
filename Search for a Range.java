public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0){
            return new int[]{-1,-1};
        }
        return new int[]{searchFirst(A,0,A.length-1,target),searchLast(A,0,A.length-1,target)};
    }
    
    private int searchFirst(int[] A, int start, int end, int target){
        if(start>end){
            return -1;
        }
        int mid=(start+end)/2;
        if(A[mid]==target){
            if(mid==start){
                return mid;
            }
            else if(A[mid]!=A[mid-1]){
                return mid;
            }
            else{
                return searchFirst(A,start,mid-1,target);
            }
        }
        else if(A[mid]>target){
            return searchFirst(A,start,mid-1,target);
        }
        else{
            return searchFirst(A,mid+1,end,target);
        }
    }
    
    private int searchLast(int[] A, int start, int end, int target){
        if(start>end){
            return -1;
        }
        int mid=(start+end)/2;
        if(A[mid]==target){
            if(mid==end){
                return mid;
            }
            else if(A[mid]!=A[mid+1]){
                return mid;
            }
            else{
                return searchLast(A,mid+1,end,target);
            }
        }
        else if(A[mid]>target){
            return searchLast(A,start,mid-1,target);
        }
        else{
            return searchLast(A,mid+1,end,target);
        }
    }
}