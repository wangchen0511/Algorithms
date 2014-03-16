public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Character> res=new ArrayList<Character>();
        for(int i=1;i<=n;i++){
            res.add((char)('0'+i));
        }
        int num=k;
        for(int i=0;i<n;i++){
            num=getStr(num,n,res,i);
        }
        StringBuilder resStr=new StringBuilder();
        for(Character ch: res){
            resStr.append(ch);
        }
        return resStr.toString();
    }
    
    private int getStr(int num, int n, ArrayList<Character> repo, int from){
        int baseNum=1;
        for(int i=1;i<=n-from-1;i++){
            baseNum*=i;
        }
        int pos=num/baseNum;
        if(num!=0 && num%baseNum==0){
            pos--;
        }
        char selected=repo.get(from+pos);
        repo.remove(pos+from);
        repo.add(from,selected);
        return num-baseNum*pos;
    }
}