public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0){
            return 1;
        }
        int sepcialNum=A.length+1;
        for(int i=0;i<A.length;i++){
            if(A[i]<=0){
                A[i]=sepcialNum;
            }
        }
        for(int i=0;i<A.length;i++){
            int absValue=Math.abs(A[i]);
            if(absValue<sepcialNum){
                A[absValue-1]=A[absValue-1]>0?A[absValue-1]*-1:A[absValue-1];
            }
        }
        for(int i=0;i<A.length;i++){
            if(A[i]>0){
                return i+1;
            }
        }
        return sepcialNum;
    }
}