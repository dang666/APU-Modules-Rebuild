package MainClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Librarian {
    
    private int UID;
    private String Passw;    
    public Librarian(){}
    public Librarian(int a, String b){UID=a;Passw=b;}
    public String toLString(){return UID + " " +Passw+ "\r\n";}
    
    
    public void WritetoFile()
    {try
    {
        File fp = new File("Librarian.txt");
        FileWriter fw = new FileWriter(fp,true);
        PrintWriter pw = new PrintWriter(fw);
        pw.write(this.toLString());
        pw.close();
        JOptionPane.showMessageDialog(null,"Add Librarian Account Successful."," Successful",JOptionPane.PLAIN_MESSAGE);
    }
    catch(IOException EX){}
    }
    
               
    
}