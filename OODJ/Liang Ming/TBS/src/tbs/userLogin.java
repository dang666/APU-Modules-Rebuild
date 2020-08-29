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

public abstract class userLogin {

    protected String userID;
    protected String userPass;

    public abstract void menu();

    public void display() {
        System.out.println("-----------------------------------------\nLogin Successfully\nAccess Granted\n-----------------------------------------\n");

    }

    public void smMenu() {
        System.out.println("Nothing");
    }

    public void pmMenu(String UserID) {
        System.out.println("Nothing");
    }
}
