public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null){
            return 0;
        }
        else if(A.length<=2){
            return A.length;
        }
        int index=2;
        int tail=1;
        for(;index<A.length;index++){
            if(A[index]==A[tail] && A[index]==A[tail-1]){
                continue;
            }
            else{
                A[++tail]=A[index];
            }
        }
        return tail+1;
    }
}