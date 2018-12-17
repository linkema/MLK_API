package Collections.FIFO_Queue;

import java.util.Iterator;

public class Steque<Item> implements Iterable<Item>{
    private Node top;//栈顶元素
    private int N;//栈中元素个数
    public void push(Item item) {
        Node oldtop=top;
        top=new Node();
        top.item=item;
        top.next=oldtop;
        N++;
    }
    public Item pop(){
        Item item=top.item;
        top=top.next;
        N--;
        return item;
    }
    public void enqueue(Item item){
        Node x = new Node();
        Node y=top;
        while(y.next!=null){
            y=y.next;
        }
        y.next=x;
        x.item=item;
    }

    @Override
    public Iterator iterator() {
        return new StequeIteraeor();
    }

    private class Node {
        Node next;
        Item item;
    }

    private class StequeIteraeor implements Iterator {
        private Node current=top;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Object next() {
            Item item=current.item;
            current=current.next;
            return item;
        }
    }
}
