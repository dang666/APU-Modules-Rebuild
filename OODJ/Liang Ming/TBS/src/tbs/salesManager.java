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

public class salesManager extends userLogin {

    private String userID;

    public salesManager(String ui) {
        this.userID = ui;
    }

    public void menu() {

        //userLogin ulObject = new userLogin();
        super.display();

        Scanner smMenuObject = new Scanner(System.in);
        String smMenuCmd;
        System.out.println("Please Select your Functionalities: ");
        System.out.println("Item Entry Enter item ");
        System.out.println("Supplier Entry Enter supplier ");
        System.out.println("Daily Item Wise Enter sales ");
        System.out.println("Purchase Requisition Enter purchase ");
        System.out.println("Display Purchase Requisition Enter display ");
        System.out.println("Display Purchase Order Enter po ");
        smMenuCmd = smMenuObject.next();
        itemEntry itemObject = new itemEntry(smMenuCmd);
        supplierEntry supplierObject = new supplierEntry();
        dailyItemWise salesObject = new dailyItemWise();
        purchaseRequisition purchaseRObject = new purchaseRequisition();
        list listObject = new list();
        switch (smMenuCmd) {
            case "item":
                itemObject.itemMenu();
                break;

            case "supplier":
                supplierObject.supplierMenu(smMenuCmd);
                break;

            case "sales":
                salesObject.salesMenu(smMenuCmd);
                break;

            case "purchase":
                purchaseRObject.menuPurchase(smMenuCmd, userID);
                break;

            case "display":
                listObject.listRequisition();
                break;

            case "po":
                listObject.listPO();
                break;

            default:
                System.out.println("Please Try Again");
        }

    }

    
}
