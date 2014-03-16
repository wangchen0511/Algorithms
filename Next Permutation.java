public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null || num.length<=1){
            return;
        }
        int firstFall=num.length-2;
        for(;firstFall>=0; firstFall--){
            if(num[firstFall]<num[firstFall+1]){
                break;
            }
        }
        if(firstFall<0){
            swap(num,0,num.length-1);
            return;
        }
        int firstBiggerThanFall=num.length-1;
        for(;firstBiggerThanFall>=0;firstBiggerThanFall--){
            if(num[firstBiggerThanFall]>num[firstFall]){
                break;
            }
        }
        if(firstFall>=0){
            int temp=num[firstFall];
            num[firstFall]=num[firstBiggerThanFall];
            num[firstBiggerThanFall]=temp;
        }
        int head=firstFall+1;
        int tail=num.length-1;
        swap(num,head,tail);
    }
    
    private void swap(int[] num, int head, int tail){
        while(head<tail){
            int temp=num[head];
            num[head]=num[tail];
            num[tail]=temp;
            head++;
            tail--;
        }
    }
}