public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length==0){
            return res;
        }
        Arrays.sort(num);
        ArrayList<Integer> numArray=new ArrayList<Integer>();
        for(int i=0;i<num.length;i++){
            numArray.add(num[i]);
        }
        traceBack(numArray,0,res,new ArrayList());
        return res;
    }
    
    
    private void traceBack(ArrayList<Integer> num, int from, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> prev){
        if(from==num.size()){
            res.add(prev);
        }
        for(int i=from;i<num.size();i++){
            if(i!=from && num.get(i)==num.get(i-1)){
                continue;
            }
            int temp=num.get(i);
            num.remove(i);
            num.add(from,temp);
            ArrayList<Integer> input=new ArrayList<Integer>(prev);
            input.add(temp);
            traceBack(num,from+1,res,input);
            num.remove(from);
            num.add(i,temp);
        }
    }
}









//The methods showed here are clean but not very efficient. The reason is we need to remove and insert to left in each iterator.
Another way to deal with the redundant is very time compare with all the elements we have visited before! We do not need to sort in this 
method.


Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. 

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permuteUnique(num, 0, result);
        return result;
    }
    
    void permuteUnique(int[] num, int begin, ArrayList<ArrayList<Integer>> result) {
        if (begin > num.length - 1) {
            ArrayList<Integer> item = new ArrayList<Integer>();
            for (int h = 0; h < num.length; h++) {
                item.add(num[h]);
            }
            result.add(item);
        }
        for (int end = begin; end < num.length; end++) {
            if (isSwap(num, begin, end)) {
                int tmp = num[end];
                num[end] = num[begin];
                num[begin] = tmp;
                
                permuteUnique(num, begin + 1, result);
                
                tmp = num[end];
                num[end] = num[begin];
                num[begin] = tmp;
            }
        }
    }
    
    boolean isSwap(int[] arr, int i, int j) {
        for (int k = i; k < j; k++) {
            if (arr[k] == arr[j]) {
                return false;
            }
        }
        return true;
    }
}
Status API Training Shop Blog About © 2013 GitHub, Inc. Terms Privacy Security Contact






public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            return res;
        }
        Arrays.sort(num);
        ArrayList<Integer> left = new ArrayList<Integer>();
        for(int element : num){
            left.add(element);
        }
        backTrack(new ArrayList<Integer>(), res, left);
        return res;
    }
    
    private void backTrack(ArrayList<Integer> prev, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> left){
        if(left.size() == 0){
            res.add(new ArrayList<Integer>(prev));
            return;
        }
        for(int i = 0; i < left.size(); i++){
            if(i == 0 || left.get(i) != left.get(i - 1)){
                int appendNum = left.get(i);
                left.remove(i);
                prev.add(appendNum);
                backTrack(prev, res, left);
                left.add(i, appendNum);
                prev.remove(prev.size() - 1);
            }
        }
    }
}
