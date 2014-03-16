public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int res = 0;
        for(int i = 31; i >=0; i--){
            int zeroCount = 0;
            for(int j : A){
                if(getBit(j, i) == 0){
                    zeroCount++;
                }
            }
            if(zeroCount % 3 == 0){
                res = (res << 1) | 1;
            }else{
                res = (res << 1) | 0; 
            }
        }
        return res;
    }
    
    private int getBit(int value, int bit){
        return (value >> bit) & 1;
    }
}