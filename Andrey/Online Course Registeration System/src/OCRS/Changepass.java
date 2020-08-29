/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OCRS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan Low
 */
public class Changepass extends javax.swing.JFrame {

    /**
     * Creates new form Stud_changepass
     */
    public Changepass() {
        initComponents();
    }
    public Changepass(String uname, String page, String profile) {     
        initComponents();
        String[] temp;
        try{
            if(profile.equals("Student")){
                FileReader fr = new FileReader("Student_Profile_DB.txt");
                BufferedReader br = new BufferedReader(fr);
                String reader;
                reader = br.readLine();
                while (reader.length() != 0) {
                    temp = reader.split(",");
                    if (uname.equals(temp[4])) {
                        page_lbl.setText(page);
                        page_lbl.setVisible(false);
                        profile_lbl.setText(profile);
                        profile_lbl.setVisible(false);
                        usr_lbl.setText(uname);
                        sec_quest_lbl.setText(temp[6]);
                        br.close();
                        fr.close();                    
                        return;
                    }
                    reader = br.readLine();
                    if ("testnull".equals(reader)){
                        System.out.println("This should not occur, only to handle NullPointerException.");
                    }
                    else{
                        if(reader == null){
                            br.close();
                            fr.close();                        
                            return;
                        }
                    }                
                }
            }
            else{
                FileReader fr = new FileReader("Admin_Profile_DB.txt");
                BufferedReader br = new BufferedReader(fr);
                String reader;
                reader = br.readLine();
                while (reader.length() != 0) {
                    temp = reader.split(",");
                    if (uname.equals(temp[3])) {
                        page_lbl.setText(page);
                        page_lbl.setVisible(false);
                        profile_lbl.setText(profile);
                        profile_lbl.setVisible(false);                        
                        usr_lbl.setText(uname);
                        sec_quest_lbl.setText(temp[5]);
                        br.close();
                        fr.close();                    
                        return;
                    }
                    reader = br.readLine();
                    if ("testnull".equals(reader)){
                        System.out.println("This should not occur, only to handle NullPointerException.");
                    }
                    else{
                        if(reader == null){
                            br.close();
                            fr.close();                        
                            return;
                        }
                    }                
                }                
            }
        } catch (Exception f) {
            JOptionPane.showMessageDialog(null, "System error" + f);
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

        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usr_lbl = new javax.swing.JLabel();
        sec_quest_lbl = new javax.swing.JLabel();
        sec_ans_f = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        newpass_f = new javax.swing.JPasswordField();
        newpass_conf_f = new javax.swing.JPasswordField();
        res_pass_b = new javax.swing.JButton();
        cancel_b = new javax.swing.JButton();
        page_lbl = new javax.swing.JLabel();
        profile_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel13.setText("Password must be at least 8 characters long and");

        jLabel1.setText("Please answer the security question and enter new password to reset.");

        jLabel15.setText("contain at least 1 numeric character.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PASSWORD RESET");

        usr_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usr_lbl.setText("(Username will be replaced here)");
        usr_lbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        sec_quest_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sec_quest_lbl.setText("(Security Question will be replaced here depending on User)");
        sec_quest_lbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setText("New Password:");

        jLabel5.setText("Confirm New Password:");

        res_pass_b.setText("Reset");
        res_pass_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                res_pass_bActionPerformed(evt);
            }
        });

        cancel_b.setText("Cancel");
        cancel_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_bActionPerformed(evt);
            }
        });

        page_lbl.setText("(placeholder for pagel)");

        profile_lbl.setText("(placeholder for profile)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(newpass_f, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(newpass_conf_f, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(res_pass_b)
                        .addGap(10, 10, 10)
                        .addComponent(cancel_b)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(profile_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(page_lbl)
                .addGap(20, 20, 20))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(usr_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sec_quest_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sec_ans_f, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profile_lbl)
                    .addComponent(page_lbl))
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usr_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addComponent(sec_quest_lbl)
                .addGap(11, 11, 11)
                .addComponent(sec_ans_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(newpass_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel13)
                .addGap(0, 0, 0)
                .addComponent(jLabel15)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(newpass_conf_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(res_pass_b)
                    .addComponent(cancel_b))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void res_pass_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_res_pass_bActionPerformed
        String uname, sec_ans, newpass, newpass_conf, profile = profile_lbl.getText();
        String[] temp;
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");

        sec_ans = sec_ans_f.getText();
        newpass = newpass_f.getText();
        newpass_conf = newpass_conf_f.getText();

        if (sec_ans.length() == 0){
            JOptionPane.showMessageDialog(null, "Please answer the security question.");
            newpass_f.setText("");
            newpass_conf_f.setText("");
            return;
        } else if (newpass.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a Password.");
            newpass_f.setText("");
            newpass_conf_f.setText("");
            return;
        } else if (newpass.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password has to be at least 8 characters long.");
            newpass_f.setText("");
            newpass_conf_f.setText("");
            return;
        } else if (!digitCasePatten.matcher(newpass).find()) {
            JOptionPane.showMessageDialog(null, "Password has to have at least 1 numeric character.");
            newpass_f.setText("");
            newpass_conf_f.setText("");
            return;
        }

        try {
            if(profile.equals("Student")){
                FileReader fr = new FileReader("Student_Profile_DB.txt");
                BufferedReader br = new BufferedReader(fr);
                String reader, oldpass;
                uname = usr_lbl.getText();
                reader = br.readLine();
                while (reader.length() != 0) {
                    temp = reader.split(",");
                    if (uname.equals(temp[4]) && sec_ans.equals(temp[7])) {
                        if (newpass.equals(newpass_conf)){
                            oldpass = temp[5];
                            br.close();
                            fr.close();
                            Modify_Files mf = new Modify_Files();
                            mf.replaceStudPass(uname, oldpass, newpass);
                            JOptionPane.showMessageDialog(null, "Password have been replaced successfully");
                            if (page_lbl.getText().equals("lp")){
                                Login_Page lp = new Login_Page();
                                lp.setVisible(true);
                                this.dispose();
                                return;
                            }
                            else{
                                Stud_vProfile svp = new Stud_vProfile(uname);
                                svp.setVisible(true);
                                this.dispose();
                                return;
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Password confirmation does not match, please try again.");
                            newpass_f.setText("");
                            newpass_conf_f.setText("");
                            br.close();
                            fr.close();
                            return;
                        }
                    }
                    else if (uname.equals(temp[4]) && !sec_ans.equals(temp[7])){
                        JOptionPane.showMessageDialog(null, "Answer for security question is incorrect, please try again.");
                        sec_ans_f.setText("");
                        newpass_f.setText("");
                        newpass_conf_f.setText("");
                        br.close();
                        fr.close();
                        return;
                    }
                    reader = br.readLine();
                    if ("testnull".equals(reader)){
                        System.out.println("This should not occur, only to handle NullPointerException.");
                    }
                    else{
                        //If username does not match from database, promt for registration
                        if (reader == null){
                            br.close();
                            fr.close();                        
                            return;
                        }                                 
                    }                 
                }
            }
            else{
                FileReader fr = new FileReader("Admin_Profile_DB.txt");
                BufferedReader br = new BufferedReader(fr);
                String reader, oldpass;
                uname = usr_lbl.getText();
                reader = br.readLine();
                while (reader.length() != 0) {
                    temp = reader.split(",");
                    if (uname.equals(temp[3]) && sec_ans.equals(temp[6])) {
                        if (newpass.equals(newpass_conf)){
                            oldpass = temp[4];
                            br.close();
                            fr.close();
                            Modify_Files mf = new Modify_Files();
                            mf.replaceAdminPass(uname, oldpass, newpass);
                            JOptionPane.showMessageDialog(null, "Password have been replaced successfully");
                            if (page_lbl.getText().equals("lp")){
                                Login_Page lp = new Login_Page();
                                lp.setVisible(true);
                                this.dispose();
                                return;
                            }
                            else{
                                admin_viewMyProfile svp = new admin_viewMyProfile(uname);
                                svp.setVisible(true);
                                this.dispose();
                                return;
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Password confirmation does not match, please try again.");
                            newpass_f.setText("");
                            newpass_conf_f.setText("");
                            br.close();
                            fr.close();
                            return;
                        }
                    }
                    else if (uname.equals(temp[4]) && !sec_ans.equals(temp[7])){
                        JOptionPane.showMessageDialog(null, "Answer for security question is incorrect, please try again.");
                        sec_ans_f.setText("");
                        newpass_f.setText("");
                        newpass_conf_f.setText("");
                        br.close();
                        fr.close();
                        return;
                    }
                    reader = br.readLine();
                    if ("testnull".equals(reader)){
                        System.out.println("This should not occur, only to handle NullPointerException.");
                    }
                    else{
                        //If username does not match from database, promt for registration
                        if (reader == null){
                            br.close();
                            fr.close();                        
                            return;
                        }                                 
                    }                 
                }                
            }
        } catch (Exception reg) {
            JOptionPane.showMessageDialog(null, "System error " + reg);
        }
    }//GEN-LAST:event_res_pass_bActionPerformed

    private void cancel_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_bActionPerformed
        if (page_lbl.getText().equals("lp")){
            Login_Page lp = new Login_Page();
            lp.setVisible(true);
            this.dispose();
            return;
        }
        else{
            Stud_vProfile svp = new Stud_vProfile(usr_lbl.getText());
            svp.setVisible(true);
            this.dispose();
            return;
        }
    }//GEN-LAST:event_cancel_bActionPerformed

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
            java.util.logging.Logger.getLogger(Changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Changepass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_b;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField newpass_conf_f;
    private javax.swing.JPasswordField newpass_f;
    private javax.swing.JLabel page_lbl;
    private javax.swing.JLabel profile_lbl;
    private javax.swing.JButton res_pass_b;
    private javax.swing.JTextField sec_ans_f;
    private javax.swing.JLabel sec_quest_lbl;
    private javax.swing.JLabel usr_lbl;
    // End of variables declaration//GEN-END:variables
}