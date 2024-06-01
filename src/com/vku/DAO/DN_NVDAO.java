/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vku.DAO;

import com.vku.MODEL.DN_ChuModel;
import com.vku.MODEL.DN_NVModel;
import com.vku.common.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DN_NVDAO {
    public static boolean checkLogin(DN_NVModel dncm){
        try {
            String sql = "SELECT * FROM DN_Chu WHERE Username = ? AND Password = ?";
            PreparedStatement ps = Database.getConnection().prepareCall(sql);

            ps.setString(1, dncm.getUsername());
            ps.setString(2, dncm.getPassword());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                rs.close();
                ps.close();
                return true;
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }
        return false;
    }
    
    // test
    public static void main(String arg[]){
         if(DN_NVDAO.checkLogin(new DN_NVModel())){
           System.out.println("Y");
        }else{
           System.out.println("N");
       }
    }
}
