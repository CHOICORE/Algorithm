/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        Node clonedNode = new Node(node.val);
        map.put(node, clonedNode);
        
        cloneNeighbors(node, clonedNode, map);
        
        return clonedNode;
    }
    
    private void cloneNeighbors(Node node, Node clonedNode, Map<Node, Node> map) {
        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor)) {
                clonedNode.neighbors.add(map.get(neighbor));
            } else {
                Node clonedNeighbor = new Node(neighbor.val);
                map.put(neighbor, clonedNeighbor);
                clonedNode.neighbors.add(clonedNeighbor);
                cloneNeighbors(neighbor, clonedNeighbor, map);
            }
        }
    }
}
