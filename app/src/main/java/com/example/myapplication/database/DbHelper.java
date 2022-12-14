package com.example.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.anychart.chart.common.dataentry.ValueDataEntry;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DbHelper extends SQLiteOpenHelper{
    static final String dbName = "QLSB";
    static final int dbVision = 6;
    public DbHelper(@Nullable Context context) {
        super(context, dbName, null, dbVision);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_CumSan = "CREATE TABLE CumSan"+
                "(maCumSan INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "chuSan TEXT NOT NULL, " +
                "diaChi TEXT NOT NULL, " +
                "tenCumSan TEXT )";

        db.execSQL(create_CumSan);

        String create_User = "CREATE TABLE User" +
                "(taiKhoan TEXT PRIMARY KEY, " +
                "hoTen TEXT NOT NULL," +
                "matKhau TEXT NOT NULL," +
                "phanQuyen TEXT NOT NULL, " +
                "hinh BLOB )";
        db.execSQL(create_User);


        String create_San = "CREATE TABLE San" +
                "(maSan INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "tenSan TEXT NOT NULL, " +
                "giaSan INTEGER NOT NULL, " +
                "loaiSan INTEGER NOT NULL, " +
                "maCumSan INTEGER NOT NULL ," +
                "anhSan BLOB )";
        db.execSQL(create_San);

        String create_PhieuThue = "CREATE TABLE PhieuThue" +
                "(maPT INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "maSan INTEGER NOT NULL, " +
                "nguoiThue TEXT NOT NULL, " +
                "caThue TEXT NOT NULL, " +
                "ngayThue DATE NOT NULL, " +
                "soKM INTEGER NOT NULL, " +
                "tienSan INTEGER NOT NULL, " +
                "danhGia INTEGER, " +//:0-ch??a ????nh gi??; 1-???? ????nh gi??
                "sao INTEGER, " +
                "phanHoi TEXT)";// 1-5 sao
        db.execSQL(create_PhieuThue);

        String create_KhuyenMai = "CREATE TABLE KHUYENMAI" +
                "(maID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "soKM INTEGER NOT NULL, " +
                "maSan INTEGER NOT NULL, " +
                "caThue TEXT NOT NULL, "+
                "ngayThue DATE NOT NULL)";
        db.execSQL(create_KhuyenMai);

        String INSERT_User = "Insert into User(taiKhoan,hoTen,matKhau,phanQuyen,hinh) values " +
                "('admin','Admin','nghia','AD',null)," +
                "('0777777777','T?? Trung Ki??n','123456','NT',null)," +
                "('0777777771','L?? Gia Ph??','123456','NT',null)," +
                "('0777777772','Nguy???n Tr???n Duy Ni??n','123456','NT',null)," +
                "('0777777773','B??? Nguy???n ?????c Long','123456','NT',null)," +
                "('0777777774','Nguy???n H???u Kh??nh','123456','NT',null)," +
                "('0777777775','L?? Ho??i Nh??','123456','NT',null)," +
                "('0777777776','Nguy???n Qu???c Tu???n','123456','NT',null)," +
                "('0888888888','L?? Quang L?? Anh','123456','CS',null)," +
                "('0333333333','Nguy???n Ho??i Tr??m','123456','CS',null)," +
                "('0333333331','Nguy???n ?????c L????ng','123456','CS',null)," +
                "('0333333332','V??n Vinh Nguy???n','123456','CS',null)," +
                "('0333333334','Nguy???n Ng??n Ph??c','123456','CS',null)," +
                "('0333333335','Nguy???n Tu???n Qu???c','123456','CS',null)," +
                "('0333333336','Nguy???n V??n Nam','123456','CS',null)," +
                "('0555555555','Nguy???n Ng???c Anh','123456','CS',null)";
        db.execSQL(INSERT_User);

        String INSERT_San1 = "Insert into San(tenSan,giaSan,loaiSan, maCumSan, anhSan) values " +
                "('S??n 5A','150000',5, 1,null)," +
                "('S??n 7A','200000',7, 1,null)," +
                "('S??n 5B','150000',5, 1,null)," +
                "('S??n 7B','200000',7, 1,null)," +
                "('S??n 5A','150000',5, 2,null)," +
                "('S??n 7A','200000',7, 2,null)," +
                "('S??n 5A','150000',5, 3,null)," +
                "('S??n 7A','200000',7, 3,null)," +
                "('S??n 5A','250000',5, 4,null)," +
                "('S??n 7A','200000',7, 4,null)," +
                "('S??n 5B','150000',5, 4,null)," +
                "('S??n 7A','200000',7, 5,null)," +
                "('S??n 7B','250000',7, 5,null)," +
                "('S??n 7C','250000',7, 5,null)," +
                "('S??n 5A','150000',5, 6,null)," +
                "('S??n 5B','220000',5, 6,null)," +
                "('S??n 5C','220000',5, 6,null)," +
                "('S??n 7A','220000',7, 9,null)," +
                "('S??n 5A','150000',5, 9,null)," +
                "('S??n 7A','220000',7, 7,null)," +
                "('S??n 5A','150000',5, 10,null)," +
                "('S??n 5B','150000',5, 10,null)," +
                "('S??n 7A','220000',7, 13,null)," +
                "('S??n 7B','220000',7, 13,null)," +
                "('S??n 5A','150000',5, 14,null)," +
                "('S??n 5B','150000',5, 14,null)," +
                "('S??n 5A','150000',5, 11,null)," +
                "('S??n 5A','150000',5, 7,null)";
        db.execSQL(INSERT_San1);

        String INSERT_CumSan = "Insert into CumSan(tenCumSan,diaChi,chuSan) values " +
                "('Trung t??m TDTT Thanh ??a','1017 B??nh Qu???i, Ph?????ng 28, B??nh Th???nh, Th??nh ph??? H??? Ch?? Minh','0888888888')," +
                "('S??n B??ng ???? HCA','324 Chu V??n An, Ph?????ng 12, B??nh Th???nh, Th??nh ph??? H??? Ch?? Minh','0888888888')," +
                "('S??n B??ng ???? S??? 8 CVA','29 ???????ng S??? 8, Ph?????ng 26, B??nh Th???nh, Th??nh ph??? H??? Ch?? Minh','0888888822')," +
                "('S??n B??ng ???? Nh??n T???o H???p Th??nh','213 B??nh Qu???i, Ph?????ng 28, B??nh Th???nh, Th??nh ph??? H??? Ch?? Minh','0333333331')," +
                "('S??n B??ng Mini ????o Duy Anh','21 ????o Duy Anh, Ph?????ng 9, Qu???n Ph?? Nhu???n, Th??nh ph??? H??? Ch?? Minh','0888888883')," +
                "('S??n B??ng Mini Tr???n K??? X????ng','87A Tr???n K??? X????ng, Ph?????ng 7, Qu???n Ph?? Nhu???n, Th??nh ph??? H??? Ch?? Minh','0333333331')," +
                "('S??n B??ng ???? King Sport','36 Hoa S???a, Ph?????ng 7, Qu???n Ph?? Nhu???n, Th??nh ph??? H??? Ch?? Minh','0888888883')," +
                "('S??n b??ng ???? Nh??n T???o P9','S??n c??? nh??n t???o Tr?????ng THPT Ph?? Nhu???n, Ph?????ng 9, Qu???n Ph?? Nhu???n, Th??nh ph??? H??? Ch?? Minh','0888888884')," +
                "('S??n B??ng CLB Quang Tuy???n 3','73 Phan Huy ??ch, Ph?????ng 12, Qu???n G?? V???p, Th??nh ph??? H??? Ch?? Minh,','0888888884')," +
                "('S??n b??ng ???? C??y Tr??m',' 19 Ph???m V??n Chi??u, Ph?????ng 9, Qu???n G?? V???p, Th??nh ph??? H??? Ch?? Minh','0888888884')," +
                "('S??n b??ng ???? An H???i','256 Phan Huy ??ch, Ph?????ng 12, Qu???n G?? V???p, Th??nh ph??? H??? Ch?? Minh','0333333336')," +
                "('S??n B??ng Mini Quang Trung','379 Quang Trung, Ph?????ng 10, Qu???n G?? V???p, Th??nh ph??? H??? Ch?? Minh','0888888885')," +
                "('S??n B??ng M?????i Th???','VRC2+2MP, Ph?????ng Linh Trung, Th??nh ph??? Th??? ?????c','0333333336')," +
                "('S??n B??ng ???? Milano','VQ7C+Q53, ???????ng s??? 12, Ph?????ng Linh Trung, Th??nh ph??? Th??? ?????c,','0888888885')," +
                "('S??n b??ng G?? D??a','H???m 54 ???????ng 36, Linh ????ng, Th??nh ph??? Th??? ?????c','0888888588')";
        db.execSQL(INSERT_CumSan);


        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String ngay = simpleDateFormat.format(now);
        String INSERT_PT = "Insert into PhieuThue(maSan,nguoiThue,caThue,ngayThue,soKM,tienSan, danhGia, sao, phanHoi) values " +
                "(1,'0777777777','1','"+ngay+"',0,150000, 1, 5, 'Gi?? h???p l??, s??n ok')," +
                "(1,'0777777773','2','"+ngay+"',0,200000, 1, 2, 'M???t s??n x???u')," +
                "(1,'0777777777','3','"+ngay+"',0,150000, 1, 5, 'Ok')," +
                "(1,'0777777777','5','"+ngay+"',0,150000, 1, 5, 'Gi?? r???, s??n ?????p')," +
                "(2,'0777777777','6','"+ngay+"',0,150000, 1, 5, 'Ok')," +
                "(2,'0777777771','9','"+ngay+"',0,200000, 1, 4, 'Ok')," +
                "(2,'0777777771','10','"+ngay+"',0,150000, 1, 5, 'Ok')," +
                "(2,'0777777771','3','"+ngay+"',0,150000, 1, 2, 'S??n ?????p')," +
                "(3,'0777777774','1','"+ngay+"',0,150000, 1, 5, 'Ok')," +
                "(3,'0777777774','3','"+ngay+"',0,200000, 1, 4, 'Ok')," +
                "(3,'0777777775','6','"+ngay+"',0,150000, 1, 5, 'Ok')," +
                "(3,'0777777775','7','"+ngay+"',0,200000, 1, 4, 'Ok')," +
                "(4,'0777777775','1','"+ngay+"',0,200000, 1, 4, 'Ok')," +
                "(4,'0777777775','3','"+ngay+"',0,200000, 1, 4, 'Ok')," +
                "(4,'0777777775','4','"+ngay+"',0,200000, 1, 4, 'Ok')," +
                "(11,'0777777777','1','24-11-2021',0,150000, 1, 3, 'ok')," +
                "(9,'0777777777','3','29-11-2021',0,200000, 1, 2, 'Ok')," +
                "(9,'0777777777','6','05-12-2021',0,150000, 1, 1, 'Ok')," +
                "(4,'0777777775','6','"+ngay+"',0,200000, 1, 4, 'Ok')";
        db.execSQL(INSERT_PT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists User");
        db.execSQL("drop table if exists San");
        db.execSQL("drop table if exists PhieuThue");
        db.execSQL("drop table if exists CumSan");
        db.execSQL("drop table if exists KhuyenMai");
        onCreate(db);
    }
}
