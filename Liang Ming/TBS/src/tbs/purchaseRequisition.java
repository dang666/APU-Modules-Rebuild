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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class purchaseRequisition extends handleFile {

    public void menuPurchase(String sCmd, String uId) {

        purchaseRequisition prObject = new purchaseRequisition();
        Scanner prInput = new Scanner(System.in);
        String cmd = null;

        System.out.println("Please Select Your Command : ");
        System.out.println("1. Add Purchase Requisition\n2. Delete\n3. Edit");
        cmd = prInput.next();

        switch (cmd) {
            case "add":
                prObject.addPR(sCmd, uId);
                break;

            case "delete":
                prObject.deletePR(sCmd);
                break;

            case "edit":
                prObject.editItem(sCmd, uId);
                break;

            default:
                System.out.println("Please Try Again");
        }

    }

    public void addPR(String cmd, String uId) {

        Scanner inputPurchase = new Scanner(System.in);

        System.out.println("Please Insert Your Purchase Requisition ID : ");
        String pID = inputPurchase.nextLine();

        System.out.println("Please Insert Your Item Code : ");
        String pItemCode = inputPurchase.nextLine();

        System.out.println("Please Insert Your Quantity : ");
        while (!inputPurchase.hasNextInt()) {
            System.out.println("Please Insert Quantity In Number : ");
            inputPurchase.next();
        }
        int pQuantity = inputPurchase.nextInt();

        String sPQ = String.format("%d", pQuantity);

        System.out.println("Please Insert Your Date in Month(12)/Day(7/Year(2017) : ");
        String strDate = inputPurchase.next();

        purchaseRequisition purReObject = new purchaseRequisition();
        while (!purReObject.validateJavaDate(strDate)) {
            System.out.println("Please Insert Your Date in Month(12)/Day(7/Year(2017) : ");
            strDate = inputPurchase.next();
        }

        System.out.println("Do You Want to Save Your Record (y/n) : ");
        String yn = inputPurchase.next();

        switch (yn) {
            case "y":
                //handleFile fileObject = new handleFile();

                super.addFile(cmd, pID, pItemCode, sPQ, strDate, uId);

                break;

            default:
                return;
        }

    }

    public void deletePR(String cmd) {
        cmd = cmd + "_info.txt";

        Scanner Sc = new Scanner(System.in);
        String prIDToDelete;
        System.out.println("Enter Purchase Requisition ID to Delete : ");
        prIDToDelete = Sc.nextLine();

        System.out.println("Do You Want to Delete Your Record (y/n) : ");
        String yn = Sc.nextLine();
        switch (yn) {
            case "y":
                //handleFile fileObject = new handleFile();
                super.deleteFile(cmd, prIDToDelete);

                break;

            default:
                return;

        }

    }

    public void editItem(String cmd, String uId) {
        cmd = cmd + "_info.txt";

        Scanner Sc = new Scanner(System.in);
        String prID;
        //--String newItem;
        System.out.println("Enter Purchase Requisition ID For Edit : ");
        prID = Sc.nextLine();

        System.out.print("New Purchase Requisition ID : ");
        String nPrID;
        nPrID = Sc.nextLine();

        System.out.print("New Item Code : ");
        String nic = Sc.nextLine();

        System.out.print("New Item Quantity: ");
        int niq = Sc.nextInt();

        System.out.print("New Date : ");
        String ndy = Sc.next();
        purchaseRequisition purReObject = new purchaseRequisition();
        while (!purReObject.validateJavaDate(ndy)) {
            System.out.println("Please Insert Your Date in Month(12)/Day(7/Year(2017) : ");
            ndy = Sc.next();
        }

        String valueNIQ = String.format("%d", niq);

        //handleFile fileObject = new handleFile();
        super.editFile(cmd, prID, nPrID, nic, valueNIQ, ndy, uId);

    }

    public static boolean validateJavaDate(String strDate) {
        /* Check if date is 'null' */
        if (strDate.trim().equals("")) {
            return true;
        } /* Date is not 'null' */ else {
            /*
	     * Set preferred date format,
	     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
            SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
            sdfrmt.setLenient(false);
            /* Create Date object
	     * parse the string into date 
             */
            try {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate + " is valid date format");
            } /* Date format is invalid */ catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            /* Return true if date format is valid */
            return true;
        }

    }
}
