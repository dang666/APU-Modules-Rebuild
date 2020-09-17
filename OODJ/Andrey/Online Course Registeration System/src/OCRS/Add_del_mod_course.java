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
 * @author BryanL
 */
public class Add_del_mod_course extends List_Courses{
    //Declaring global variables.
    String reader,line_sep = System.lineSeparator();
    String[] temp;
    String[] course;
    File oldFile = new File("Course_List.txt");
    File newTempfile = new File("temp_Course_List.txt");
    File replaceFile = new File("Course_List.txt");
    
    //Method for deleting course(s).
    public void delCourse(String des,String courses){
        //Assigning string to variable
        desig = des;
        
        //Only these 2 designations are able to delete course(s).
        if(desig.equals("Administrative Director")||desig.equals("Administrative Manager")){
            if(courses.length() != 0){
                
                //Split courses into a course array
                course = courses.split(",");
                
                //Assign size of array to variable
                int course_size = course.length;
                try{
                    //Display confirm message.
                    int return_opt = 0;
                    return_opt = JOptionPane.showConfirmDialog(null, "Confirm delete course(s)?", "WARNING", JOptionPane.OK_CANCEL_OPTION);
                    
                    //If confirm delete, proceed to delete courses.
                    if(return_opt == JOptionPane.OK_OPTION){
                        FileReader fr = new FileReader(oldFile);
                        BufferedReader br = new BufferedReader(fr);
                        FileWriter fw = new FileWriter (newTempfile, true);
                        reader = br.readLine();
                        while (reader.length() != 0){
                            
                            //Use variable h as a flag.
                            int h = 0;
                            temp = reader.split(",");
                            for(int i=0 ; i < course_size ; i++){
                                
                                //If course code matches course to delete then set "h" value to 1.
                                if (temp[1].equals(course[i])){
                                    h = 1;
                                    
                                    //Replacing current course code to "deleted" status.
                                    String replace = course[i];
                                    course[i] = course[i].replaceAll(replace, "deleted");
                                }
                            }
                            
                            //If "h" value is 1, ignore/delete course and continue.
                            if(h == 1){
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
                            else if (h == 0){
                                
                                //If "h" value remains as 0, keep the course, write it to new temp file and continue.
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
                        }
                        fw.close();
                        br.close();
                        fr.close();
                    }
                    else{
                        return;
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Unable to delete "+e, "Error!", JOptionPane.ERROR_MESSAGE);
                }
                
                //Replacing old file with new file.
                try{
                    Files.deleteIfExists(Paths.get("Course_List.txt"));
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
            else{
                return;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "You do not have authority to delete.", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    //Method for adding course(s).
    public void addCourse(String cn, String cc, String lvl, String desc, String price){
        try{
            FileReader fr = new FileReader(oldFile);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter (oldFile, true);
            reader = br.readLine();
            while (reader.length() != 0){
                temp = reader.split(",");
                
                //If course name or course code that is being added already exists, display error.
                if (cn.equals(temp[0])||cc.equals(temp[1])){
                    JOptionPane.showMessageDialog(null, "Course already exists.");
                    fw.close();
                    br.close();
                    fr.close();
                    return;
                }
                reader = br.readLine();
                if ("testnull".equals(reader)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }
                else if (reader == null){
                    fw.write(cn+","+cc+","+lvl+","+desc+","+price);
                    fw.write(line_sep);
                    JOptionPane.showMessageDialog(null, "Course added!");
                    fw.close();
                    br.close();
                    fr.close();                        
                    break;                                
                }                
            }
            fw.close();
            br.close();
            fr.close();               
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unable to add course."+e, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void modCourse(String oldcn, String cn, String cc, String lvl, String desc, String price){
        String oldS,newS;
        try{
            FileReader fr = new FileReader(oldFile);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter (newTempfile, true);
            reader = br.readLine();
            while (reader.length() != 0){
                temp = reader.split(",");
                if(temp[0].equals(oldcn)){
                    if (!cn.equals("Enter new course name")){
                        oldS = temp[0];
                        newS = cn;
                        reader = reader.replaceAll(oldS, newS);
                    }
                    if (!cc.equals("Enter new course code")){
                        oldS = temp[1];
                        newS = cc;
                        reader = reader.replaceAll(oldS, newS);
                    }
                    if (!lvl.equals("Select new course level")){
                        oldS = temp[2];
                        newS = lvl;
                        reader = reader.replaceAll(oldS, newS);
                    }
                    if (!desc.equals("Enter new course description")){
                        oldS = temp[3];
                        newS = desc;
                        reader = reader.replaceAll(oldS, newS);
                    }
                    if (!price.equals("Enter new course fee")){
                        oldS = temp[4];
                        newS = price;
                        reader = reader.replaceAll(oldS, newS);
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
                else{
                    continue;
                }                
            }
            fw.close();
            br.close();
            fr.close();              
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unable to modify course.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        try{
            Files.deleteIfExists(Paths.get("Course_List.txt"));
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
}
