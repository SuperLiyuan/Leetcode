package sword.finished;

public class ReplaceSpace_05 {

    public static String run(String s) {

        String res="";
        int lastSpacePos = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                res = res + s.substring(lastSpacePos+1, i)+"%20";
                lastSpacePos = i;
            }
        }
        res = res + s.substring(lastSpacePos+1);
        return res;

    }
}
