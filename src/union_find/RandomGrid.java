package union_find;

import java.util.Random;
import java.util.Scanner;

public class RandomGrid extends WeightedQuickUnionUF{
    private int count;
    private int [][]id;
    private int [][]sz;
    public RandomGrid(int N) {
        //初始化各个结点
        count=N;
        id=new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
              id[i][j]=i*N+j;
            }
        }
        sz=new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sz[i][i]=1;
            }
        }
    }
    public int count(){
        return count;
    }
    public boolean connected(int p,int q,int i,int j,int N){
        return find(p,q,N)==find(i,j,N);
    }
    public int find(int p,int q,int N) {
        //跟随链接找到根节点
        //增加一个循环来将从q到根节点的路径上的每个触点都连接到根节点，使之能产生一棵高度为4的树
        while((p*(N-1)+q)!=id[p][q]) break;
        return id[p][q];
    }
    public void union(int p,int q,int m,int n,int N){
        int i=find(p,q,N );
        int j=find(m,n,N);
        if(i==j) return;
        //将小树的根节点连接到大树的根节点
        if(sz[i/N][i%N-1]<sz[j/N][j%N-1]){
            id[i/N][i%N-1]=j;
            sz[j/N][j%N-1]+=sz[i/N][i%N-1];
        }else{
            id[j/N][i%N-1]=i;
            sz[i/N][i%N-1]+=sz[j/N][j%N-1];
        }
        count--;
    }

    private class Connection{
        int p;
        int q;
        public Connection(int p,int q){
            this.p=p;
            this.q=q;
        }
    }
    public static void main(String [] args){
        Scanner input=new Scanner(System.in);
        int N=input.nextInt ();
        int [][]arr=generate ( N );
        for(int i[]:arr){
            for(int j:i){
                System.out.print ( j+++" " );
            }
        }
    }
    private static int[][] generate(int n) {
        Random r=new Random (  );
        int p= r.nextInt (n );
        int q=r.nextInt (n);
        int i=r.nextInt (n);
        int j=r.nextInt (n);
        boolean flag;
        RandomGrid rg=new RandomGrid ( n );
        //while(rg.count!=1){
            flag=rg.connected ( p,q,i,j,n );
            if(!flag){
                rg.union ( p,q,i,j,n );
            }
        //}
        return rg.id;
    }
}
