package Leetcode75;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {


        Arrays.sort(strs, Comparator.comparingInt(String::length));
        int length = strs[0].length();
        int i;
        boolean flag = true;
        for(i=0;i<length;i++){
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i) != strs[0].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        return strs[0].substring(0, i);

    }

}
