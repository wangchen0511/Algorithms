public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        //（）
        if(A==null || A.length==0){
            return 0;
        }
        int lastNonDup=-1;
        for(int i=0;i<A.length;i++){
            if(A[i]!=elem){
                A[++lastNonDup]=A[i];
            }
        }
        return lastNonDup+1;
    }
}