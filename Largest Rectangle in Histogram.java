public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maxAera=0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i=0;i<height.length;i++){
            if(stack.size()==0){
                stack.push(i);
            }
            else if(height[stack.peek()]<=height[i]){
                stack.push(i);
            }
            else{
                while(stack.size()>0 && height[stack.peek()]>height[i]){
                    int center=stack.pop();
                    int left;
                    if(stack.size()==0){
                        left=0;
                    }
                    else{
                        left=stack.peek()+1;
                    }
                    int localAera=(i-left)*height[center];
                    maxAera=localAera>maxAera?localAera:maxAera;
                }
                stack.push(i);
            }
        }
        while(stack.size()>0){
            int center=stack.pop();
            int left=stack.size()==0?0:stack.peek()+1;
            int localAera=(height.length-left)*height[center];
            maxAera=localAera>maxAera?localAera:maxAera;
        }
        return maxAera;
    }
}




//better way!

    int maxiMalArea(vector<int> &height){
        stack<int> stk;
        int pos=0,m=0;
        height.push_back(0);
        while(pos<height.size()){
            if(stk.empty() || height[stk.top()]<=height[pos]){
                stk.push(pos++);
            }
            else{
                int heightRec=height[stk.top()];
                stk.pop();
                m=max(m,heightRec*(stk.empty()?pos:pos-1-(stk.top()+1)+1));
                
            }
        }
        return m;
    }