package Leetcode75;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if( len <= 1){
            return len;
        }
        //滑动窗口
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap();
        int left = 0;
        int currLen = 0;
        for(int right =0;right < len;right++){
            Character c = s.charAt(right);
            if(map.containsKey(c)){
                int pos = map.get(c);
                for(int i = left;i<pos+1;i++){
                    map.remove(s.charAt(i));
                }
                left = pos + 1;
            }
            map.put(c, right);
            currLen = map.size();
            maxLen = Math.max(maxLen, currLen);


        }
        return maxLen;
    }
}
