package MainClass;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;


public class SearchBook {
    public ArrayList<String> BookList = new ArrayList<>();
    public SearchBook(){}
    public SearchBook(String keyword,String fn)
    {try
    {
        String a=null;
        int Bid = 0;
        String Name ="";
        int Available =0;
        String Location ="";
        File fp = new File(fn);
        Scanner sc = new Scanner(fp);
        while(sc.hasNextLine())
        {
            int i =0;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
            String Line = sc.nextLine();
            String[] BookArr = Line.split("-");
            for (String ss:BookArr)
            {
                if (i==0){Bid = Integer.parseInt(ss);}
                if (i==1){Name = ss;}
                if (i==3){Available = Integer.parseInt(ss);}
                if (i==4){Location = ss;}
                i++;
            }
            if(Name.contains(keyword))
                {
                    a =Bid+"  "+Name+"  "+Available+"   "+Location+"\r\n";
                    BookList.add(a);
                }
        }
     }
     catch(IOException EX){}
    }
    
    public void DSearch(String keyword,String fn)
    {try
    {
        String a=null;
        int Bid = 0;
        String Name ="";
        String Author ="";       
        File fp = new File(fn);
        Scanner sc = new Scanner(fp);
        while(sc.hasNextLine())
        {
            int i =0;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
            String Line = sc.nextLine();
            String[] BookArr = Line.split("-");
            for (String ss:BookArr)
            {
                if (i==0){Bid = Integer.parseInt(ss);}
                if (i==1){Name = ss;}
                if (i==2){Author = ss;}
               
                i++;
            }
            if(Name.contains(keyword))
                {
                    a =Bid+"  "+Name+"  "+Author+"   "+"\r\n";
                    BookList.add(a);
                }
        }
     }
     catch(IOException EX){}
    }
}
