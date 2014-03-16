/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null){
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = null, newTail = null, iter = head;
        while(iter != null){
            RandomListNode copy = new RandomListNode(iter.label);
            if(newHead == null){
                newHead = copy;
                newTail = copy;
            }else{
                newTail.next = copy;
                newTail = copy;
            }
            map.put(iter, copy);
            iter = iter.next;
        }
        RandomListNode newIter = newHead;
        iter = head;
        while(newIter != null){
            if(iter.random != null){
                RandomListNode target = map.get(iter.random);
                newIter.random = target;
            }
            iter = iter.next;
            newIter = newIter.next; 
        }
        return newHead;
    }
}