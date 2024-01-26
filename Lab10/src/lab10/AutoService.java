/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SystemX
 */
public class AutoService extends javax.swing.JFrame {

    /**
     * Creates new form AutoService
     */
    public AutoService() {
        initComponents();
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
        Table = new javax.swing.JTable();
        Menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        AddButton = new javax.swing.JMenuItem();
        DeleteButton = new javax.swing.JMenuItem();
        SaveToFileButton = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        ChangeButton = new javax.swing.JMenuItem();
        ExitButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Malgun Gothic", 3, 10)); // NOI18N

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "�����", "������", "���", "����"
            }
        ));
        jScrollPane1.setViewportView(Table);

        jMenu1.setText("File");

        AddButton.setText("��������");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        jMenu1.add(AddButton);

        DeleteButton.setText("�������");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        jMenu1.add(DeleteButton);

        SaveToFileButton.setText("��������� � ����");
        SaveToFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveToFileButtonActionPerformed(evt);
            }
        });
        jMenu1.add(SaveToFileButton);

        Menu.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        ChangeButton.setText("��������");
        ChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeButtonActionPerformed(evt);
            }
        });
        jMenu2.add(ChangeButton);

        ExitButton.setText("�����");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        jMenu2.add(ExitButton);

        Menu.add(jMenu2);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeButtonActionPerformed
        EditFrame edit=new EditFrame();
        edit.setVisible(true);
        edit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_ChangeButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        AddFrame add = new AddFrame();
        add.setVisible(true);
        add.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // TODO add your handling code here:
    }//GEN-LAST:event_AddButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        DefaultTableModel model   = (DefaultTableModel) Table.getModel();
        model.removeRow(Table.getSelectedRow());// TODO add your handling code here:
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
       System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void SaveToFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveToFileButtonActionPerformed
     DefaultTableModel model = (DefaultTableModel) Table.getModel();

        try {
            FileWriter file = new FileWriter("C:/Users/SystemX/Downloads/Lab10.txt");
            PrintWriter pw = new PrintWriter(file);
            for (int i = 0; i < model.getDataVector().size(); i++) {
                pw.print(model.getDataVector().get(i) + "\n");
            }
            pw.close();
            JOptionPane.showMessageDialog(null, "���� ������� �������� � ��������", "OK", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "�� ����� ������ ��������� ������", "OK", JOptionPane.INFORMATION_MESSAGE);
        }     // TODO add your handling code here:
    }//GEN-LAST:event_SaveToFileButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AutoService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutoService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutoService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutoService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutoService().setVisible(true);
            }
        });
    }
       public static void Add(Object[] dataRow) {
        DefaultTableModel model;
        model = (DefaultTableModel) Table.getModel();
        model.addRow(dataRow);
    }
           public static void Edit(String n) {
        int row = Table.getSelectedRow();
        int col = Table.getSelectedColumn();
        try {
            switch (col) {
                 
                case 2: {
                    if (Integer.parseInt(n) < 0) {
                        throw new NumberFormatException();
                    }
                    break;
                }
                case 3: {
                    System.out.println(n);
                    if (!(Integer.parseInt(n)>=1920&& Integer.parseInt(n)<=2024) ) {
                        throw new NumberFormatException();
                    }
                    break;
                }
            }
            Table.setValueAt(n, row, col);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "������������ ������ ������ ��������� ����", "��", JOptionPane.PLAIN_MESSAGE);
        }

    }
           

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddButton;
    private javax.swing.JMenuItem ChangeButton;
    private javax.swing.JMenuItem DeleteButton;
    private javax.swing.JMenuItem ExitButton;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem SaveToFileButton;
    private static javax.swing.JTable Table;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
