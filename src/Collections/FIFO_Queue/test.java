package Collections.FIFO_Queue;

import java.util.Iterator;

public class test {
    public static void main(String [] args) throws Exception{
        Dequeue s=new Dequeue ();
        s.pushLeft ( 1 );
        s.pushLeft ( 12 );
        s.pushright ( 65 );
        System.out.println ( s.popLeft () );
        System.out.println ( s.popLeft () );
        System.out.println ( s.popLeft () );
    }
}

