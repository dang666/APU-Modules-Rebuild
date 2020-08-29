
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
public class StudentClass {
    
    String reader;
    int error = 0; // 0 means no error
    
    String pv_id, pv_fn;
    public void PassVariable(String ID, String fullname)
    {
        pv_id = ID;
        pv_fn = fullname;
    }
    
    //View Student
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
    
    //Add Student
    public void AddUser(String id, String fn, String un, String pw, String ct, String em, String dl, String location, String userType)
    {
        int confirm = JOptionPane.showConfirmDialog(null, "Do you confirm want to add", "Add User", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION)
        {
            try{
                FileReader fr = new FileReader(location);
                BufferedReader br = new BufferedReader(fr);            
                ArrayList<String> userData = new ArrayList<String>();
                String[] array = null;
                
                while ((reader = br.readLine()) != null)
                {
                    userData.add(reader);
                }
                
                //check id and username whether got repeated or not 
                for (int i = 0; i < userData.size(); i++)
                {
                    //line = br.readLine();
                    array = userData.get(i).split(":");
                    if (id.equals(array[2]) || un.equals(array[0]))
                    {
                        error = 1; // which means it is repeated
                        break;
                    }
                }
                
                if (error == 1) 
                {
                    JOptionPane.showMessageDialog(null,"AddUser - ID or Username repeated", "Add Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (error == 0)
                {
                    //no ID repeated
                    //append into file
                    FileWriter fw = new FileWriter(location, true);
                    if (userType.equals("Admin"))
                    {
                        //Add to Admin.txt
                        fw.append(un + ":" + pw + ":" + id + ":" + fn + ":" + ct + ":" + em);
                    }
                    else
                    {
                        //Add to Student.txt
                        fw.append(un + ":" + pw + ":" + id + ":" + fn + ":" + ct + ":" + em + ":" + dl);
                    }
                    fw.write("\r\n");
                    fw.close();
                }
                br.close();
                fr.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "UserClass - AddUser Error", "Error!!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        int confirm2 = JOptionPane.showConfirmDialog(null, "Do you want to add user again", "Add Another User", JOptionPane.YES_NO_OPTION);
        if (confirm2 == JOptionPane.YES_OPTION)
        {
            //The user want to add another course
            if (userType.equals("Admin"))
            {
                AddAdminMenu aam = new AddAdminMenu();
                aam.PassVariable(pv_id, pv_fn);
                aam.setVisible(true);
            }
            else
            {
                AddStudentMenu asm = new AddStudentMenu();
                asm.PassVariable(pv_id, pv_fn);
                asm.setVisible(true);
            }
        }
        else
        {
            if (userType.equals("Admin"))
            {
                ViewAdminList val = new ViewAdminList();
                val.PassVariable(pv_id, pv_fn);
                val.setVisible(true);
            }
            else
            {
                ViewStudentList vsl = new ViewStudentList();
                vsl.PassVariable(pv_id, pv_fn);
                vsl.setVisible(true);
            }
        }
    }
    
    //Edit Student
    public void EditStudent(String id, String fn, String un, String pw, String ct, String em, String dl, String OriginStudentID)
    {
        //OriginStudentID = stud1
        int confirm = JOptionPane.showConfirmDialog(null, "Do you confirm want to edit", "Edit User", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION)
        {
            try{
                FileReader fr = new FileReader("SaveFile/Student.txt");
                BufferedReader br = new BufferedReader(fr);            
                ArrayList<String> userData = new ArrayList<String>();
                String[] array;
                
                while ((reader = br.readLine()) != null)
                {
                    userData.add(reader);
                }
                
                //Check whether the Student ID will repeat or not
                for (int i = 0; i < userData.size(); i++)
                {
                    array = userData.get(i).split(":"); 
                    
                    //check student id duplicate
                    if (id.equals(OriginStudentID)) // the id does not changed
                    {
                        error = 0;
                    }
                    else // id change
                    {
                        if (id.equals(array[2]))
                        {
                            JOptionPane.showMessageDialog(null, "StudentClassError\nEditStudent - CourseCode Repeated", "Error!!!", JOptionPane.ERROR_MESSAGE);
                            error =1;
                        }
                    }
                }
                
                //if student id repeated, error = 1 else error = 0
                //if no error, write into Student.txt and StudentCourseRegisted.txt
                for (int i = 0; i < userData.size(); i++)
                {
                    array = userData.get(i).split(":");
                    //write into student.txt
                    if (OriginStudentID.equals(array[2]) && error == 0)
                    {
                        array[0] = un;
                        array[1] = pw;
                        array[2] = id;
                        array[3] = fn;
                        array[4] = ct;
                        array[5] = em;
                        array[6] = dl;
                        
                        userData.set(i, array[0] + ":" + array[1] + ":" + array[2] + ":" + array[3] + ":" + array[4] + ":" + array[5] + ":" + array[6]);
                        FileWriter fw = new FileWriter("SaveFile/Student.txt");
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
                
                //StudentCourseRegisted.txt
                FileReader fr2 = new FileReader("SaveFile/StudentCourseRegisted.txt");
                BufferedReader br2 = new BufferedReader(fr2);            
                ArrayList<String> courseData2 = new ArrayList<String>();
                String[] array2 = new String[courseData2.size()];
                
                while ((reader = br2.readLine()) != null)
                {
                    courseData2.add(reader);
                }
                
                //Change StudentCourseRegisted.txt
                for (int i = 0; i < courseData2.size(); i++)
                {
                    array2 = courseData2.get(i).split(":");
                    if (OriginStudentID.equals(array2[0])  && error == 0)
                    {
                        array2[0] = id;
                        array2[1] = fn;
                        courseData2.set(i, array2[0] + ":" + array2[1] + ":" + array2[2] + ":" + array2[3] + ":" + array2[4] + ":" + array2[5]);
                        FileWriter fw2 = new FileWriter("SaveFile/StudentCourseRegisted.txt");
                        for (int x = 0; x < courseData2.size(); x++)
                        {
                            fw2.write(courseData2.get(x));
                            fw2.write("\r\n");
                        }
                        fw2.close();
                    } 
                }
                br2.close();
                fr2.close();
                JOptionPane.showMessageDialog(null, "The Student has been edited", "Successfully Edited", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "StudentClass - Edit Student Error", "Error!!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        ViewStudentList vsl = new ViewStudentList();
        vsl.PassVariable(pv_id, pv_fn);
        vsl.setVisible(true);
    }
    
    //Delete Student
    public void DeleteStudent(String OriginStudentID)
    {
        //OriginStudentID = stud1
        int confirm = JOptionPane.showConfirmDialog(null, "Do you confirm want to delete", "Delete Student Records", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION)
        {
            try{
                FileReader fr = new FileReader("SaveFile/Student.txt");
                BufferedReader br = new BufferedReader(fr);            
                ArrayList<String> adminData = new ArrayList<String>();
                String[] array = new String[adminData.size()];
                
                while ((reader = br.readLine()) != null)
                {
                    adminData.add(reader);
                }
                
                //Delete Student.txt
                for (int i = 0; i < adminData.size(); i++)
                {
                    array = adminData.get(i).split(":");
                    if (OriginStudentID.equals(array[2]))
                    {
                        FileWriter fw = new FileWriter("SaveFile/Student.txt");
                        for (int x = 0; x < adminData.size(); x++)
                        {
                            if (x != i)
                            {
                                fw.write(adminData.get(x));
                                fw.write("\r\n");
                            }
                        }
                        fw.close();
                    } 
                }
                
                //Since the student has been deleted, the particular student register course record will also deleted
                //StudentCourseRegisted
                FileReader fr2 = new FileReader("SaveFile/StudentCourseRegisted.txt");
                BufferedReader br2 = new BufferedReader(fr2);            
                ArrayList<String> RegisterData = new ArrayList<String>();
                String[] array2 = new String[RegisterData.size()];
                
                while ((reader = br2.readLine()) != null)
                {
                    RegisterData.add(reader);
                }
                
                //Delete record in StudentCourseRegisted.txt
                for (int i = 0; i < RegisterData.size(); i++)
                {
                    array2 = RegisterData.get(i).split(":");
                    if (OriginStudentID.equals(array2[0]))
                    {
                        FileWriter fw2 = new FileWriter("SaveFile/StudentCourseRegisted.txt");
                        for (int x = 0; x < RegisterData.size(); x++)
                        {
                            if (x != i)
                            {
                                fw2.write(RegisterData.get(x));
                                fw2.write("\r\n");
                            }
                        }
                        fw2.close();
                    } 
                }
                JOptionPane.showMessageDialog(null, "The Student has been deleted", "Successfully Delete", JOptionPane.INFORMATION_MESSAGE);
                br2.close();
                fr2.close();
                br.close();
                fr.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "StudentClass - Delete Error", "Error!!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        ViewStudentList vsl = new ViewStudentList();
        vsl.PassVariable(pv_id, pv_fn);
        vsl.setVisible(true);
    }
}
