public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices==null || prices.length==0){
            return 0;
        }
        return getDataPack(prices,0,prices.length-1).maxProfit;
    }
    
    
    static class DataPack{
        int min;
        int max;
        int maxProfit;
    }
    
    
    private DataPack getDataPack(int[] prices, int from, int to){
        DataPack ret=new DataPack();
        if(from==to){
            ret.min=prices[from];
            ret.max=ret.min;
            ret.maxProfit=0;
            return ret;
        }
        int mid=(from+to)/2;
        DataPack left=getDataPack(prices,from,mid);
        DataPack right=getDataPack(prices,mid+1,to);
        ret.min=Math.min(left.min,right.min);
        ret.max=Math.max(left.max,right.max);
        ret.maxProfit=Math.max(left.maxProfit,right.maxProfit);
        ret.maxProfit=Math.max(ret.maxProfit,right.max-left.min);
        return ret;
    }
}