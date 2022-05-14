package sword.finished;

import java.util.Stack;

public class IsPalindrome_018 {
    public boolean run(String s) {
        s = s.toLowerCase();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a' && s.charAt(i)<='z')
                    || (s.charAt(i)>='0' && s.charAt(i)<='9')){
                stack.push(s.charAt(i));
            }
        }

        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a' && s.charAt(i)<='z')
                    || (s.charAt(i)>='0' && s.charAt(i)<='9')){
                if(s.charAt(i)!=stack.pop()){
                    return false;
                }
            }
        }


        return true;
    }
    }
