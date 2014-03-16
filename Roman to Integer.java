public class Solution {
    public int romanToInt(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            if(i!=s.length()-1){
                if(value(s.charAt(i))<value(s.charAt(i+1))){
                    res-=value(s.charAt(i));        
                }
                else{
                    res+=value(s.charAt(i));
                }
            }
            else{
                res+=value(s.charAt(i));
            }
        }
        return res;
    }
    
    private int value(char elements){
        switch(elements){
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
                return 0;
        }
    }
}