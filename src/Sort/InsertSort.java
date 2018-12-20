package Sort;

public class InsertSort {
    public static void sort(Comparable[] arr){
        //插入排序的算法
        /**
            1.从第一个元素开始排序，将这个元素跟前一个元素进行比较
            2.再从已经排序好的元素中逐个比较找到正好比他小的位置（都是升序排序）
            3.把后面的元素全往后移一个位置
            4.等到循环走到这个数组元素的最后一个元素结束
         */
        int N=arr.length;//需要排序的数组的大小
        for (int i = 1; i < N; i++) {
            //比较前一个元素
                //找到元素插入到合适的位置的索引
                for (int j = i; j >0&&less ( arr[j],arr[j-1] ); j--)
                    exch(arr,j,j-1);
               //将数组中较大元素向右移动
            /*for (int j = i; j > 0&&less ( arr[i],arr[i-1] ); j--) {
                Comparable temp = arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
            }*/
        }
    }
    private static boolean less(Comparable a,Comparable b){
        //返回一个元素比较的boolean
        return a.compareTo(b)<0;
    }
    private static void exch(Comparable []arr,int i,int j){
        //交换对象元素
        Comparable temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static void show(Comparable[] arr){
        //打印出排序的对象
        for(Object i:arr){
            System.out.println(i+" ");
        }
    }
    public static boolean isSorted(Comparable []arr){
        //判断是否已经排序
        boolean flag=false;
        for (int i = 1; i < arr.length; i++)
            if(less(arr[i],arr[i-1])) return flag;
            flag=true;
            return flag;
    }
    public static void main(String [] args){
        Comparable[]a={34,45,12,45,85,69};
        InsertSort.sort ( a );
        System.out.println ( InsertSort.isSorted ( a ) );
        InsertSort.show(a);
    }
}

