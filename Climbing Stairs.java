public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] recordTable=new int[n+1];
        recordTable[0]=1;
        recordTable[1]=1;
        for(int i=2;i<=n;i++){
            recordTable[i]=recordTable[i-1]+recordTable[i-2];
        }
        return recordTable[n];
        
    }
}