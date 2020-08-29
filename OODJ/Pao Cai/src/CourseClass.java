
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
public class CourseClass {
    String reader;
    int error = 0; // 0 means no error
    
    String id, fn;
    public void PassVariable(String ID, String fullname)
    {
        id = ID;
        fn = fullname;
    }
        
    //View Course
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
    
    //Add Course
    public void AddCourse(String c_Code, String c_Name, String c_level, String c_fees, String duration)
    {
        //check whether it is blank or not
        if (c_Code.equals("") || c_Name.equals("") || c_level.equals("") || c_fees.equals("") || duration.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Missing Details\nPlease Fill in the blank", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            //ask user whether confirm want to proceed or not
            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Add Course", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION)
            {
                //before write into the Course.txt read from the file to verify the Course Code
                try{
                    FileReader fr = new FileReader("SaveFile/Course.txt");
                    BufferedReader br = new BufferedReader(fr);
                    ArrayList<String> courseData = new ArrayList<String>();
                    String[] array = new String[courseData.size()];
                    while ((reader = br.readLine()) != null)
                    {
                        courseData.add(reader);
                    }
                    
                    //Check whether the course ID will repeat or not
                    for (int i = 0; i < courseData.size(); i++)
                    {
                        array = courseData.get(i).split(":"); 
                        if (c_Code.equals(array[0]))
                        {
                            JOptionPane.showMessageDialog(null, "CourseClassError\nAddCourse - CourseCode Repeated", "Error!!!", JOptionPane.ERROR_MESSAGE);
                            error = 1;
                        }
                    }
                    
                    br.close();
                    fr.close();
                    
                    if (error == 0)
                    {
                        //write in to Course.txt
                        try{
                            FileWriter fw = new FileWriter("SaveFile/Course.txt", true);
                            fw.append(c_Code + ":" + c_Name + ":" + c_level + ":" + c_fees + ":" + duration + "\r\n");
                            fw.close();
                        }
                        catch (Exception e) 
                        {
                            JOptionPane.showMessageDialog(null,"CourseClassError - AddCourse", "Error!!!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(null,"CourseClassError - AddCourse", "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                finally
                {
                    //after add no matter success or not, it will dispose the AddCourseMenu and open it again. Just like refresh
                    int confirm2 = JOptionPane.showConfirmDialog(null, "Do you want to add course again", "Add Another Course", JOptionPane.YES_NO_OPTION);
                    if (confirm2 == JOptionPane.YES_OPTION)
                    {
                        //The user want to add another course
                        AddCourseMenu ac = new AddCourseMenu();
//                        ac.dispose();
                        ac.PassVariable(id, fn);
                        ac.setVisible(true);
                    }
                    else
                    {
                        //The user do not want to add again, go to Course menu
//                        AddCourseMenu acm = new AddCourseMenu();
//                        acm.dispose();
                        CourseMenu cm = new CourseMenu();
                        cm.PassVariable(id, fn);
                        cm.setVisible(true);
                    }
                } 
            }
        }
    }
    
    //Edit COurse
    public void EditCourse(String c_Code, String c_Name, String c_level, String c_fees, String duration, String OriginalCode)
    {
        //OriginalCode = MPU3113-HE
        int confirm = JOptionPane.showConfirmDialog(null, "Do you confirm want to edit", "Edit Course Records", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION)
        {
            try{
                FileReader fr = new FileReader("SaveFile/Course.txt");
                BufferedReader br = new BufferedReader(fr);            
                ArrayList<String> courseData = new ArrayList<String>();
                String[] array = new String[courseData.size()];
                
                while ((reader = br.readLine()) != null)
                {
                    courseData.add(reader);
                }
                
                //Check whether the course ID will repeat or not
                for (int i = 0; i < courseData.size(); i++)
                {
                    array = courseData.get(i).split(":"); 
                    if (c_Code.equals(OriginalCode))
                    {
                        error = 0;
                    }
                    else // Course Code Changes
                    {
                        if (c_Code.equals(array[0]))
                        {
                            JOptionPane.showMessageDialog(null, "CourseClassError\nEditCourse - CourseCode Repeated", "Error!!!", JOptionPane.ERROR_MESSAGE);
                            error = 1;
                        }
                    }
                }
                
                //if course code repeated, error = 1 else error = 0
                //if no error, write into Course.txt and StudentCourseRegisted.txt
                //Change Course.txt
                for (int i = 0; i < courseData.size(); i++)
                {
                    //JOptionPane.showMessageDialog(null, "Error 2" + c_Name);
                    array = courseData.get(i).split(":");
                    if (OriginalCode.equals(array[0]) && error == 0)
                    {
                        array[0] = c_Code;
                        array[1] = c_Name;
                        array[2] = c_level;
                        array[3] = c_fees;
                        array[4] = duration;
                        courseData.set(i, array[0] + ":" + array[1] + ":" + array[2] + ":" + array[3] + ":" + array[4]);
                        FileWriter fw = new FileWriter("SaveFile/Course.txt");
                        for (int x = 0; x < courseData.size(); x++)
                        {
                            fw.write(courseData.get(x));
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
                    if (OriginalCode.equals(array2[2])  && error == 0)
                    {
                        array2[2] = c_Code;
                        array2[3] = c_Name;
                        array2[4] = c_fees;
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
                JOptionPane.showMessageDialog(null, "The Course has been edited", "Successfully Edited", JOptionPane.INFORMATION_MESSAGE);
                br2.close();
                fr2.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"CourseClassError - EditCourse", "Error!!!", JOptionPane.ERROR_MESSAGE);
            }            
        }
        //After edit got to course menu
        CourseMenu cm = new CourseMenu();
        cm.PassVariable(id, fn);
        cm.setVisible(true);
    }
    
    //Drop Course
    public void DeleteCourse(String OriginalCode)
    {
        //OriginalCode = MPU3113-HE
        int confirm = JOptionPane.showConfirmDialog(null, "Do you confirm want to delete", "Save Records", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION)
        {
            try{
                //Course
                FileReader fr = new FileReader("SaveFile/Course.txt");
                BufferedReader br = new BufferedReader(fr);            
                ArrayList<String> adminData = new ArrayList<String>();
                String[] array = new String[adminData.size()];
                
                while ((reader = br.readLine()) != null)
                {
                    adminData.add(reader);
                }
                
                //Delete record in Course.txt
                for (int i = 0; i < adminData.size(); i++)
                {
                    array = adminData.get(i).split(":");
                    if (OriginalCode.equals(array[0]))
                    {
                        FileWriter fw = new FileWriter("SaveFile/Course.txt");
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
                
                //Since the course is deleted, the record that student register course will also be deleted
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
                    if (OriginalCode.equals(array2[2]))
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
                JOptionPane.showMessageDialog(null, "The Course has been deleted", "Successfully Delete", JOptionPane.INFORMATION_MESSAGE);
                br2.close();
                fr2.close();
                br.close();
                fr.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "ManageProfileClass - Delete Course Error", "Error!!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        //After delete got to course menu
        CourseMenu cm = new CourseMenu();
        cm.PassVariable(id, fn);
        cm.setVisible(true);
    }
}
