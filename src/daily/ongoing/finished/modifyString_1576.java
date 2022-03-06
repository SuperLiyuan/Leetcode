package daily.ongoing.finished;

import java.util.ArrayList;
import java.util.List;

public class modifyString_1576{


    public static String run(String s){

        char[] sArr = new char[s.length()];
        List<Integer> questionPosList = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            sArr[i] = s.charAt(i);
            if("?".equals(String.valueOf(s.charAt(i)))){
                questionPosList.add(i);
            }
        }

        for(Integer pos: questionPosList){
            for(int i='a';i<='z';i++){
                if(pos>0){
                    if(sArr[pos-1] != i){
                        if(pos<sArr.length-1){
                            if(sArr[pos+1] !=i){
                                sArr[pos] = (char)i;
                            }
                        }else{
                            sArr[pos] = (char)i;
                            break;
                        }
                    }
                }else{
                    if(pos<sArr.length-1){
                        if(sArr[pos+1] !=i){
                            sArr[pos] = (char)i;
                            break;
                        }
                    }else{
                        sArr[pos] = (char)i;
                        break;
                    }
                }
            }

        }

        return String.valueOf(sArr);

    }

}
