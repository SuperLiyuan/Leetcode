package leetcode.finished;


/**
 * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 *
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
 *
 * 如果可以构成，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanConstruct_383 {

    public static boolean run(String ransomNote, String magazine){

        //计数
        for(int i='a';i<'z';i++){
            if(countChar(ransomNote, i) > countChar(magazine, i)){
                return false;
            }
        }
        return true;

    }

    public static int countChar(String str, int asciiChar){
        int cnt = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == asciiChar){
                cnt++;
            }
        }
        return cnt;
    }

}
