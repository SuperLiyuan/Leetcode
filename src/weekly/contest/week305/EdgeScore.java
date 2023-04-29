package weekly.contest.week305;

public class EdgeScore {
    public int run(int[] edges) {

        //看起来很简单的样子诶
        int n = edges.length;
        int[] points = new int[n];
        for(int i = 0;i<n;i++){
            int node = edges[i];
            points[node] += i;
        }
        int maxNode = 0;
        for(int i = 0;i<n;i++){
            if(points[i]>points[maxNode]){
                maxNode = i;
            }
        }
        return maxNode;


    }
}
