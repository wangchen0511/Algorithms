public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists==null || lists.size()==0){
            return null;
        }
        PriorityQueue<ListNode> minHeap=new PriorityQueue<ListNode>(lists.size(),new Comparator(){
            public int compare(Object o1, Object o2){
                ListNode lO1=(ListNode) o1;
                ListNode lO2=(ListNode) o2;
                if(lO1.val<lO2.val){
                    return -1;
                }
                else if(lO1.val==lO2.val){
                    return 0;
                }
                else{
                    return 1;
                }
            } 
            
             public boolean equals(Object obj){
                return true;
             }
        });
        ListNode head=null,tail=null;
        for(int i=0;i<lists.size();i++){
            if(lists.get(i)!=null)
                minHeap.add(lists.get(i));
        }
        
        while(minHeap.size()!=0){
            ListNode temp=minHeap.poll();
            if(temp==null){
                continue;
            }
            if(head==null){
                head=temp;
                tail=head;
            }
            else{
                tail.next=temp;
                tail=temp;
            }
            temp=temp.next;
            if(temp!=null){
                minHeap.add(temp);
            }
        }
        return head;
    }
}