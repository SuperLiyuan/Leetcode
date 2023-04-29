package Leetcode75;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Multiply_43 {

    public String multiply(String num1, String num2) {

        //应该默认填0 了哈？
         int[] res = new int[num1.length() + num2.length()];
         int pointer = res.length - num1.length();
         int digit = num2.length()-1;
         while(digit>=0){
             int n = num2.charAt(digit) - '0';
             for(int i = 0;i<num1.length();i++){
                 res[pointer + i] = res[pointer+i] + (num1.charAt(i)-'0') * n;
             }
             pointer --;
             digit --;
         }

         StringBuilder sb = new StringBuilder();

         int arrCarry = 0;
         int ii = 0;
         while(ii<res.length && res[ii]==0){
             ii++;
         }
         if(ii==res.length){
             return "0";
         }
         for(int i = res.length-1;i>=ii;i--){
             res[i] = res[i]+ arrCarry;
             int left = res[i] %10;
             arrCarry = res[i] / 10;
             sb.append(left);
         }
         if(arrCarry!=0){
             sb.append(arrCarry);
         }
         return sb.reverse().toString();

    }

}
