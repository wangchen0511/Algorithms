/**
		Longest Palindromic Substring 
		
		Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

*/



public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String processedStr=preprocess(s);
        int center=0;
        int rightEdge=0;
        int maxLeft=0;
        int maxRight=0;
        int centerPoints=processedStr.length();
        int[] maxLength=new int[centerPoints];
        for(int i=0;i<centerPoints;i++){
            int mirror;
            int left,right;
            int tempLength=0;
            if(rightEdge>i){
                mirror=center-(i-center);
                if(maxLength[mirror]<rightEdge-i){
                    maxLength[i]=maxLength[mirror];
                    continue;
                }
                else{
                    left=i-(rightEdge-i)-1;
                    right=rightEdge+1;
                    tempLength=rightEdge-i;
                }
            }
            else{
                left=i-1;
                right=i+1;
            }
            while(left>=0 && right<centerPoints){
                if(processedStr.charAt(left)==processedStr.charAt(right)){
                    tempLength++;
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }
            maxLength[i]=tempLength;
            if(i+tempLength>rightEdge){
                rightEdge=i+tempLength;
                center=i;
            }
            if(((right-1)/2-(left+2)/2)>maxRight/2-(maxLeft+1)/2){
                maxLeft=left+1;;
                maxRight=right-1;
            }
        }
        return s.substring((maxLeft+1)/2,maxRight/2+1);
    }
    
    private String preprocess(String s){
        StringBuilder strBuilder=new StringBuilder();
        if(s==null || s.length()==0){
            return null;
        }
        strBuilder.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            strBuilder.append("#");
            strBuilder.append(s.charAt(i));
        }
        return strBuilder.toString();
    }
}


//
public class Solution {
    public String longestPalindrome(String s) {
        String processedS = process(s);
        int center = 0;
        int radius = 0;        
        int rightEdge = 1;
        int[] radiusRecords = new int[processedS.length()];
        while(rightEdge < radiusRecords.length){
            int centerReachable = center + radius;
            if(rightEdge > centerReachable){
                radiusRecords[rightEdge] = countRadius(processedS, rightEdge, 0);
                center = rightEdge;
                radius = radiusRecords[rightEdge];
            }else{
                int mirrorCenter = center - (rightEdge - center);
                int mirrorRadius = radiusRecords[mirrorCenter];
                int minimalRaduis = (rightEdge + mirrorRadius) > centerReachable ? (centerReachable - rightEdge) : mirrorRadius;
                radiusRecords[rightEdge] = countRadius(processedS, rightEdge, minimalRaduis);
                if(rightEdge + radiusRecords[rightEdge] > centerReachable){
                    center = rightEdge;
                    radius = radiusRecords[rightEdge];
                }
            }
            rightEdge++;
        }
        int maxCenter = maxOf(radiusRecords);
        int maxRadius = radiusRecords[maxCenter];
        int left = (maxCenter - maxRadius + 1)/2;
        int right = (maxCenter + maxRadius)/2;
        return s.substring(left, right + 1);
    }
    
    private String process(String s){
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            strBuilder.append(s.charAt(i));
            if(i != s.length() - 1){
                strBuilder.append("*");
            }
        }
        return strBuilder.toString();
    }
    
    private int countRadius(String s, int center, int startRadius){
        startRadius++;
        while(center + startRadius < s.length() && center - startRadius >= 0){
            if(s.charAt(center + startRadius) == s.charAt(center - startRadius)){
                startRadius++;
            }else{
                startRadius--;
                break;
            }
        }
        if(center + startRadius == s.length() || center - startRadius < 0){
            startRadius--;
        }
        return startRadius;
    }
    
    private int maxOf(int[] arr){
        int max = arr[0];
        int maxIndex = 0;
        for(int i = 1; i < arr.length; i++){
            int length = (i + arr[i])/2 - (i - arr[i] + 1)/2;
            if(max < length){
                max = length;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}