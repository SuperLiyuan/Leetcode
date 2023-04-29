package weekly.contest.week299;

public class CountHousePlacements {

    public int countHousePlacements(int n) {

        // 所以说是个数学问题来的，草
        // 能想到的就是，i代表河一侧的数目，n-i代表另一侧的数目，因为不能相邻所以判断数目放不下就可以直接返回
        // 感觉似乎有更好的方法：概率论，但是我不会。。。我最多可以优化成n/2的时候返回，然后x2，代表两侧对换的情况
        int sum = 0;
        for(int i=0;i<n*2;i++){
            sum = sum + countNum(i, n*2) ;
            int toMod = (int) (Math.pow(10,9)+7);
            sum = sum % toMod;
        }
        return sum;
    }

    public int countNum(int i, int n){
        int j = n - i;
        int availableSpots = (int) Math.ceil(n /2.0) ;

        if(availableSpots < i || availableSpots < j){
            return 0;
        }
        // 从5里面选3个，也就是c53
        // 算法如下： C（下标n，上标m） =n*（n-1）*（n-2）*……*（n-m+1）/（1*2*3*……*m）
        int res1 = c(availableSpots, i);
        int res2 = c(availableSpots, j);
        return res1 + res2;
    }

    public int c(int n, int m){
        int stop = n-m+1;
        int up = 1;
        for(int i = n;i >= stop;i--){
            up = up * i;
        }
        int down = 1;
        for(int i =1;i<=m;i++){
            down = down * i;
        }
        return (up / down) % (int) (Math.pow(10,9)+7);
    }
}
