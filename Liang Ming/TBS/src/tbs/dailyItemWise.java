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

public class dailyItemWise extends handleFile {

    public void salesMenu(String sCmd) {
        dailyItemWise salesObject = new dailyItemWise();
        Scanner itemInput = new Scanner(System.in);
        String cmd = null;

        System.out.println("Please Select Your Command : ");
        System.out.println("1. Add Sales\n2. Delete\n3. Edit");
        cmd = itemInput.next();

        switch (cmd) {
            case "add":
                salesObject.addSales(sCmd);
                break;

            case "delete":
                salesObject.deleteSales(sCmd);
                break;

            case "edit":
                salesObject.editSales(sCmd);
                break;

            default:
                System.out.println("Please Try Again");
        }

    }

    public void addSales(String cmd) {

        Scanner dailyItemObject = new Scanner(System.in);
        String item, yn, salesID;
        int quantity;

        System.out.println("Please Insert Your Sales ID : ");
        salesID = dailyItemObject.nextLine();

        System.out.println("Please Insert Your Item : ");
        item = dailyItemObject.nextLine();

        System.out.println("Please Insert Your Quantity of the Item");
        while (!dailyItemObject.hasNextInt()) {
            System.out.print("Your Input Is Not A Number, Try Again To Input Number");
            dailyItemObject.next();
        }

        quantity = dailyItemObject.nextInt();

        System.out.println("Do You Want to Save Your Record (y/n) : ");
        yn = dailyItemObject.next();

        String sQ = String.format("%d", quantity);

        switch (yn) {
            case "y":
                //1dailyItemWise dailyObject = new dailyItemWise();
                //dailyObject.addItemToFile(cmd, salesID, item, sQ);
                //1dailyObject.addItemToFile(cmd, salesID, item, sQ);
                super.addItemToFile(cmd, salesID, item, sQ);
                break;
            default:
                return;
        }

    }

    public void deleteSales(String cmd) {
        cmd = cmd + "_info.txt";

        Scanner Sc = new Scanner(System.in);
        String itemCodeToDelete;
        System.out.println("Enter Sales ID to Delete : ");
        itemCodeToDelete = Sc.nextLine();

        System.out.println("Do You Want to Delete Your Record (y/n) : ");
        String yn = Sc.nextLine();

        switch (yn) {
            case "y":
                //handleFile fileObject = new handleFile();
                super.deleteFile(cmd, itemCodeToDelete);
                break;
            default:
                return;
        }

    }

    public void editSales(String cmd) {
        cmd = cmd + "_info.txt";
        Scanner Sc = new Scanner(System.in);
        String itemCodeToEdit;
        String newItem;
        System.out.println("Enter Sales ID For Edit : ");
        itemCodeToEdit = Sc.nextLine();

        System.out.print("New Sales ID : ");
        String si;
        si = Sc.nextLine();

        System.out.print("New Item Code : ");
        String nic = Sc.nextLine();
        int qu;
        System.out.print("New Item Quantity: ");
        while (!Sc.hasNextInt()) {
            System.out.println("Your Input Is Not A Number, Please Input Again for Nem Item Quantity : ");
            qu = Sc.nextInt();

        }
        qu = Sc.nextInt();
        String valueQ = String.format("%d", qu);

        //dailyItemWise fileEditObject = new dailyItemWise();
        //fileEditObject.editItemToFile(cmd, itemCodeToEdit, si, nic, valueQ);
        super.editItemToFile(cmd, itemCodeToEdit, si, nic, valueQ);

    }

}
