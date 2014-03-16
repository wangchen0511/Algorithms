public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<String,Integer> strMap= new HashMap<String, Integer>();
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(L==null || L.length==0){
            return new ArrayList<Integer>();
        }
        if(L[0]==null || L[0].length()==0){
            return new ArrayList<Integer>();
        }
        for(int i=0;i<L.length;i++){
            if(strMap.get(L[i])==null){
                strMap.put(L[i],1);
            }
            else{
                strMap.put(L[i],strMap.get(L[i])+1);
            }
        }
        for(int i=0;i<=S.length()-L[0].length()*L.length;i++){
            Map<String,Integer> tempMap=new HashMap(strMap);
            boolean isMatch=true;
            for(int j=0;j<L.length;j++){
                String oneStr=S.substring(i+j*L[0].length(),i+j*L[0].length()+L[0].length());
                if(tempMap.get(oneStr)==null){
                    isMatch=false;
                    break;
                }
                else{
                    int lastValue=tempMap.get(oneStr);
                    if(lastValue==0){
                        isMatch=false;
                        break;
                    }
                    tempMap.put(oneStr,lastValue-1);
                }
            }
            if(isMatch){
                res.add(i);
            }
            
        }
        return res;
    }
}