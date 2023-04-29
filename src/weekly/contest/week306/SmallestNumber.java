package weekly.contest.week306;

public class SmallestNumber {
    public String smallestNumber(String pattern) {

        StringBuilder sb = new StringBuilder();
        int currPos = 0;
        int number = 2;
        sb.append(1);
        //贪心
        while(currPos < pattern.length()){
            while(currPos < pattern.length() &&pattern.charAt(currPos) == 'I' ){
                sb.append(number++);
                currPos ++;
            }

            int cnt = 0;
            while(currPos < pattern.length() && pattern.charAt(currPos) == 'D'){
                currPos ++;
                cnt ++;
            }
            int c=0;
            if(cnt>0){
                c = Integer.parseInt(String.valueOf(sb.charAt(sb.length()-1)));
                sb.deleteCharAt(sb.length()-1);
                for(int i = cnt;i>=0;i--){
                    sb.append(c+i);
                }
            }
            number = sb.length()+1;

        }
        return sb.toString();

    }
}
