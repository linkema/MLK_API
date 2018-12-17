package Collections.FIFO_Queue;

import java.util.Iterator;

public class Dequeue<Item> implements Iterable {
    private Node left;//栈顶最左边
    private Node right;//最右边元素
    private int N;//栈面所有元素数量
    public Dequeue(){}
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void pushLeft(Item item){
        left=new Node();
        Node oldleft=left;
        left=new Node();
        left.item=item;
        left.next=oldleft;
        oldleft.last=left;
        left.last=right;
        N++;
    }
    public void pushright(Item item){
        while(left.next!=null){
            left=left.next;
        }
        Node oldright=left;
        right=new Node();
        right.next=oldright.next;
        oldright.next=right;
        right.last=oldright;
        right.item=item;
        right.next=left;
        N++;
    }
    public Item popLeft(){
        if(isEmpty ())
            throw new NullPointerException (  );
        Item item=left.next.item;
        left=left.next;
        N--;
        return item;
    }
    public Item popright(){
        Item item=right.item;
        right=right.last;
        N--;
        return item;
    }
    @Override
    public Iterator iterator() {
        return new DequeueIterator();
    }

    private class
    DequeueIterator implements Iterator {
        private Node current;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Object next() {
            Item item=current.item;;
            current=current.next;
            return item;
        }
    }

    private class Node {
        Node next;
        Node last;
        Item item;
    }
}
