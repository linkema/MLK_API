package union_find;

import java.util.Random;
import java.util.Scanner;

public class RandomGrid extends WeightedQuickUnionUF{
    public RandomGrid(){}
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
    public boolean connected(Connection c1,Connection c2,int N){

        return find(c1,N)==find(c2,N);
    }
    public int find(Connection c,int N) {
        //跟随链接找到根节点
        //增加一个循环来将从q到根节点的路径上的每个触点都连接到根节点，使之能产生一棵高度为4的树
        while((c.p*(N-1)+c.q)!=id[c.p][c.q]) break;
        return id[c.p][c.q];
    }
    public void union(Connection c1,Connection c2,int N){
        int i=find(c1,N );
        int j=find(c2,N);
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
        RandomGrid rg=new RandomGrid ( n );
        Random r=new Random (  );
        int p= r.nextInt (n);
        int q=r.nextInt (n);
        int i=r.nextInt (n);
        int j=r.nextInt (n);
        RandomGrid.Connection c1=rg.new Connection ( p,q );
        RandomGrid.Connection c2=rg. new Connection ( i,j );
        boolean flag;
        //while(rg.count!=1){
            flag=rg.connected ( c1,c2,n );
            if(!flag){
                rg.union ( c1,c2,n );
            }
        //}
        return rg.id;
    }
}
