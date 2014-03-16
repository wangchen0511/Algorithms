public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0){
            return -1;
        }else{
            return searchRange(A,0,A.length-1,target);
        }
    }
    
    private int searchRange(int[] A, int start, int end, int target){
        if(start>end){
            return -1;
        }
        int mid=(start+end)/2;
        if(A[mid]==target){
            return mid;
        }
        if(A[mid]>=A[start]){
            if(A[mid]>target && A[start]<=target){
                return searchRange(A,start,mid-1,target); 
            }else{
                return searchRange(A,mid+1,end,target);
            }
        }
        else{
            if(A[mid]<target && A[end]>=target){
                return searchRange(A,mid+1,end,target);
            }else{
                return searchRange(A,start,mid-1,target);
            }
        }
    }
}