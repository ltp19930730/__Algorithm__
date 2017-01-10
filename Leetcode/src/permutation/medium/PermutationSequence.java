package permutation.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	
	public String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<>();
		k--;
		int mod = 1;
		for (int i = 1; i <= n; i++) {
			list.add(i);
			mod = mod * i;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			mod = mod / (n - i);
			int index = k / mod;
			k = k % mod;
			sb.append(list.get(index));
			list.remove(index);
		}
		return sb.toString();
	}
	public static void main(String[] args) {

		System.out.println(new PermutationSequence().getPermutation(3, 10));
	}
}
