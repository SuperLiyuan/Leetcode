package sword.finished.ongoing;

public class IsPalindrome_018 {
    public boolean run(String s) {
        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a' && s.charAt(i)<='z')
                    || (s.charAt(i)>='0' && s.charAt(i)<='9')){
                stringBuilder.append(s.charAt(i));
            }
        }
        String letterStr = stringBuilder.toString();
        for(int i = 0,j = letterStr.length()-1;i<=j;i++,j--){
            if(letterStr.charAt(i)!=letterStr.charAt(j)){
                return false;
            }
        }
        return true;
    }
    }
