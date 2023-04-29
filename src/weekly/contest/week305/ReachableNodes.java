package weekly.contest.week305;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReachableNodes {
    public int run(int n, int[][] edges, int[] restricted) {
        List<Integer>[] adj = new List[n];
        for(int i = 0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0;i<n-1;i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        for(int i = 0;i<restricted.length;i++){
            visited[restricted[i]] = true;
        }
        //节点0总是可访问的
        int cnt = 1;
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            Integer node = queue.pop();
            for(int next : adj[node]){
                if(!visited[next]){
                    queue.offer(next);
                    visited[node] = true;
                    cnt ++;
                }
                }
            }

        return cnt;

    }
}
