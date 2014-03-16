/**
	Median of Two Sorted Arrays
	
	There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/



//Use copyOfRange
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if((A.length+B.length)%2>0)
            return findKthNum(A,B,(A.length+B.length)/2+1);
        else{
            return (findKthNum(A,B,(A.length+B.length)/2+1)+findKthNum(A,B,(A.length+B.length)/2))/2.0;
        }    
    }
    
    public int findKthNum(int A[], int B[], int k){
        if(A==null || A.length==0){
            return B[k-1];
        }else if(B==null || B.length==0){
            return A[k-1];
        }else if(k==1){
            return A[0]>B[0]?B[0]:A[0];
        }else if(A.length>B.length){
            return findKthNum(B,A,k);
        }
        int markA,markB;
        if(A.length>=k/2){
            markA=k/2;
        }else{
            markA=A.length;
        }
        markB=k-markA;
        if(A[markA-1]>B[markB-1]){
            return findKthNum(Arrays.copyOfRange(A,0,markA),Arrays.copyOfRange(B,markB,B.length),k-markB);
        }else{
            return findKthNum(Arrays.copyOfRange(A,markA,A.length),Arrays.copyOfRange(B,0,markB),k-markA);
        }
    }
}




//Without using copyOfRange
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
         if((A.length + B.length)%2 != 0){
             return findKthInSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1, (A.length + B.length)/2 + 1);      
         }else{
             return (findKthInSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1, (A.length + B.length)/2) +  findKthInSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1, (A.length + B.length)/2 + 1))/2.0;
         }
    }
    private double findKthInSortedArrays(int A[], int startA, int endA, int B[], int startB, int endB, int target){
        if(endA < startA){
            return B[startB + target - 1];
        }else if(endB < startB){
            return A[startA + target - 1];
        }else if((endA -startA) > (endB - startB)){
            return findKthInSortedArrays(B, startB, endB, A, startA, endA, target);
        }else if(target == 1){
            return A[startA] > B[startB]? B[startB] : A[startA];
        }
        int indexA;
        if(target/2 > (endA - startA + 1)){
            indexA = endA;
        }else{
            indexA = startA + target/2 - 1;
        }
        int indexB = (target - (indexA - startA + 1)) + startB - 1;
        if(A[indexA] > B[indexB]){
            return findKthInSortedArrays(A, startA, indexA, B, indexB + 1, endB, target - (indexB - startB + 1));
        }else{
            return findKthInSortedArrays(A, indexA + 1, endA, B, startB, indexB, target - (indexA - startA + 1));
        }
    }
}