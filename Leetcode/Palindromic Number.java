public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0){
            return false;
        }
        int count=totalNum(x);
        int head=count-1,tail=0;
        while(head>tail){
            if(getKthNum(x,head--)!=getKthNum(x,tail++)){
                return false;
            }
        }
        return true;
    }
    
    private int getKthNum(int x, int pos){
        x=x/(int)Math.pow(10,pos);
        return x%10;
    }
    
    private int totalNum(int x){
        int count=0;
        while(x>0){
            count++;
            x=x/10;
        }
        return count;
    }
}