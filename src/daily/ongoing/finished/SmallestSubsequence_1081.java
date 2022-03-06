package daily.ongoing.finished;

import java.util.*;

public class SmallestSubsequence_1081 {


    public static String run(String s) {
        //记录字符串s的第i位
        List<Integer> l = new ArrayList<>();
        Map<Character, Integer> settledMap = new HashMap<>();
        //每个字母对应出现的次数
        Map<Character, Integer> map = new HashMap<>();

        //存放字符串（settledMap的功能）
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            map.merge(curr, 1, Integer::sum);
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if(stack.size() ==0) {
                stack.push(curr);
                map.replace(curr,map.get(curr)-1);
                continue;
            }

            Integer left = map.get(stack.peek());

            //栈顶字母后面都不出现了,则不出栈
            if (left == 0) {
                //无重复则进栈
                if(stack.search(curr) == -1) {
                    stack.push(curr);
                }
                //无论进不进栈都-1
                map.replace(curr, map.get(curr) - 1);
            } else {
                if(stack.search(curr) ==-1) {
                while (stack.size()>0&&curr < stack.peek() ) {
                    if(map.get(stack.peek())>0 ) {
                        stack.pop();
                    }
                    else break;
                }
                    stack.push(curr);
                }
                map.replace(curr, map.get(curr) - 1);

                //这个字母重复出现过，顺序已经定下来了
//            if(settledMap.get(curr) != null && list !=null &&list.size()>1) {
//                continue;
//            }


                //如果字母第一次出现 就要这个字母

                //if(left == null){
//                list = new ArrayList<>();
//                list.add(i);
//                map.put(curr,list);
//                settledMap.put(curr,i);

                //stack.push(curr);

                //如果当字母有出现过，则根据排序对比取舍
//            }else{
//                list.add(i);
//                map.replace(curr,list);
//
//                if(curr < stack.peek()){
//                    if(stack.search(curr)==0){
//                        stack.pop();
//                        stack.push(curr);
//                    }
//
//                }
//
//
//                //curr = a, s = a ... b a 不要后面的
////                if(curr <= s.charAt(i-1)){
////                    settledMap.replace(curr,list.get(0));
////                }
//                //curr = b, s = b ... a b 不要前面的
////                else settledMap.replace(curr,list.get(list.size()-1));
//
//            }
//
//
//        }
//        for(int ii=0;ii<s.length();ii++){
//            char c= s.charAt(ii);
//            if(settledMap.get(c)==ii){
//                sb.append(c);
//
//            }
//        }
            }
        }

        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
