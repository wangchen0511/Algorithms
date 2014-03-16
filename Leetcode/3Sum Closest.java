/**

   3Sum Closest 


   Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
   Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */







//v2

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int closest = num[0] + num[1] + num[2];
        Arrays.sort(num);
        for(int i = 0; i < num.length - 2; i++){
            int localClosest = num[i] + twoSumClosest(num, i + 1, num.length - 1, target - num[i]);
            closest = Math.abs(target - closest) > Math.abs(target - localClosest) ? localClosest : closest;
        }
        return closest;
    }
    
    private int twoSumClosest(int[] num, int head, int end, int target){
        int closest = num[head] + num[end];
        while(head < end){
            int sum = num[head] + num[end];
            if(sum == target){
                return target;
            }else if(sum > target){
                end--;
            }else{
                head++;
            }
            closest = Math.abs(target - sum) < Math.abs(closest - target) ? sum : closest;
        }
        return closest;
    }


}



//v1
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