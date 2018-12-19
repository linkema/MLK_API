package Sort;

public class SelectSort {
    public static void sort(Comparable []arr){
        //选择排序的算法
        /**
             1.找到最小的元素
         2.放在第一个位置
         3找到第二小的元素
         4.。。。。
         最后退出
         */
        int N=arr.length;//需要排序元素长度
        for (int i = 0; i < N; i++) {
            //置换最小值到arr[i]的位置
            int min=i;//找到的元素索引值
            for (int j = i+1; j <N ; j++) {
                if(less(arr[j],arr[min])) min=j;
                exch(arr,i,min);
            }
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
    private void show(Comparable []arr){
        //打印出排序的对象
        for(Object i:arr){
            System.out.println(i+" ");
        }
    }
    public static boolean isSorted(Comparable []arr){
        //判断是否已经排序
        boolean flag=false;
        for (int i = 0; i < arr.length; i++)
            if(less(arr[i],arr[i-1])) return flag;
            flag=true;
            return flag;
    }
}

