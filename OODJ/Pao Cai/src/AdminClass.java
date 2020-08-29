
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DragonKimchi
 */
public class AdminClass extends StudentClass {
    String reader;
    int error = 0; // 0 means no error
    
    String pv_id, pv_fn;
    public void PassVariable(String ID, String fullname)
    {
        pv_id = ID;
        pv_fn = fullname;
    }
    
    //View Admin
    public void View(JTable CourseTable, String a)
    {        
        DefaultTableModel table = (DefaultTableModel) CourseTable.getModel();
        try {
            FileReader fr = new FileReader(a);
            BufferedReader br = new BufferedReader(fr);
            table.setRowCount(0);
            while((reader = br.readLine()) != null){
                table.addRow(reader.split(":"));
            }
            br.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }
    
    
    
    //Add User
    public void addAdmin(String id, String fn, String un, String pw, String ct, String em, String dl, String location, String userType)
    {
        super.PassVariable(pv_id, pv_fn);
        super.AddUser(id, fn, un, pw, ct, em, dl, location, userType);
    }
    
    
}
