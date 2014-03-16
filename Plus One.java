public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int c=0;
        int[] res=new int[digits.length+1];
        for(int i=digits.length-1;i>=0;i--){
            int current;
            if(i==digits.length-1){
                current=digits[i]+c+1;
            }
            else{
                current=digits[i]+c;
            }
            res[i+1]=current%10;
            c=current/10;
        }
        res[0]=c;
        if(c==1){
            return res;
        }
        else{
            return Arrays.copyOfRange(res,1,res.length);
        }
    }
}