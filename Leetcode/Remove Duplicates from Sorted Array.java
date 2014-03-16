public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lastNonDup=0;
        if(A==null || A.length==0){
            return 0;
        }
        for(int i=1;i<A.length;i++){
            if(A[i]!=A[i-1]){
                A[++lastNonDup]=A[i];
            }
        }
        return lastNonDup+1;
        
    }
}