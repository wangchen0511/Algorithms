public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
      long remain=0;
      int result=0;
      int sign;
      long dividendL=Math.abs((long) dividend);
      long divisorL=Math.abs((long) divisor);
      if(divisor==0){
          throw new RuntimeException("0");
      }
      if(dividend>0 && divisor>0){
          sign=1;
      }
      else if(dividend<0 && divisor<0){
          sign=1;
      }
      else{
          sign=-1;
      }
      for(int i=31;i>=0;i--){
          long localDividend=(remain<<1)+((dividendL>>i) & 1);
          if(localDividend>=divisorL){
              result=(result<<1)+1;
              remain=localDividend-divisorL;
          }
          else{
              remain=localDividend;
              result=result<<1;
          }
      }
      return result*sign;
    }
}