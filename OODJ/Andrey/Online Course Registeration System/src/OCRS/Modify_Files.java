/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OCRS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan Low
 */
public class Modify_Files {
    public void replaceAdminPass(String uname, String oldS, String newS){
        //Get operating system's default line separator (mac = \n, windows = \r\n)
        String line_sep = System.lineSeparator();
        //Read from old file
        File oldFile = new File("Admin_Profile_DB.txt");
        //Create new temporary file to write to
        File newTempfile = new File("temp_Admin_Profile_DB.txt");
        //Replace the old file with the new temporary file
        File replaceFile = new File("Admin_Profile_DB.txt");
        String reader;
        String[] temp;
        try
        {
            FileReader fr = new FileReader(oldFile);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter (newTempfile, true);
             
            //Reading all the lines from file into variable
            reader = br.readLine();
            while (reader.length() != 0) 
            {
                temp = reader.split(",");
                //If username and old password matches, replace old password with new password
                if (uname.equals(temp[3]) && oldS.equals(temp[4])){
                    reader = reader.replaceAll(oldS, newS);
                    //Write line to file
                    fw.write(reader);
                    fw.write(line_sep);
                    reader = br.readLine();
                    if ("testnull".equals(reader)){
                        System.out.println("This should not occur, only to handle NullPointerException.");
                    }
                    else if (reader == null){
                        fw.close();
                        br.close();
                        fr.close();                        
                        break;                                
                    }
                    else{
                        continue;
                    }
                }
                //If username and old password does not match, write line to file and continue
                fw.write(reader);
                fw.write(line_sep);
                reader = br.readLine();
                if ("testnull".equals(reader)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }
                else{
                    if (reader == null){
                        fw.close();
                        br.close();
                        fr.close();                        
                        break;
                    }                                 
                } 
            }
            fw.close();
            br.close();
            fr.close();             
        }
        catch (Exception rep)
        {
            JOptionPane.showMessageDialog(null, "Error setting new password " + rep);
        }
        //Delete old file and rename temporary file to replace old file
        try{
            Files.deleteIfExists(Paths.get("Admin_Profile_DB.txt"));
            newTempfile.renameTo(replaceFile);
        }
        catch(NoSuchFileException e) 
        { 
            JOptionPane.showMessageDialog(null, "No such file/directory exists " + e);
        } 
        catch(DirectoryNotEmptyException e) 
        { 
            JOptionPane.showMessageDialog(null, "Directory is not empty " + e);
        } 
        catch(IOException e) 
        { 
            JOptionPane.showMessageDialog(null, "Invalid permissions " + e);
        } 
    }
    public void replaceStudPass(String uname, String oldS, String newS){
        String line_sep = System.lineSeparator();
        File oldFile = new File("Student_Profile_DB.txt");
        File newTempfile = new File("temp_Student_Profile_DB.txt");
        File replaceFile = new File("Student_Profile_DB.txt");
        String reader;
        String[] temp;
        try
        {
            FileReader fr = new FileReader(oldFile);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter (newTempfile, true);
             
            //Reading all the lines of input text file into Content
            reader = br.readLine();
            while (reader.length() != 0) 
            {
                temp = reader.split(",");
                if (uname.equals(temp[4]) && oldS.equals(temp[5])){
                    reader = reader.replaceAll(oldS, newS);
                    fw.write(reader);
                    fw.write(line_sep);
                    reader = br.readLine();
                    if ("testnull".equals(reader)){
                        System.out.println("This should not occur, only to handle NullPointerException.");
                    }
                    else if (reader == null){
                        fw.close();
                        br.close();
                        fr.close();                        
                        break;                                
                    }
                    else{
                        continue;
                    }
                }
                fw.write(reader);
                fw.write(line_sep);
                reader = br.readLine();
                if ("testnull".equals(reader)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }
                else{
                    if (reader == null){
                        fw.close();
                        br.close();
                        fr.close();                        
                        break;
                    }                                 
                }                
            }
            fw.close();
            br.close();
            fr.close();             
        }
        catch (Exception rep)
        {
            JOptionPane.showMessageDialog(null, "Error setting new password " + rep);
        }
        try{
            Files.deleteIfExists(Paths.get("Student_Profile_DB.txt"));
            newTempfile.renameTo(replaceFile);
        }
        catch(NoSuchFileException e) 
        { 
            JOptionPane.showMessageDialog(null, "No such file/directory exists " + e);
        } 
        catch(DirectoryNotEmptyException e) 
        { 
            JOptionPane.showMessageDialog(null, "Directory is not empty " + e);
        } 
        catch(IOException e) 
        { 
            JOptionPane.showMessageDialog(null, "Invalid permissions " + e);
        } 
    }
    public String replaceStudDetails(String uname, String name, String id, String degree, String lvl, String course){
        String line_sep = System.lineSeparator();
        File oldFile = new File("Student_Profile_DB.txt");
        File newTempfile = new File("temp_Student_Profile_DB.txt");
        File replaceFile = new File("Student_Profile_DB.txt");
        String reader, reader2, oldS, newS, id_check = "not";
        String[] temp;
        String[] temp2;
        try
        {
            FileReader fr = new FileReader(oldFile);
            FileReader fr2 = new FileReader(oldFile);
            BufferedReader br = new BufferedReader(fr);
            BufferedReader br2 = new BufferedReader(fr2);
            FileWriter fw = new FileWriter (newTempfile, true);
             
            //Reading all the lines of input text file into Content
            reader = br.readLine();
            while (reader.length() != 0){
                temp = reader.split(",");
                if (uname.equals(temp[4])){
                    if (!name.equals("Enter new name")){
                        oldS = temp[0];
                        newS = name;
                        reader = reader.replaceAll(oldS, newS);
                    }
                    reader2 = br2.readLine();
                    while(reader2.length() != 0){
                        temp2 = reader2.split(",");
                        if(id.equals(temp2[1])){
                            id_check = "exists";
                            break;
                        }
                        reader2 = br2.readLine();
                        if ("testnull".equals(reader)){
                            System.out.println("This should not occur, only to handle NullPointerException.");
                        }
                        else if (reader2 == null){
                            br2.close();
                            fr2.close();                        
                            break;                                
                        }
                        else{
                            continue;
                        }                        
                    }
                    br2.close();
                    fr2.close();                    
                    if (!id.equals("Enter new ID") && !id_check.equals("exists")){
                        oldS = temp[1];
                        newS = id;
                        reader = reader.replaceAll(oldS, newS);
                    }
                    if (!degree.equals("Select Course")){
                        oldS = temp[2];
                        newS = degree;
                        reader = reader.replace(oldS, newS);
                    }
                    if (!lvl.equals("Select Degree Level")){
                        oldS = temp[3];
                        newS = lvl;
                        reader = reader.replaceAll(oldS, newS);
                    }
                    fw.write(reader);
                    fw.write(line_sep);                    
                    reader = br.readLine();
                    if ("testnull".equals(reader)){
                        System.out.println("This should not occur, only to handle NullPointerException.");
                    }
                    else if (reader == null){
                        fw.close();
                        br.close();
                        fr.close();                        
                        break;                                
                    }
                    else{
                        continue;
                    }
                }
                fw.write(reader);
                fw.write(line_sep);
                reader = br.readLine();
                if ("testnull".equals(reader)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }
                else if (reader == null){
                    fw.close();
                    br.close();
                    fr.close();                        
                    break;                                
                }                
            }           
            fw.close();
            br.close();
            fr.close();
            if(id_check.equals("exists")){
                JOptionPane.showMessageDialog(null, "Student ID entered already exists, please try entering a different Student ID.");
            }
        }
        catch (Exception rep)
        {
            JOptionPane.showMessageDialog(null, "Error in changing profile details " + rep);
        }
        try{
            Files.deleteIfExists(Paths.get("Student_Profile_DB.txt"));
            newTempfile.renameTo(replaceFile);
        }
        catch(NoSuchFileException e) 
        { 
            JOptionPane.showMessageDialog(null, "No such file/directory exists " + e);
        } 
        catch(DirectoryNotEmptyException e) 
        { 
            JOptionPane.showMessageDialog(null, "Directory is not empty " + e);
        } 
        catch(IOException e) 
        { 
            JOptionPane.showMessageDialog(null, "Invalid permissions " + e);
        }

        File oldFile2 = new File("Enrollment_List.txt");
        File newTempfile2 = new File("temp_Enrollment_List.txt");
        File replaceFile2 = new File("Enrollment_List.txt"); 
        String invalid = "", status = "";
        if(!course.equals("")){
            temp2 = course.split(",");
            int arraysize = temp2.length;            
            try{
                FileReader fr = new FileReader(oldFile2);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter (newTempfile2, true);

                //Reading all the lines of input text file into Content
                reader = br.readLine();
                while (reader.length() != 0){
                    int h = 0;
                    temp = reader.split(",");
                    //IF username matches, check whether this course needs to be deleted;
                    //ELSE write to temp file and read next line.
                    if (uname.equals(temp[0])){
                        for(int i=0 ; i < arraysize ; i++){
                            //If course code matches course to delete then set "h" value to 1.
                            if (temp[2].equals(temp2[i])){
                                h = 1;
                                String replace = temp2[i];
                                temp2[i] = temp2[i].replaceAll(replace, "deleted");
                            }
                        }
                        //If "h" value is 1, ignore/delete course and continue.
                        if(h == 1){
                            reader = br.readLine();
                            if ("testnull".equals(reader)){
                                System.out.println("This should not occur, only to handle NullPointerException.");
                            }
                            else if (reader == null){
                                for(int i = 0; i < arraysize; i++){
                                    if(!temp2[i].equals("deleted")){
                                        invalid = invalid + temp2[i] + line_sep;
                                    }
                                }
                                if(!invalid.equals("")){
    //                                JOptionPane.showMessageDialog(null, "Invalid course code(s): "+line_sep+invalid, "Error, not deleted!",  JOptionPane.ERROR_MESSAGE);
                                    status = "not all deleted";
                                }
                                else{
                                    status = "all deleted";
                                }
                                fw.close();
                                br.close();
                                fr.close();                        
                                break;                                
                            }
                            else{
                                continue;
                            }                        
                        }
                        else if (h == 0){
                            //If "h" value remains as 0, keep the course and continue.
                            fw.write(reader);
                            fw.write(line_sep);                    
                            reader = br.readLine();
                            if ("testnull".equals(reader)){
                                System.out.println("This should not occur, only to handle NullPointerException.");
                            }
                            else if (reader == null){
                                for(int i = 0; i < arraysize; i++){
                                    if(!temp2[i].equals("deleted")){
                                        invalid = invalid + temp2[i] + line_sep;
                                    }
                                }
                                if(!invalid.equals("")){
                                    status = "not all deleted";
                                }
                                else{
                                    status = "all deleted";
                                }
                                fw.close();
                                br.close();
                                fr.close();                        
                                break;                                
                            }
                            else{
                                continue;
                            }
                        }
                    }
                    fw.write(reader);
                    fw.write(line_sep);
                    reader = br.readLine();
                    if ("testnull".equals(reader)){
                        System.out.println("This should not occur, only to handle NullPointerException.");
                    }
                    else if (reader == null){
                        for(int i = 0; i < arraysize; i++){
                            if(!temp2[i].equals("deleted")){
                                invalid = invalid + temp2[i] + line_sep;
                            }
                        }
                        if(!invalid.equals("")){
                            JOptionPane.showMessageDialog(null, "Invalid course code(s): "+line_sep+invalid, "Error, not deleted!",  JOptionPane.ERROR_MESSAGE);
                            status = "not all deleted";
                        }
                        else{
                            status = "all deleted";
                        }
                        fw.close();
                        br.close();
                        fr.close();                        
                        break;                                
                    }
                }            
            }
            catch (Exception rem){
                JOptionPane.showMessageDialog(null, "Error in removing course(s) " + rem);            
            }
            try{
                Files.deleteIfExists(Paths.get("Enrollment_List.txt"));
                newTempfile2.renameTo(replaceFile2);
            }
            catch(NoSuchFileException e) 
            { 
                JOptionPane.showMessageDialog(null, "No such file/directory exists " + e);
            } 
            catch(DirectoryNotEmptyException e) 
            { 
                JOptionPane.showMessageDialog(null, "Directory is not empty " + e);
            } 
            catch(IOException e) 
            { 
                JOptionPane.showMessageDialog(null, "Invalid permissions " + e);
            }
            return status; 
        }
        else{
            status = "all deleted";
        }
        return status;            
    }
}
