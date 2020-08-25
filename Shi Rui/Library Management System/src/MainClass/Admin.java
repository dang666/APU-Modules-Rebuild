package MainClass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Admin {
    private String Uname;
    private String Passw;
    public Admin(){}
    public Admin(String a, String b){Uname=a;Passw=b;}
    public String toAString(){return Uname + " " +Passw+ "\r\n";}
    
    
}
