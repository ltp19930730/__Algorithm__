package string.medium;

import java.util.Arrays;
import java.util.Collections;

/**
* @author Tianpei Luo 
* @email teslaluo@gmail.com
* @date Jan 3, 2017 12:37:43 AM
* 
*/
public class reverseString {
    public static String reverseWords(String s) {
    	// delete any number of blank 
    	String[] strs = s.trim().split(" +");
        int i = 0,j = strs.length-1;
        while(i<j){
            String tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < strs.length; k++) {
        	if (k == strs.length - 1) {
        		sb.append(strs[k]);
        	}else{
        		sb.append(strs[k]).append(" ");
        	}
        }
        return sb.toString();
    }
    
    public static String reverseWords2(String s) {
    	String[] strs = s.trim().split(" +");
    	Collections.reverse(Arrays.asList(strs));
    	//System.out.println(Arrays.toString(strs));
    	return String.join(" ", strs);
    }
	public static void main(String[] args) {
		String test = "the sky is blue";
		System.out.println(reverseWords(test));
		
		System.out.println(reverseWords2(test));
	}

}
