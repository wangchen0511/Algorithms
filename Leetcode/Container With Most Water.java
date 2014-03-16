public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int head=0;
        int tail;
        int maxAera=0;
        if(height==null){
            return 0;
        }
        tail=height.length-1;
        while(head<tail){
            int currentAera=(tail-head)*Math.min(height[head],height[tail]);
            maxAera=currentAera>maxAera?currentAera:maxAera;
            if(height[head]>height[tail]){
                tail--;
            }
            else{
                head++;
            }
        }
        return maxAera;
        
    }
}