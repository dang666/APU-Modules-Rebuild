/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OCRS;

/**
 *
 * @author BryanL
 */
public class Receipt_Num_Generator {
    // function to generate at random, a receipt of 8 character length.
    public String getReceiptNumber() 
    { 
        int length = 8;
        // Declaring variable containing all Alpha Numeric variations.
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz"; 
  
        // Create a StringBuilder for receipt number with size of 8 characters
        StringBuilder sb = new StringBuilder(length); 
        
        // Build the receipt number until it reaches 8 characters.
        for (int i = 0; i < length; i++) { 
  
            // Generate a random index number within the length size of AlphaNumericString.
            int index = (int)(AlphaNumericString.length() * Math.random()); 
  
            // Add character one by one at the end of receipt number.
            sb.append(AlphaNumericString.charAt(index)); 
        } 
  
        return sb.toString(); 
    }     
}
