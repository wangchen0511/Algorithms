public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        double num=x;
        if(num==0){
            return 0;
        }
        for(int i=0;i<20;i++){
            num=(x/num+num)/2;
        }
        return (int) num;
    }
}