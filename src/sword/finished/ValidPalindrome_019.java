package sword.finished;

public class ValidPalindrome_019 {

    public boolean run(String s) {
        int i = 0;
        int j = s.length() - 1;


        while (i < j && s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
        }
        return isPalindrome(s.substring(i + 1, j)) || isPalindrome(s.substring(i, j - 1));
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;


        while (s.charAt(i) == s.charAt(j) && i<j) {
                i++;
                j--;
        }

        if(i>=j){
            return true;
        }
        return false;

    }

//        while(i<j){
//            if(s.charAt(i)!=s.charAt(j)){
//                //他们对两端的距离差大于1
//                if(Math.abs(i-0 - (s.length()-1-j))>1){
//                    return false;
//                }else{
//                    //如果i右移一位可以跟j相同
//                    if(s.charAt(i+1) == s.charAt(j)){
//                        i++;
//                    //如果j左移一位可以跟i相同
//                    }else if(s.charAt(i) == s.charAt(j-1)){
//                        j--;
//                    }else{
//                        //！！！判断不出 mlcup ... uc[u]lm的情况，不要再用了！
//                        return false;
//                    }
//                }
//            }else{
//                i++;
//                j--;
//            }
//        }


}
