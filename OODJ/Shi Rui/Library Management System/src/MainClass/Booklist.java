package MainClass;

import java.io.*;
import javax.swing.JOptionPane;


public class Booklist {
    
    private int BookID;
    private String BookName;
    private String Author;    
    private int Quantity;
    private String Location;
    
    //public Booklist(){}
    public Booklist(int a,String b,String c,int d,String e)
    {BookID=a;BookName=b;Author=c;Quantity=d;Location=e;}
    public String toBString()
    {
        return BookID+"-"+BookName+"-"+Author+"-"+Quantity+"-"+Location+"\r\n";
    }
    public void WritetoFile()
    {try
    {
        File fp = new File("BookList.txt");
        FileWriter fw = new FileWriter(fp,true);
        PrintWriter pw = new PrintWriter(fw);
        pw.write(this.toBString());
        pw.close();
        JOptionPane.showMessageDialog(null,"Add Book Successful ","Successful",JOptionPane.PLAIN_MESSAGE);
    }
    catch(IOException EX){}
    }
}
