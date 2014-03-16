public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function       
        if(n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        double res=1;
        for(int i=0;i<Math.abs(n);i++){
            res*=x;
        }
        return n>0?res:1/res;
    }
}