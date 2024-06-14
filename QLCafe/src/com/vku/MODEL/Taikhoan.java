package com.vku.MODEL;
public class Taikhoan {
    private int id, lv;
    public static String UserName;
    private String Password;
    public Taikhoan()
    {
        id=lv=0;
        UserName = "";
        Password = "";
    }
     public Taikhoan(String Username,String PassWord,int lv){
         this.lv=lv;
        this.UserName=Username;
        this.Password=PassWord;
     }
    public Taikhoan(int id,String Username,String PassWord,int lv)
    {
        this.id=id;
        this.lv=lv;
        this.UserName=Username;
        this.Password=PassWord;
    }
    public void SetID(int id)
    {
        this.id=id;
    }
    public int GetID()
    {
        return this.id;
    }
     public void SetLv(int lv)
    {
        this.lv=lv;
    }
    public int GetLv()
    {
        return this.lv;
    }
     public void SetUsername(String Username)
    {
        this.UserName=Username;
    }
    public String GetUsername()
    {
        return this.UserName;
    }
     public void SetPassword(String Password)
    {
        this.Password=Password;
    }
    public String GetPassword()
    {
        return this.Password;
    }
}
