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

public class list {
    public void listItem(){
			try{
			FileReader file = new FileReader("item_info.txt");
			BufferedReader buffer = new BufferedReader(file);
			String line = "";
			
			while((line = buffer.readLine()) != null){
			String[] tokens = line.split(";");
				if(tokens.length>1){
			System.out.println("Item Code : "+tokens[0]);
			System.out.println("Item Name : "+tokens[1]);
			System.out.println("Supplier ID : "+tokens[2]);
			System.out.println("Item Quantity : "+tokens[3]);
			System.out.println("\n");
				}
			}
			buffer.close();
			
			}
		catch(IOException e){
			System.out.println("A read error as occured. ");
			
		}
			
		}
		
		
		public void listSupplier(){
			try{
			FileReader file = new FileReader("supplier_info.txt");
			BufferedReader buffer = new BufferedReader(file);
			String line = "";
			
			while((line = buffer.readLine()) != null){
				String[] tokens = line.split(";");
				if(tokens.length>1){
			System.out.println("Supplier ID : "+tokens[0]);
			System.out.println("Supplier Name : "+tokens[1]);
			System.out.println("Item Code : "+tokens[2]);
			System.out.println("\n");
				}
			}
			buffer.close();
			
			}
		catch(IOException e){
			System.out.println("A read error as occured. ");
			
		}
			
		}
		
		
		
		public void listRequisition(){
			try{
			FileReader file = new FileReader("purchase_info.txt");
			BufferedReader buffer = new BufferedReader(file);
			String line = "";
			
			while((line = buffer.readLine()) != null){
				String[] tokens = line.split(";");
				if(tokens.length>1){
			System.out.println("Purchase Requisition ID : "+tokens[0]);
			System.out.println("Item Code : "+tokens[1]);
			System.out.println("Quantity : "+tokens[2]);
			System.out.println("Date : "+tokens[3]);
			System.out.println("Supplier ID : "+tokens[4]);
			System.out.println("User ID : " +tokens[5]);
			System.out.println("\n");
				}
			}
			buffer.close();
			
			}
		catch(IOException e){
			System.out.println("A read error as occured. ");
			
		}
			
		}
                
                public void listPO(){
			try{
			FileReader file = new FileReader("purchase_info.txt");
			BufferedReader buffer = new BufferedReader(file);
			String line = "";
			
			while((line = buffer.readLine()) != null){
				String[] tokens = line.split(";");
				if(tokens.length>1){
			System.out.println("Purchase Requisition ID : "+tokens[0]);
			System.out.println("Item Code : "+tokens[1]);
			System.out.println("Quantity : "+tokens[2]);
			System.out.println("Date : "+tokens[3]);
			System.out.println("Supplier ID : "+tokens[4]);
			System.out.println("User ID : " +tokens[5]);
                        System.out.println("Approved or Rejected : "+tokens[6]);
			System.out.println("\n");
				}
			}
			buffer.close();
			
			}
		catch(IOException e){
			System.out.println("A read error as occured. ");
			
		}
			
		}
}
