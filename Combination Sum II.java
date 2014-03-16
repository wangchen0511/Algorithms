public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length==0){
            return res;
        }
        Arrays.sort(num);
        int[] count=new int[num.length];
        int end=removeDup(num,count);
        return  combinationSum(num,count,0,end,target);
    }
    
    
    
    
    private ArrayList<ArrayList<Integer>> combinationSum(int[] num, int[] count, int start, int end, int target){
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(start>end){
            return res;
        }  
        for(int currentNum=0;currentNum<=count[start];currentNum++){
            ArrayList<Integer> template=new ArrayList<Integer>();
            for(int i=0;i<currentNum;i++){
                template.add(num[start]);
            }
            if(currentNum*num[start]>target){
                return res;
            }
            else if(currentNum*num[start]==target){
                res.add(template);
                return res;
            }
            else{
                ArrayList<ArrayList<Integer>> buffer=combinationSum(num,count,start+1,end,target-currentNum*num[start]);
                for(int i=0;i<buffer.size();i++){
                     ArrayList<Integer> localTemplate=new ArrayList<Integer>(template);
                     localTemplate.addAll(buffer.get(i));
                     res.add(localTemplate);
                }
            
            }
        }
        return res;
        
    }
    
    private int removeDup(int[] num, int[] count){
        int lastNonDup=0;
        int counts=1;
        for(int i=1;i<num.length;i++){
            if(num[i]==num[i-1]){
                counts++;
            }
            else{
                count[lastNonDup]=counts;
                counts=1;
                num[++lastNonDup]=num[i];
            }
        }
        count[lastNonDup]=counts;
        return lastNonDup;
    }
}