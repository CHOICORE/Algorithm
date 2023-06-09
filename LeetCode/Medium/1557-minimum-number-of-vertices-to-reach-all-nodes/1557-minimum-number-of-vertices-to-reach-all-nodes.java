class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int size = edges.size();
        List<Integer> ans = new ArrayList<>();
        int[] reached = new int[n];
        for (List<Integer> edge : edges) {
            reached[edge.get(1)] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (reached[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}