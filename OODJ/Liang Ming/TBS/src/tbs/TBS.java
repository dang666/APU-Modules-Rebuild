/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbs;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ming
 */
public class TBS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //userLogin user = new userLogin();
        //user.login();

        String userID, userPass;

        Scanner inputValidation = new Scanner(System.in);

        String[] data;
        String line;
        //String userID , userPass;

        BufferedReader read = null;
        int ok = 0;

        System.out.println("Please Insert Your ID : ");
        userID = inputValidation.next();

        System.out.println("Please Insert Your Password : ");
        userPass = inputValidation.next();

        try {
            Scanner inputData = new Scanner(System.in);

            //D:\Ming\jdk1.7.0_40\bin
            read = new BufferedReader(new FileReader("user_info.txt"));

            while ((line = read.readLine()) != null) {
                data = line.split(";");

                while (userID.equals(data[0]) && userPass.equals(data[1])) {

                    if (!userID.equals(data[0]) || !userPass.equals(data[1])) {
                        System.out.println("-----------------------------------------\nEither User ID or Password is Wrong \nPlease Try Again \n-----------------------------------------\n\n");
                        return;
                    }

                    switch (data[2]) {
                        case "sm":
                            //System.out.println("-----------------------------------------\nLogin Successfully\nAccess Granted\n-----------------------------------------\n");
                            salesManager sManager = new salesManager(userID);
                            //sManager.display();
                            //itemEntry item = new itemEntry(userID);
                            sManager.menu();
                            ok++;
                            break;

                        case "admin":
                            //System.out.println("-----------------------------------------\nLogin Successfully\nAccess Granted\n-----------------------------------------\n");
                            administrator admin = new administrator();
                            //admin.display();
                            admin.menu();
                            ok++;
                            break;

                        case "pm":
                            purchaseManager pManager = new purchaseManager();
                            pManager.pmMenu(userID);//
                            ok++;
                            break;

                        default:
                            System.out.println("Please Try Again. ");
                            break;
                    }

                    read.close();
                    return;

                }

            }

            read.close();
        } catch (IOException ex) {
            System.out.println("Failed");
        }

        if (ok < 1) {
            System.out.println("Please Try Again. ");
        }
    }

}
