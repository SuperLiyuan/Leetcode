package daily.ongoing;

public class IsAdditiveNumber_306 {

    public static boolean run(String num) {

        if(num.length()<3) return false;

        int halfLen = num.length()/2;
        int l1=1;
        while(l1<=halfLen){
            int l2 = 1;
            while(l2<=halfLen) {
                //从index位开始，长度为l1和长度为l2的是否能找到第三个符合的元素
                if(checkMatch(num,0,l1,l2)){
                    return true;
                }
                l2++;
            }

            l1++;
        }
        return false;
    }

    private static boolean checkMatch(String num, int index, int len1, int len2) {
        if((index+len1+len2 ==num.length()-1) && len1==1&&len2==1
                &&num.charAt(0)-'0'+num.charAt(1)-'0'==num.charAt(2)-'0') return true;
        String num2 = "0";
        if (num.charAt(index + len1) == '0') {
            if (len2 > 1) {
                return false;
            }
        }
        num2 = num.substring(index + len1, index + len1 + len2);

            int len3 = Math.max(len1, len2);
            if(len3 > num.length()-len1-len2-index) return false;
            String num1 = num.substring(index, index + len1);
            if (num.length() < index + len1 + len2 + len3) return false;
            if (num.charAt(index + len1 + len2 ) == '0'&&!("0".equals(num1)&&"0".equals(num2))) {
                    return false;
            }
            String num3 = num.substring(index + len1 + len2, index + len1 + len2 + len3);
            String num3Carry = "0";
            if (num.length() >= index + len1 + len2 + len3 + 1) {
                num3Carry = num.substring(index + len1 + len2, index + len1 + len2 + len3 + 1);
            }

            if (!verify(num1, num2, num3)) {
                if (!verify(num1, num2, num3Carry)) {
                    return false;
                } else {
                    return checkMatch(num,index+len1,len2,len3+1);
                }
            } else {
                return checkMatch(num,index+len1,len2,len3);
            }

        }


    private static boolean verify(String num1, String num2, String num3){
        int idx2 = num2.length()-1;
        int idx1 = num1.length()-1;
        int idx3 = num3.length()-1;
        if(num3.length()<num1.length()||num3.length()<num2.length()) return false;
        int carry = 0;
        int n=0;
        while(idx1>=0 && idx2>=0){
             n = num1.charAt(idx1) - '0'+ num2.charAt(idx2)- '0';
            if(carry ==1) n++;
            if(n>=10) {
                carry = 1;
                n = n - 10;
            }else{
                carry = 0;
            }
            if(n!=num3.charAt(idx3)-'0') {
                return false;
            } else{
                idx1--;
                idx2--;
                idx3--;
            }
        }
        while(idx1>=0&&idx3>=0){
             int n1=num1.charAt(idx1)-'0';
            if(carry ==1) {
                n1 = n1+1;
                if(n1>=10) {
                    n1=n1-10;
                    carry = 1;
                }else{
                    carry = 0;
                }
            }
            if(n1!=num3.charAt(idx3)-'0'){
                return false;
            }
            idx1--;
            idx3--;
        }
        while(idx2>=0&&idx3>=0){
            int n2=num2.charAt(idx2)-'0';
            if(carry ==1) {
                n2 = n2+1;
                if(n2>=10) {
                    n2=n2-10;
                    carry = 1;
                }else{
                    carry = 0;
                }
            }
            if(n2!=num3.charAt(idx3)-'0'){
                return false;
            }
            idx2--;
            idx3--;
        }
        if(idx3>=0){
            if(carry==1 && num3.charAt(idx3)-'0'==1){
                return true;
            }
            else {
                return false;
            }
        }


        return true;
    }


}
