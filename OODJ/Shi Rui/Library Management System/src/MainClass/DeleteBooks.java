package MainClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class DeleteBooks {
    public void Delete(String a,String file)
    {try
    {
        File fp = new File(file);
        Scanner sc = new Scanner(fp);
        while(sc.hasNextLine())
        {
            int i = 0;
            String Id = "";
            String Line = sc.nextLine();
            String LoginArr[] = Line.split("-");
            for (String ss:LoginArr)
            {
                if (i==0){Id = ss;}
                if (a.equals(Id))
                {
                    File inFile = new File(file);
                    File tempFile = new File("temp_"+file);
                    BufferedReader br = new BufferedReader(new FileReader(inFile));
                    PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        if (line.contains(a)){
                            pw.println(line);
                            pw.flush();
                            }}
                    br.close();
                    pw.close();
                    
                }
                i++;
            }    
        }
        
                    JOptionPane.showMessageDialog(null,"Book Deleted Successful", "Successful",JOptionPane.PLAIN_MESSAGE);
                    
                    List<String> lines = new ArrayList<String>();
                    String line = null;
                    String line1 = null;
                    File f1 = new File(file);
                    File f2 = new File("temp_"+file);
                    FileReader fr = new FileReader(f1);
                    FileReader ft = new FileReader(f2);
                    BufferedReader br = new BufferedReader(fr);
                    BufferedReader bt = new BufferedReader(ft);
                    line1 = bt.readLine();
                    while ((line = br.readLine()) != null) {
                        if (!line.contains(line1)){
                            lines.add(line+"\r\n");}
                            }
                    fr.close();
                    br.close();
                    bt.close();

                    FileWriter fw = new FileWriter(f1);
                    BufferedWriter out = new BufferedWriter(fw);
                    for(String s : lines)
                    {out.write(s);}
                    out.flush();
                    out.close();
                    File fg = new File("temp_"+file);
                    fg.delete();
                  
    }
    catch(IOException EX){}
    }
}
