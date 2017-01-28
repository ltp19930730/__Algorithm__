package word_count.priority_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Pair{
	String name;
	int freq;
	Pair(String name, int freq) {
		this.name = name;
		this.freq = freq;
	}
}

public class Solution {
	private Comparator<Pair> comp = new Comparator<Pair>() {
		@Override
		public int compare(Pair a, Pair b) {
			if (a.freq != b.freq) {
				return Integer.compare(a.freq, b.freq);
			}
			return b.name.compareTo(a.name);
		}
	};
	
	public List<String> topKwordFreq(String[] input,int k) {
		List<String> result = new ArrayList<>();
		if (input == null || input.length == 0) {
			return result;
		}
		Map<String,Integer> hm = new HashMap<>();
		for (String str : input) {
			if (hm.containsKey(str)) {
				hm.put(str, hm.get(str) + 1);
				continue;
			}
			hm.put(str, 1);
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>(k,comp);
		for (String str : hm.keySet()){
			Pair newP = new Pair(str,hm.get(str));
			if (pq.size() != k) {
				pq.add(newP);
				continue;
			}
			Pair peek = pq.peek();
			if (comp.compare(newP,peek) > 0) {
				pq.poll();
				pq.add(newP);
			}
		}

		while(!pq.isEmpty()){
			Pair tmp = pq.poll();
			result.add(tmp.name);
		}
		Collections.reverse(result);
		return result;
	}
	
	public static void main(String[] args) {
		String[] input = {"mom","mom","mom","aome","aome","aome","tesla"};
		
		System.out.println(new Solution().topKwordFreq(input, 3));
	}
}
