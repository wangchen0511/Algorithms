/**
   Roman to Integer:

   Given a roman numeral, convert it to an integer.

   Input is guaranteed to be within the range from 1 to 3999.

 */





public class Solution {
    public int romanToInt(String s) {
        int value = 0;
        for(int i = 0; i < s.length(); i++){
            if(i < s.length() - 1 && getVal(s.charAt(i)) < getVal(s.charAt(i + 1))){
                value -= getVal(s.charAt(i));
            }else{
                value += getVal(s.charAt(i));
            }
        }
        return value;
    }
    
    private int getVal(char c){
        switch(c){
	case 'I':
	    return 1;
	case 'V':
	    return 5;
	case 'X':
	    return 10;
	case 'L':
	    return 50;
	case 'C':
	    return 100;
	case 'D':
	    return 500;
	case 'M':
	    return 1000;
	default:
	    return -1;
        }
    }

}