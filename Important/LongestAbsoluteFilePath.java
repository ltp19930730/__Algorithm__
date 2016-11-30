Leetcode 388
public class Solution {
    // public int lengthLongestPath(String input) {
    //     String[] paths = input.split("\n");
    //     int[] stack = new int[paths.length+1];
    //     int maxLen = 0;
    //     for(String s:paths){
    //         int lev = s.lastIndexOf("\t")+1, curLen = stack[lev+1] = stack[lev]+s.length()-lev+1;
    //         if(s.contains(".")) maxLen = Math.max(maxLen, curLen-1);
    //     }
    //     return maxLen;
    // }
    	public static int lengthLongestPath(String input) {
		if (input == null || input.length() == 0 || !input.contains(".")) {
			return 0;
		}
		int maxLen = 0;
		String[] dirs = input.split("\n");
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(-1, 0);
		for (String dir : dirs) {
			int depth = 0;
			while (dir.charAt(depth) == '\t') {
				depth++;
			}
			String a = dir.substring(depth);
			if (a.contains(".")) {
				maxLen = Math.max(hm.get(depth - 1) + a.length(), maxLen);
				continue;
			}
			System.out.println(depth + "+" + (hm.get(depth - 1) + a.length() + 1));
			hm.put(depth, hm.get(depth - 1) + a.length() + 1);
		}
		return maxLen;
	}
}
