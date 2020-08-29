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

public class supplierEntry extends handleFile {

    public void supplierMenu(String cmd) {
        supplierEntry supplierObject = new supplierEntry();
        Scanner supplierInput = new Scanner(System.in);
        String cmdS = null;

        System.out.println("Please Select Your Command : ");
        System.out.println("1. Add Supplier\n2. Delete\n3. Edit");
        cmdS = supplierInput.next();

        switch (cmdS) {
            case "add":
                supplierObject.addSupplier(cmd);
                break;

            case "delete":
                supplierObject.deleteSupplier(cmd);
                break;

            case "edit":
                supplierObject.editSupplier(cmd);
                break;

            default:
                System.out.println("Please Try Again");
        }

    }

    public void addSupplier(String cmd) {
        String supplierCode, supplierName, itemID;
        String cmdSupplier;
        String line;
        int sQuantity;

        Scanner inputSupplier = new Scanner(System.in);
        cmd = cmd + "_info.txt";

        System.out.println("Please Enter Supplier Code : ");
        supplierCode = inputSupplier.next();

        System.out.println("Please Enter Supplier Name : ");
        supplierName = inputSupplier.next();

        System.out.println("Please Enter Item ID : ");
        itemID = inputSupplier.next();

        System.out.println("Do You Want to Save Your Record (y/n) : ");
        String yn = inputSupplier.next();

        switch (yn) {
            case "y":
                //handleFile fileObject = new handleFile();
                super.addFile(cmd, supplierCode, supplierName, itemID);
                break;

            default:
                return;
        }

    }

    public void deleteSupplier(String cmd) {
        cmd = cmd + "_info.txt";

        Scanner Sc = new Scanner(System.in);
        String supplierCodeToDelete;
        System.out.println("Enter Supplier Code to Delete : ");
        supplierCodeToDelete = Sc.next();

        System.out.println("Do You Want to Delete Your Record (y/n) : ");
        String yn = Sc.next();

        switch (yn) {
            case "y":
                //handleFile fileObject = new handleFile();
                super.deleteFile(cmd, supplierCodeToDelete);
                break;

            default:
                return;
        }

    }

    public void editSupplier(String cmd) {
        cmd = cmd + "_info.txt";

        Scanner Sc = new Scanner(System.in);
        String supplierCodeToEdit;
        String newItem;
        System.out.println("Enter Supplier Code For Edit : ");
        supplierCodeToEdit = Sc.next();

        System.out.print("New Supplier Code : ");
        String nsc;
        nsc = Sc.next();

        System.out.print("New Supplier Name: ");
        String nin = Sc.next();

        System.out.print("New Item ID: ");
        String nii = Sc.next();

        System.out.println("Do You Want to Save Your Record (y/n) : ");
        String yn = Sc.next();

        switch (yn) {
            case "y":
                //handleFile fileObject = new handleFile();
                super.editFile(cmd, supplierCodeToEdit, nsc, nin, nii);
                break;

            default:
                return;
        }

    }
}
