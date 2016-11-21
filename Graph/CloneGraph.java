/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null){
            return null;
        }
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        // bfs a graph using a queue 
        while(!q.isEmpty()){
            UndirectedGraphNode tmp = q.poll();
            if (map.containsKey(tmp)){
                continue;
            }else{
                map.put(tmp,new UndirectedGraphNode(tmp.label));
            }
            for (int i = 0; i < tmp.neighbors.size(); i++){
                if (map.containsKey(tmp.neighbors.get(i))){
                    continue;
                }else{
                    q.add(tmp.neighbors.get(i));
                }
            }
        }
        for (Map.Entry<UndirectedGraphNode,UndirectedGraphNode> entry: map.entrySet()){
            for(UndirectedGraphNode n:entry.getKey().neighbors){
                entry.getValue().neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }
}
