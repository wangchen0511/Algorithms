/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> res=new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0){
            return res;
        }
        
        Collections.sort(intervals,new Comparator(){
            public int compare(Object a1, Object a2){
                Interval aInter1=(Interval) a1;
                Interval aInter2=(Interval) a2;
                if(aInter1.start<aInter2.start){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });
        res.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start>res.get(res.size()-1).end){
                res.add(intervals.get(i));
            }
            else{
                Interval newInter=new Interval();
                newInter.start=res.get(res.size()-1).start;
                if(intervals.get(i).end>res.get(res.size()-1).end){
                    newInter.end=intervals.get(i).end;
                }
                else{
                    newInter.end=res.get(res.size()-1).end;
                }
                res.remove(res.size()-1);
                res.add(newInter);
            }
        }
        return res;
    }
}