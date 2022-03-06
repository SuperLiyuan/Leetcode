package daily.ongoing;

public class LongestNiceSubstring_1763 {

    public String run(String s) {
        int[] lowLetterCount = new int[26];
        int[] capLetterCount = new int[26];
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            //小写 A-Z ... a-z
            if (c > 'Z') {
                lowLetterCount[c - 'a']++;
                if (capLetterCount[c - 'a'] > 0) {
                    return c + String.valueOf(capLetterCount[c - 'a']);
                }
            } else {
                capLetterCount[c - 'A']++;
                if (lowLetterCount[c - 'A'] > 0) {
                    return c + String.valueOf(lowLetterCount[c - 'A']);
                }
            }
        }
            return "";
        }
    }


