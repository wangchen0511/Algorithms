public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null || num.length<3){
            return Integer.MAX_VALUE;
        }
        int closest=num[0]+num[1]+num[2];
        int gap=Math.abs(target-closest);
        Arrays.sort(num);
        for(int index=0;index<num.length-2;index++){
            int localClosest=twoSumCloest(num,index+1,target-num[index])+num[index];
            int localGap=Math.abs(target-localClosest);
            if(gap>localGap){
                gap=localGap;
                closest=localClosest;
            }
        }
        return closest;
    }
    
    
    private int twoSumCloest(int[] num, int start, int target){
        int head=start,tail=num.length-1;
        int closest=(num[head]+num[tail]);
        int gap=Math.abs(target-closest);
        while(head<tail){
            if(Math.abs(target-num[head]-num[tail])<gap){
                gap=Math.abs(target-num[head]-num[tail]);
                closest=num[head]+num[tail];
            }
            if(num[head]+num[tail]>target){
                tail--;
            }
            else if(num[head]+num[tail]<target){
                head++;
            }
            else{
                break;
            }
        }
        return closest;
    }
    
}