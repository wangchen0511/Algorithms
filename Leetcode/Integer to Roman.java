/**
   Integer to Roman:

   Given an integer, convert it to a roman numeral.

   Input is guaranteed to be within the range from 1 to 3999.
   

 */




//v2
public class Solution {
    public String intToRoman(int num) {
        String[] romanKeys = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] relatedValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder resBuilder = new StringBuilder();
        for(int i = romanKeys.length - 1; i >= 0; i--){
            if(num == 0){
                break;
            }
            int repeat = num / relatedValues[i];
            for(int j = 0; j < repeat; j++){
                resBuilder.append(romanKeys[i]);
            }
            num = num % relatedValues[i];
        }
        return resBuilder.toString();
    }
}




//v1
public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // Start typing your C/C++ solution below
        // DO NOT write int main() function    
        String[] elements={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] values={1,4,5,9,10,40,50,90,100,400,500,900,1000};
        int remain=num;
        StringBuilder romanBuilder=new StringBuilder();
        for(int i=elements.length-1;i>=0;i--){
            int nums=remain/values[i];
            remain=remain%values[i];
            romanBuilder.append(getString(elements[i],nums));
        }
        return romanBuilder.toString();
    }
    
    private String getString(String base, int nums){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<nums;i++){
            builder.append(base);
        }
        return builder.toString();
    }
}