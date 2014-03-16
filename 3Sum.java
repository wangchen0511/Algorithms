public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length<3){
            return res;
        }
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
             if(i!=0 && num[i]==num[i-1]){
                 continue;
             }
             ArrayList<ArrayList<Integer>> buffer=twosum(num,i+1,0-num[i]);
             for(int j=0;j<buffer.size();j++){
                 ArrayList<Integer> temp=buffer.get(j);
                 temp.add(0,num[i]);
                 res.add(temp);
             }
        }
        return res;
    }
    
    private ArrayList<ArrayList<Integer>> twosum(int[] num, int start, int target){
        int head=start,tail=num.length-1;
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        while(head<tail){
            if(num[head]+num[tail]==target){
                ArrayList<Integer> oneRes=new ArrayList<Integer>(Arrays.asList(num[head],num[tail]));
                res.add(oneRes);
                while(head<num.length-1 && num[head]==num[++head]){
                }
                while(tail>start && num[tail]==num[--tail]){                    
                }
            }
            else if(num[head]+num[tail]>target){
                tail--;
            }
            else{
                head++;
            }
        }
        return res;
    }
}