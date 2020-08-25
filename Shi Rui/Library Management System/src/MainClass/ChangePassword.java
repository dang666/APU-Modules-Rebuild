package MainClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class ChangePassword {
    private int UID;
    private String UP;
    
    int result;
    public int getID(){return UID;}
    public String getUpassword(){return UP;}   
    
    public int getResult(){return result;}
    public void setresult(int a){result = a;}
    public ChangePassword(){}
    public ChangePassword(int a, String b)
    {
        UID=a;UP=b;
    }
    
    public void Search (int k,String f)
    {try
    {
        String a =null;
        int id = 0;
        String pass ="";        
        File fp = new File(f);
        Scanner sc = new Scanner(fp);
        while(sc.hasNextLine())
        {
            int i =0;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
            String Line = sc.nextLine();
            String[] BookArray = Line.split(" ");
            for (String ss:BookArray)
            {
                if (i==0){id = Integer.parseInt(ss);}
                if (i==1){pass = ss;}                
                i++;
            }
            if (id==k)
            {
                {setresult(1);
                 UID=id;UP=pass;
                }
            }
        if(result==0)
        {
            
        }
            
        }
    }    
    catch(IOException EX){}
    }
   public void Update(int a, String b)
    {try
    {
        List<String> lines = new ArrayList<String>();
        String line =null;
        File ff = new File("Librarian.txt");
        FileReader fr = new FileReader(ff);
        BufferedReader brr = new BufferedReader(fr);
            while ((line = brr.readLine()) != null) 
            {
                if (line.contains(UID+" "+UP))
                {
                    line=line.replace(UID+" "+UP,a+" "+b);
                }
                lines.add(line+"\r\n");
            }
            fr.close();
            brr.close();
            
            FileWriter fw = new FileWriter(ff);
            BufferedWriter bb = new BufferedWriter(fw);
            for(String sss : lines)
            {
                bb.write(sss);
            }
            bb.flush();
            bb.close();
            
            
        
    }
    
     catch(IOException EX){}   
    }
}
