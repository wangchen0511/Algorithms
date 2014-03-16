public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        if(numRows<1){
            return ret;
        }
        ArrayList<Integer> firstRow=new ArrayList<Integer>();
        firstRow.add(1);
        ret.add(firstRow);
        for(int i=2;i<=numRows;i++){
            ArrayList<Integer> lastRow=ret.get(ret.size()-1);
            ArrayList<Integer> nextRow=new ArrayList<Integer>();
            nextRow.add(1);
            for(int j=1;j<lastRow.size();j++){
                nextRow.add(lastRow.get(j)+lastRow.get(j-1));
            }
            nextRow.add(1);
            ret.add(nextRow);
        }
        return ret;
        
    }
}