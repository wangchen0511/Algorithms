class Solution {
public:
    string convert(string s, int nRows) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function   
        int probe=0;
        string result(s);
        if(s.size()==0){
            return s;
        }
        for(int i=0;i<nRows;i++){
            int flag=0;
            int interval1=2*i;
            int interval2=2*(nRows-1)-interval1;
            int index=i;
            while(index < s.size()){
                result[index]=s[probe++];
                if(interval1==0 || interval2==0){
                    index+=interval1+interval2;
                }
                else{
                    if(flag==0){
                        index+=interval2;
                        flag=1;
                    }
                    else{
                        flag=0;
                        index+=interval1;
                    }
                }
            }
        }
        return result;
        
    }
};