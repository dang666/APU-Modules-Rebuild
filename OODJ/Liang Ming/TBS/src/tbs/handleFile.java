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

public class handleFile {

    private String c;
    private String value1;
    private String value2;
    private String value3;
    private int quantity;

    public handleFile(String sMCmd, String itemCode, String itemName, String supplierID, int iQuantity) {
        this.c = sMCmd;
        this.value1 = itemCode;
        this.value2 = supplierID;
        this.value3 = supplierID;
        this.quantity = iQuantity;
    }

    public handleFile() {

    }
    //purchase requisition
    //overloading - changing no. of arguments

    public void addFile(String c, String value1, String value2, String value3, String value4, String uId) {
        try {
            //--BufferedReader read = null;
            //--BufferedWriter bWrite = null;
            BufferedWriter buffer = null;

            c = c + "_info.txt";

            String stringLine = null;

            BufferedReader readBuffer = new BufferedReader(new FileReader(c));
            while ((stringLine = readBuffer.readLine()) != null) {
                String token[] = stringLine.split(";");
                if (token[0].equals(value1)) {
                    System.out.println("Purchase ID have already exist, please try another one");
                    readBuffer.close();
                    return;
                }

            }

            FileInputStream fstream = new FileInputStream("item_info.txt");
            BufferedReader read = new BufferedReader(new InputStreamReader(fstream));
            StringBuilder fileContent = new StringBuilder();

            //--FileReader fstream = new FileReader("item_info.txt");
            //--read = new BufferedReader(new FileReader("item_info.txt"));
            //--read = new BufferedReader(new FileReader("item_info.txt"));
            String line;
            int ok = 0;
            //StringBuilder fileContent = new StringBuilder();

            while ((line = read.readLine()) != null) {
                System.out.println("The record : " + line);

                String data[] = line.split(";");

                //int itemQuanti = Integer.parseInt(data[3]);
                //int valueQuanti = Integer.parseInt(value3);
                System.out.println(data[0]);

                //while(itemQuanti < valueQuanti){
                //	System.out.println("Your Item Not Enough");
                //	read.close();
                //	return;
                //}
                if (value2.equals(data[0])) {

                    FileWriter file = new FileWriter("purchase_info.txt", true);

                    buffer = new BufferedWriter(file);

                    //System.out.println("Your Record is Exist");
                    buffer.newLine();
                    buffer.append(value1);
                    buffer.append(";");
                    buffer.append(value2);
                    buffer.append(";");
                    buffer.append(value3);
                    buffer.append(";");
                    buffer.append(value4);
                    buffer.append(";");
                    buffer.append(data[2]);
                    buffer.append(";");
                    buffer.append(uId);
                    buffer.append(";");
                    buffer.append("n");
                    buffer.append(";\n");

                    buffer.close();

                    System.out.println("Record Entry Procedure is Successfully");

                    //itemQuanti = itemQuanti - valueQuanti;
                    //String newData3 = data[3];
                    //newData3 = String.format("%d", itemQuanti);
                    //System.out.println(data[3]);
                    //String newLine = data[0] + ";" + data[1] + ";" + data[2] + ";"+ data[3] + ";"+ newData3 + ";";
                    //System.out.println("The record has changed : " +newLine);
                    //fileContent.append(newLine);
                    //fileContent.append("\n");
                    //System.out.println("Item Record has modified");
                    //--read.close();
                    //--FileInputStream fstream = new FileInputStream("item_code.txt");
                    //--BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                    //--out.write(fileContent.toString());
                    //--out.close();
                    //--read.close();
                    ok++;

                    //--return;		
                } else {
                    // update content as it is
                    fileContent.append(line);
                    fileContent.append("\n");

                }

            }
            //FileWriter out = new FileWriter("item_info.txt");
            //read.close();
            //--BufferedWriter out = new BufferedWriter(fstreamWrite);
            //out.write(fileContent.toString());
            //out.close();

            if (ok < 1) {
                System.out.println("Your Item does not exist. ");
            }

        } catch (IOException ex) {
            //Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed, Please Try Again");
        }

    }

