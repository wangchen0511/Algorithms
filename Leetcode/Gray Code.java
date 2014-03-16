public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> lastRes = new ArrayList<Integer>();
        lastRes.addAll(Arrays.asList(0));
        for(int i = 1; i <= n; i++){
            ArrayList<Integer> currentRes = new ArrayList<Integer>(lastRes);
            for(int j = lastRes.size() - 1; j >= 0; j--){
                currentRes.add(lastRes.get(j) | (1 << (i - 1)));
            }
            lastRes = currentRes;
        }
        return lastRes;
        
    }
}