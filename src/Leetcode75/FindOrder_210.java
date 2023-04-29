package Leetcode75;

import java.util.*;

public class FindOrder_210  {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] adj = new HashSet[numCourses];
        //记录入度
        int[] inDegree = new int[numCourses];
        //构建邻接表
        //要学习pair0， 必须先学习pair1，即pair1-> pair0
        for(int[] pair: prerequisites){
            adj[pair[0]].add(pair[1]);
            inDegree[pair[0]]++;
        }

        Queue<Integer> q = new LinkedList();
        for(int i = 0;i<numCourses;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int cnt = 0;
        while(!q.isEmpty()){
            int i = q.poll();
            res[cnt++] = i;
            for(int node: adj[i]){
                inDegree[node] --;
                if(inDegree[node] == 0){
                    q.offer(node);
                }
            }

        }

        if(cnt == numCourses){
            return res;
        }
        return null;






    }
}
