public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null){
            return 0;
        }
        Map<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
        int max=0;
        for(int i=0;i<num.length;i++){
            if(map.containsKey(num[i])){
                continue;
            }
            ArrayList<Integer> record=new ArrayList<Integer>();
            ArrayList<Integer> lastRecord, nextRecord;
            lastRecord=map.get(num[i]-1);
            nextRecord=map.get(num[i]+1);
            if(lastRecord==null){
                record.add(num[i]);
            }
            else{
                record.add(lastRecord.get(0));
            }
            if(nextRecord==null){
                record.add(num[i]);
            }
            else{
                record.add(nextRecord.get(1));
            }
            map.put(num[i],record);
            ArrayList<Integer> head,tail;
            head=map.get(record.get(0));
            tail=map.get(record.get(1));
            head.set(1,record.get(1));
            tail.set(0,record.get(0));
            if(record.get(1)-record.get(0)+1>max){
                max=record.get(1)-record.get(0)+1;
            }  
            
        }
        return max;
    }
}