package com.vku.DAO;

import com.vku.MODEL.ThucDon;
import com.vku.common.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin!
 */
public class QLTPDAO {

    public static List<ThucDon> showData() {
        List<ThucDon> tds = new ArrayList<>();
        try {
            String sql = "Select * from thucdon";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaMon = rs.getString("MaMon");
                String TenMon = rs.getString("TenMon");
                String MaLoai = rs.getString("MaLoai");
                int DonGia = Integer.valueOf(rs.getString("DonGia")); // cast
                String s = rs.getString("DVT");

                ThucDon td = new ThucDon(MaMon, TenMon, MaLoai, DonGia, s);
                tds.add(td);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tds;
    }

    public static List<ThucDon> getSearch(String keyword) {

        List<ThucDon> tds = new ArrayList<>();

        try {
            String sql = "select * from thucdon where MaMon like ? or TenMon like ? or MaLoai like ? or DonGia like ? or DVT like ?";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ps.setString(1, '%' + keyword + '%');
            ps.setString(2, '%' + keyword + '%');
            ps.setString(3, '%' + keyword + '%');
            ps.setString(4, '%' + keyword + '%');
            ps.setString(5, '%' + keyword + '%');
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String maMon = rs.getString("MaMon");
                String tenMon = rs.getString("TenMon");
                String maLoai = rs.getString("MaLoai");
                int donGia = Integer.valueOf(rs.getString("DonGia")); // cast
              String dvt = rs.getString("DVT");
                ThucDon td = new ThucDon(maMon, tenMon, maLoai, donGia, dvt);
                tds.add(td);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QLTPDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tds;

    }

    public static boolean update(ThucDon td) {
        try {
            String sql = "UPDATE thucdon set TenMon = ?, MaLoai = ?, DonGia = ?, DVT = ? WHERE MaMon = ? ";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ps.setString(1, td.GetTenMon());
            ps.setString(2, td.GetMaLoai());
            ps.setInt(3, td.GetDonGia());
            ps.setString(4, td.GetDVT());
            ps.setString(5, td.GetMaMon());
            int check = ps.executeUpdate();
            System.out.println("check: " + check);
            if (check == 1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(QLTPDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    public static boolean insert(ThucDon td){
     try {
            String sql = "INSERT INTO thucdon \n" +
"VALUES\n" +
"(?, ?,?, ?,?)"; ;
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ps.setString(1, td.GetMaMon());
            ps.setString(2, td.GetTenMon());
            ps.setString(3, td.GetMaLoai());
            ps.setInt(4, td.GetDonGia());
            ps.setString(5, td.GetDVT());
           
           
            int check = ps.executeUpdate();
            System.out.println("check: " + check);
            if(check == 1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(QLTPDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

      }
    public static boolean delete(ThucDon td){
     try {
            String sql = "DELETE FROM thucdon \n"+
"WHERE MaMon = " +"?";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ps.setString(1, td.GetMaMon());
            int check = ps.executeUpdate();
            System.out.println("check: " + check);
            if(check == 1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(QLTPDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

      }  


}
