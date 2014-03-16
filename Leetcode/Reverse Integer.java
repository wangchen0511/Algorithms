/**
	Reverse Integer
	
	Reverse digits of an integer.

	Example1: x = 123, return 321
	Example2: x = -123, return -321
	
*/

public class Solution {
    public int reverse(int x) {
        long res = 0;
        long processedX = Math.abs((long) x);
        long sign = x > 0 ? 1 : -1;
        while(processedX > 0){
            res = res * 10 + processedX % 10;
            processedX = processedX / 10;
        }
        return (int) (res * sign);
    }
}