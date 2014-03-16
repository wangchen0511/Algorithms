public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max=A[0];
        int localSum=0;
        for(int i=0;i<A.length;i++){
            localSum+=A[i];
            max=localSum>max?localSum:max;
            if(localSum<0){
                localSum=0;
            }
        }
        return max;
    }
}