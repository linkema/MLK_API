package union_find;

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
    public  int count(){
        //返回连通分量数
        return count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public int find(int q) {
        //跟随链接找到根节点
        while(q!=id[q]) q=id[q];
        return q;
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
}
