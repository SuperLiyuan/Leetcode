package weekly.contest.week303;

public class RepeatedCharacter {
    public char run(String s) {
        int[] cnt = new int[26];
        for(int i = 0;i<s.length();i++){
            if(cnt[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
                cnt[s.charAt(i) - 'a'] ++;
        }
        return 'a';
    }
}
