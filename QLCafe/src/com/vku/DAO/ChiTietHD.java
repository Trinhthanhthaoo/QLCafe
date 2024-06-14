/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vku.DAO;

import com.vku.common.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin!
 */
public class ChiTietHD {
      public static List<com.vku.Model.ChiTietHD> showData() {
        List<com.vku.Model.ChiTietHD> hds = new ArrayList<>();
        try {
            String sql = "Select * from chitiethd";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int MaChiTietHD = Integer.valueOf(rs.getString("MaChiTietHD")); // cast
                int MaHoaDon = Integer.valueOf(rs.getString("MaHoaDon")); // cast
                String MaMon = rs.getString("MaMon");
                int soLuong = Integer.valueOf(rs.getString("soLuong")); // cast
                int gia = Integer.valueOf(rs.getString("Gia")); // cast

                com.vku.Model.ChiTietHD hd = new com.vku.Model.ChiTietHD(MaChiTietHD, MaHoaDon, MaMon, soLuong, gia);
                hds.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hds;
    }
   public static boolean insert(com.vku.Model.ChiTietHD cthd) {
    try {
        String sql = "INSERT INTO chitiethd (MaChiTietHD, MaHD, MaMon, SoLuong, Gia) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = Database.getConnection().prepareCall(sql);
        ps.setInt(1, cthd.GetMaChiTietHD());
        ps.setInt(2, cthd.GetMaHD());
        ps.setString(3, cthd.GetMaMon());
        ps.setInt(4, cthd.GetSoLuong());
        ps.setInt(5, cthd.GetGia());

        int check = ps.executeUpdate();
        System.out.println("Insert check: " + check);
        return check == 1;

    } catch (SQLException ex) {
        Logger.getLogger(ChiTietHD.class.getName()).log(Level.SEVERE, "Insert ChiTietHD failed: " + ex.getMessage(), ex);
        return false;
    }
}

//   public static boolean insert(ChiTietHD cthd) {
//    try {
//        String sql = "INSERT INTO chitiethd (MaHoaDon, MaMon, SoLuong, Gia) VALUES (?, ?, ?, ?)";
//        PreparedStatement ps = Database.getConnection().prepareStatement(sql);
//        ps.setInt(1, cthd.GetMaHD());
//        ps.setString(2, cthd.GetMaMon());
//        ps.setInt(3, cthd.GetSoLuong());
//        ps.setInt(4, cthd.GetGia());
//
//        int check = ps.executeUpdate();
//        System.out.println("check: " + check);
//        return check == 1;
//    } catch (SQLException ex) {
//        Logger.getLogger(ChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
//        return false;
//    }
//}



}
