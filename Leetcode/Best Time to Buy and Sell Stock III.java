public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices==null || prices.length<=1){
            return 0;
        }
        int[] min=new int[prices.length];
        int[] max=new int[prices.length];
        int[] forwardProfit=new int[prices.length];
        int[] backwardProfit=new int[prices.length];
        min[0]=prices[0];
        max[max.length-1]=prices[prices.length-1];
        for(int i=1;i<prices.length;i++){
            min[i]=Math.min(min[i-1],prices[i]);
            max[prices.length-1-i]=Math.max(prices[prices.length-1-i],max[prices.length-i]);
        }
        for(int i=1;i<prices.length;i++){
            forwardProfit[i]=Math.max(forwardProfit[i-1],prices[i]-min[i-1]);
            int j=prices.length-i-1;
            backwardProfit[j]=Math.max(backwardProfit[j+1],max[j+1]-prices[j]);;
        }
        int ret=forwardProfit[forwardProfit.length-1];
        for(int i=0;i<prices.length-1;i++){
            int temp=forwardProfit[i]+backwardProfit[i+1];
            ret=ret<temp?temp:ret;
        }
        return ret;
    }
}