
package com.vku.GUI;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import java.io.*;
//import javafx.scene.control.Cell;
import javax.swing.UIManager;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin!
 */

public class Home extends javax.swing.JFrame { 
public static void copyfile(File source, File dest) throws IOException{
        Files.copy(source.toPath(), dest.toPath());
    }
private int currentFontSize = 80;
  public Home() {
        initComponents();
        textArea.setVisible(true);
 
       
    }



   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        document = new javax.swing.JButton();
        btnWord = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        video = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCopy = new javax.swing.JButton();
        btnCreateFile = new javax.swing.JButton();
        txtPath = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(128, 171, 200));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("JAVA COFFEE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(new java.awt.Color(128, 171, 200));

        jButton5.setBackground(new java.awt.Color(128, 171, 200));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vku/icon/My-Pictures-icon.png"))); // NOI18N
        jButton5.setText("Image");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnExcel.setBackground(new java.awt.Color(128, 171, 200));
        btnExcel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vku/icon/Excel-icon.png"))); // NOI18N
        btnExcel.setText("Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        document.setBackground(new java.awt.Color(128, 171, 200));
        document.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        document.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vku/icon/Documents-icon.png"))); // NOI18N
        document.setText("Documents");
        document.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentActionPerformed(evt);
            }
        });

        btnWord.setBackground(new java.awt.Color(128, 171, 200));
        btnWord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vku/icon/Word-icon.png"))); // NOI18N
        btnWord.setText("Word");
        btnWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWordActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(128, 171, 200));
        jButton11.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vku/icon/PC-a-icon.png"))); // NOI18N
        jButton11.setText("Home");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        video.setBackground(new java.awt.Color(128, 171, 200));
        video.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        video.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vku/icon/Movies-icon.png"))); // NOI18N
        video.setText("Video");
        video.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnWord, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(video, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(document, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton5)
                .addGap(51, 51, 51)
                .addComponent(btnExcel)
                .addGap(64, 64, 64)
                .addComponent(document)
                .addGap(55, 55, 55)
                .addComponent(btnWord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(video)
                .addGap(65, 65, 65)
                .addComponent(jButton11)
                .addGap(30, 30, 30))
        );

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        btnSave.setBackground(new java.awt.Color(128, 171, 200));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vku/icon/Save-icon.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(128, 171, 200));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vku/icon/Delete-icon.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCopy.setBackground(new java.awt.Color(128, 171, 200));
        btnCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vku/icon/folder-blue-copy-cloud-icon.png"))); // NOI18N
        btnCopy.setText("Copy");
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyActionPerformed(evt);
            }
        });

        btnCreateFile.setBackground(new java.awt.Color(128, 171, 200));
        btnCreateFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vku/icon/edit-new-document-icon.png"))); // NOI18N
        btnCreateFile.setText("Create");
        btnCreateFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateFileActionPerformed(evt);
            }
        });

        txtPath.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jButton1.setBackground(new java.awt.Color(128, 171, 200));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vku/icon/Rename-icon.png"))); // NOI18N
        jButton1.setText("Rename");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(128, 171, 200));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vku/icon/open-file-icon.png"))); // NOI18N
        jButton2.setText("Open");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(btnDelete)
                                .addGap(62, 62, 62)
                                .addComponent(btnCopy)
                                .addGap(56, 56, 56)
                                .addComponent(btnCreateFile)
                                .addGap(84, 84, 84)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCopy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreateFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 try {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "png", "jpg");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);
        System.out.println("Result: " + result);

        File selectedFile = null; // Declare outside the if block

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            System.out.println("Filepath: " + selectedFile.getAbsolutePath());

            if (!Desktop.isDesktopSupported()) {
                System.out.println("Not supported");
                return;
            } else {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(selectedFile);
            }
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Cancelled.");
            return;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
     Explorer2 e = new Explorer2();
     e.show();
     this.hide();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btnWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWordActionPerformed
          JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Word Documents", "docx");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // Kiểm tra nếu là file Word (docx)
            if (filePath.toLowerCase().endsWith(".docx")) {
                readDocxFile(filePath);
                txtPath.setText(filePath);
            } else {
                JOptionPane.showMessageDialog(null, "Chọn một file Word (docx) hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnWordActionPerformed

    private void btnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyActionPerformed
        try {
        File sourceFile = new File(txtPath.getText());
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView());
        fileChooser.showSaveDialog(null);
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File destFile = fileChooser.getSelectedFile();
            copyfile(sourceFile, destFile);
            JOptionPane.showMessageDialog(this, "Copy file thành công");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnCopyActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
     JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Documents", "xlsx");
    fileChooser.setFileFilter(filter);

    int result = fileChooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        String filePath = selectedFile.getAbsolutePath();

        // Kiểm tra nếu là file Excel (xlsx)
        if (filePath.toLowerCase().endsWith(".xlsx")) {
            readXLSXFile(filePath);
            txtPath.setText(filePath);
                
        } else {
            JOptionPane.showMessageDialog(null, "Chọn một file Excel (xlsx) hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    } 
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      try{
          File fi = new File(txtPath.getText());
          if(fi.delete()){
              JOptionPane.showMessageDialog(this, "Xóa file thành công");
              textArea.setText("");
              txtPath.setText("");
          }
      }catch(Exception e){
          e.printStackTrace();
      }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       String filePath = txtPath.getText();
    if (filePath.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một vị trí để lưu file.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (FileOutputStream fout = new FileOutputStream(filePath)) {
        String s = textArea.getText();
        byte[] b = s.getBytes();
        fout.write(b);
        JOptionPane.showMessageDialog(this, "Lưu dữ liệu thành công");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi lưu dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCreateFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFileActionPerformed
       
        Create c = new Create();
        c.show();
        this.hide();
    }//GEN-LAST:event_btnCreateFileActionPerformed

    private void documentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentActionPerformed
         JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
        j.showSaveDialog(null);
        int result = j.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fi = j.getSelectedFile();
            String f = fi.getPath();
            String line;
            txtPath.setText(f);
            try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                textArea.setText(content.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_documentActionPerformed

    private void videoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videoActionPerformed
          try {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Video files", "mp4", "avi", "mkv");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(null);
            System.out.println("Result: " + result);

            File selectedFile = null; // Declare outside the if block

            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                System.out.println("Filepath: " + selectedFile.getAbsolutePath());

                if (!Desktop.isDesktopSupported()) {
                    System.out.println("Not supported");
                    return;
                } else {
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(selectedFile);
                }
            } else if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("Cancelled.");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_videoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           String newFileName = JOptionPane.showInputDialog(this, "Nhập tên file");
        try {
            // file cũ
            String path = txtPath.getText();
            // java corn
            File myFile = new File(txtPath.getText());
            //new file
            String newPath = myFile.getParent() + "\\" + newFileName;
            File newFile = new File(newPath);
            if(  myFile.renameTo(newFile)){
                txtPath.setText(newFile.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Đổi tên file thành công");
            }else{
                JOptionPane.showMessageDialog(this, "Đổi tên file thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getAbsolutePath();
            txtPath.setText(path);
            textArea.setText(displayDirectoryTree(new File(path), "", true));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) {
        
          try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
        // Đọc tập tin Excel
//        Home reader = new Home();
//        reader.readXLSXFile("D:/QuanlyCafe/NhomMon.xlsx");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCopy;
    private javax.swing.JButton btnCreateFile;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnWord;
    private javax.swing.JButton document;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField txtPath;
    private javax.swing.JButton video;
    // End of variables declaration//GEN-END:variables
    private void readDocxFile(String filePath) {
        FileInputStream fis = null;
        try {
            File file = new File(filePath);
            fis = new FileInputStream(file);
            XWPFDocument document = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = document.getParagraphs();

            StringBuilder content = new StringBuilder();

            for (XWPFParagraph para : paragraphs) {
                content.append(para.getText()).append("\n");
            }

            textArea.setText(content.toString());

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 private void readXLSXFile(String file) {
        try {
            File excelFile = new File(file);

            // Kiểm tra nếu tập tin rỗng
            if (excelFile.length() == 0) {
                System.out.println("File is empty.");
                return;
            }

            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet sheet = workbook.getSheetAt(0);
            StringBuilder content = new StringBuilder();

            // Đọc tiêu đề cột và thêm vào content
            Row headerRow = sheet.getRow(0);
            for (org.apache.poi.ss.usermodel.Cell headerCell : headerRow) {
                content.append(String.format("%-20s", headerCell.toString())).append("\t");
            }
            content.append("\n");

            // Lặp qua từng hàng (bỏ qua hàng tiêu đề)
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    // Lặp qua từng ô trong hàng và thêm vào content
                    for (org.apache.poi.ss.usermodel.Cell cell : row) {
                        content.append(String.format("%-20s", cell.toString())).append("\t");
                    }
                    content.append("\n"); // Xuống dòng sau khi kết thúc mỗi hàng
                }
            }

            // Hiển thị nội dung trong textarea hoặc nơi khác
            textArea.setText(content.toString());
            // Đóng workbook
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 private String displayDirectoryTree(File dir, String indent, boolean isLast) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent);
        if (isLast) {
            sb.append("└── ");
            indent += "    ";
        } else {
            sb.append("├── ");
            indent += "│   ";
        }
        sb.append(dir.getName()).append(" (").append(getDirectorySize(dir)).append(" bytes)").append("\n");

        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                boolean last = (i == files.length - 1);
                if (files[i].isDirectory()) {
                    sb.append(displayDirectoryTree(files[i], indent, last));
                } else {
                    sb.append(displayFile(files[i], indent, last));
                }
            }
        }

        return sb.toString();
    }

  private long getDirectorySize(File dir) {
        long size = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length();
                } else {
                    size += getDirectorySize(file);
                }
            }
        }
        return size;
    }


   private String displayFile(File file, String indent, boolean isLast) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent);
        if (isLast) {
            sb.append("└── ");
        } else {
            sb.append("├── ");
        }
        sb.append(file.getName()).append(" (").append(file.length()).append(" bytes)").append("\n");
        return sb.toString();
    }
     
}
