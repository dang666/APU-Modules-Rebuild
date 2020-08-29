/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OCRS;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author BryanL
 */
public class Stud_enrollcourse extends javax.swing.JFrame {

    /**
     * Creates new form Stud_enrollcourse
     */
    public Stud_enrollcourse() {
        initComponents();
    }
    public Stud_enrollcourse(String uname, String courses, String page) {
        initComponents();
        String[] temp;
        String[] course;
        String reader;
        try{
            FileReader fr = new FileReader("Student_Profile_DB.txt");
            BufferedReader br = new BufferedReader(fr);
            reader = br.readLine();
            while (reader.length() != 0) {
                temp = reader.split(",");
                if (uname.equals(temp[4])) {
                    page_lbl.setText(page);
                    page_lbl.setVisible(false);
                    usr_lbl.setText(uname);
                    lvl_lbl.setText(temp[3]);
                    br.close();
                    fr.close();                    
                    break;
                }
                reader = br.readLine();
                if ("testnull".equals(reader)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }
                else{
                    if(reader == null){
                        br.close();
                        fr.close();                        
                        break;
                    }
                }                
            }
        }
        catch (Exception f) {
            JOptionPane.showMessageDialog(null, "Error setting labels " + f);
        }
        
        String lvl = lvl_lbl.getText();
        try{
            FileReader fr2 = new FileReader ("Course_List.txt");
            BufferedReader br2 = new BufferedReader(fr2);
            reader = br2.readLine();
            if ("testnull".equals(reader)){
                System.out.println("This should not occur, only to handle NullPointerException.");
            }
            else{
                if (reader == null){
                    br2.close();
                    fr2.close();
                }
                else{
                    while (reader.length() != 0) {
                        temp = reader.split(",");
                        if (lvl.equals(temp[2])){
                            course_s.addItem(temp[0]);
                        }
                        reader = br2.readLine();
                        if ("testnull".equals(reader)){
                            System.out.println("This should not occur, only to handle NullPointerException.");
                        }
                        else if(reader == null){
                            br2.close();
                            fr2.close();
                            break;
                        }                        
                    }
                }
            }
        }
        catch (Exception f) {
            JOptionPane.showMessageDialog(null, "Error parsing course selector " + f);
        } 
        
        if(!courses.equals("")){
            course = courses.split(",");
            int course_size = course.length;
            try{
                FileReader fr2 = new FileReader ("Course_List.txt");
                BufferedReader br2 = new BufferedReader(fr2);
                reader = br2.readLine();
                int i = 0, j = 0;
                if ("testnull".equals(reader)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }
                else{
                    if (reader == null){
                        br2.close();
                        fr2.close();
                        return;
                    }
                    else{
                        while (reader.length() != 0) {
                            temp = reader.split(",");
                            for (int k = 0;k < course_size;k++){
                                if (course[k].equals(temp[1])) {
                                    course_t.setValueAt(temp[0], i, j);
                                    course_t.setValueAt(temp[1], i, j+1);
                                    i++;
                                }
                            }
                            reader = br2.readLine();
                            if ("testnull".equals(reader)){
                                System.out.println("This should not occur, only to handle NullPointerException.");
                            }
                            else if(reader == null){
                                br2.close();
                                fr2.close();
                                break;
                            }
                        }
                    }
                }                
            }
            catch (Exception f) {
                JOptionPane.showMessageDialog(null, "Error listing course selection " + f);
            }                
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        course_t = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lvl_lbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        usr_lbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        course_s = new javax.swing.JComboBox<>();
        proc_b = new javax.swing.JButton();
        reset_b = new javax.swing.JButton();
        back_b = new javax.swing.JButton();
        page_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ENROLL COURSES");

        course_t.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"No courses selected yet", " "},
                {" ", " "},
                {" ", " "},
                {" ", " "},
                {" ", " "},
                {" ", " "},
                {" ", " "},
                {" ", " "}
            },
            new String [] {
                "Course", "Course Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(course_t);

        jLabel6.setText("Username:");

        jLabel5.setText("Selected courses:");

        lvl_lbl.setText("(Level will be replaced here)");

        jLabel10.setText("Level:");

        usr_lbl.setText("(Username will be replaced here)");

        jLabel2.setText("Select Course:");

        course_s.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));
        course_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_sActionPerformed(evt);
            }
        });

        proc_b.setText("Proceed");
        proc_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proc_bActionPerformed(evt);
            }
        });

        reset_b.setText("Reset");
        reset_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_bActionPerformed(evt);
            }
        });

        back_b.setText("Back");
        back_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_bActionPerformed(evt);
            }
        });

        page_lbl.setText("(placeholder for page)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lvl_lbl)
                    .addComponent(usr_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(course_s, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(proc_b, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(reset_b, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(back_b, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(page_lbl)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(page_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(usr_lbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lvl_lbl))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(course_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proc_b)
                    .addComponent(reset_b)
                    .addComponent(back_b))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void course_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_sActionPerformed
        String selected = course_s.getSelectedItem().toString();
        String[] temp;
        String reader, course;
        if (!selected.equals("Select Course")){
            try{
                FileReader fr = new FileReader ("Course_List.txt");
                BufferedReader br = new BufferedReader(fr);
                reader = br.readLine();
                int i = 0, j = 0;
                if ("testnull".equals(reader)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }
                else{
                    if (reader == null){
                        br.close();
                        fr.close();
                        return;
                    }
                    else{
                        while (reader.length() != 0) {
                            temp = reader.split(",");
                            if (temp[0].equals(selected)){
                                while(true){
                                    course = course_t.getValueAt(i, j).toString();
                                    if (course.equals(" ")){
                                        course_t.setValueAt(temp[0], i, j);
                                        course_t.setValueAt(temp[1], i, j+1);
                                        break;
                                    }
                                    else if (course.equals("No courses selected yet")){
                                        course_t.setValueAt(temp[0], i, j);
                                        course_t.setValueAt(temp[1], i, j+1);
                                        break;                                        
                                    }
                                    else if (course.equals(selected)){
                                        JOptionPane.showMessageDialog(null, "Course already added to selection, please choose another course.");
                                        return;
                                    }
                                    else{
                                        i++;
                                    }
                                }
                                br.close();
                                fr.close();
                                break;
                            }
                            reader = br.readLine();
                            if ("testnull".equals(reader)){
                                System.out.println("This should not occur, only to handle NullPointerException.");
                            }
                            else if(reader == null){
                                br.close();
                                fr.close();
                                break;
                            }
                        }
                    }
                }                
            }
            catch (Exception f) {
                JOptionPane.showMessageDialog(null, "System error " + f);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a course and try again.");
        }
    }//GEN-LAST:event_course_sActionPerformed

    private void back_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_bActionPerformed
        String page = page_lbl.getText();
        String uname = usr_lbl.getText();
        if(page.equals("mm")){
            Stud_mMenu smm = new Stud_mMenu(uname);
            smm.setVisible(true);
            this.dispose();
            return;
        }
        else{
            String profile = "Student";
            List_Courses lc = new List_Courses(uname,profile);
            lc.setVisible(true);
            this.dispose();
            return;
        }
    }//GEN-LAST:event_back_bActionPerformed

    private void reset_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_bActionPerformed
        String uname = usr_lbl.getText(),courses = "",page = page_lbl.getText();
        Stud_enrollcourse sec = new Stud_enrollcourse(uname,courses,page);
        sec.setVisible(true);
        this.dispose();
        return;        
    }//GEN-LAST:event_reset_bActionPerformed

    private void proc_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proc_bActionPerformed
        String page = page_lbl.getText();
        String uname = usr_lbl.getText();
        int i = 0, j = 1;
        String course, courses = "";
        while(true){
            course = course_t.getValueAt(i, j).toString();
            if (!course.equals(" ")){
                courses = courses + course + ",";
                i++;
            }
            else{
                break;
            }
        }
        if (!courses.equals("")){
            //Remove last character of courses which is "," to avoid arrayoutofboundsexception 2
            //Ex: OODJ,PDT, will create an array of 3 indexes as it's split by ","
            courses = courses.substring(0, courses.length() - 1);
            Checkout_Page cp = new Checkout_Page(uname, courses, page);
            cp.setVisible(true);
            this.dispose();
            return;
        }
        else{
            JOptionPane.showMessageDialog(null, "No course(s) have been selected yet, please select and try again.");
            return;
        }
    }//GEN-LAST:event_proc_bActionPerformed

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
            java.util.logging.Logger.getLogger(Stud_enrollcourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stud_enrollcourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stud_enrollcourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stud_enrollcourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stud_enrollcourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_b;
    private javax.swing.JComboBox<String> course_s;
    private javax.swing.JTable course_t;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lvl_lbl;
    private javax.swing.JLabel page_lbl;
    private javax.swing.JButton proc_b;
    private javax.swing.JButton reset_b;
    private javax.swing.JLabel usr_lbl;
    // End of variables declaration//GEN-END:variables
}
