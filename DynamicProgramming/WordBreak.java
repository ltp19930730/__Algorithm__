public class Solution {
        private int getMaxLength(Set<String> dict){
        int maxLength = 0;
        for (String word : dict){
            maxLength = Math.max(word.length(), maxLength);
        }
        return maxLength;
    }
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0){
            return true;
        }
        int maxLen = getMaxLength(wordDict);
        int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for (int i = 1; i <= len; i++){
            for (int j = 0; j <= i && j <= maxLen; j++){
                if(f[i-j]){
                    String word = s.substring(i-j,i);
                    if (wordDict.contains(word)){
                        f[i] = true;
                        break;
                    }
                }
            }
        }
        return f[len];
        // int maxLength = getMaxLength(wordDict);
        // boolean[] canSegment = new boolean[s.length() + 1];

        // canSegment[0] = true;
        // for (int i = 1; i <= s.length(); i++) {
        //     canSegment[i] = false;
        //     for (int lastWordLength = 1;
        //              lastWordLength <= maxLength && lastWordLength <= i;
        //              lastWordLength++) {
        //         if (!canSegment[i - lastWordLength]) {
        //             continue;
        //         }
        //         String word = s.substring(i - lastWordLength, i);
        //         if (wordDict.contains(word)) {
        //             canSegment[i] = true;
        //             break;
        //         }
        //     }
        // }

        // return canSegment[s.length()];
    }
}
