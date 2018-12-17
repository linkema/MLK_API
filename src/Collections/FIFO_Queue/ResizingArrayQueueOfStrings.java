package Collections.FIFO_Queue;

import java.util.Iterator;

public class ResizingArrayQueueOfStrings<Item> implements Iterable {
    private Item []a=(Item[])new Object[1];//队列中的元素
    private int N;//队列的长度
    public boolean isEmpty(){
        return N==0;
    }
    public boolean isFull(){
        return N==a.length;
    }
    public void enqueue(Item item){
        if(isFull ())
            resize(2*a.length);
        a[N]=item;
        N++;
    }
    public Item dequeue(){
        if(isEmpty ())
            System.out.println ( "队列为空" );
        Item temp=a[0];
        for (int i = 0; i < N -1; i++) {
            a[i]=a[i+1];
        }
        if(N>0&&N==a.length/4)
            resize ( a.length/2 );
        N--;
        return temp;
    }
    public int size(){
        return N;
    }
    private void resize(int i) {
        Item []temp=(Item[]) new Object[i];
        for (int j = 0; j <N; j++) {
            temp[j]=a[j];
        }
        a=temp;
    }
    public Item IndexOfQueue(int k){
        return a[N-k];
    }

    @Override
    public Iterator iterator() {

        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator {
        private int current=N;
        @Override
        public boolean hasNext() {

            return current>0;
        }

        @Override
        public Object next() {
            //实现队列形式的遍历
            Item item= a[N-current];
            current--;
            return item;
        }
    }
}
