package twosigama;

import org.junit.Test;

/**
* @author Tianpei Luo 
* @email teslaluo@gmail.com
* @date Jan 28, 2017 12:39:16 PM
* 
*/
public class FriendCycle {
	public static int findCycle(String[] input) {
		int len = input.length;
		UnionFind uf = new UnionFind(len);
		for (int i = 0; i < len; i++) {
			String cur = input[i];
			for (int j = i ;j < len; j++){
				if (cur.charAt(j) == 'Y') {
					uf.union(i, j);
				}
			}
		}
		return uf.getCount();
	}
	public static void main(String[] args) {
		String[] input = { "YYNN","YYYN","NYYN","NNNY"};
		System.out.println(findCycle(input));
	}

	static class UnionFind {
		private int[] id;
		private int count;
		public UnionFind(int n) {
			// TODO Auto-generated constructor stub
			id = new int[n];
			for (int i = 0; i < n; i++) {
				id[i] = i;
			}
			count = n;
		}
		public void union(int i, int j) {
			int pId = find(i);
			int qId = find(j);
			if (pId == qId){
				return;
			}
			for (int k = 0; k < id.length;k++) {
				if (id[k] == pId){
					id[k] = qId;
				}
			}
			count--;
		}
		public int find(int i){
			return id[i];
		}
		public int getCount(){
			return count;
		}
	}
}

