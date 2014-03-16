public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || s.length()==0){
            return 0;
        }
        boolean isCounting=false;
        int num=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                isCounting=false;
            }
            else{
                if(isCounting){
                    num++;
                }
                else{
                    num=1;
                    isCounting=true;
                }
            }
        }
        return num;
    }
}