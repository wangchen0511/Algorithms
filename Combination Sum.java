public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        if(candidates==null || candidates.length==0){
            return res;
        }
        Arrays.sort(candidates);
        int end=removeDupilcate(candidates);
        return combinationSumRange(candidates,0,end,target);
    }
    
    private ArrayList<ArrayList<Integer>> combinationSumRange(int[] candidates, int start, int end, int target){
        if(start>end){
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        int num=-1;
        while(true){
            num++;
            if(num*candidates[start]>target){
                break;
            }
            ArrayList<Integer> template= new ArrayList<Integer>();
            for(int i=0;i<num;i++){
                template.add(candidates[start]);
            }
            
            if(num*candidates[start]==target){
                res.add(template);
                break;
            }
            else{
                ArrayList<ArrayList<Integer>> buffer=combinationSumRange(candidates,start+1,end,target-num*candidates[start]);
                if(buffer==null){
                    continue;
                }
                for(int i=0;i<buffer.size();i++){
                    ArrayList<Integer> localTemplate= new ArrayList<Integer>(template);
                    localTemplate.addAll(buffer.get(i));
                    res.add(localTemplate);
                }
            }
        }
        return res;
    }
    
    private int removeDupilcate(int[] candidates){
        int lastNonDup=0;
        for(int i=1;i<candidates.length;i++){
            if(candidates[i]!=candidates[i-1]){
                candidates[++lastNonDup]=candidates[i];
            }
        }
        return lastNonDup;
    }
}


//method 2

//method 2
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		dfs(result, tmp, candidates, target, 0);
		return result;
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmp, int[] cand, int target, int pos){
		if(target<0) return;  
        if(target==0){  
            result.add(new ArrayList<Integer>(tmp));  
            return;  
        } 
        for(int i = pos; i<cand.length; i++){
        	tmp.add(cand[i]);
        	dfs(result, tmp, cand, target-cand[i],i);
        	tmp.remove(tmp.size()-1);
        }
	}
	
	
	
	
//method 3
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(target <= 0 || candidates == null){
            return res;
        }
        Arrays.sort(candidates);
        backtrack(new ArrayList<Integer>(), target, candidates, 0, candidates.length - 1, res);
        return res;
    }
    
    private void backtrack(ArrayList<Integer> prev, int target, int[] candidates, int from, int to, ArrayList<ArrayList<Integer>> res){
        if(from == to){
            if(target < 0){
                return;
            }else{
                if(target % candidates[to] != 0){
                    return;
                }
                ArrayList<Integer> inserted = new ArrayList<Integer>(prev);
                int num = target / candidates[to];
                for(int i = 0; i < num; i++){
                    inserted.add(candidates[to]);
                }
                res.add(inserted);
                return;
            }
        }
        backtrack(prev, target, candidates, from + 1, to, res);
        int numOfSelected = 1;
        for(; numOfSelected * candidates[from] <= target; numOfSelected++){
            if(numOfSelected * candidates[from] == target){
                prev.add(candidates[from]);
                ArrayList<Integer> inserted = new ArrayList<Integer>(prev);
                res.add(inserted);
            }else{
                prev.add(candidates[from]);
                backtrack(prev, target - numOfSelected * candidates[from], candidates, from + 1, to, res);
            }   
        }
        for(int i = 0; i < numOfSelected - 1; i++){
            prev.remove(prev.size() - 1);
        }
    }
    
}
	