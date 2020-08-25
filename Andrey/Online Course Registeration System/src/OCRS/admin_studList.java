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
 * @author audrey
 */
public class admin_studList extends javax.swing.JFrame {

    /** Creates new form admin_studList */
    public admin_studList() {
        initComponents();
    }
    private String uname;
    private int action_flag = 1;
    
    public admin_studList(String uname) {
        initComponents();
        String reader, reader1;
        String[] temp_sp;
        String[] temp_ec;
        String[] temp_c;
        int i = 0, i2 = 0, j = 0, total_student = 0, total_enrolled = 0;
        adminUN_label.setText(uname);
        adminUN_label.setVisible(false);
        this.uname = uname;

        //Setting user details from student_profile_db.txt and comparing if these students are enrolled into any courses
        //list them down as well with duplicate listing if multiple courses have been enrolled.
        try {
            FileReader fr = new FileReader("Student_Profile_DB.txt");
            BufferedReader br = new BufferedReader(fr);
            BufferedReader br2 = new BufferedReader(new FileReader("Enrollment_List.txt"));
            reader = br.readLine();
            if ("testnull".equals(reader)){
                System.out.println("This should not occur, only to handle NullPointerException.");
            }                
            else{
                reader1 = br2.readLine();
                if ("testnull".equals(reader1)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }                
                else{             
                    while(reader.length()!=0){
                        temp_sp = reader.split(",");
                        int count = 0, flag = 0;
                        while(reader1.length()!=0){  
                            temp_ec = reader1.split(",");
                            if(temp_ec[0].equals(temp_sp[4])){
                                table.setValueAt(temp_ec[2], i2, j+4);
                                table.setValueAt(temp_ec[1], i2, j+5);
                                count++;
                                flag = 1;
                                i2++;
                            }
                            reader1 = br2.readLine();
                            if ("testnull".equals(reader1)){
                                System.out.println("This should not occur, only to handle NullPointerException.");
                            }
                            else if(reader1 == null){
                                br2.close();
                                break;
                            }
                        }
                        //so the course name and and code will be empty, later on inserting student name
                        if(flag == 0){
                            count++;
                        }
                        else{
                            total_enrolled++;
                        }
                        // printing out student namewhich is equalvalent to the course file
                        for(int k = 0; k < count; k++){
                            table.setValueAt(temp_sp[1], i, j);
                            table.setValueAt(temp_sp[0], i, j+1);
                            table.setValueAt(temp_sp[2], i, j+2);
                            table.setValueAt(temp_sp[3], i, j+3);
                            i++;
                        }
                        total_student++;
//                        // count total number of students
//                        cnt++;
                        // as i2 runs more thani
                        i2 = i; 
                        reader = br.readLine();
                        if ("testnull".equals(reader)){
                            System.out.println("This should not occur, only to handle NullPointerException.");
                        }
                        else if(reader == null){
                            br.close();
                            fr.close();
                            break;
                        }
                        //re-read the enrolment file cuz it ended prevu=iously edi? so need to reinitialize to read
                        else{
                            br2 = new BufferedReader(new FileReader("Enrollment_List.txt"));
                            reader1 = br2.readLine();
                            continue;
                        }
                    }
                }
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading from student profile database " + e);
        }
        
        //Set total number of students and total students who are enrolled in courses.
        totalStudRegText.setText(Integer.toString(total_enrolled));
        totalStudText.setText((Integer.toString(total_student)));
        
        try{
            for (int k = table.getRowCount() - 1; k >= 0; k--){
                if (table.getValueAt(k, 1).equals(" ")){
                    int viewIndex = k;
                    int modelIndex = table.convertRowIndexToModel(viewIndex);
                    DefaultTableModel model = (DefaultTableModel)table.getModel();
                    model.removeRow(modelIndex);
                }
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error removing empty rows " + e);
        }
        
        //Assign all information to relevant combo boxes.
        try{
            FileReader fr = new FileReader("Course_List.txt");
            BufferedReader br = new BufferedReader(fr);
            reader = br.readLine();
            while(reader.length()!=0) {               
                temp_c = reader.split(",");
                courseCodeCB.addItem(temp_c[1]);
                courseNameCB.addItem(temp_c[0]);
                i++; // to the next item
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
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading from course list database " + e);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        courseNameCB = new javax.swing.JComboBox<>();
        courseCodeCB = new javax.swing.JComboBox<>();
        okButton = new javax.swing.JButton();
        adminUN_label = new javax.swing.JLabel();
        note_1 = new javax.swing.JLabel();
        totalstudentLabel = new javax.swing.JLabel();
        totalstudentregLabel = new javax.swing.JLabel();
        totalStudRegText = new javax.swing.JLabel();
        totalStudText = new javax.swing.JLabel();
        levelCB = new javax.swing.JComboBox<>();
        degreeCB = new javax.swing.JComboBox<>();
        resetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("YuKyokasho", 1, 18)); // NOI18N
        jLabel1.setText("L I S T  O F  S T U D E N T S ");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " "}
            },
            new String [] {
                "Student ID", "Student Name", "Degree", "Level", "Course Code", "Course Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(20);
            table.getColumnModel().getColumn(1).setPreferredWidth(80);
            table.getColumnModel().getColumn(2).setPreferredWidth(120);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(3).setPreferredWidth(5);
            table.getColumnModel().getColumn(4).setPreferredWidth(25);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(5).setPreferredWidth(130);
        }

        courseNameCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course Name..." }));
        courseNameCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNameCBActionPerformed(evt);
            }
        });

        courseCodeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course Code..." }));
        courseCodeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCodeCBActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        adminUN_label.setText("(placeholder for admin username)");

        note_1.setText("*Above are a list of all student.");

        totalstudentLabel.setText("Total Students: ");

        totalstudentregLabel.setText("Total Student Enrolled In Courses:");

        totalStudRegText.setText("xxx");

        totalStudText.setText("xxx");

        levelCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Level...", "Level 1", "Level 2", "Level 3" }));
        levelCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelCBActionPerformed(evt);
            }
        });

        degreeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Degree...", "BSc (Hons) Computer Science", "BSc (Hons) Software Engineering", "BSc (Hons) Cyber Security", "BSc (Hons) Intelligent Systems" }));
        degreeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degreeCBActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(note_1)
                                .addGap(242, 242, 242)
                                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(okButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(totalstudentregLabel)
                                .addGap(25, 25, 25)
                                .addComponent(totalStudRegText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(totalstudentLabel)
                                .addGap(18, 18, 18)
                                .addComponent(totalStudText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(degreeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(levelCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(courseCodeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(courseNameCB, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(adminUN_label))
                            .addComponent(jLabel1))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(adminUN_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalstudentregLabel)
                    .addComponent(totalStudRegText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalstudentLabel)
                            .addComponent(totalStudText))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courseCodeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(levelCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(degreeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseNameCB, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(resetButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(note_1)))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addGap(10, 10, 10))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        admin_mMenu am = new admin_mMenu(uname);
        am.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void degreeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degreeCBActionPerformed
        if(action_flag == 1){
            resetButton.doClick();
            String search = degreeCB.getSelectedItem().toString();
            try{
                for (int k = table.getRowCount() - 1; k >= 0; k--){
                    String current = table.getValueAt(k, 2).toString();
                    if(!search.equals(current)){
                        int viewIndex = k;
                        int modelIndex = table.convertRowIndexToModel(viewIndex);
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        model.removeRow(modelIndex);
                    }
                }
                this.action_flag = 0;
                levelCB.setSelectedIndex(0);
                courseCodeCB.setSelectedIndex(0);
                courseNameCB.setSelectedIndex(0);
                this.action_flag = 1;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Unable to filter "+e, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_degreeCBActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        for (int k = table.getRowCount() - 1; k >= 0; k--){
            int viewIndex = k;
            int modelIndex = table.convertRowIndexToModel(viewIndex);
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.removeRow(modelIndex);
        }
        
        for(int k = 0; k < 32; k++){
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.addRow(new Object[]{" "," "," "," "," "," "});
        }

        String reader, reader1;
        String[] temp_sp;
        String[] temp_ec;
        String[] temp_c;
        int i = 0, i2 = 0, j = 0;

        try {
            FileReader fr = new FileReader("Student_Profile_DB.txt");
            BufferedReader br = new BufferedReader(fr);
            BufferedReader br2 = new BufferedReader(new FileReader("Enrollment_List.txt"));
            reader = br.readLine();
            if ("testnull".equals(reader)){
                System.out.println("This should not occur, only to handle NullPointerException.");
            }                
            else{
                reader1 = br2.readLine();
                if ("testnull".equals(reader1)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }                
                else{             
                    while(reader.length()!=0){
                        temp_sp = reader.split(",");
                        int count = 0, flag = 0;
                        while(reader1.length()!=0){  
                            temp_ec = reader1.split(",");
                            if(temp_ec[0].equals(temp_sp[4])){
                                table.setValueAt(temp_ec[2], i2, j+4);
                                table.setValueAt(temp_ec[1], i2, j+5);
                                count++;
                                flag = 1;
                                i2++;
                            }
                            reader1 = br2.readLine();
                            if ("testnull".equals(reader1)){
                                System.out.println("This should not occur, only to handle NullPointerException.");
                            }
                            else if(reader1 == null){
                                br2.close();
                                break;
                            }
                        }
                        //so the course name and and code will be empty, later on inserting student name
                        if(flag == 0){
                            count++;
                        }
                        // printing out student namewhich is equalvalent to the course file
                        for(int k = 0; k < count; k++){
                            table.setValueAt(temp_sp[1], i, j);
                            table.setValueAt(temp_sp[0], i, j+1);
                            table.setValueAt(temp_sp[2], i, j+2);
                            table.setValueAt(temp_sp[3], i, j+3);
                            i++;
                        }
                        i2 = i; 
                        reader = br.readLine();
                        if ("testnull".equals(reader)){
                            System.out.println("This should not occur, only to handle NullPointerException.");
                        }
                        else if(reader == null){
                            br.close();
                            fr.close();
                            break;
                        }
                        //re-read the enrolment file cuz it ended prevu=iously edi? so need to reinitialize to read
                        else{
                            br2 = new BufferedReader(new FileReader("Enrollment_List.txt"));
                            reader1 = br2.readLine();
                            continue;
                        }
                    }
                }
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading from student profile database " + e);
        }
        try{
            for (int k = table.getRowCount() - 1; k >= 0; k--){
                if (table.getValueAt(k, 1).equals(" ")){
                    int viewIndex = k;
                    int modelIndex = table.convertRowIndexToModel(viewIndex);
                    DefaultTableModel model = (DefaultTableModel)table.getModel();
                    model.removeRow(modelIndex);
                }
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error removing empty rows " + e);
        }        
//        admin_studList asl = new admin_studList(uname);
//        asl.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void levelCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelCBActionPerformed
        if(action_flag == 1){
            resetButton.doClick();
            String search = levelCB.getSelectedItem().toString();
            try{
                for (int k = table.getRowCount() - 1; k >= 0; k--){
                    String current = table.getValueAt(k, 3).toString();
                    if(!search.equals(current)){
                        int viewIndex = k;
                        int modelIndex = table.convertRowIndexToModel(viewIndex);
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        model.removeRow(modelIndex);
                    }
                }
                this.action_flag = 0;
                degreeCB.setSelectedIndex(0);
                courseCodeCB.setSelectedIndex(0);
                courseNameCB.setSelectedIndex(0);
                this.action_flag = 1;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Unable to filter "+e, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_levelCBActionPerformed

    private void courseCodeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCodeCBActionPerformed
        if(action_flag == 1){    
            resetButton.doClick();
            String search = courseCodeCB.getSelectedItem().toString();
            try{
                for (int k = table.getRowCount() - 1; k >= 0; k--){
                    String current = table.getValueAt(k, 4).toString();
                    if(!search.equals(current)){
                        int viewIndex = k;
                        int modelIndex = table.convertRowIndexToModel(viewIndex);
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        model.removeRow(modelIndex);
                    }
                }
                this.action_flag = 0;
                levelCB.setSelectedIndex(0);
                degreeCB.setSelectedIndex(0);
                courseNameCB.setSelectedIndex(0);
                this.action_flag = 1;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Unable to filter "+e, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_courseCodeCBActionPerformed

    private void courseNameCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNameCBActionPerformed
        if(action_flag == 1){
            resetButton.doClick();
            String search = courseNameCB.getSelectedItem().toString();
            try{
                for (int k = table.getRowCount() - 1; k >= 0; k--){
                    String current = table.getValueAt(k, 5).toString();
                    if(!search.equals(current)){
                        int viewIndex = k;
                        int modelIndex = table.convertRowIndexToModel(viewIndex);
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        model.removeRow(modelIndex);
                    }
                }
                this.action_flag = 0;
                levelCB.setSelectedIndex(0);
                courseCodeCB.setSelectedIndex(0);
                degreeCB.setSelectedIndex(0); 
                this.action_flag = 1;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Unable to filter "+e, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_courseNameCBActionPerformed

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
            java.util.logging.Logger.getLogger(admin_studList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_studList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_studList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_studList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_studList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminUN_label;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> courseCodeCB;
    private javax.swing.JComboBox<String> courseNameCB;
    private javax.swing.JComboBox<String> degreeCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> levelCB;
    private javax.swing.JLabel note_1;
    private javax.swing.JButton okButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalStudRegText;
    private javax.swing.JLabel totalStudText;
    private javax.swing.JLabel totalstudentLabel;
    private javax.swing.JLabel totalstudentregLabel;
    // End of variables declaration//GEN-END:variables

}
