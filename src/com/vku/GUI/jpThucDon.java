/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vku.GUI;
import com.vku.Connect.Connect;
import com.vku.Connect.Connect;
import com.vku.MODEL.Loai;
import com.vku.MODEL.ThucDon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ThangIKCU
 */
public class jpThucDon extends javax.swing.JPanel {
    Connect cn = new Connect();
    /**
     * Creates new form jpThucDon
     */
    public String gioden, tenban;
    public int maban;
    public ArrayList<ThucDon> arrdsmon;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    public static jpThucDon td;
    public void FillLoai(){
        ArrayList<Loai> arrLoai = cn.GetLoai();
        if(arrLoai != null){
            JButton btn;
            jpLoai.setLayout(new BoxLayout(jpLoai, BoxLayout.PAGE_AXIS));
            jpLoai.removeAll();
            jpChonMon.setLayout(new  FlowLayout(FlowLayout.CENTER));
            for(Loai l : arrLoai){
                    btn = new JButton(l.GetTenLoai());
                    btn.setName(l.GetMaLoai());
                    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    btn.setMaximumSize(new Dimension(140, 40));
                    btn.setForeground(Color.decode("#331a00"));
                    btn.setBackground(Color.decode(l.GetMauSac()));
                    btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    btn.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            lblNhom.setText("    Nhóm "+l.GetTenLoai());
                            lblNhom.setBackground(Color.decode(l.GetMauSac()));
                            ArrayList<ThucDon> arrThucDon = cn.GetThucDon(l.GetMaLoai());
                            jpChonMon.removeAll();
                            jpChonMon.updateUI();
                            if(arrThucDon != null){
                                JPanel[] pn = new JPanel[arrThucDon.size()];
                                //jPanel4.setLayout(new BoxLayout(jPanel4, BoxLayout.PAGE_AXIS));
                                for(int i=0;i<arrThucDon.size();i++){
                                    pn[i] = new JPanel();
                                    pn[i].setName(arrThucDon.get(i).GetMaMon());
                                    pn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                                    pn[i].setBackground(Color.decode("#dfff80"));
                                    pn[i].setBorder(BorderFactory.createLineBorder(Color.decode("#a3a375"), 2));
                                    pn[i].setPreferredSize(new Dimension(128, 60));
                                    pn[i].add(new JLabel(arrThucDon.get(i).GetTenMon())).setFont(new java.awt.Font("Tahoma", 1, 12));
                                    pn[i].add(new JLabel(String.valueOf(chuyentien.format(arrThucDon.get(i).GetDonGia()))+" VNĐ/ "+arrThucDon.get(i).GetDVT())).setForeground(Color.decode("#ff0000"));
                                    pn[i].addMouseListener(new MouseAdapter() {
                                        @Override
                                        public void mousePressed(MouseEvent e){

                                            DLSoLuong sl = new DLSoLuong( true, e.getComponent().getName(), tenban, maban);
                                           sl.gioden = gioden;
                                            sl.setVisible(true);
                                        }
                                    });                                     
                                    jpChonMon.add(pn[i]);
                                    jpChonMon.updateUI();
                                }
                            }

                        }
                    });
                    jpLoai.add(btn);
                    jpLoai.updateUI();
            }
            
        }

    }
    public jpThucDon() {
        initComponents();
        td = this;
        FillLoai();
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNhom = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jpChonMon = new javax.swing.JPanel();
        jpLoai = new javax.swing.JPanel();

        setBackground(Color.decode("#A77A5D"));

        jPanel1.setBackground(Color.decode("#e6e6e6"));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setAlignmentX(0.0F);

        lblNhom.setBackground(new java.awt.Color(11, 112, 14));
        lblNhom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNhom.setForeground(new java.awt.Color(253, 253, 253));
        lblNhom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNhom.setText("                          Chọn món");
        lblNhom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNhom.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblNhom.setIconTextGap(7);
        lblNhom.setOpaque(true);

        jPanel2.setBackground(Color.decode("#e6e6e6"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jpChonMon.setBackground(Color.decode("#A77A5D"));
        jpChonMon.setAutoscrolls(true);
        jpChonMon.setPreferredSize(new java.awt.Dimension(289, 420));

        javax.swing.GroupLayout jpChonMonLayout = new javax.swing.GroupLayout(jpChonMon);
        jpChonMon.setLayout(jpChonMonLayout);
        jpChonMonLayout.setHorizontalGroup(
            jpChonMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
        );
        jpChonMonLayout.setVerticalGroup(
            jpChonMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNhom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpChonMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblNhom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpChonMon, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpLoai.setBackground(Color.decode("#A77A5D"));
        jpLoai.setLayout(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLoai, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpChonMon;
    private javax.swing.JPanel jpLoai;
    private javax.swing.JLabel lblNhom;
    // End of variables declaration//GEN-END:variables

}