    //item
    //overloading - changing no. of arguments
    public void addFile(String c, String value1, String value2, String value3, int quantity) {
                                System.out.println( value1 + ";" + value2 + ";" + value3 + ";" + quantity + ";");

        String line;
        
            try {
                //BufferedReader read = null;
                //BufferedWriter bWrite = null;
                

                c = c + "_info.txt";

                String stringLine = null;

                BufferedReader readBuffer = new BufferedReader(new FileReader("item_info.txt"));
                while ((stringLine = readBuffer.readLine()) != null) {
                    String token[] = stringLine.split(";");
                    if (token[0].equals(value1)) {
                        System.out.println("Item Code have already exist, please try another one");
                        readBuffer.close();
                        return;
                    }
                }

                FileInputStream fstream = new FileInputStream("supplier_info.txt");
                BufferedReader read = new BufferedReader(new InputStreamReader(fstream));
                StringBuilder fileContent = new StringBuilder();

                //FileReader fstream = new FileReader("item_info.txt");
                //read = new BufferedReader(new FileReader("item_info.txt"));
                //read = new BufferedReader(new FileReader("item_info.txt"));
                int ok = 0;
                FileWriter file = new FileWriter(c, true);
                BufferedWriter buffer = null;
                buffer = new BufferedWriter(file);
                //StringBuilder fileContent = new StringBuilder();
                String newData = String.format("%d", quantity);
                while ((line = read.readLine()) != null) {
                    if (line.equals("")) {
                        break;
                    }
                    System.out.println("The record : " + line);

                    String data[] = line.split(";");

                    if (value1.equals(data[2])) {

                    //System.out.println(data[2]);

                        //FileWriter file = new FileWriter(c, true);
                        String newLine = value1 + ";" + value2 + ";" + value3 + ";" + newData + ";";
                        //buffer = new BufferedWriter(file);
                           System.out.println("Record Entry Procedure is Successfully");
                        
                        
                        
                        //System.out.println("The record has changed : " + newLine);
                        System.out.println(newLine);

                        buffer.append(newLine);
                        buffer.append("\n");
                        //System.out.println("Your Record is Exist");
                        //buffer.newLine();
                        //buffer.append(value1);
                        //buffer.append(";");
                        //buffer.append(value2);
                        //buffer.append(";");
                        //buffer.append(value3);
                        //buffer.append(";");
                        //buffer.append(newData);
                        //buffer.append(";");
                    }
                        

                        
                        //System.out.println("Item Record has modified");

                        //--read.close();
                        //--FileInputStream fstream = new FileInputStream("item_code.txt");
                        //--BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                        //--out.write(fileContent.toString());
                        //--out.close();
                        //read.close();
                        //ok++;

                        //return;		
                     //else{
                        // update content as it is
                      //  buffer.append(line);
                      //  buffer.append("\n");

                    //}

                }
//                buffer.close();
                //FileWriter out = new FileWriter("item_info.txt");
                //--BufferedWriter out = new BufferedWriter(fstreamWrite);
               // out.write(fileContent.toString());
                //out.close();
                buffer.close();
                read.close();
                //System.out.println("test last  ");
//                if (ok < 1) {
//                    System.out.println("Your Item does pnot exist. ");
//                }

            } catch (IOException ex) {
                System.out.println("Failed, Try Again");
            }

            
    }

    //overloading - changing no. of arguments
    public void addFile(String c, String value1, String value2, String value3) {
        String line;
        try {

            BufferedReader read = null;
            //BufferedWriter bWrite = null;
            BufferedWriter buffer = null;

            read = new BufferedReader(new FileReader(c));

            FileWriter file = new FileWriter(c, true);

            buffer = new BufferedWriter(file);

            while ((line = read.readLine()) != null) {

                String data[] = line.split(";");

                while (value1.equals(data[0])) {
                    System.out.println("Your Record have already Exist");
                    read.close();
                    return;
                }

            }

            buffer.newLine();
            buffer.append(value1);
            buffer.append(";");
            buffer.append(value2);
            buffer.append(";");
            buffer.append(value3);
            buffer.append(";");

            buffer.close();
            System.out.println("Record Entry Procedure is Successfully");
        } catch (IOException ex) {
            //Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed, Please Try Again");
        }
    }

