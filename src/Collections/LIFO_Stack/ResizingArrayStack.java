package Collections.LIFO_Stack;

import java.util.Iterator;

public class ResizingArrayStack <Item> implements Stack{
    private Item[]a=(Item[])new Object[1];//栈元素
    private int N=0;//元素数量
    public boolean isEmpty(){
        return N==0;
    }
    public boolean isFull(){
       return N==a.length;
    }
    public int size(){
        return N;
    }



    private void resize(int max){
        //将栈移动到一个大小为max的数组
        Item[] temp=(Item[])new Object[max];
        for (int i = 0; i < N; i++)
            temp[i]=a[i];
        a=temp;
    }
    public void push(Item item){
        //将元素添加到栈顶
        if(isFull ())
            resize(2*a.length);
        a[N++]=item;
    }
    public Item pop(){
        //从栈顶删除元素
        Item item=a[--N];
        a[N]=null;//避免对象游离无法被垃圾回收
        if(N>0&&N==a.length/4)
            resize(a.length/2);
        return item;
    }
    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    @Override
    public Object seek() {
        //读取栈顶元素
        return a[N];
    }

    private class ReverseArrayIterator implements Iterator {
        private int i=N;
//支持后进先出的迭代
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Object next() {
            return a[--i];
        }
    }
    public static ResizingArrayStack copy(ResizingArrayStack<String> ras){
        //接受一个字符串对象并返回副本栈
        ResizingArrayStack rask=new ResizingArrayStack ();
        while(ras.iterator ().hasNext ()){
            rask.push (ras.iterator ().next ());
        }
        return rask;
    }
}
