/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vku.DAO;

import com.vku.MODEL.Loai;
import com.vku.common.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author admin!
 */
public class QLNMDAO {

    public static List<Loai> showData2() {
        List<Loai> ls = new ArrayList<>();
        try {
            String sql = "Select * from nhommon";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaLoai = rs.getString("MaLoai");
                String TenLoai = rs.getString("TenLoai");
                String MauSac = rs.getString("MauSac");

                Loai l = new Loai(MaLoai, TenLoai, MauSac);
                ls.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ls;
    }

    public static List<Loai> getSearchLoai(String keyword) {

        List<Loai> ls = new ArrayList<>();

        try {
            String sql = "select * from nhommon where MaLoai like ? or TenLoai like ? or MauSac like ?";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ps.setString(1, '%' + keyword + '%');
            ps.setString(2, '%' + keyword + '%');
            ps.setString(3, '%' + keyword + '%');
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String maLoai = rs.getString("MaLoai");
                String tenLoai = rs.getString("TenLoai");
                String mauSac = rs.getString("MauSac");              
                Loai l = new Loai(maLoai, tenLoai, mauSac);
                ls.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QLTPDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ls;

    }

    public static boolean update(Loai l) {
        try {
            String sql = "UPDATE nhommon set TenLoai = ?, MauSac = ? WHERE MaLoai = ? ";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ps.setString(1, l.GetTenLoai());
            ps.setString(2, l.GetMauSac());
            ps.setString(3, l.GetMaLoai());
            int check = ps.executeUpdate();
            System.out.println("check: " + check);
            if (check == 1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(QLNMDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean insert(Loai l) {
        try {
            String sql = "INSERT INTO nhommon \n"
                    + "VALUES\n"
                    + "(?, ?,?)";;
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ps.setString(1, l.GetMaLoai());
            ps.setString(2, l.GetTenLoai());
            ps.setString(3, l.GetMauSac());
            int check = ps.executeUpdate();
            System.out.println("check: " + check);
            if (check == 1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(QLNMDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean delete(Loai l) {
        try {
            String sql = "DELETE FROM nhommon \n"
                    + "WHERE MaLoai = " + "?";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ps.setString(1, l.GetMaLoai());
            int check = ps.executeUpdate();
            System.out.println("check: " + check);
            if (check == 1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(QLNMDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    public String GetMaLoai(String TenLoai) {
        String maloai = null;
        String sql = "Select MaLoai From nhommon Where TenLoai = '" + TenLoai + "'";
        try {
            Statement st = Database.getConnection().prepareCall(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                maloai = rs.getString(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được mã loại !");
        }
        return maloai;
    }
    
}
