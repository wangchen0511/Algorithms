//this version think that equal means no relation
public class Solution {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] res = new int[ratings.length];
        int min = 0;
        for(int i = 0; i < ratings.length - 1; i++){
            if(ratings[i] < ratings[i + 1]){
                res[i + 1] = res[i] + 1;
            }else if(ratings[i] > ratings[i + 1]){
                res[i + 1] = res[i] -1;
            }else{
                res[i + 1] = res[i];
            }
            min = Math.min(min, res[i + 1]);
        }
        int sum = 0;
        int increament = 1 - min;
        for(int i : res){
            sum += i + increament;
        }
        return sum;
    }
}

//

public class Solution {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] res = new int[ratings.length];
        int min = 0;
        int minStartIndex = 0;
        int sum = 0;
        boolean isUp = true;
        for(int i = 0; i < ratings.length - 1; i++){
            if(ratings[i] < ratings[i + 1]){
                res[i + 1] = res[i] + 1;
            }else if(ratings[i] > ratings[i + 1]){
                res[i + 1] = res[i] -1;
            }else{
                res[i + 1] = 0;
                int increament = 1 - min;
                min = 0;
                for(int j = minStartIndex; j <= i; j++){
                    sum += (res[j] + increament);
                }
                minStartIndex = i + 1;
            }
            min = Math.min(min, res[i + 1]);
        }
        int increament = 1 - min;
        for(int i = minStartIndex; i < ratings.length; i++){
            sum += (res[i] + increament);    
        }
        return sum;
    }
}