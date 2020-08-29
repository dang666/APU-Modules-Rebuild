package MainClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import Presentation.*;


public class loginMe {
    private int result = 0;  
    public int getresult(){return result;}
    public void setresult(int a) { result = a;}
    public loginMe(String ID, String Passw, String fn)
    {try
    {
        File fp = new File(fn);
        Scanner sc = new Scanner(fp);
        while(sc.hasNextLine())
        {
            int i = 0;
            String Id = "";
            String passw = "";
            String Line = sc.nextLine();
            String LoginArr[] = Line.split(" ");
            for (String ss:LoginArr)
            {
                if (i==0){Id = ss;}
                if (i==1){passw = ss;}
                if (ID.equals(Id) && Passw.equals(passw))
                {
                    setresult(1);
                    JOptionPane.showMessageDialog(null,"Login successful",
                            "Welcome",JOptionPane.PLAIN_MESSAGE);                                      
                }
                i++;
            }    
        }
        if (result == 0)
        {
            JOptionPane.showMessageDialog(null,
          "Check your username or password","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    catch(IOException EX){}
    }
    
}
    
