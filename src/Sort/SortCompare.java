package Sort;


import Stopwatch.Stopwatch;

import java.util.Random;

public class SortCompare {
    public static double time(String alg,Comparable[]arr){
        Stopwatch s=new Stopwatch ();
        if(alg.equals ( "InsertSort" )) InsertSort.sort ( arr );
        if(alg.equals ( "SelectSort" )) SelectSort.sort ( arr );
        return s.elapsedTime ();
    }
    public static double timeRandomInput(String alg,int N,int T){
        //使用算法“alg”将T个长度为N的数组排列
        double total=0.0;
        Double []arr=new Double[N];
        Random r=new Random (  );
        for (int i = 0; i < T; i++) {
            //生成一个随机数组并进行排序
            for (int j = 0; j < N; j++) {
                arr[j]=r.nextDouble ();
            }
            total+=time (alg,arr);
        }
        return total;
    }
}
