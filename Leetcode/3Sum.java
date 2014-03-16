/**
   3Sum 

   Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

   Note:
   Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
   The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

 */





//v2 More efficient version, instead of using array insert, we use array append.
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        for(int i = num.length - 1 ; i > 1; i--){
            if(i == num.length - 1 || num[i] != num[i + 1]){
                for(ArrayList<Integer> element : twoSum(num, 0, i - 1, 0 - num[i])){
                    element.add(num[i]);
                    res.add(element);
                }
            }
        }
        return res;
    }
    
    private ArrayList<ArrayList<Integer>> twoSum(int[] num, int start, int end, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(start < end){
            if(num[start] + num[end] == target){
                res.add(new ArrayList<Integer>(Arrays.asList(num[start], num[end])));
                start++;
                while(start < end && num[start] == num[start - 1]){
                    start++;
                }
                end--;
                while(start < end && num[end] == num[end + 1]){
                    end--;
                }
            }else if(num[start] + num[end] < target){
                start++;
            }else{
                end--;
            }
        }
        return res;
    }
}





//v1
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