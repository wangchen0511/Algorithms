public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index=m+n-1;
        int indexA=m-1,indexB=n-1;
        while(indexB>=0){
            if(indexA<0){
                A[index--]=B[indexB--];
            }
            else{
                if(A[indexA]>=B[indexB]){
                    A[index--]=A[indexA--];
                }
                else{
                    A[index--]=B[indexB--];
                }
            }
        }
    }
}