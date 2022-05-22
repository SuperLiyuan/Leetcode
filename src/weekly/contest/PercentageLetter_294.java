package weekly.contest;

public class PercentageLetter_294 {
    public int run(String s, char letter) {

        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == letter){
                cnt ++;
            }
        }
        return (cnt * 100 / s.length() );

    }
}
