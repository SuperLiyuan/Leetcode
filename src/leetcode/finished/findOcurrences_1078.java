package leetcode.finished;

import java.util.ArrayList;
import java.util.List;

public class findOcurrences_1078 {

    public static void main(String[] args) {
        findOcurrences("jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa",
                "kcyxdfnoa","jkypmsxd");
    }

    public static String[] findOcurrences(String text, String first, String second) {

        String[] words = text.split(" ");
        List<String> thirdList = new ArrayList<>();
        if(words.length <=2) return null;
        String[] thirds = new String[]{};
        int cnt = 0;
        for(int i=0;i<=words.length-2;i++){
            if(first.equals(words[i])){
                if(second.equals(words[i+1])){
                    thirdList.add(words[i+2]);
                }
            }
        }

        return thirdList.toArray(thirds);



    }

}
