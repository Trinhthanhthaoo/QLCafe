/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vku.DAO;

import com.vku.MODEL.Taikhoan;
import com.vku.common.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                String id = rs.getString("id");
                 String username = rs.getString("username");
                 String password = rs.getString("password");
                 String lv = rs.getString("lv");
                 
                 Taikhoan l = new Taikhoan (id, username, password, lv);
                 tks.add(l);
                 
            }
    }catch(SQLException e){
            e.printStackTrace();
            }
       return tks; 
    }
 
}
