/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(node == null){
            return null;
        }
        return cloneHelper(node, new HashMap<Integer, UndirectedGraphNode>());
    }
    
    
    private UndirectedGraphNode cloneHelper(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map){
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node.label, root);
        for(UndirectedGraphNode neighbor : node.neighbors){
            root.neighbors.add(cloneHelper(neighbor, map));
        }
        return root;
    }
    
}