public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0){
            return 0;
        }
        int[] left=new int[A.length];
        int[] right=new int[A.length];
        int max=A[0];
        for(int i=0;i<A.length;i++){
            max=A[i]>max?A[i]:max;
            left[i]=max;
        }
        max=A[A.length-1];
        for(int i=A.length-1;i>=0;i--){
            max=A[i]>max?A[i]:max;
            right[i]=max;
        }
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=min(left[i],right[i])-A[i];
        }
        return sum;
    }
    
    private int min(int left, int right){
        if(left<right){
            return left;
        }
        else{
            return right;
        }
    }
}