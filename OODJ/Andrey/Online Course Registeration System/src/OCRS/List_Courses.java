/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OCRS;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BryanL
 */
public class List_Courses extends javax.swing.JFrame {

    /**
     * Creates new form List_Courses
     */
    String desig;
    public List_Courses() {
        initComponents();
    }
    public List_Courses(String uname, String profile) {
        initComponents();
        table.setAutoCreateRowSorter(true);
        String[] temp;
        String reader;
        int i = 0, j = 1;
        profile_lbl.setText(profile);
        profile_lbl.setVisible(false);
        try{
            if(profile.equals("Student")){
                delete_b.setVisible(false);
                add_b.setVisible(false);
                modify_b.setVisible(false);
                modify_lbl.setVisible(false);
                desigt_lbl.setVisible(false);
                desig_lbl.setVisible(false);
                FileReader fr = new FileReader("Student_Profile_DB.txt");
                BufferedReader br = new BufferedReader(fr);
                reader = br.readLine();
                while (reader.length() != 0) {
                    temp = reader.split(",");
                    if (uname.equals(temp[4])) {
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
                br.close();
                fr.close();                  
            }
            else{
                FileReader fr = new FileReader("Admin_Profile_DB.txt");
                BufferedReader br = new BufferedReader(fr);
                reader = br.readLine();
                while (reader.length() != 0) {
                    temp = reader.split(",");
                    if (uname.equals(temp[3])) {
                        usr_lbl.setText(uname);
                        desig_lbl.setText(temp[2]);
                        jLabel4.setVisible(false);
                        lvl_lbl.setVisible(false);
                        enroll_b.setVisible(false);
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
                br.close();
                fr.close();                 
            }
        }
        catch (Exception f) {
            JOptionPane.showMessageDialog(null, "Error setting labels " + f);
        }
        
        try{
            if(profile.equals("Student")){
                String lvl = lvl_lbl.getText();
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
                                table.setValueAt(temp[0], i, j);
                                table.setValueAt(temp[1], i, j+1);
                                table.setValueAt(temp[2], i, j+2);
                                table.setValueAt(temp[3], i, j+3);
                                table.setValueAt(temp[4], i, j+4);
                                i++;
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
                        br2.close();
                        fr2.close();                        
                    }
                }
            }
            else{
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
                            table.setValueAt(temp[0], i, j);
                            table.setValueAt(temp[1], i, j+1);
                            table.setValueAt(temp[2], i, j+2);
                            table.setValueAt(temp[3], i, j+3);
                            table.setValueAt(temp[4], i, j+4);
                            i++;
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
                        br2.close();
                        fr2.close();                        
                    }
                }                
            }
        }
        catch (Exception f) {
            JOptionPane.showMessageDialog(null, "Error parsing course selector " + f);
        }
        for (int k = table.getRowCount() - 1; k >= 0; k--){
            if (table.getValueAt(k, 1).equals(" ")){
                int viewIndex = k;
                int modelIndex = table.convertRowIndexToModel(viewIndex);
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                model.removeRow(modelIndex);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        search_f = new javax.swing.JTextField();
        search_b = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usr_lbl = new javax.swing.JLabel();
        lvl_lbl = new javax.swing.JLabel();
        back_b = new javax.swing.JButton();
        add_b = new javax.swing.JButton();
        delete_b = new javax.swing.JButton();
        profile_lbl = new javax.swing.JLabel();
        enroll_b = new javax.swing.JButton();
        reset_b = new javax.swing.JButton();
        modify_b = new javax.swing.JButton();
        modify_lbl = new javax.swing.JLabel();
        desigt_lbl = new javax.swing.JLabel();
        desig_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Boolean(false), " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", "  ", "  ", "  ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null},
                {null, " ", " ", " ", " ", null}
            },
            new String [] {
                "Select", "Course", "Course Code", "Level", "Description", "Fee ($)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(0).setPreferredWidth(3);
            table.getColumnModel().getColumn(3).setPreferredWidth(5);
            table.getColumnModel().getColumn(4).setMinWidth(180);
            table.getColumnModel().getColumn(4).setPreferredWidth(200);
            table.getColumnModel().getColumn(4).setMaxWidth(300);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(5).setPreferredWidth(3);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIST OF COURSES");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Search course:");

        search_f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_fActionPerformed(evt);
            }
        });

        search_b.setText("Search");
        search_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_bActionPerformed(evt);
            }
        });

        jLabel3.setText("Username:");

        jLabel4.setText("Level:");

        usr_lbl.setText("(username will be replaced here)");

        lvl_lbl.setText("(level will be replaced here)");

        back_b.setText("Back");
        back_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_bActionPerformed(evt);
            }
        });

        add_b.setText("Add Course(s)");
        add_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_bActionPerformed(evt);
            }
        });

        delete_b.setText("Delete selected course(s)");
        delete_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_bActionPerformed(evt);
            }
        });

        profile_lbl.setText("(placeholder for profile)");

        enroll_b.setText("Enroll selected course(s)");
        enroll_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enroll_bActionPerformed(evt);
            }
        });

        reset_b.setText("Reset");
        reset_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_bActionPerformed(evt);
            }
        });

        modify_b.setText("Modify selected course");
        modify_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify_bActionPerformed(evt);
            }
        });

        modify_lbl.setText("Note: only select 1 course to modify at a time.");

        desigt_lbl.setText("Designation:");

        desig_lbl.setText("(designation will be replaced here)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(596, 596, 596)
                .addComponent(profile_lbl))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(usr_lbl))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4))
                    .addComponent(desigt_lbl))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desig_lbl)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lvl_lbl)))
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(search_f, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(search_b, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane2)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(add_b, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(enroll_b, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(delete_b, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modify_b, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modify_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(reset_b, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(back_b, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(profile_lbl)
                .addGap(3, 3, 3)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(usr_lbl))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(desigt_lbl))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(desig_lbl))
                            .addComponent(lvl_lbl)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(search_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(search_b))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add_b)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(enroll_b))
                    .addComponent(delete_b)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(modify_b)
                        .addGap(7, 7, 7)
                        .addComponent(modify_lbl)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reset_b)
                    .addComponent(back_b)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void search_fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_fActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_fActionPerformed

    private void search_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_bActionPerformed
        String search = search_f.getText();
        if(search.length() == 0){
            JOptionPane.showMessageDialog(null, "Please enter the correct Course Name or Course Code and try again!", "Invalid Search", JOptionPane.ERROR_MESSAGE);
            search_f.setText("");
            return;
        }
        try{
            FileReader fr = new FileReader("Course_List.txt");
            BufferedReader br = new BufferedReader(fr);
            String reader;
            String[] temp;
            reader = br.readLine();
            int i = 0,j = 0;
            while(reader.length() != 0){
                temp = reader.split(",");
                if(search.equals(temp[0]) || search.equals(temp[1])){
                    for (int k = table.getRowCount() - 1; k > 0; k--){
                        int viewIndex = k;
                        int modelIndex = table.convertRowIndexToModel(viewIndex);
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        model.removeRow(modelIndex);
                    }
                    table.setValueAt(false, i, j);
                    table.setValueAt(temp[0], i, j+1);
                    table.setValueAt(temp[1], i, j+2);
                    table.setValueAt(temp[2], i, j+3);
                    table.setValueAt(temp[3], i, j+4);
                    table.setValueAt(temp[4], i, j+5);
                    br.close();
                    fr.close();
                    return;
                }
                reader = br.readLine();
                if ("testnull".equals(reader)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }
                else if(reader.length() == 0){
                    JOptionPane.showMessageDialog(null, "Please enter the correct Course Name or Course Code and try again!", "Invalid Search", JOptionPane.ERROR_MESSAGE);
                    br.close();
                    fr.close();
                    return;
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unable to search "+e, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_search_bActionPerformed

    private void reset_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_bActionPerformed
        String uname = usr_lbl.getText(), profile = profile_lbl.getText();
        List_Courses lc = new List_Courses(uname,profile);
        lc.setVisible(true);
        this.dispose();
        return;
    }//GEN-LAST:event_reset_bActionPerformed

    private void back_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_bActionPerformed
        String uname = usr_lbl.getText(), profile = profile_lbl.getText();
        if(profile.equals("Admin")){
            admin_mMenu amm = new admin_mMenu(uname);
            amm.setVisible(true);
            this.dispose();
            return;
        }
        else{
            Stud_mMenu smm = new Stud_mMenu(uname);
            smm.setVisible(true);
            this.dispose();
            return;
        }
    }//GEN-LAST:event_back_bActionPerformed

    private void enroll_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enroll_bActionPerformed
        String uname = usr_lbl.getText(), page = "lc";
        String course, courses = "";
        int k = 0;
        try{
            while (k < table.getRowCount()){
                String select = String.valueOf(table.getValueAt(k, 0));
                if ("testnull".equals(select)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }
                else{
                    if (select.equals("null") || select.equals("false")){
                        k++;
                    }                
                    else if(select.equals("true")){
                        course = table.getValueAt(k, 2).toString();
                        courses = courses + course + ",";
                        k++;
                    }
                }
            }
            courses = courses.substring(0, courses.length() - 1);
            Stud_enrollcourse sec = new Stud_enrollcourse(uname,courses,page);
            sec.setVisible(true);
            this.dispose();
            return;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unable to enroll selected course(s) "+e, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_enroll_bActionPerformed

    private void delete_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_bActionPerformed
        Add_del_mod_course adc = new Add_del_mod_course();
        String course, courses = "", desig = desig_lbl.getText(), uname = usr_lbl.getText(), profile = profile_lbl.getText();
        int k = 0;
        try{
            while (k < table.getRowCount()){
                String select = String.valueOf(table.getValueAt(k, 0));
                if ("testnull".equals(select)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }
                else{
                    if (select.equals("null") || select.equals("false")){
                        k++;
                    }                
                    else if(select.equals("true")){
                        course = table.getValueAt(k, 2).toString();
                        courses = courses + course + ",";
                        k++;
                    }
                }
            }
            if(courses.length()!=0){
                //remove comma from while parsing as it creates error
                courses = courses.substring(0, courses.length() - 1);
                adc.delCourse(desig,courses);
                List_Courses lc = new List_Courses (uname, profile);
                lc.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select course(s) to delete and try again.");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unable to delete selected course(s) "+e, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delete_bActionPerformed

    private void add_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_bActionPerformed
        String uname = usr_lbl.getText();
        admin_addCourse aac = new admin_addCourse(uname);
        aac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_add_bActionPerformed

    private void modify_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modify_bActionPerformed
        String uname = usr_lbl.getText(),coursen = "",coursec = "",lvl = "",coursed = "",fee = "";
        int k = 0;
        try{
            while (k < table.getRowCount()){
                String select = String.valueOf(table.getValueAt(k, 0));
                if ("testnull".equals(select)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }
                else{
                    if (select.equals("null") || select.equals("false")){
                        k++;
                    }                
                    else if(select.equals("true")){
                        coursen = table.getValueAt(k, 1).toString();
                        coursec = table.getValueAt(k, 2).toString();
                        lvl = table.getValueAt(k, 3).toString();
                        coursed = table.getValueAt(k, 4).toString();
                        fee = table.getValueAt(k, 5).toString();
                        break;
                    }
                }
            }
            admin_modCourse amc = new admin_modCourse(uname,coursen, coursec, lvl, coursed, fee);
            amc.setVisible(true);
            this.dispose();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unable to delete selected course(s) "+e, "Error!", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_modify_bActionPerformed

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
            java.util.logging.Logger.getLogger(List_Courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_Courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_Courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_Courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List_Courses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_b;
    private javax.swing.JButton back_b;
    private javax.swing.JButton delete_b;
    private javax.swing.JLabel desig_lbl;
    private javax.swing.JLabel desigt_lbl;
    private javax.swing.JButton enroll_b;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lvl_lbl;
    private javax.swing.JButton modify_b;
    private javax.swing.JLabel modify_lbl;
    private javax.swing.JLabel profile_lbl;
    private javax.swing.JButton reset_b;
    private javax.swing.JButton search_b;
    private javax.swing.JTextField search_f;
    private javax.swing.JTable table;
    private javax.swing.JLabel usr_lbl;
    // End of variables declaration//GEN-END:variables
}
