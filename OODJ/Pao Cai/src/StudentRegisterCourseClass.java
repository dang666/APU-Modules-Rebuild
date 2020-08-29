
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
public class StudentRegisterCourseClass {
    String reader;
    int error = 0; // 0 means no error
    
    String pv_id, pv_fn, pv_dl;
    public void PassVariable(String ID, String fullname, String degreelevel)
    {
        pv_id = ID;
        pv_fn = fullname;
        pv_dl = degreelevel;
    }
    
    //View All From Text file
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
    
    //View only match with student degree level
    public void ViewAccordingLevel(JTable CourseTable, String a, String dl)
    {        
        DefaultTableModel table = (DefaultTableModel) CourseTable.getModel();
        try {
            FileReader fr = new FileReader(a);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> StudentRegisterData = new ArrayList<String>();
            String[] array = null;
            table.setRowCount(0);
            while((reader = br.readLine()) != null){
                StudentRegisterData.add(reader);
            }
            //get only degree lv which is array 2 match with dl
            for (int i = 0; i < StudentRegisterData.size(); i++)
            {
                array = StudentRegisterData.get(i).split(":");
                if (array[2].equals(dl))
                {
                    table.addRow(array);
                }
            }
            br.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "ViewAccordingLevel Error!");
        }
    }
    
    //View Pending Status Only
    public void ViewPending(JTable CourseTable, String a)
    {        
        DefaultTableModel table = (DefaultTableModel) CourseTable.getModel();
        try {
            FileReader fr = new FileReader(a);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> StudentRegisterData = new ArrayList<String>();
            String[] array = null;
            table.setRowCount(0);
            while((reader = br.readLine()) != null){
                StudentRegisterData.add(reader);
            }
            //get only Payment Status = Pending
            for (int i = 0; i < StudentRegisterData.size(); i++)
            {
                array = StudentRegisterData.get(i).split(":");
                if (array[5].equals("Pending"))
                {
                    table.addRow(array);
                }
            }
            br.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }
    
    //View Completed Status Only
    public void ViewCompleted(JTable CourseTable, String a)
    {        
        DefaultTableModel table = (DefaultTableModel) CourseTable.getModel();
        try {
            FileReader fr = new FileReader(a);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> StudentRegisterData = new ArrayList<String>();
            String[] array = null;
            table.setRowCount(0);
            while((reader = br.readLine()) != null){
                StudentRegisterData.add(reader);
            }
            //get only Payment Status = Pending
            for (int i = 0; i < StudentRegisterData.size(); i++)
            {
                array = StudentRegisterData.get(i).split(":");
                if (array[5].equals("Completed"))
                {
                    table.addRow(array);
                }
            }
            br.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }
    
    //View that match the studentID
    public void ViewStudentID(JTable CourseTable, String a, String id)
    {
        DefaultTableModel table = (DefaultTableModel) CourseTable.getModel();
        try {
            FileReader fr = new FileReader(a);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> StudentRegisterData = new ArrayList<String>();
            String[] array = null;
            table.setRowCount(0);
            while((reader = br.readLine()) != null){
                StudentRegisterData.add(reader);
            }
            //get only student id which is array 0 match with id
            for (int i = 0; i < StudentRegisterData.size(); i++)
            {
                array = StudentRegisterData.get(i).split(":");
                if (array[0].equals(id))
                {
                    table.addRow(array);
                }
            }
            br.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "ViewStudentID Error!");
        }
    }
    
    //ViewBillMenu
    //View All but same Student
    public void ViewAllSameStudent(JTable CourseTable, String a)
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
    
    //Confirm Payment
    public void ConfirmPayment(String studID, String studName, String courseID, String courseName, String Fees, String PaymentStatus)
    {
        //ask confirm payment
        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to confirm the payment", "Payment Status Changes", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION)
        {
            try{
                FileReader fr = new FileReader("SaveFile/StudentCourseRegisted.txt");
                BufferedReader br = new BufferedReader(fr);            
                ArrayList<String> userData = new ArrayList<String>();
                String[] array;
                
                while ((reader = br.readLine()) != null)
                {
                    userData.add(reader);
                }
                
                //check the student ID and Course ID, both match the data, then can make changes in StudentCourseRegisted.txt
                for (int i = 0; i < userData.size(); i++)
                {
                    array = userData.get(i).split(":");

                    //write into student.txt
                    if (studID.equals(array[0]) && courseID.equals(array[2]))
                    {
                        //change the array[5] which is PaymentStatus to Completed
                        array[5] = "Completed";
                        
                        userData.set(i, array[0] + ":" + array[1] + ":" + array[2] + ":" + array[3] + ":" + array[4] + ":" + array[5]);
                        FileWriter fw = new FileWriter("SaveFile/StudentCourseRegisted.txt");
                        for (int x = 0; x < userData.size(); x++)
                        {
                            fw.write(userData.get(x));
                            fw.write("\r\n");
                        }
                        fw.close();
                    }              
                }
                br.close();
                fr.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Make Payment - Confirm Payment Error", "Error!!!", JOptionPane.ERROR_MESSAGE);
            } 
        }
        MakePaymentListMenu mplm = new MakePaymentListMenu();
        mplm.PassVariable(pv_id, pv_fn);
        mplm.setVisible(true);
    }
    
    //RegisterCourse
    public void RegisterCourse(String studID, String studName, String courseID, String courseName, String Fees, String PaymentStatus, String pv_dl)
    {
        //ask confirm payment
        int confirm = JOptionPane.showConfirmDialog(null, "Do you sure you want to register this course", "Register Course", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION)
        {
            try{
                FileReader fr = new FileReader("SaveFile/StudentCourseRegisted.txt");
                BufferedReader br = new BufferedReader(fr);            
                ArrayList<String> userData = new ArrayList<String>();
                String[] array;
                while ((reader = br.readLine()) != null)
                {
                    userData.add(reader);
                }
                
                //check student ID and Course ID , same student cannot register on the same course
                for (int i = 0; i < userData.size(); i++)
                {
                    //line = br.readLine();
                    array = userData.get(i).split(":");
                    if (studID.equals(array[0]) && courseID.equals(array[2]))
                    {
                        error = 1; // which means it is repeated
                        break;
                    }
                }
                
                if (error == 1) 
                {
                    JOptionPane.showMessageDialog(null,"Register Repeated\nThis Course had Register Before", "Register Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (error == 0)
                {
                    //no error
                    //append into file
                    FileWriter fw = new FileWriter("SaveFile/StudentCourseRegisted.txt", true);
                    fw.append(studID + ":" + studName + ":" + courseID + ":" + courseName + ":" + Fees + ":" + PaymentStatus);
                    fw.write("\r\n");
                    fw.close();
                    JOptionPane.showMessageDialog(null,"The Course has successfully register", "Register Success", JOptionPane.INFORMATION_MESSAGE);
                }
                br.close();
                fr.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Register Course - Register Error", "Error!!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        RegisterCourseMenu rcm = new RegisterCourseMenu(pv_dl);
        rcm.PassVariable(pv_id, pv_fn, pv_dl);
        rcm.setVisible(true);
    }
    
    public void DropCourse(String studID, String studName, String courseID, String courseName, String Fees, String PaymentStatus, String pv_dl)
    {
        //ask confirm payment
        int confirm = JOptionPane.showConfirmDialog(null, "Do you sure you want to drop this course", "Drop Course", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION)
        {
            try{
                FileReader fr = new FileReader("SaveFile/StudentCourseRegisted.txt");
                BufferedReader br = new BufferedReader(fr);            
                ArrayList<String> userData = new ArrayList<String>();
                String[] array;
                while ((reader = br.readLine()) != null)
                {
                    userData.add(reader);
                }
                
                //Delete record in StudentCourseRegisted.txt
                for (int i = 0; i < userData.size(); i++)
                {
                    array = userData.get(i).split(":");
                    // match studID and Course ID
                    if (studID.equals(array[0]) && courseID.equals(array[2]))
                    {
                        FileWriter fw = new FileWriter("SaveFile/StudentCourseRegisted.txt");
                        for (int x = 0; x < userData.size(); x++)
                        {
                            if (x != i)
                            {
                                fw.write(userData.get(x));
                                fw.write("\r\n");
                            }
                        }
                        fw.close();
                    } 
                }
                
                br.close();
                fr.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Drop Course - Drop Error", "Error!!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        DropCourseMenu dcm = new DropCourseMenu(pv_id);
        dcm.PassVariable(pv_id, pv_fn, pv_dl);
        dcm.setVisible(true);
    }
}
