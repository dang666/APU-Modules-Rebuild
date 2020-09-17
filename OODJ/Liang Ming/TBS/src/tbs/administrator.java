/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbs;

/**
 *
 * @author Ming
 */
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class administrator extends userLogin {

    private String uId;

    public administrator(String userID) {
        this.uId = userID;
    }

    public administrator() {
        
    }

    public void menu() {
        Scanner sInput = new Scanner(System.in);
        System.out.println("Please Select Your Manager Type ( pm / sm / register) : ");
        String select = sInput.nextLine();
        userLogin ulObject[] = new userLogin[2];
        ulObject[0] = new salesManager(uId);
        ulObject[1] = new purchaseManager();
                 
        switch (select) {
            case "sm":
                ulObject[0].menu();
                break;
            case "pm":
                ulObject[1].pmMenu(uId);
                break;

            case "register":
                register();
                break;

            default:
                System.out.println("Try Again");
                break;
        }
    }

    public void register() {

        String line;
        Scanner inputData = new Scanner(System.in);

        BufferedReader read = null;
        //BufferedWriter bWrite = null;
        BufferedWriter buffer = null;

        //userLogin ulObject = new userLogin();
        super.display();

        try {

            //D:\Ming\jdk1.7.0_40\bin
            read = new BufferedReader(new FileReader("user_info.txt"));

            //Buffered bWrite = new BufferedWriter(new FileWriter("user_info.txt"), true);
            FileWriter file = new FileWriter("user_info.txt", true);
            buffer = new BufferedWriter(file);
            String nUserId = null, nUserPass1 = null, nUserPass2 = null;
            //buffer = new BufferedWriter(writer);

            System.out.println("Please Insert Account Type : ");
            String nAccountType = inputData.nextLine();

            if (nAccountType.equals("admin") || nAccountType.equals("sm") || nAccountType.equals("pm")) {
                System.out.println("Please Insert New User Account : ");
                nUserId = inputData.nextLine();
                System.out.println("Please Insert New Passwords : ");
                nUserPass1 = inputData.nextLine();
                System.out.println("Please Insert Confirmation Passwords : ");
                nUserPass2 = inputData.nextLine();

                if (!nUserPass1.equals(nUserPass2)) {
                    System.out.println("Your Passwords is not tally with Confirmation Password");
                    return;
                }
            } else {
                System.out.println("Please Insert Again. ");
                return;
            }

            while ((line = read.readLine()) != null) {

                //do{
                String data[] = line.split(";");

                while (nUserId.equals(data[0]) && nUserPass1.equals(data[1])) {
                    System.out.println("Your Account have already Exist");
                    read.close();
                    return;
                }

            }
            buffer.newLine();
            buffer.append(nUserId);
            buffer.append(";");
            buffer.append(nUserPass1);
            buffer.append(";");
            buffer.append(nAccountType);
            buffer.append(";");
            buffer.newLine();
            //bWrite.flush();
            //buffer.flush();
            buffer.close();
            System.out.println("Register Procedure is Successfully");

            read.close();
        } catch (IOException ex) {
            //Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed, Please Try Again");
        }

    }
}
