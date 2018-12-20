package Sort;

public class ShellSort {
    public static void sort(Comparable []arr){
        //选择排序的算法
        /**
            1.确定h能取的最大值 即序列3h+1    1,4,13，40，121，364,1093.。。。
            2.再根据插入排序将数组分为h有序
            3.循环h/3有序。。。
            4.直到1有序
         */
            //将arr[]按升序排列
        int N=arr.length;
        int h=1;
        while(h<N/3){
            h=3*h+1;//1.4.13.40.....
        }
        while(h>=1){
            //将数组变为h有序
            for (int i = 0; i <N ; i++) {
                //将a[i]插入到a[i-h]，a[i-2h],a[i-3h]...之中
                for (int j = i; j >=h&&less(arr[j],arr[j-h]) ; j--) {
                    exch(arr,j,j-h);
                }
                h=h/3;
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

