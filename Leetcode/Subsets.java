public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        return subset1(S,0);
    }
    
    private ArrayList<ArrayList<Integer>> subset1(int[] S, int from){
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        if(from==S.length){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            ret.add(temp);
            return ret;
        }
        ArrayList<ArrayList<Integer>> buffer=subset1(S,from+1);
        for(ArrayList<Integer> item: buffer){
            ret.add(item);
            ArrayList<Integer> item1 = new ArrayList<Integer>(item);
            item1.add(0,S[from]);
            ret.add(item1);
        }
        return ret;
    }
}