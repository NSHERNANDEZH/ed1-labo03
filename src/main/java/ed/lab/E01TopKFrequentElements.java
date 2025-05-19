package ed.lab;
import java.util.*;

class E01TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);

            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (var entry : map.entrySet()) {
            pq.offer(entry.getKey());
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];

        int index = 0;

        while (!pq.isEmpty()) {
            result[index] = pq.poll();
            index++;

        }

        return result;
    }
}

