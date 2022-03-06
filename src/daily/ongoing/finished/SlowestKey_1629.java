package daily.ongoing.finished;

public class SlowestKey_1629 {

    public static char run(int[] releaseTimes, String keysPressed) {
        int maxDuration = releaseTimes[0];
        char maxDurLetter = keysPressed.charAt(0);
        for(int i=1;i<releaseTimes.length;i++){
            int currentDuration = releaseTimes[i] - releaseTimes[i-1];
            if(currentDuration == maxDuration){
                if(maxDurLetter < keysPressed.charAt(i)){
                    maxDurLetter = keysPressed.charAt(i);
                }
            }else if(currentDuration > maxDuration){
                maxDurLetter = keysPressed.charAt(i);
                maxDuration = currentDuration;
            }
        }
        return maxDurLetter;
    }
}
