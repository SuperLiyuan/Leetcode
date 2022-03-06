package daily.ongoing.finished;

public class LastRemaining_390 {

    public static int run(int n){
        if(n==1) return 1;

        int[] arr = new int[n/2];
        for(int i=1;i<=n/2;i++){
            arr[i-1] = i*2;
        }

        while(arr.length >1){

            arr = delEveryOther(arr,-1);
            if(arr.length>1) {
                arr = delEveryOther(arr, 1);
            }

        }

        System.out.println(arr[0]);

        return arr[0];



    }

    private static int[] delEveryOther(int[] array, int order){
        int[] res =new int[array.length/2];
        //从右开始删，保留第0位
        if(order == -1){
            if(array.length%2==0) {
                for (int i = 0; i < array.length / 2; i++) {
                    res[i] = array[i * 2];
                }
                //不保留第0位
            }else{
                for (int i = 0; i < array.length / 2; i++) {
                    res[i] = array[i * 2+1];
                }
            }
        //从左开始删，删除第0位，保留第1位,删除第2位……
        }else{
            for(int i=0;i<array.length/2;i++){
                res[i] = array[i*2+1];
            }
        }

        return res;

    }

}
