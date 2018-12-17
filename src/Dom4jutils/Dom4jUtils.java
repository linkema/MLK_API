package Dom4jutils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Dom4jUtils {
    public static final String PATH="";
    //返回document
    public static Document getDocument(String path){
        Document d=null;
        try {
             d= new SAXReader (  ).read ( path );
        } catch (DocumentException e) {
            e.printStackTrace ();
        }finally {
            return d;
        }
    }
    //回写xml
    public static void xmlWrites(String path,Document d){
        try {
            XMLWriter xmlw=new XMLWriter ( new FileOutputStream ( path ) ,OutputFormat.createPrettyPrint () );
            try {
                xmlw.write ( d );
            } catch (IOException e) {
                e.printStackTrace ();
            }finally {
                try {
                    xmlw.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace ();
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
    }
}
