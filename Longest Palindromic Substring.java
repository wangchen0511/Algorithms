//Complexity is O(n^2). Can not pass the big test
public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int centerPoints=2*s.length()-1;
        int maxLength=0;
        String maxStr=null;
        for(int i=0;i<centerPoints;i++){
            int length;
            StringBuilder tempStrBuilder=new StringBuilder();
            int left,right;
            if(i%2==0){
                length=1;
                tempStrBuilder.append(s.charAt(i/2));
                left=i/2-1;
                right=left+2;
            }
            else{
                length=0;
                left=i/2;
                right=left+1;
            }
            while(left>=0 && right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    length+=2;
                    tempStrBuilder.insert(0,s.charAt(left--));
                    tempStrBuilder.append(s.charAt(right++));
                }
                else{
                    break;
                }
            }
            if(length>maxLength){
                maxLength=length;
                maxStr=tempStrBuilder.toString();
            }
        }
        return maxStr;
    }
}