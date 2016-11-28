/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

        // caculate the in-degree of these nodes
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        HashMap<DirectedGraphNode,Integer> hm = new HashMap<DirectedGraphNode,Integer>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode node2 : node.neighbors) {
                if (hm.containsKey(node2)) {
                    hm.put(node2, hm.get(node2) + 1);
                } else {
                    hm.put(node2, 1);
                }
            }
        }
        // find the node that in-degree is 0 and push it into the result and queue

        for (DirectedGraphNode node : graph) {
            if (!hm.containsKey(node)){
                result.add(node);
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode cur = queue.poll();
            for (DirectedGraphNode node : cur.neighbors) {
                hm.put(node, hm.get(node) - 1);
                if (hm.get(node) == 0) {
                    result.add(node);
                    queue.add(node);
                }
            }
        }
        return result;
    }
}
