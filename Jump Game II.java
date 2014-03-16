public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int currentNum=1;
        if(A==null || A.length==0){
            return 0;
        }
        if(A.length==1){
            return 0;
        }
        int rangeEdge=A[0];
        int nextEdge=A[0];
        if(nextEdge>=A.length-1){
                    return 1;
        }
        for(int i=1;i<A.length;i++){
            if(i>rangeEdge){
                rangeEdge=nextEdge;
                currentNum++;
            }
            if(A[i]+i>nextEdge){
                nextEdge=A[i]+i;
            }
            if(nextEdge>=A.length-1){
                    return currentNum+1;
            }
        }
        return 0;
    }
}