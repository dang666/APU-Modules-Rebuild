package MainClass;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class BookRecord {
    private int BID;
    private String BookTitle;
    private String Author;
  
    private int Quantity;
    private String Location;
    private String GuestID;
    public int reduce(int a){return a-1;}
    public int add(int a) {return a+1;}
    public BookRecord (){}
    public BookRecord (int a,String b){ BID=a;GuestID=b;}
    Date now = new Date(); 
    SimpleDateFormat d = new SimpleDateFormat("(dd/MM/yyyy HH:mm)");       
    String date = d.format( now );
    String toBBString(){return BID+"-"+BookTitle+"-"+Author+"-"+Quantity+"-"+Location+"\r\n";}
    public String toBRString()
     {
         return BID+"-"+GuestID+"-Borrow-"+date+"\r\n";
     }
    public void Borrow()
    {try
    {
        int Bid = 0;
        String Name ="";
        String Author ="";       
        int Available =0;
        String Location ="";
        int result = 0;
        File fp = new File("BookList.txt");
        Scanner sc = new Scanner(fp);
        while(sc.hasNextLine())
        {
            int i = 0;
            String Line = sc.nextLine();
            String BookListArr[] = Line.split("-");
            for (String ss:BookListArr)
            {
                if (i==0){Bid = Integer.parseInt(ss);}
                if (i==1){Name = ss;}
                if (i==2){Author = ss;}             
                if (i==3){Available = Integer.parseInt(ss);}
                if (i==4){Location = ss;}
                if (BID == Bid)
                {
                    result = 1;
                    BID=Bid;BookTitle=Name;this.Author=Author;Quantity=Available;this.Location=Location;
                }
                i++;
            }
        }
        if(result==1)
        {
            File file = new File("BookRecord.txt");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.toBRString());
            bw.close();
            JOptionPane.showMessageDialog(null,"Book check out.","Successful",JOptionPane.PLAIN_MESSAGE);
            List<String> lines = new ArrayList<String>();
            String line = null;
            File f1 = new File("BookList.txt");
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (line.contains(BID+"-"+BookTitle+"-"+this.Author+"-"+Quantity+"-"+this.Location))
                {line = line.replace(BID+"-"+BookTitle+"-"+this.Author+"-"+Quantity+"-"+this.Location,
                 BID+"-"+BookTitle+"-"+this.Author+"-"+reduce(Quantity)+"-"+this.Location);}
                lines.add(line+"\r\n");
            }
            fr.close();
            br.close();

            FileWriter fd = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fd);
            for(String s : lines)
            {out.write(s);}
            out.flush();
            out.close();
        }
        else if(result==0)
        {
            JOptionPane.showMessageDialog(null,"Book ID not found","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    catch(IOException EX){}
    }
    public void Return()
    {try
    {
        int Bid = 0;
        String Name ="";
        String Author ="";  
        int Available =0;
        String Location ="";
        File fc = new File("BookList.txt");
        Scanner sd = new Scanner(fc);
        while(sd.hasNextLine())
        {
            int i = 0;
            String Line = sd.nextLine();
            String BookListArr[] = Line.split("-");
            for (String ss:BookListArr)
            {
                if (i==0){Bid = Integer.parseInt(ss);}
                if (i==1){Name = ss;}
                if (i==2){Author = ss;}                
                if (i==3){Available = Integer.parseInt(ss);}
                if (i==4){Location = ss;}
                if (BID == Bid)
                {
                    BID=Bid;BookTitle=Name;this.Author=Author;Quantity=Available;this.Location=Location;
                }
                i++;
            }
        }
        Date now = new Date(); 
        SimpleDateFormat d = new SimpleDateFormat("(dd/MM/yyyy HH:mm)");       
        String T = d.format( now );
        int a = 0;
        File fp = new File("BookRecord.txt");
        Scanner sc = new Scanner(fp);
        while(sc.hasNextLine())
        {
            int i = 0;
            String BookID = "";
            String GID = "";
            String status = "";
            String Line = sc.nextLine();
            String BRArr[] = Line.split("-");
            for (String ss:BRArr)
            {
                if (i==0){BookID = ss;}
                if (i==1){GID = ss;}
                if (i==2){status = ss;}
                if (this.BID == Integer.parseInt(BookID) && GuestID.equals(GID) && status.equals("Borrow"))
                {
                    a=1;
                    System.out.println(a);
                }
                i++;
            }    
        }
        if(a==1)
        {try{
            List<String> lines = new ArrayList<String>();
            String line = null;
            File f1 = new File("BookRecord.txt");
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (line.contains(BID+"-"+GuestID+"-Borrow-")){
                    line = line.replace(BID+"-"+GuestID+"-Borrow-",BID+"-"+GuestID+"-Return-"+T);}
                lines.add(line+"\r\n");
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : lines)
                 out.write(s);
            out.flush();
            out.close();
            
            JOptionPane.showMessageDialog(null,"Book check in Successful.","Successful",JOptionPane.PLAIN_MESSAGE);
            
            List<String> lined = new ArrayList<String>();
            String linea = null;
            File f2 = new File("BookList.txt");
            FileReader fa = new FileReader(f2);
            BufferedReader ba = new BufferedReader(fa);
            while ((linea = ba.readLine()) != null) {
                if (linea.contains(BID+"-"+BookTitle+"-"+this.Author+"-"+Quantity+"-"+this.Location))
                {linea = linea.replace(BID+"-"+BookTitle+"-"+this.Author+"-"+Quantity+"-"+this.Location,
                 BID+"-"+BookTitle+"-"+this.Author+"-"+add(Quantity)+"-"+this.Location);}
                lined.add(linea+"\r\n");
            }
            fa.close();
            ba.close();

            FileWriter fs = new FileWriter(f2);
            BufferedWriter outed = new BufferedWriter(fs);
            for(String s : lined)
            {outed.write(s);}
            outed.flush();
            outed.close();
        }
        catch(IOException EX){}
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Record not found.","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    catch(IOException EX){}
    }
                  
}
        