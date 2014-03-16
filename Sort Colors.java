public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0){
            return;
        }
        int nextRed=0,nextBlue=A.length-1;
        int index=0;
        while(index<=nextBlue){
                if(A[index]==0){
                    int temp=A[nextRed];
                    A[nextRed++]=A[index];
                    A[index]=temp;
                    if(index<nextRed){
                        index=nextRed;
                    }
                }
                else if(A[index]==2){
                    int temp=A[nextBlue];
                    A[nextBlue--]=A[index];
                    A[index]=temp;
                }
                else{
                    index++;
                }
        }
    }
}





//another version
public class Solution {
    public void sortColors(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A == null){
            return;
        }
        int lastZeroIndex = -1, firstTwoIndex = A.length;
        int iterIndex = 0;
        while(iterIndex < firstTwoIndex){
            if(A[iterIndex] == 1){
                iterIndex++;
            }else if(A[iterIndex] == 0){
                swap(A, ++lastZeroIndex, iterIndex);
                iterIndex++;
            }else{
                swap(A, --firstTwoIndex, iterIndex);
            }
        }
    }
    
    private void swap(int[] A, int index1, int index2){
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
}



//better version

public class Solution {
    public void sortColors(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int head = -1, tail = A.length, index = 0;
        while(index < tail){
            if(A[index] == 1){
                index++;
            }else if(A[index] == 0){
                swap(A, ++head, index++);
            }else{
                swap(A, --tail, index);
            }
        }
    }
    
    private void swap(int[] A, int index1, int index2){
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
}
