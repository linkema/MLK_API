package Collections.LIFO_Stack;

import java.util.Iterator;

public class test {
    public static void main(String [] args){
        ResizingArrayStack <Integer>ras=new ResizingArrayStack <>();
        LinkedStack ls=new LinkedStack ();
        ls.push ( "sdadsa" );
        System.out.println ( ls.pop () );
        ras.push ( 3 );
        Iterator it=ras.iterator ();
        while(it.hasNext ()){
            System.out.println ( it.next () );
        }
        System.out.println ( ras.size () );
    }
}
