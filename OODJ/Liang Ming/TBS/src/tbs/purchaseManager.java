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

public class purchaseManager extends userLogin {
    
    purchaseManager(){
        
    }

    public void pmMenu(String uId) {

        //userLogin ulObject = new userLogin();
        super.display();

        Scanner pmMenuObject = new Scanner(System.in);
        String pmMenuCmd;
        System.out.println("Please Select your Functionalities: ");
        System.out.println("List Item Enter item ");
        System.out.println("List Supplier Enter supplier ");
        System.out.println("List Purchase Requisition Enter requisition ");
        System.out.println("Generate Purchase Order Enter generate ");
        System.out.println("List Generate Purchase Order Enter list ");
        pmMenuCmd = pmMenuObject.next();
        list pmObject = new list();
        purchaseManager pmNObject = new purchaseManager();
        switch (pmMenuCmd) {
            case "item":
                pmObject.listItem();
                break;

            case "supplier":
                pmObject.listSupplier();
                break;

            case "requisition":
                pmObject.listRequisition();
                break;

            case "generate":
                pmNObject.purchaseOrder();
                break;

            case "list":
                pmObject.listPO();
                break;

            default:
                System.out.println("Please Try Again");

        }
    }

    

    public void purchaseOrder() {
        try {
            FileReader file = new FileReader("purchase_info.txt");
            BufferedReader buffer = new BufferedReader(file);
            String line = "";

            while ((line = buffer.readLine()) != null) {
                String[] tokens = line.split(";");
                if (tokens.length > 1) {
                    System.out.println("Purchase Requisition ID : " + tokens[0]);
                    System.out.println("Item Code : " + tokens[1]);
                    System.out.println("Quantity : " + tokens[2]);
                    System.out.println("Date : " + tokens[3]);
                    System.out.println("Supplier ID : " + tokens[4]);
                    System.out.println("User ID : " + tokens[5]);
                    System.out.println("Status : " + tokens[6]);
                    System.out.println("\n");
                }
            }
            buffer.close();

        } catch (IOException e) {
            System.out.println("A read error as occured. ");

        }
        System.out.println("Please Select the Purchase Requisition That Need To Approve : ");
        Scanner sInput = new Scanner(System.in);

        String select = sInput.nextLine();

        System.out.println("Please Select Approve or Reject Purchase Order : ");
        String ar = sInput.nextLine();

        if (ar.equals("a") || ar.equals("r")) {
            try {
                // Open the file that is the first
                // command line parameter
                FileInputStream fstream = new FileInputStream("purchase_info.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                StringBuilder fileContent = new StringBuilder();

                //Read File Line By Line
                while ((strLine = br.readLine()) != null) {
                    // Print the content on the console
                    //System.out.println("The record : " +strLine);
                    String tokens[] = strLine.split(";");

                    //if(value1.equals(tokens[0])){
                    // Here tokens[0] will have value of ID
                    //	
                    if (tokens[0].equals(select)) {
                        //if(!tokens[0].equals(value1))
                        //	tokens[0] = value1;
                        //else{
                        //	System.out.println("Your Item Code records has already exist");
                        //	br.close();
                        //	return;						
                        //}

                        tokens[6] = ar;

                        System.out.println("The before record changed : " + strLine);
                        String newLine = tokens[0] + ";" + tokens[1] + ";" + tokens[2] + ";" + tokens[3] + ";" + tokens[4] + ";" + tokens[5] + ";" + tokens[6] +";";
                        System.out.println("The record has changed : " + newLine);
                        fileContent.append(newLine);
                        fileContent.append("\n");
                    } else {
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");

                    }
                    //}

                }
                // Now fileContent will have updated content , which you can override into file

                FileWriter fstreamWrite = new FileWriter("purchase_info.txt");
                //Close the input stream
                br.close();

                BufferedWriter out = new BufferedWriter(fstreamWrite);
                out.write(fileContent.toString());
                out.close();

            } catch (Exception e) {//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println("You can select either (a) for approved or (r) for rejected");
        }

    }

    @Override
    public void menu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
