public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum=0;
        if(n==1 || n==0){
            return 1;
        }
        for(int i=1;i<=n;i++){
            int left=numTrees(i-1);
            int right=numTrees(n-i);
            sum+=left*right;
        }
        return sum;
    }
}