/**
	ZigZag Conversion 
	
	
	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:

	string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	
*/


public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder[] strBuilders=new StringBuilder[nRows];
        int lastRow=0;
        boolean up=true;
        for(int i=0;i<s.length();i++){
            if(strBuilders[lastRow]==null){
                strBuilders[lastRow]=new StringBuilder();
            }
            strBuilders[lastRow].append(s.charAt(i));
            if(lastRow>0 && lastRow<nRows-1){
                if(up){
                    lastRow--;
                }
                else{
                    lastRow++;
                }
            }
            else{
                if(lastRow==0){
                    if(nRows==1){
                        lastRow=0;
                    }
                    else{
                        lastRow=1;
                        up=false;
                    }
                }
                else if(lastRow==nRows-1){
                    lastRow--;
                    up=true;
                }
            }
        }
        String res="";
        for(int j=0;j<nRows;j++){
            if(strBuilders[j]!=null)    
                res=res+strBuilders[j].toString();
        }
        return res;
    }
}




//A cleaner version




