import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // max heap
        
        for (int stone : stones) {
            pq.offer(stone);
        }
        
        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            
            if (stone1 != stone2) {
                pq.offer(Math.abs(stone1 - stone2));
            }
        }
        
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
