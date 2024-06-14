package com.vku.Connect;

import com.vku.MODEL.Taikhoan;
import com.vku.MODEL.Ban;
import com.vku.Model.ChiTietHD;
import com.vku.Model.DsOrder;
import com.vku.Model.HoaDon;
import com.vku.MODEL.Loai;
import com.vku.MODEL.ThucDon;
import com.vku.common.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Connect {

    private Connection cn;

    public Connect() {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dacs", "root", "");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Loai> GetLoai() {
        ArrayList<Loai> arrloai = null;
        String sql = "Select * From nhommon";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrloai = new ArrayList<Loai>();
            while (rs.next()) {
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrloai;
    }

    public ArrayList<Ban> GetBan(int maban) {
        ArrayList<Ban> arrBan = null;
        String sql;
        if (maban == 0) {
            sql = "Select * From ban";
        } else {
            sql = "Select * From ban Where MaBan = '" + maban + "'";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrBan = new ArrayList<Ban>();
            while (rs.next()) {
                Ban sp = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
                arrBan.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrBan;
    }

    public int UpdateBan(Ban b) {
        int update = 0;
        String sql = "UPDATE ban SET TenBan = '" + b.GetTenBan() + "', TrangThai = '" + b.GetTrangThai() + "' WHERE MaBan = '" + b.GetMaBan() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update bàn không thành công !");
        }
        return update;
    }

    public String GetMaLoai(String TenLoai) {
        String maloai = null;
        String sql = "Select MaLoai From nhommon Where TenLoai = '" + TenLoai + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                maloai = rs.getString(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được mã loại !");
        }
        return maloai;
    }

    public HoaDon GetHDbyMaBan(int ma) {
        String sql;
        HoaDon arrhd = null;
        sql = "Select * From hoadon Where MaBan = '" + ma + "' AND TrangThai = 0";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                arrhd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return arrhd;
    }

    public ArrayList<DsOrder> GetDsOrder(int ma) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon Where ct.MaHoaDon = '" + ma + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;
    }

    public ArrayList<ThucDon> GetThucDon(String ma) {
        ArrayList<ThucDon> arrThucDon = null;
        String sql;
        if (ma == null) {
            sql = "Select * From thucdon";
        } else {
            sql = "Select * From thucdon Where MaLoai = '" + ma + "'";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<ThucDon>();
            while (rs.next()) {
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;
    }

    public ArrayList<ThucDon> GetThucDonByMa(String ma) {
        ArrayList<ThucDon> arrThucDon = null;
        String sql;

        sql = "Select * From thucdon Where MaMon = '" + ma + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<ThucDon>();
            while (rs.next()) {
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;
    }

    public int DeleteMon(String mamon, int mahd, int maban) {
        int check = 0;
        try {
            String sql;
            sql = "Delete From chitiethd Where MaMon = '" + mamon + "' AND MaHoaDon = '" + mahd + "'";
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            check = 1;
            if (CheckDsMon(mahd, maban) == 0) {
                check = 2;
            }
        } catch (SQLException ex) {

        }
        return check;
    }

    public int CheckDsMon(int mahd, int maban) {
        String sql;
        int dem = 0;
        sql = "Select * From hoadon AS hd INNER JOIN chitiethd AS ct ON ct.MaHoaDon = hd.MaHoaDon Where MaBan = '" + maban + "' AND ct.MaHoaDon = '" + mahd + "' AND TrangThai = 0";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dem++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return dem;
    }

    public int UpDateTrangThaiBan(Ban b) {
        int update = 0;
        String sql = "UPDATE ban SET TrangThai = '" + b.GetTrangThai() + "' WHERE MaBan = '" + b.GetMaBan() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update trạng thái bàn không thành công !");
        }
        return update;
    }

    public int HuyHD(HoaDon hd) {
        int update = 0;
        String sql = "Delete From hoadon WHERE MaHoaDon = '" + hd.GetMaHD() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;
    }

    public ChiTietHD GetDsChiTiet(String ma, int maban) {
        ChiTietHD arrDs = null;
        String sql;

        sql = "Select SoLuong, Gia, MaChiTietHD From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon Where MaMon = '" + ma + "' AND MaBan = '" + maban + "' AND hd.TrangThai = 0";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                arrDs = new ChiTietHD();
                arrDs.SetSoLuong(rs.getInt(1));
                arrDs.SetGia(rs.getInt(2));
                arrDs.SetMaChiTietHD(rs.getInt(3));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;
    }

    public int InsertHoaDon(HoaDon hd, String gio) {
        int insert = 0;
        String sql = "Insert into hoadon (MaBan, GioDen, TrangThai) values ('" + hd.GetMaBan() + "', '" + gio + "', '" + hd.GetTrangThai() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
        }
        return insert;
    }

    public int GetMaHD(int ma) {
        String sql;
        int mahd = 0;
        sql = "Select MaHoaDon From hoadon Where MaBan = '" + ma + "' AND TrangThai = 0";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                mahd = rs.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return mahd;
    }

    public int UpdateChiTiet(ChiTietHD ct) {
        int update = 0;
        String sql = "UPDATE chitiethd SET SoLuong = '" + ct.GetSoLuong() + "', Gia = '" + ct.GetGia() + "' WHERE MaChiTietHD = '" + ct.GetMaChiTietHD() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update chi tiết không thành công !");
        }
        return update;
    }

    public int InsertChiTietHD(ChiTietHD cthd) {
        int insert = 0;
        String sql = "Insert into chitiethd (MaHoaDon, MaMon, SoLuong, Gia) values ('" + cthd.GetMaHD() + "', '" + cthd.GetMaMon() + "', '" + cthd.GetSoLuong() + "', '" + cthd.GetGia() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn không thành công !" + ex.toString());
        }
        return insert;
    }

    public int ThanhToan(HoaDon hd) {
        int update = 0;
        String sql = "UPDATE hoadon SET TongTien = '" + hd.GetTongTien() + "', TrangThai = 1 WHERE MaHoaDon = '" + hd.GetMaHD() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;
    }

    public ArrayList<Taikhoan> GetTaiKhoan() {
        ArrayList<Taikhoan> arrtd = null;
        String sql;
        sql = "SELECT * FROM taikhoan WHERE lv != 1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<Taikhoan>();
            while (rs.next()) {
                Taikhoan td = new Taikhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                arrtd.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }

    public ArrayList<HoaDon> GetDSHD() {
        ArrayList<HoaDon> arrDs = null;
        String sql;
        sql = "Select * From hoadon Where TrangThai = 1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<HoaDon>();
            while (rs.next()) {
                HoaDon order = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

    public ArrayList<ThucDon> GetChiTietMonByMa() {
        ArrayList<ThucDon> arrDs = null;
        String sql;
        sql = "SELECT TenMon, MaMon, DVT FROM thucdon where MaMon in (Select MaMon From chitiethd)";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<ThucDon>();
            while (rs.next()) {
                ThucDon order = new ThucDon();
                order.SetTenMon(rs.getString(1));
                order.SetMaMon(rs.getString(2));
                order.SetDVT(rs.getString(3));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

    public ArrayList<DsOrder> GetGiaSoLuong(String ma) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND ct.MaMon = '" + ma + "'";
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {

                DsOrder order = new DsOrder();
                order.SetGia(rs.getInt(1));
                order.SetSoLuong(rs.getInt(2));
                order.SetTenMon(rs.getString(3));
                order.SetDVT(rs.getString(4));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

    public ArrayList<DsOrder> GetHdByDate(String d1, String d2, String m) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        if (d1.equals(d2)) {
            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND hd.GioDen >= '" + d1 + "' AND ct.MaMon ='" + m + "'";
        } else {
            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND hd.GioDen BETWEEN '" + d1 + "' AND '" + d2 + "' AND ct.MaMon ='" + m + "'";
        }
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {
                DsOrder order = new DsOrder();
                order.SetGia(rs.getInt(1));
                order.SetSoLuong(rs.getInt(2));
                order.SetTenMon(rs.getString(3));
                order.SetDVT(rs.getString(4));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

    public ArrayList<DsOrder> GetCtHDByDate(int ma, String d1, String d2) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        if (d1.equals(d2)) {
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, ct.MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon INNER JOIN hoadon AS hd ON hd.MaHoaDon = ct.MaHoaDon Where ct.MaHoaDon = '" + ma + "' AND hd.GioDen >= '" + d1 + "'";
        } else {
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, ct.MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon INNER JOIN hoadon AS hd ON hd.MaHoaDon = ct.MaHoaDon Where ct.MaHoaDon = '" + ma + "' AND hd.GioDen BETWEEN '" + d1 + "' AND '" + d2 + "'";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách chi tiết hoa đơn !" + ex.toString());
        }
        return arrDs;
    }
    public boolean CheckLogin(Taikhoan tk)
    {
        boolean check = false;
        String sql;
            sql = "Select * From taikhoan Where username = '"+tk.GetUsername()+"' AND password='"+tk.GetPassword()+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                check = true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập !");
        }
        return check; 
    }
    public int LVTK(Taikhoan tk)
    {
        int lvtk =0;
        String sql;
            sql = "Select lv From taikhoan Where username = '"+tk.GetUsername()+"' AND password='"+tk.GetPassword()+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                lvtk = rs.getInt(1);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return lvtk; 
    } 
    public boolean themTk(Taikhoan account){
        try {
            String sql = "INSERT INTO Taikhoan(username, password, lv) VALUES (?, ?, ?)" ;
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, account.GetUsername());
            ps.setString(2, account.GetPassword());
            ps.setInt(3, account.GetLv());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
           ex.printStackTrace();
            return false;
        }
        
      } 
//     public int InsertChiTietHD(ChiTietHD cthd){
//        int insert = 0;
//        String sql = "Insert into chitiethd (MaHoaDon, MaMon, SoLuong, Gia) values ('"+cthd.GetMaHD()+"', '"+cthd.GetMaMon()+"', '"+cthd.GetSoLuong()+"', '"+cthd.GetGia()+"')";
//        try{
//            Statement st = cn.createStatement();
//            insert = st.executeUpdate(sql);
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn không thành công !"+ex.toString());
//        }
//        return insert;
//    }
//     public int InsertChiTietHD(ChiTietHD cthd){
//    int insert = 0;
//    // Do not include MaChiTietHD in the insert statement
//    String sql = "Insert into chitiethd (MaHoaDon, MaMon, SoLuong, Gia) values ('"+cthd.GetMaHD()+"', '"+cthd.GetMaMon()+"', '"+cthd.GetSoLuong()+"', '"+cthd.GetGia()+"')";
//    try{
//        Statement st = cn.createStatement();
//        insert = st.executeUpdate(sql);
//    }catch(SQLException ex){
//        JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn không thành công !"+ex.toString());
//    }
//    return insert;
//}
//  
}
