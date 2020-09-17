
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DragonKimchi
 */
public class LoginClass {
    
    int error = 1; //default error (1 for yes, 0 for no)
    String line, saveLocation, id, fn, dl;
    
    public void Login(String username, String password, String userType)
    {
        if (userType.equals("Admin"))
        {
            saveLocation = "SaveFile/Admin.txt";
        }
        else
        {
            saveLocation = "SaveFile/Student.txt";
        }
        try{            
            FileReader fr = new FileReader(saveLocation);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> loginArray = new ArrayList<String>();
            //take the admin data from text file and enter to the adminArray
            while ((line = br.readLine()) != null)
            {
                loginArray.add(line);
            }
            
            // validate one by one
            for (int i = 0; i < loginArray.size(); i++)
            {
                String [] line_array;
                line_array = loginArray.get(i).split(":");
                if (username.equals(line_array[0]) && password.equals(line_array[1])) //find match
                {
                    error = 0; // which means it is valid
                    if (userType.equals("Admin"))
                    {
                        id = line_array[2];
                        fn = line_array[3];
                    }
                    else
                    {
                        id = line_array[2];
                        fn = line_array[3];
                        dl = line_array[6];
                    }
                    break;
                }
            }
            
            if (error == 1) 
            {
                JOptionPane.showMessageDialog(null,"LoginClass - Invalid Username or Password", "Login Error", JOptionPane.ERROR_MESSAGE);
                LoginMenu lm = new LoginMenu(userType);
                lm.setVisible(true);
            }
            else if (error == 0)
            {
                //close the previous menu : AdminLoginMenu
                if (userType.equals("Admin"))
                {
                    //close the previous menu : AdminLoginMenu
                    //call Admin Menu, pass the id and fullname to admin menu
                    AdminMenu am = new AdminMenu(id, fn);
                    am.setVisible(true);
                }
                else
                {
                    //close the previous menu : StudentLoginMenu
                    //call Student Menu, pass the id and fullname to Student Menu
                    StudentMenu sm = new StudentMenu(id, fn);
                    sm.PassVariable(id, fn, dl);
                    sm.setVisible(true);
                }
            }
            br.close();
            fr.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "LoginClass - Failed", "Error!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    String reader;
    public void setAdminManageProfileClass(JTextField ID, JTextField Name, JTextField Username, JTextField Password, JTextField Contact, JTextField Email, String usernameLogin)
    {
        try 
        {
            FileReader fr = new FileReader("SaveFile/Admin.txt");
            BufferedReader br = new BufferedReader(fr);            
            ArrayList<String> adminData = new ArrayList<String>();
            String[] array = new String[adminData.size()];
            while ((reader = br.readLine()) != null)
            {
                adminData.add(reader);
            }
            for (int i = 0; i < adminData.size(); i++)
            {                
                array = adminData.get(i).split(":"); 
                if (array[2].equals(usernameLogin))
                {
                    ID.setText(array[2]);
                    Name.setText(array[3]);
                    Username.setText(array[0]);
                    Password.setText(array[1]);
                    Contact.setText(array[4]);
                    Email.setText(array[5]);
                }
            }  
            br.close();
            fr.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "ManageProfileClass Error", "Error!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void AdminConfirm(String id, String fn, String un, String pw, String ct, String em)
    {
        int confirm = JOptionPane.showConfirmDialog(null, "Do you confirm want to edit Admin details", "Save Edit", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION)
        {
            try{
                FileReader fr = new FileReader("SaveFile/Admin.txt");
                BufferedReader br = new BufferedReader(fr);            
                ArrayList<String> adminData = new ArrayList<String>();
                String[] array = new String[adminData.size()];
                
                while ((reader = br.readLine()) != null)
                {
                    adminData.add(reader);
                }
                for (int i = 0; i < adminData.size(); i++)
                {
                    array = adminData.get(i).split(":");
                    if (id.equals(array[2]))
                    {
                        array[0] = un;
                        array[1] = pw;
                        array[3] = fn;
                        array[4] = ct;
                        array[5] = em;
                        adminData.set(i, array[0] + ":" + array[1] + ":" + array[2] + ":" + array[3] + ":" + array[4] + ":" + array[5]);
                        FileWriter fw = new FileWriter("SaveFile/Admin.txt");
                        for (int x = 0; x < adminData.size(); x++)
                        {
                            fw.write(adminData.get(x));
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
                JOptionPane.showMessageDialog(null, "ManageProfileClass - Save Admin Error", "Error!!!", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
    
    //Student
    public void setStudentManageProfileClass(JTextField ID, JTextField Name, JTextField Username, JTextField Password, JTextField Contact, JTextField Email, JComboBox degreeLevel, String usernameLogin)
    {
        try 
        {
            FileReader fr = new FileReader("SaveFile/Student.txt");
            BufferedReader br = new BufferedReader(fr);            
            ArrayList<String> studentData = new ArrayList<String>();
            String[] array = new String[studentData.size()];
            while ((reader = br.readLine()) != null)
            {
                studentData.add(reader);
            }
            for (int i = 0; i < studentData.size(); i++)
            {                
                array = studentData.get(i).split(":"); 
                if (array[2].equals(usernameLogin))
                {
                    ID.setText(array[2]);
                    Name.setText(array[3]);
                    Username.setText(array[0]);
                    Password.setText(array[1]);
                    Contact.setText(array[4]);
                    Email.setText(array[5]);
                    degreeLevel.setSelectedItem(array[6]);
                }
            }  
            br.close();
            fr.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "ManageProfileClass Error", "Error!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void StudentConfirm(String id, String fn, String un, String pw, String ct, String em, String dl)
    {
        int confirm = JOptionPane.showConfirmDialog(null, "Do you confirm want to edit Student details", "Save Edit", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION)
        {
            try{
                FileReader fr = new FileReader("SaveFile/Student.txt");
                BufferedReader br = new BufferedReader(fr);            
                ArrayList<String> studentData = new ArrayList<String>();
                String[] array = new String[studentData.size()];
                
                while ((reader = br.readLine()) != null)
                {
                    studentData.add(reader);
                }
                for (int i = 0; i < studentData.size(); i++)
                {
                    array = studentData.get(i).split(":");
                    if (id.equals(array[2]))
                    {
                        array[0] = un;
                        array[1] = pw;
                        array[3] = fn;
                        array[4] = ct;
                        array[5] = em;
                        array[6] = dl;
                        studentData.set(i, array[0] + ":" + array[1] + ":" + array[2] + ":" + array[3] + ":" + array[4] + ":" + array[5] + ":" + array[6]);
                        FileWriter fw = new FileWriter("SaveFile/Student.txt");
                        for (int x = 0; x < studentData.size(); x++)
                        {
                            fw.write(studentData.get(x));
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
                JOptionPane.showMessageDialog(null, "ManageProfileClass - Save Admin Error", "Error!!!", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
}
