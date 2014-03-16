/**
	Palindrome Number
	
	Determine whether an integer is a palindrome. Do this without extra space.

*/


public class Solution {
    public boolean isPalindrome(int x) {
        int highLevel = 1, lowLevel = 1;
        if(x < 0){
            return false;
        }
        int temp = x;
        while(temp >= 10){
            temp /= 10;
            highLevel *= 10;
        }
        while(highLevel > lowLevel){
            if(getDigNum(x, highLevel) != getDigNum(x, lowLevel)){
                return false;
            }
            highLevel /= 10;
            lowLevel *= 10;
        }
        return true;
    }
    
    private int getDigNum(int x, int level){
        return (x / level) % 10;
    }
}