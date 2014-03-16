public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices==null || prices.length==0){
            return 0;
        }
        if(prices.length==1){
            return 0;
        }
        int lastBuy=0;
        if(prices[0]<=prices[1]){
            lastBuy=prices[0];
        }
        int sum=0;//Selling point is very sure! The only mistake may be buying points!
        for(int i=1;i<prices.length-1;i++){
            if(prices[i]<prices[i-1] && prices[i]<=prices[i+1]){
                lastBuy=prices[i];
            }
            else if(prices[i]>prices[i-1] && prices[i]>=prices[i+1]){
                sum+=(prices[i]-lastBuy);
                lastBuy=prices[i];
            }
        }
        if(prices[prices.length-1]>prices[prices.length-2]){
            sum+=prices[prices.length-1]-lastBuy;
        }
        return sum;
    }
}