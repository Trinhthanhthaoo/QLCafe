/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vku.DAO;

import com.vku.MODEL.Loai;
import com.vku.MODEL.Taikhoan;
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
public class QLTKDAO {
    public static List<Taikhoan> taikhoan (){
        List <Taikhoan> tks = new ArrayList<>();
        try{
        String sql = "Select * from taikhoan";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                 String username = rs.getString("username");
                 String password = rs.getString("password");
                 int lv = rs.getInt("lv");
                 
                 Taikhoan l = new Taikhoan (id, username, password, lv);
                 tks.add(l);
                 
            }
    }catch(SQLException e){
            e.printStackTrace();
            }
       return tks; 
    }
    
        public static boolean delete(Taikhoan l) {
        try {
            String sql = "DELETE FROM taikhoan \n"
                    + "WHERE id = " + "?";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);
            ps.setInt(1, l.GetID());
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
 
}
