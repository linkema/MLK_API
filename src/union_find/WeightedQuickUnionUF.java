package union_find;

/**
 * @version 最终版压缩路径的加权UF算法
 * @author 马苓珂
 */
public class WeightedQuickUnionUF {
    private int [] id;//父链接数组（由触点索引）
    private int [] sz;//(由触点索引)的各个根节点所对应的分量大小
    private int count;//所有分量数
    public WeightedQuickUnionUF(int N){
        //初始化各个结点
        count=N;
        id=new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
        sz=new int[N];
        for (int i = 0; i < N; i++) {
            sz[i]=1;
        }
    }
    public WeightedQuickUnionUF() {
    }

    public  int count(){
        //返回连通分量数
        return count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public int find(int q) {
        //跟随链接找到根节点
        //增加一个循环来将从q到根节点的路径上的每个触点都连接到根节点，使之能产生一棵高度为4的树
        while(q!=id[q]) q=id[q];
        return id[q];
    }
    public void union(int p,int q){
        int i=find(p);
        int j=find(q);
        if(i==j) return;
        //将小树的根节点连接到大树的根节点
        if(sz[i]<sz[j]){
            id[i]=j;
            sz[j]+=sz[i];
        }else{
            id[j]=i;
            sz[i]+=sz[j];
        }
        count--;
    }
    private int newSite(){
        int size=0;
        return size;
    }
}
