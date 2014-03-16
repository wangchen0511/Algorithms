public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> former=new ArrayList<Integer>();
        ret.add(former);
        if(num==null){
            return ret;
        }
        Arrays.sort(num);
        subSets(num,0,num.length-1,ret,former);
        return ret;
        
    }
    
    private void subSets(int[] num, int from, int to, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> former){
        int repeatEnd=from+1;
        if(from>to){
            return;
        }
        for(;repeatEnd<=to;repeatEnd++){
            if(num[repeatEnd]!=num[repeatEnd-1]){
                break;
            }
        }
        for(int i=0;i<=repeatEnd-from;i++){
            for(int j=0;j<i;j++){
                former.add(num[from]);
            }
            if(i!=0){
                ret.add(new ArrayList<Integer>(former));
            }
            subSets(num,repeatEnd,to,ret,former);
            for(int j=0;j<i;j++){
                former.remove(former.size()-1);
            }  
        }
    }
    
}



//method better methdo 
public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    result.add(new ArrayList<Integer>());
	    Arrays.sort(num);
	    
	    int previousSize =0;
	    for(int i=0; i< num.length;i++){
	    	int size = result.size();
	    	for(int j=0; j<size; j++){
	    		if(i==0 || num[i]!=num[i-1]|| j>=previousSize){
	    			ArrayList<Integer> a = new ArrayList<Integer>(result.get(j));
	    			a.add(num[i]);
	    			result.add(a);
	    		}
	    	}
	    	previousSize = size;
	    }
	    return result;
	}