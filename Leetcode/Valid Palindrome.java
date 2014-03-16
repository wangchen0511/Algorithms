public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String sLower=s.toLowerCase();
        if(s==null || sLower.length()==0){
            return true;
        }
        int head=0,tail=sLower.length()-1;
        while(head<tail){
            if(!isValid(sLower.charAt(head))){
                head++;
                continue;
            }
            if(!isValid(sLower.charAt(tail))){
                tail--;
                continue;
            }
            if(sLower.charAt(head++)!=sLower.charAt(tail--)){
                return false;
            }
        }
        return true;
    }
    
    
    private boolean isValid(char s){
        if(s<='z' && s>='a'){
            return true;
        }
        else if(s<='9' && s>='0'){
            return true;
        }
        else{
            return false;
        }
    }
}