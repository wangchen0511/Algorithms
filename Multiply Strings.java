public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num1==null || num1.length()==0 || num2==null || num2.length()==0){
            return new String();
        }
        else if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        char[] res=new char[num1.length()+num2.length()+1];
        Arrays.fill(res,'0');
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int pos=num1.length()-1-i+num2.length()-1-j;
                pos=res.length-1-pos;
                int localRes=(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+(res[pos]-'0');
                int o=localRes%10;
                int c=localRes/10;
                for(int k=pos;k>=0;k--){
                    res[k]=(char)('0'+o);
                    if(c==0){
                        break;
                    }
                    else{
                        localRes=(res[k-1]-'0')+c;
                        o=localRes%10;
                        c=localRes/10;
                    }
                }
            }
        }
        int firstNonZero=0;
        for(;firstNonZero<res.length;firstNonZero++){
            if(res[firstNonZero]!='0'){
                break;
            }
        }
        return new String(Arrays.copyOfRange(res,firstNonZero,res.length));
    }
}