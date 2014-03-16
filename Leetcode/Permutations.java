public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null || num.length==0){
            return new ArrayList<ArrayList<Integer>>();
        }
        return permuteRange(num,0);
    }
    
    private ArrayList<ArrayList<Integer>> permuteRange(int[] num, int from){
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(from>=num.length){
            return res;
        }
        else if(from==num.length-1){
            ArrayList<Integer> uniqueRes=new ArrayList<Integer>();
            uniqueRes.add(num[from]);
            res.add(uniqueRes);
            return res;
        }
        ArrayList<ArrayList<Integer>> lastRes=permuteRange(num,from+1);
        for(int i=0;i<lastRes.size();i++){
            ArrayList<Integer> template=lastRes.get(i);
            for(int j=0;j<=template.size();j++){
                ArrayList<Integer> oneInstance=new ArrayList<Integer>(template);
                oneInstance.add(j,num[from]);
                res.add(oneInstance);
            }
        }
        return res;
    }
}



//In this problem, using backtrack is a better way, because using the for, we need to insert into ArrayList, which is very low efficient.
Here we only need an array and an begin index! Note we do not add prev ArrayList, because we can save this space and create an ArrayList
when we need it.

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            return res;
        }
        backTrack(res, num, 0);
        return res;
    }   
    
    private void backTrack(ArrayList<ArrayList<Integer>> res, int[] num, int begin){
        if(begin == num.length){
            ArrayList<Integer> oneRes = new ArrayList<Integer>();
            for(int element : num){
                oneRes.add(element);
            }
            res.add(oneRes);
            return;
        }
        for(int i = begin; i < num.length; i++){
            swap(num, i, begin);
            backTrack(res, num, begin + 1);
            swap(num, i, begin);
        }
    }
    
    private void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
