package Leetcode75;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome_2131 {
    public int longestPalindrome(String[] words) {
        // 记录有哪些是字母不一样并且pair了的，然后记录有哪些字母是一样的
        Map<String, Integer> letters = new HashMap();
        for(String word: words){
            letters.put(word, letters.getOrDefault(word,0)+1);
        }
        //mid - 是否存在出现了奇数次的可以作为中心的相同字符
        boolean mid = false;
        int ans = 0;
        for(String word: letters.keySet()){
            String reversedWord = word.charAt(1) + word.substring(0, 1);
            //相同字符
            if(reversedWord.equals(word)){
                int times = letters.get(word);
                if(times % 2 == 0){
                    ans += 2 * times;
                }else{
                    mid = true;
                }
            }else{
                int times1 = letters.get(word);
                int times2 = letters.getOrDefault(reversedWord,0);
                int times = Math.min(times1, times2);
                ans += 4 * times;
                //避免重复
                letters.put(word,0);
                if(times2>0) {
                    letters.put(reversedWord, 0);
                }
            }
        }
        if(mid){
            ans += 2;
        }
        return ans;


    }
}
