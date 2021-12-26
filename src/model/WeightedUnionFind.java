package model;

public class WeightedUnionFind {

    int[] parents;

    public WeightedUnionFind(int n){
        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i;
        }
    }

//    public union(int a,int b,double[] weights,double val){
//        //a/b=val
//        //a/pa=w[a]
//        //b/pb=w[b]
//        //a/b=w[a]*pa/(w[b]*pb)=val
//
//        int bParent = find(b);
//        int aParent = find(a);
//        parents[aParent] = bParent;
//        weights[aParent]=
//    }

}
