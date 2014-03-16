package com.example.test1;

/* Enter your code here. Read input from STDIN. Print output to STDOUT */


/* Enter your code here. Read input from STDIN. Print output to STDOUT */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        ArrayList<Racer> racers = new ArrayList<Racer>();
        while ((line = br.readLine()) != null) {
            // ...
            String[] params = line.split(" ");
            racers.add(new Racer(Long.parseLong(params[0]), Long.parseLong(params[1]), Long.parseLong(params[2])));
        }
        Collections.sort(racers, new Comparator<Racer>(){
        	public int compare(Racer a, Racer b){
        		if(a.start < b.start){
        			return -1;
        		}else if(a.start > b.start){
        			return 1;
        		}else{
        			return 0;
        		}
        	}
        });
        for(int i = 0 ; i < racers.size(); i++){
        	racers.get(i).startRank = i;
        }
        Collections.sort(racers, new Comparator<Racer>(){
        	public int compare(Racer a, Racer b){
        		if(a.end < b.end){
        			return -1;
        		}else if(a.end > b.end){
        			return 1;
        		}else{
        			return 0;
        		}
        	}
        });
        ArrayList<Long> recordRank = new ArrayList<Long>();
        for(Racer racer : racers){
        	long currentStartRank = racer.startRank;
        	long insertPoint = Collections.binarySearch(recordRank, currentStartRank);
        	insertPoint = -1 * insertPoint - 1;
        	long score = recordRank.size() - insertPoint;
        	racer.score = score;
        	recordRank.add((int) insertPoint,currentStartRank);
        }
        Collections.sort(racers, new Comparator<Racer>(){
        	public int compare(Racer a, Racer b){
        		if(a.score < b.score){
        			return -1;
        		}else if(a.score > b.score){
        			return 1;
        		}else{
        			return (int) (a.id-b.id);
        		}
        	}
        });
        for (Racer racer : racers){
            System.out.println(racer.id+" "+racer.score);
        }
    }
    
    static class Racer{
        public long id;
        public long start;
        public long end;
        public long score;
        public long startRank;
        public Racer(long id, long start, long end){
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }
}













import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        ArrayList<Racer> racers = new ArrayList<Racer>();
        while ((line = br.readLine()) != null) {
            // ...
            String[] params = line.split(" ");
            racers.add(new Racer(Long.parseLong(params[0]), Long.parseLong(params[1]), Long.parseLong(params[2])));
        }
        //Sort racers as their start time, stable merge sort O(nlog(n))
        Collections.sort(racers, new Comparator<Racer>(){
        	public int compare(Racer a, Racer b){
        		if(a.start < b.start){
        			return -1;
        		}else if(a.start > b.start){
        			return 1;
        		}else{
        			return 0;
        		}
        	}
        });
        /*
            bucketNum is the size of the buckets. I choose it as sqrt(n), 
            where n is the size of the input.
        */        
        int bucketNum = (int) Math.sqrt(n)+1;
        //Initialize buckets O(n)
        ArrayList<ArrayList<Long>> buckets = new ArrayList<ArrayList<Long>>();
        for(int i = 0; i < bucketNum ; i++){
        	ArrayList<Long> bucket = new ArrayList<Long>();
        	buckets.add(bucket);
        }
        //startTimes[i] record the biggest start time which can be put in the buckets[i]
        ArrayList<Long> startTimes = new ArrayList<Long>();
        //Initialize the startTimes O(n)
        for (int i=0 ; i < racers.size(); i++){
            /*
                At the first bucketNum-1 buckets, each bucket has bucketNum-1 racers. 
                The last bucket contains the rest of the racers which are not cantained
                in the first bucketNum-1 buckets. It may be empty or may have more than
                bucketNum-1 racers.               
            */
        	if((i + 1) % (bucketNum - 1) == 0 && startTimes.size() < bucketNum - 1){
        		startTimes.add(racers.get(i).start);
        	}else if(i == racers.size() - 1){
        		startTimes.add(racers.get(i).start);
        	}
        }
        //Sort racers by their end time. O(nlog(n))
        Collections.sort(racers, new Comparator<Racer>(){
        	public int compare(Racer a, Racer b){
        		if(a.end < b.end){
        			return -1;
        		}else if(a.end > b.end){
        			return 1;
        		}else{
        			return 0;
        		}
        	}
        });
        /*
            Iterate racer from early end time to late end time.
            
            When we get the racer, we find its bucketIndex by binary search 
            the startTimes, which is O(log(sqrt(n))) also is O(log(n)).
            
            To count the score, we need to count how many racers has been inserted
            into the buckets which have higher index than it, which is O(sqrt(n)). 

            Also we should not forget the early inserted racers in the same bucket, 
            which has higher start time. We use binary search to find this number, which
            is O(log(sqrt(n))), aslo is O(log(n)).

            Then we need to insert this racer to the bucket, which is O(log(n)).

            There are totally n iterators in the for loop. Each complexity is 
            O(sqrt(n)+log(n)), which is also O(sqrt(n)). Therefore, the total complexity
            in this step is O(n*sqrt(n))
        */
        for (Racer racer : racers){
        	int insertBucketIndex = Collections.binarySearch(startTimes, racer.start);
            insertBucketIndex = insertBucketIndex >= 0 ? insertBucketIndex : (-insertBucketIndex -1);
            int score=0;
            ArrayList<Long> bucket = buckets.get(insertBucketIndex);
        	int indexInBucket =  Collections.binarySearch(bucket, racer.start);
        	indexInBucket = -indexInBucket - 1;
        	score += bucket.size() - indexInBucket;
        	bucket.add(indexInBucket , racer.start);
        	for (int j = insertBucketIndex+1; j < buckets.size(); j++){
        		score += buckets.get(j).size();
        	}
        	racer.score = score;
        }
        //Sort as the score. O(nlog(n))
        Collections.sort(racers, new Comparator<Racer>(){
        	public int compare(Racer a, Racer b){
        		if(a.score < b.score){
        			return -1;
        		}else if(a.score > b.score){
        			return 1;
        		}else{
                    /*
                       Since the maximal id is 70,000, 
                       so we do not need to worry about overflow, we
                       can use substract here.
                    */
        			return (int) (a.id-b.id);
        		}
        	}
        });
        /*
            The total complexity is O(n*sqrt(n)+n*log(n)), which is aslo O(n*sqrt(n)).
            It satisfies with the requirement, which is o(n^2).
        */
        for (Racer racer : racers){
            System.out.println(racer.id+" "+racer.score);
        }
    }
    
    static class Racer{
        public long id;
        public long start;
        public long end;
        public long score;
        public Racer(long id, long start, long end){
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }
}
