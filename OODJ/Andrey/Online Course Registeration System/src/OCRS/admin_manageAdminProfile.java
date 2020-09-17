/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OCRS;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author audrey
 */
public class admin_manageAdminProfile extends javax.swing.JFrame {

    /**
     * Creates new form admin_manageAdminProfile
     */
    public admin_manageAdminProfile() {
        initComponents();
    }
    private String uname;
    
    public admin_manageAdminProfile(String uname) {
        initComponents();
        String[]temp;
        this.uname = uname;
        try {
            FileReader fr = new FileReader("Admin_Profile_DB.txt");
            BufferedReader br = new BufferedReader(fr);
            String reader;
            reader = br.readLine();
            while(reader.length()!=0) {
                temp = reader.split(",");
                if (uname.equals(temp[3])) {
                    nameText.setText(temp[0]);
                    idText.setText(temp[1]);
                    //if(temp[2].equals(designationCB.getSelectedItem()));
                    designationCB.setSelectedItem(temp[2]); 
                    unameText.setText(uname);
                    unameText.setEditable(false);
                    br.close();
                    fr.close();
                    return;
                }
                reader = br.readLine();
            }
        }
        catch(Exception f) {
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        unameText = new javax.swing.JTextField();
        designationCB = new javax.swing.JComboBox<>();
        idText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        masterText = new javax.swing.JPasswordField();
        backMainMenu = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("M Y   P R O F I L E ");

        jLabel2.setText("NAME");

        jLabel3.setText("ID");

        jLabel4.setText("Designation");

        jLabel5.setText("Username");

        jLabel6.setText("Master Code");

        designationCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Designation", "Administrative Assistant", "Administrative Coordinator", "Administrative Director", "Administrative Manager", " " }));

        backMainMenu.setText("Back to Main Menu");
        backMainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMainMenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMainMenuMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMainMenuMouseEntered(evt);
            }
        });

        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
        });

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("username can not be changed.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backMainMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(unameText, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(designationCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(idText, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(75, 75, 75)
                                .addComponent(masterText, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmButton)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backMainMenu)
                            .addComponent(back))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(designationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(unameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(masterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(confirmButton)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        admin_viewMyProfile vmp = new admin_viewMyProfile(uname);
        vmp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
        Font original = evt.getComponent().getFont();
        Map attributes = original.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        evt.getComponent().setFont(original.deriveFont(attributes));
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
        Font original = evt.getComponent().getFont();
        Map attributes = original.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        evt.getComponent().setFont(original.deriveFont(attributes));
    }//GEN-LAST:event_backMouseExited

    private void backMainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMainMenuMouseClicked
        // TODO add your handling code here:
        admin_mMenu m = new admin_mMenu(uname);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMainMenuMouseClicked

    private void backMainMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMainMenuMouseEntered
        // TODO add your handling code here:
        Font original = evt.getComponent().getFont();
        Map attributes = original.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        evt.getComponent().setFont(original.deriveFont(attributes));
    }//GEN-LAST:event_backMainMenuMouseEntered

    private void backMainMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMainMenuMouseExited
        // TODO add your handling code here:
        Font original = evt.getComponent().getFont();
        Map attributes = original.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        evt.getComponent().setFont(original.deriveFont(attributes));
    }//GEN-LAST:event_backMainMenuMouseExited

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
        String masterCode = "123";
        File oldFile = new File("Admin_Profile_DB.txt");
        File newTempfile = new File("temp_Admin_Profile_DB.txt");
        File replaceFile = new File("Admin_Profile_DB.txt");
        String[]temp;
        String oldStr, newStr;
        String line_sep = System.lineSeparator();
        String reader;
        
        String masCode = masterText.getText();
        String name = nameText.getText();
        String id = idText.getText();
        String designation = designationCB.getSelectedItem().toString();
        
        if (masCode.equals(masterCode)) {                        
            try { 
                FileWriter fw = new FileWriter(newTempfile, true);
                FileReader fr = new FileReader(oldFile);
                BufferedReader br = new BufferedReader(fr);
                reader = br.readLine();
                while(reader.length()!=0){
                    temp = reader.split(",");
                    if(uname.equals(temp[3])) {
                        if(!name.equals(temp[0])){
                            oldStr = temp[0];
                            newStr = name;
                            reader = reader.replaceAll(oldStr, newStr);                
                        }
                        if (!id.equals(temp[1])){
                            oldStr = temp[1];
                            newStr = id;
                            reader = reader.replaceAll(oldStr, newStr);
                        }
                        if (!designation.equals(temp[2])){
                           oldStr = temp[2];
                           newStr = designation;
                           reader = reader.replaceAll(oldStr, newStr);
                        }
                        fw.write(reader);
                        fw.write(line_sep);
                        reader = br.readLine();
                        if ("testnull".equals(reader)){
                        System.out.println("This should not occur, only to handle NullPointerException.");
                        }
                        else if (reader == null){
                        fw.close();
                        br.close();
                        fr.close();                        
                        break;                                
                        }
                        else{
                            continue;
                        }
                    }
                    fw.write(reader);
                    fw.write(line_sep);
                    reader = br.readLine();
                    if ("testnull".equals(reader)){
                        System.out.println("This should not occur, only to handle NullPointerException.");
                    }
                    else if (reader == null){
                        fw.close();
                        br.close();
                        fr.close();                        
                        break;                                
                    }              
                }                
//                    oldString += reader;     
            }
            catch(Exception f) {
                System.out.println(f);
                f.printStackTrace();
            }
            try{
                Files.deleteIfExists(Paths.get("Admin_Profile_DB.txt"));
                newTempfile.renameTo(replaceFile);
            }
            catch(NoSuchFileException e) 
            { 
                JOptionPane.showMessageDialog(null, "No such file/directory exists " + e);
            } 
            catch(DirectoryNotEmptyException e) 
            { 
                JOptionPane.showMessageDialog(null, "Directory is not empty " + e);
            } 
            catch(IOException e) 
            { 
                JOptionPane.showMessageDialog(null, "Invalid permissions " + e);
            }
            finally{
                JOptionPane.showMessageDialog(null,"You have successfully made changes.");
                admin_viewMyProfile vmp = new admin_viewMyProfile(uname);
                vmp.setVisible(true);
                this.dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Wrong master code, Re-enter MasterCode.");
            masterText.setText("");
            return;
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin_manageAdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_manageAdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_manageAdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_manageAdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_manageAdminProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel backMainMenu;
    private javax.swing.JButton confirmButton;
    private javax.swing.JComboBox<String> designationCB;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPasswordField masterText;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField unameText;
    // End of variables declaration//GEN-END:variables
}
