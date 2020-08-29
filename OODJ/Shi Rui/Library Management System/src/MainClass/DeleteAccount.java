package MainClass;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class DeleteAccount {  
    public void Delete(String a,String b)
    {try
    {
        File fp = new File("Librarian.txt");
        Scanner sc = new Scanner(fp);
        while(sc.hasNextLine())
        {
            int i = 0;
            String Id = "";
            String passw = "";
            String Line = sc.nextLine();
            String AccArr[] = Line.split(" ");
            for (String ss:AccArr)
            {
                if (i==0){Id = ss;}
                if (i==1){passw = ss;}
                if (a.equals(Id) && b.equals(passw))
                {
                    JOptionPane.showMessageDialog(null,"Account Deleted.","Congratulation",JOptionPane.PLAIN_MESSAGE);
                    
                    List<String> lines = new ArrayList<String>();
                    String line = null;
                    File f1 = new File("Librarian.txt");
                    FileReader fr = new FileReader(f1);
                    BufferedReader br = new BufferedReader(fr);
                    while ((line = br.readLine()) != null) {
                        if (!line.contains(a+" "+b)){
                            lines.add(line+"\r\n");}
                            }
                    fr.close();
                    br.close();

                    FileWriter fw = new FileWriter(f1);
                    BufferedWriter out = new BufferedWriter(fw);
                    for(String s : lines)
                    {out.write(s);}
                    out.flush();
                    out.close();
                    
                }
                i++;
            }    
        }
    }
    catch(IOException EX){}
    }
}

