public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null){
            return res;
        }
        Arrays.sort(num);
        for(int i = 0; i <= num.length - 3; i++){
            if(i != 0 && num[i] == num[i - 1]){
                continue;
            }else{
                ArrayList<ArrayList<Integer>> threeSumRes = threeSum(num, i + 1, num.length - 1, target - num[i]);
                for(ArrayList<Integer> element : threeSumRes){
                    element.add(0 , num[i]);
                    res.add(element);
                }
            }
        }
        return res;
    }
    
    private ArrayList<ArrayList<Integer>> twoSum(int[] num, int from, int to, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        while(from < to){
            if(num[from] + num[to] == target){
                ArrayList<Integer> element = new ArrayList<Integer>();
                element.add(num[from]);
                element.add(num[to]);
                res.add(element);
                from++;
                while(from < to && num[from] == num[from - 1]){
                    from++;
                }
                to--;
                while(to > from && num[to] == num[to + 1]){
                    to--;
                }
            }else if(num[from] + num[to] < target){
                from++;
            }else{
                to--;
            }
        }
        return res;
    }
    
    
    private ArrayList<ArrayList<Integer>> threeSum(int[] num, int from, int to, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i = from; i <= to -2; i++){
            if(i != from && num[i] == num[i - 1]){
                continue;
            }else{
                ArrayList<ArrayList<Integer>> twoSumRes = twoSum(num, i + 1, to, target - num[i]);
                for(ArrayList<Integer> element : twoSumRes){
                    element.add(0, num[i]);
                    res.add(element);
                }
            }
        }
        return res;
    }
}






public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 4){
            return res;
        }
        Arrays.sort(num);
        backTrack(new ArrayList<Integer>(), num, 0, num.length - 1, 4, target, res);
        return res;
    }
    
    private void backTrack(ArrayList<Integer> prev, int[] num, int start, int end, int numOfRes, int target, ArrayList<ArrayList<Integer>> res){
        if(numOfRes > 2){
            for(int i = start; i <= end - numOfRes + 1; i++){
                if(i == start || num[i] != num[i - 1]){
                    prev.add(num[i]);
                    backTrack(prev, num, i + 1, end, numOfRes - 1, target - num[i], res);
                    prev.remove(prev.size() - 1);
                }
            }
        }else{
            while(start < end){
                if(num[start] + num[end] < target){
                    start++;
                }else if(num[start] + num[end] > target){
                    end--;
                }else{
                    ArrayList<Integer> localRes = new ArrayList<Integer>(prev);
                    localRes.add(num[start]);
                    localRes.add(num[end]);
                    res.add(localRes);
                    start++;
                    while(start < end && num[start] == num[start - 1]){
                        start++;
                    }
                    end--;
                    while(start < end && num[end] == num[end + 1]){
                        end--;
                    }
                }
            }
        }
    }
}
