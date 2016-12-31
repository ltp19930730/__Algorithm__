/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if (graph == null || graph.size() == 0){
            return -1;
        }
        if (s.equals(t)) {
            return 0;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, Integer> hm = new HashMap<UndirectedGraphNode, Integer>();
        queue.offer(s);
        hm.put(s,0);
        while (!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode neighbor: cur.neighbors){
                if (hm.containsKey(neighbor)){
                    continue;
                }
                if (neighbor.equals(t)){
                    return hm.get(cur) + 1;
                }
                hm.put(neighbor,hm.get(cur) + 1);
                queue.offer(neighbor);
            }
        }
        return -1;
    }
}
