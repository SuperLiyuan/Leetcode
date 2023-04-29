package weekly.contest.week300;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {

    public String run(String key, String message) {

        Map<Character, Character> map = new HashMap();
        int indexPos = 0;
        int keyLen = key.length();
        key = key.replace(" ", "");
        map.put(' ', ' ');
        for (int i = 0; i < keyLen && indexPos <26; i++) {
            char c = key.charAt(i);
            Character index = map.getOrDefault(c, '0');
            if(index == '0'){
                map.put(c, (char)('a'+indexPos));
                indexPos ++;
            }
        }
        int messageLen = message.length();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<messageLen;i++){
            stringBuilder.append(map.get(message.charAt(i)));
        }
        return stringBuilder.toString();
    }
}
