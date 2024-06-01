/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vku.DAO;

import com.vku.MODEL.Ban;
import com.vku.common.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;

/**
 *
 * @author admin!
 */
public class QLBanDAO {

    public static List<Ban> showData3() {
        List<Ban> bs = new ArrayList<>();
        try {
            String sql = "Select * from ban";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                int MaBan = Integer.valueOf(r.getString("MaBan")); // cast

                String TenBan = r.getString("TenBan");
                String TrangThai = r.getString("TrangThai");

                Ban b = new Ban(MaBan, TenBan, TrangThai);
                bs.add(b);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return bs;
    }
public static List<Ban> getSearch(String keyword) {

        List<Ban> bs = new ArrayList<>();

        try {
            String sql = "select * from ban where MaBan like ? or TenBan like ? or TrangThai like ? ";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ps.setString(1, '%' + keyword + '%');
            ps.setString(2, '%' + keyword + '%');
            ps.setString(3, '%' + keyword + '%');          
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int maBan = Integer.valueOf(rs.getString("MaBan")); // cast 
                String tenBan = rs.getString("TenBan");
                String TrangThai = rs.getString("TrangThai");
             
                Ban b = new Ban(maBan, tenBan, TrangThai);
                bs.add(b);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QLBanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bs;

    }
 public static boolean update(Ban b) {
        try {
            String sql = "UPDATE ban set TenBan = ?, TrangThai = ? WHERE MaBan = ? ";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ps.setString(1, b.GetTenBan());
            ps.setString(2, b.GetTrangThai());
            ps.setInt(3, b.GetMaBan());
            int check = ps.executeUpdate();
            System.out.println("check: " + check);
            if (check == 1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(QLBanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
  public static boolean insert(Ban b) {
        try {
            String sql = "INSERT INTO ban \n"
                    + "VALUES\n"
                    + "(?, ?,?)";;
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ps.setInt(1, b.GetMaBan());
            ps.setString(2, b.GetTenBan());
            ps.setString(3, b.GetTrangThai());
            int check = ps.executeUpdate();
            System.out.println("check: " + check);
            if (check == 1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(QLBanDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
 
}
