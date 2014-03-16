public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0){
            return true;
        }
        int rangeEdge=A[0];
        int nextEdge=rangeEdge;
        for(int i=1;i<A.length;i++){
            if(nextEdge>=A.length-1){
                return true;
            }
            if(i>rangeEdge){
                if(nextEdge<=rangeEdge){
                    return false;
                }
                else{
                    rangeEdge=nextEdge;
                }
            }
            if(i+A[i]>rangeEdge){
                nextEdge=i+A[i];
            }
        }
        return true;
        
    }
}