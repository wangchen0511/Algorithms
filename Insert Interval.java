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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> res= new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0){
            res.add(newInterval);
            return res;
        }
        int pos=getPos(intervals,newInterval.start);
        Interval insertedOne=new Interval(newInterval.start,newInterval.end);
        intervals.add(pos,insertedOne);
        res.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval resLast=res.get(res.size()-1);
            if(resLast.end>=intervals.get(i).start){
                if(resLast.end<intervals.get(i).end){
                    resLast.end=intervals.get(i).end;
                }
            }
            else{
                res.add(intervals.get(i));
            }
        }
        return res;
    }
    
    
    
    private int getPos(ArrayList<Interval> intervals, int value){
        int start=0;
        int end=intervals.size()-1;
        while(true){
            if(start==end){
                if(intervals.get(start).start>value){
                    return start;
                }
                else{
                    return start+1;
                }
            }
            else if(start>end){
                return start;
            }
            int mid=(start+end)/2;
            if(intervals.get(mid).start>value){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
    }
}



//method 2
public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){
		ArrayList<Interval> result = new ArrayList<Interval>();
		if(intervals==null || intervals.size() == 0){
			result.add(newInterval);
			return result;
		}
		int i =0;
		for(; i<intervals.size();i++){
			if(intervals.get(i).start < newInterval.start){
				result.add(intervals.get(i));
			}else{
				break;
			}
		}
		if(i==0){
			 result.add(newInterval);
		}else if(result.get(result.size()-1).end<newInterval.start){
			 result.add(newInterval);
		}else if(result.get(result.size()-1).end < newInterval.end){
			 result.get(result.size()-1).end = newInterval.end;
		}
		
		for(int j=i; j< intervals.size(); j++){
			Interval p = intervals.get(j);
			if(result.get(result.size()-1).end< p.start){
				result.add(p);
			}else if(result.get(result.size()-1).end < p.end){
				result.get(result.size()-1).end = p.end;
			}
		}
		return result;
}


//version 2
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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        int index = 0;
        boolean hasInserted = false;
        while(!hasInserted || index < intervals.size()){
            Interval toInserted;
            if(hasInserted){
                toInserted = intervals.get(index++);
            }else{
                if(index >= intervals.size() || newInterval.start < intervals.get(index).start){
                    toInserted = newInterval;
                    hasInserted = true;
                }else{
                    toInserted = intervals.get(index++);
                }
            }
            if(res.size() == 0){
                res.add(toInserted);
            }else{
                Interval tail = res.get(res.size() - 1);
                if(tail.end < toInserted.start){
                    res.add(toInserted);
                }else{
                    tail.end = Math.max(tail.end, toInserted.end);
                }
            }
        }
        return res;
    }
}