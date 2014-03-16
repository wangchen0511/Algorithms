/**
	Longest Substring Without Repeating Characters
		
	Given a string, find the length of the longest substring without repeating characters. For example, 
	the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
	For "bbbbb" the longest substring is "b", with the length of 1.

*/


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int headProbe = 0, tailProbe = 0;
        boolean moveTail = true;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        while(tailProbe < s.length() || !moveTail){
            if(!moveTail){
                map.put(s.charAt(headProbe), map.get(s.charAt(headProbe)) - 1);
                if(map.get(s.charAt(headProbe++)) > 0){
                    moveTail = true;
                    maxLength = (tailProbe - headProbe) > maxLength ? (tailProbe - headProbe) : maxLength;
                }
            }else{
                if(map.get(s.charAt(tailProbe)) == null || map.get(s.charAt(tailProbe)) <= 0){
                    map.put(s.charAt(tailProbe++), 1);
                    maxLength = (tailProbe - headProbe) > maxLength ? (tailProbe - headProbe) : maxLength;
                }else{
                    map.put(s.charAt(tailProbe++), 2);
                    moveTail = false;
                }
            }
        }
        return maxLength;
    }
}