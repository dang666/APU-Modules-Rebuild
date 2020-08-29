package MainClass;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ModifyBook {
    private int BI;
    private String BN;
    private String BA;
    private int BQ;
    private String BL;
    int result;
    public int getID(){return BI;}
    public String getBTitle(){return BN;}
    public String getBAuthor(){return BA;}
    public int getBQuantity(){return BQ;}
    public String getBLocation(){return BL;}
    
    public int getResult(){return result;}
    public void setresult(int a){result = a;}
    public ModifyBook(){}
    public ModifyBook(int a, String b,String c, int d, String e)
    {
        BI=a;BN=b; BA=c; BQ=d; BL=e;
    }
    
    public void Search (int k,String f)
    {try
    {
        String a =null;
        int Bid = 0;
        String Name ="";
        String Author ="";        
        int Available =0;
        String Location ="";    
        File fp = new File(f);
        Scanner sc = new Scanner(fp);
        while(sc.hasNextLine())
        {
            int i =0;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
            String Line = sc.nextLine();
            String[] BookArray = Line.split("-");
            for (String ss:BookArray)
            {
                if (i==0){Bid = Integer.parseInt(ss);}
                if (i==1){Name = ss;}
                if (i==2){Author = ss;}                
                if (i==3){Available = Integer.parseInt(ss);}
                if (i==4){Location = ss;}
                i++;
            }
            if (Bid==k)
            {
                {setresult(1);
                 BI=Bid;BN=Name;BA=Author;BQ=Available;BL=Location;
                }
            }
        if(result==0)
        {
            
        }
            
        }
    }    
    catch(IOException EX){}
    }
   public void Update(int a, String b,String c, int d, String e)
    {try
    {
        List<String> lines = new ArrayList<String>();
        String line =null;
        File ff = new File("BookList.txt");
        FileReader fr = new FileReader(ff);
        BufferedReader brr = new BufferedReader(fr);
            while ((line = brr.readLine()) != null) 
            {
                if (line.contains(BI+"-"+BN+"-"+BA+"-"+BQ+"-"+BL))
                {
                    line=line.replace(BI+"-"+BN+"-"+BA+"-"+BQ+"-"+BL,a+"-"+b+"-"+c+"-"+d+"-"+e);
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