    public void deleteFile(String c, String deleteData) {

        try {
            File inFile = new File(c);
            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }
            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(c));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line;
            int ok = 0;
            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (!data[0].equals(deleteData)) {
                    pw.println(line);
                    pw.flush();
                } else if (data[0].equals(deleteData)) {
                    ok++;
                }

            }
            pw.close();
            br.close();

            if (ok < 1) {
                System.out.println("Data not exist");
            } else {
                System.out.println("Finish Delete Data Process");
            }

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                System.out.println("Could not rename file");
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // item overloading
    public void editFile(String c, String valueEdit, String value1, String value2) {

        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(c);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();

            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                //System.out.println("The record : " +strLine);
                String tokens[] = strLine.split(";");

                while (value1.equals(tokens[0])) {
                    System.out.println("Your Record have already Exist");
                    br.close();
                    return;
                }

                if (tokens.length > 0) {
                    // Here tokens[0] will have value of ID

                    if (tokens[0].equals(valueEdit)) {
                        if (!tokens[0].equals(value1)) {
                            tokens[1] = value1;
                        } else {
                            System.out.println("Your Item Code records has already exist");
                            br.close();
                            return;
                        }

                        //if(tokens[0].equals(nin))
                        
                        tokens[3] = value2;

                        System.out.println("The before record changed : " + strLine);
                        String newLine = tokens[0] + ";" + tokens[1] + ";" + tokens[2] + ";" + tokens[3] + ";";
                        System.out.println("The record has changed : " + newLine);
                        fileContent.append(newLine);
                        fileContent.append("\n");
                    } else {
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");

                    }
                }

            }
            // Now fileContent will have updated content , which you can override into file

            FileWriter fstreamWrite = new FileWriter(c);
            //Close the input stream
            br.close();

            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();

        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    //overloading dailyItemWise
    public void addItemToFile(String c, String value1, String value2, String value3) {
        String line, sQuanti;

        try {
            //BufferedReader read = null;
            //BufferedWriter bWrite = null;
            BufferedWriter buffer = null;

            c = c + "_info.txt";

            String stringLine = null;

            BufferedReader readBuffer = new BufferedReader(new FileReader(c));
            while ((stringLine = readBuffer.readLine()) != null) {
                String token[] = stringLine.split(";");
                if (token[0].equals(value1)) {
                    System.out.println("Sales ID have already exist, please try another one");
                    readBuffer.close();
                    return;
                }

            }

            FileInputStream fstream = new FileInputStream("item_info.txt");
            BufferedReader read = new BufferedReader(new InputStreamReader(fstream));
            StringBuilder fileContent = new StringBuilder();

            //FileReader fstream = new FileReader("item_info.txt");
            //read = new BufferedReader(new FileReader("item_info.txt"));
            //read = new BufferedReader(new FileReader("item_info.txt"));
            int ok = 0;
            //StringBuilder fileContent = new StringBuilder();

            while ((line = read.readLine()) != null) {
                //System.out.println("The record : " + line);

                String data[] = line.split(";");

                if (value2.equals(data[0])) {

                    int itemQuanti = Integer.parseInt(data[3]);
                    int valueQuanti = Integer.parseInt(value3);

                    System.out.println(data[0]);

                    while (itemQuanti < valueQuanti) {
                        System.out.println("Your Item Not Enough");
                        read.close();
                        return;
                    }

                    FileWriter file = new FileWriter(c, true);

                    buffer = new BufferedWriter(file);

                    System.out.println("Your Record is Exist");
                    buffer.newLine();
                    buffer.append(value1);
                    buffer.append(";");
                    buffer.append(value2);
                    buffer.append(";");
                    buffer.append(value3);
                    buffer.append(";");

                    buffer.close();

                    System.out.println("Record Entry Procedure is Successfully");

                    itemQuanti = itemQuanti - valueQuanti;
                    String newData3 = data[3];
                    newData3 = String.format("%d", itemQuanti);
                    System.out.println(data[3]);
                    String newLine = data[0] + ";" + data[1] + ";" + data[2] + ";" + newData3 + ";";
                    System.out.println("The record has changed : " + newLine);
                    fileContent.append(newLine);
                    fileContent.append("\n");
                    System.out.println("Item Record has modified");

                    //--read.close();
                    //--FileInputStream fstream = new FileInputStream("item_code.txt");
                    //--BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                    //--out.write(fileContent.toString());
                    //--out.close();
                    //read.close();
                    ok++;

                    //return;		
                } else {
                    // update content as it is
                    fileContent.append(line);
                    fileContent.append("\n");

                }

            }
            FileWriter out = new FileWriter("item_info.txt");
            read.close();
            //--BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();

            if (ok < 1) {
                System.out.println("Your Item does not exist. ");
            }

        } catch (IOException ex) {
            System.out.println("Failed, Try Again");
        }

    }

    //sales
    public void editItemToFile(String c, String valueEdit, String value1, String value2, String value3) {

        try {

            FileInputStream ifstream = new FileInputStream("item_info.txt");
            BufferedReader read = new BufferedReader(new InputStreamReader(ifstream));
            String line;
            int i = 0;
            while ((line = read.readLine()) != null) {
                String data[] = line.split(";");
                if (value2.equals(data[0])) {
                    i++;
                    break;
                } else {
                    i = 0;
                }
            }
            read.close();

            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(c);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();

            if (i > 0) { //exist
                //Read File Line By Line
                while ((strLine = br.readLine()) != null) {
                    // Print the content on the console
                    //System.out.println("The record : " + strLine);
                    String tokens[] = strLine.split(";");

                    while (value1.equals(tokens[0])) {
                        System.out.println("Your Record have already Exist");
                        br.close();
                        return;
                    }

                    if (tokens.length > 0) {
                        // Here tokens[0] will have value of ID

                        if (tokens[0].equals(valueEdit)) {
                            if (!tokens[0].equals(value1)) {
                                tokens[0] = value1;
                            } else {
                                System.out.println("Your Item Code records has already exist");
                                br.close();
                                return;
                            }

                            //if(tokens[0].equals(nin))
                            tokens[1] = value2;

                            //if(tokens[2].equals(nsn))
                            tokens[2] = value3;

                            System.out.println("The before record change : " + strLine);
                            String newLine = tokens[0] + ";" + tokens[1] + ";" + tokens[2] + ";";
                            System.out.println("The record has changed : " + newLine);
                            fileContent.append(newLine);
                            fileContent.append("\n");
                        } else {
                            // update content as it is
                            fileContent.append(strLine);
                            fileContent.append("\n");
                        }
                    }

                }
            } else {
                System.out.println("Your Item Code doesn't exist");
                return;
            }
            // Now fileContent will have updated content , which you can override into file

            FileWriter fstreamWrite = new FileWriter(c);
            //Close the input stream
            br.close();

            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();

        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    // overloading supplier
    public void editFile(String c, String valueEdit, String value1, String value2, String value3) {

        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(c);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                //System.out.println("The record : " +strLine);
                String tokens[] = strLine.split(";");

                while (value1.equals(tokens[0])) {
                    System.out.println("Your Record have already Exist");
                    br.close();
                    return;
                }

                if (tokens.length > 0) {
                    // Here tokens[0] will have value of ID

                    if (tokens[0].equals(valueEdit)) {
                        if (!tokens[0].equals(value1)) {
                            tokens[0] = value1;
                        } else {
                            System.out.println("Your Item Code records has already exist");
                            br.close();
                            return;
                        }

                        //if(tokens[0].equals(nin))
                        tokens[1] = value2;

                        //if(tokens[2].equals(nsn))
                        tokens[2] = value3;

                        System.out.println("The before record changed : " + strLine);
                        String newLine = tokens[0] + ";" + tokens[1] + ";" + tokens[2] + ";";
                        System.out.println("The record has changed : " + newLine);
                        fileContent.append(newLine);
                        fileContent.append("\n");
                    } else {
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");

                    }
                }

            }
            // Now fileContent will have updated content , which you can override into file

            FileWriter fstreamWrite = new FileWriter(c);
            //Close the input stream
            br.close();

            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();

        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    //purchase requisition
    public void editFile(String c, String valueEdit, String value1, String value2, String value3, String value4, String u) {
        //fileObject.editFile(cmd, prID, nPrID, nic, valueNIQ, valueNDY, valueNDM, valueNDD);

        try {

            FileInputStream ifstream = new FileInputStream("item_info.txt");
            BufferedReader read = new BufferedReader(new InputStreamReader(ifstream));
            String line;
            int i = 0;
            int j = 0;
            String itemSupplier = null;
            while ((line = read.readLine()) != null) {
                String data[] = line.split(";");
                if (value2.equals(data[0])) {
                    i++;
                    //		System.out.println("value 2 : "+value2);
                    itemSupplier = data[2];
                } else {
                    j = 0;
                }

            }
            read.close();

            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(c);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();

            if (i > 0) {
                //Read File Line By Line
                while ((strLine = br.readLine()) != null) {
                    // Print the content on the console
                    //System.out.println("The record : " +strLine);
                    String tokens[] = strLine.split(";");

                    while (value1.equals(tokens[0])) {
                        System.out.println("Your Record have already Exist");
                        br.close();
                        return;
                    }

                    if (tokens.length > 0) {
                        // Here tokens[0] will have value of ID

                        if (tokens[0].equals(valueEdit)) {
                            if (!tokens[0].equals(value1)) {
                                tokens[0] = value1;
                            } else {
                                System.out.println("Your Item Code records has already exist");
                                br.close();
                                return;
                            }

                            tokens[0] = value1;

                            //if(tokens[0].equals(nin))
                            tokens[1] = value2;

                            //if(tokens[2].equals(nsn))
                            tokens[2] = value3;

                            tokens[3] = value4;

                            tokens[4] = itemSupplier;

                            tokens[5] = u;

                            tokens[6] = "n";

                            System.out.println("The record has : " + strLine);
                            String newLine = tokens[0] + ";" + tokens[1] + ";" + tokens[2] + ";" + tokens[3] + ";" + tokens[4] + ";" + tokens[5] + ";" + tokens[6] + ";";
                            System.out.println("The record has changed : " + newLine);
                            fileContent.append(newLine);
                            fileContent.append("\n");
                        } else if (j == 0) {
                            // update content as it is
                            fileContent.append(strLine);
                            fileContent.append("\n");

                        }
                    }

                }
            } else {
                System.out.println("Your Item Code doesn't exist");
                return;
            }
            // Now fileContent will have updated content , which you can override into file

            FileWriter fstreamWrite = new FileWriter(c);
            //Close the input stream
            br.close();

            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();

        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

}
