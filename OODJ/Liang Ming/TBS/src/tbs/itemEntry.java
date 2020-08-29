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

public class itemEntry extends handleFile {

    private String sMCmd;

    public itemEntry(String c) {
        this.sMCmd = c;
    }

    public void itemMenu() {
        itemEntry itemObject = new itemEntry(sMCmd);
        Scanner itemInput = new Scanner(System.in);
        String cmd = null;

        System.out.println("Please Select Your Command : ");
        System.out.println("1. Add Item\n2. Delete\n3. Edit");
        cmd = itemInput.nextLine();

        switch (cmd) {
            case "add":
                itemObject.addItem();
                break;

            case "delete":
                itemObject.deleteItem();
                break;

            case "edit":
                itemObject.editItem();
                break;

            default:
                System.out.println("Please Try Again");
        }

    }

    public void addItem() {
        Scanner inputItem = new Scanner(System.in);

        String itemCode, itemName, supplierID;
        int iQuantity;

        System.out.println("Please Enter Item Code : ");
        itemCode = inputItem.nextLine();

        System.out.println("Please Enter Item Name : ");
        itemName = inputItem.nextLine();

        System.out.println("Please Enter Supplier : ");
        supplierID = inputItem.nextLine();

        System.out.println("Please Enter Quantity : ");
        while (!inputItem.hasNextInt()) {
            inputItem.next();
            System.out.println("Please Insert Quantity In Number : ");
        }
        iQuantity = inputItem.nextInt();

        System.out.println("Do You Want to Save Your Record (y/n) : ");
        String yn = inputItem.next();

        switch (yn) {
            case "y":
                handleFile fileObject = new handleFile();
                super.addFile(sMCmd, itemCode, itemName, supplierID, iQuantity);
                break;

            default:
                return;
        }

    }

    public void deleteItem() {
        sMCmd = sMCmd + "_info.txt";

        Scanner Sc = new Scanner(System.in);
        String itemCodeToDelete;
        System.out.println("Enter Item Code to Delete : ");
        itemCodeToDelete = Sc.nextLine();

        //handleFile fileObject = new handleFile();
        System.out.println("Do You Want to Delete Your Record (y/n) : ");
        String yn = Sc.nextLine();

        switch (yn) {
            case "y":
                super.deleteFile(sMCmd, itemCodeToDelete);
                break;

            default:
                return;
        }

    }

    public void editItem() {
        sMCmd = sMCmd + "_info.txt";

        Scanner Sc = new Scanner(System.in);
        String itemCodeToEdit;
        String newItem;
        System.out.println("Enter Item Code For Edit : ");
        itemCodeToEdit = Sc.nextLine();

        System.out.print("New Item Name: ");
        String nin = Sc.nextLine();

        System.out.print("New Item Quantity: ");
        while (!Sc.hasNextInt()) {
            Sc.next();
            System.out.println("Please Insert New Quantity In Number : ");
        }
        int qu = Sc.nextInt();

        String valueQ = String.format("%d", qu);

        //handleFile fileObject = new handleFile();
        super.editFile(sMCmd, itemCodeToEdit, nin, valueQ);

    }
}
