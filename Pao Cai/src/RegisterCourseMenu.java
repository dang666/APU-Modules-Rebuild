
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DragonKimchi
 */
public class RegisterCourseMenu extends javax.swing.JFrame {

    /**
     * Creates new form RegisterCourseMenu
     */
    String code, name, lv, fees, duration;
    int checkSearch = 0;
    public RegisterCourseMenu(String degreeLevel) {
        initComponents();
        this.setLocationRelativeTo(null); // This will display the user interface at the middle
        String x = "SaveFile/Course.txt";
        StudentRegisterCourseClass srcc = new StudentRegisterCourseClass();
        srcc.ViewAccordingLevel(CourseTable, x, degreeLevel); // View according to student degree lv
        this.getContentPane().setBackground(new Color(245,245,245));
        TableColumnModel tcm = CourseTable.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(150);
        tcm.getColumn(1).setPreferredWidth(300);
        tcm.getColumn(2).setPreferredWidth(50);
        tcm.getColumn(3).setPreferredWidth(100);
        tcm.getColumn(4).setPreferredWidth(100);
        RegisterCourse.setEnabled(false);
    }
    
    String pv_id, pv_fn, pv_dl;

    private RegisterCourseMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void PassVariable(String ID, String fullname, String degreelevel)
    {
        pv_id = ID;
        pv_fn = fullname;
        pv_dl = degreelevel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        CourseTable = new javax.swing.JTable();
        RegisterCourse = new javax.swing.JButton();
        Search_text = new javax.swing.JTextField();
        Back = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Code", "Course Name", "Level", "Fees (RM)", "Durations (months)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CourseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CourseTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CourseTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(CourseTable);

        RegisterCourse.setText("Register Course");
        RegisterCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterCourseActionPerformed(evt);
            }
        });

        Search_text.setText("Search......");
        Search_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Search_textMousePressed(evt);
            }
        });
        Search_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_textActionPerformed(evt);
            }
        });
        Search_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Search_textKeyReleased(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Register Course Menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RegisterCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Search_text, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(314, 314, 314)
                                .addComponent(Back)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegisterCourse)
                    .addComponent(Search_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CourseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CourseTableMouseClicked

    private void CourseTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseTableMousePressed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)CourseTable.getModel();
        int selectedRowIndex = CourseTable.getSelectedRow();

        //if got search then the view and the model will not match, use convertRowIndexToModel method to convert the index of the view to the model
        //Eg in view it is 1, model is 6
        if (checkSearch == 1)
        {
            selectedRowIndex = CourseTable.convertRowIndexToModel(selectedRowIndex);
            checkSearch = 0;
        }

        //String code, name, lv, fees, duration;
        code = (model.getValueAt(selectedRowIndex, 0).toString());
        name = (model.getValueAt(selectedRowIndex, 1).toString());
        lv = (model.getValueAt(selectedRowIndex, 2).toString());
        fees = (model.getValueAt(selectedRowIndex, 3).toString());
        duration = (model.getValueAt(selectedRowIndex, 4).toString());
        
        RegisterCourse.setEnabled(true);
    }//GEN-LAST:event_CourseTableMousePressed

    private void RegisterCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterCourseActionPerformed
        // TODO add your handling code here:
        dispose();
        StudentRegisterCourseClass srcc = new StudentRegisterCourseClass();
        String PaymentStatus = "Pending";
        srcc.PassVariable(pv_id, pv_fn, pv_dl);
        srcc.RegisterCourse(pv_id, pv_fn, code, name, fees, PaymentStatus, pv_dl);
    }//GEN-LAST:event_RegisterCourseActionPerformed

    private void Search_textMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_textMousePressed
        // TODO add your handling code here:
        Search_text.setText("");
    }//GEN-LAST:event_Search_textMousePressed

    private void Search_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Search_textActionPerformed

    private void Search_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search_textKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)CourseTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        CourseTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + Search_text.getText()));

        //infrom that search is trigger
        checkSearch = 1;
    }//GEN-LAST:event_Search_textKeyReleased

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        dispose();
        StudentMenu sm = new StudentMenu(pv_id, pv_fn);
        sm.PassVariable(pv_id, pv_fn, pv_dl);
        sm.setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterCourseMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterCourseMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterCourseMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterCourseMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterCourseMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Back;
    private javax.swing.JTable CourseTable;
    private javax.swing.JButton RegisterCourse;
    private javax.swing.JTextField Search_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}