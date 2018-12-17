package union_find;

public class UF {
    private int []id;
    private int count;
    public UF(int N) {
        count =N;
        id=new int [N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
    }
    public int count(){
        return count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

  /*  private int find(int q) {
        return id[q];
    }*/
  //将各个分量中的元素全部增加到根节点上
    public int find(int q){
        while(q!=id[q]){
            q=id[q];
        }
        return id[q];
    }
    public void union(int p,int q){
        //将p和q合并到相同的分量当中
        int IDp=id[p];
        int IDq=id[q];
        //如果p和q已经在同一个分量当中
        if(IDp==IDq) return;
        //否则将p的分量重命名到q的名称
        else{
            for (int i = 0; i < id.length; i++) {
                if(id[i]==IDp){
                    id[i]=IDq;
                }
            }
            count--;
        }
    }
}
