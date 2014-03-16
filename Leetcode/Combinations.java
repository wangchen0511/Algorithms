public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return combine1(1,n,k);
    }
    
    
    public ArrayList<ArrayList<Integer>> combine1(int from, int to, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        if(to-from+1==k){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(;from<=to;from++){
                temp.add(from);
            }
            ret.add(temp);
            return ret;
        }
        else if(to-from+1<k){
            return ret;
        }
        else if(k<=0){
            return ret;
        }
        ret=combine1(from+1,to,k);
        if(k==1){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(from);
            ret.add(temp);
        }
        else{
            ArrayList<ArrayList<Integer>> buffer=combine1(from+1,to,k-1);
            for(ArrayList<Integer> item: buffer){
                item.add(0,from);
                ret.add(item);
            }
        }
        return ret;
    }
}