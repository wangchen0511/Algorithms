public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] diff = new int[gas.length];
        for(int i = 0; i < gas.length; i++){
            diff[i] = gas[i] - cost[i];
        }
        int sum = 0;
        for(int c : diff){
            sum += c;
        }
        if(sum < 0){
            return -1;
        }
        int count = 0;
        int countStartIndex = 0;
        int max = 0;
        int maxStartIndex = 0;
        for(int i = 0; i < diff.length * 2; i++){
            int index = i % diff.length;
            count += diff[index];
            if(count < 0){
                count = 0;
                countStartIndex = (index + 1) % diff.length;
            }else{
                if(count > max){
                    max = count;
                    maxStartIndex = countStartIndex;
                }
            }
        }
        return countStartIndex;
    }
}