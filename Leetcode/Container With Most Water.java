/**
   Container With Most Water:

   Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
   n vertical lines are drawn such that the two endpoints of line i is at (i, a) and (i, 0). 
   Find two lines, which together with x-axis forms a container, such that the container contains the most water.

   Note: You may not slant the container.
 */

public class Solution {
    public int maxArea(int[] height) {
        int head = 0, tail = height.length - 1;
        int res = 0;
        while(head < tail){
            int temp = Math.min(height[head], height[tail]) * (tail - head);
            res = res >= temp ? res : temp;
            if(height[head] > height[tail]){
                tail--;
            }else{
                head++;
            }
        }
        return res;
    }
}